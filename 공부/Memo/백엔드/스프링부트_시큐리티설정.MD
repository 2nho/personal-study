```
package com.innosoft.boankwan.config;

import com.innosoft.boankwan.filter.NonceFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.header.HeaderWriterFilter;
import org.springframework.security.web.header.writers.ReferrerPolicyHeaderWriter;
import org.springframework.security.web.header.writers.XXssProtectionHeaderWriter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;
import static org.springframework.security.config.http.SessionCreationPolicy.IF_REQUIRED;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                //CORS 설정
                .cors(cors -> cors.configurationSource(corsConfigurationSource())) // corsConfigurationSource 빈의 내용 적용 //
                //CSRF 방어 활성화 (기본값이 enabled지만 명시)
                /*.csrf(csrf -> csrf
                        .ignoringRequestMatchers("/h2-console/**") // 필요시 제외 경로 지정
                )*/
                //기본 인증/인가 설정 (필요에 따라 세부화)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                        .requestMatchers("/dist/**", "/css/**", "/js/**", "/imges/**").permitAll()
                        .anyRequest().authenticated()
                )
                //보안 헤더 설정
                .headers(headers -> headers
                        // MIME 타입 스니핑 방지
                        .contentTypeOptions(c -> {
                        }) // 기본 활성화 X-Content-Type-Options: nosniff

                        // 클릭재킹 방지
                        //.frameOptions(HeadersConfigurer.FrameOptionsConfig::deny) // X-Frame-Options: DENY
                        .frameOptions(f -> f.deny())

                        // XSS 필터(최신 브라우저는 CSP로 대체 권장, 여기선 레거시도 켬)
                        .xssProtection(xss -> xss.headerValue(XXssProtectionHeaderWriter.HeaderValue.ENABLED_MODE_BLOCK)) // X-XSS-Protection: 1; mode=block  XSS 필터를 활성화 공격이 감지되면 페이지 전체 렌더링을 차단

                        // 콘텐츠 보안 정책(CSP): 외부 스크립트/리소스 차단
                        .contentSecurityPolicy(csp -> csp
                                .policyDirectives(
                                        "default-src 'self' ; " +
                                                "script-src 'self' 'unsafe-inline' https://ajax.googleapis.com ; " + // 'nonce-{nonce}'
                                                "object-src 'none'; " +
                                                "style-src 'self' 'unsafe-inline' https://fonts.googleapis.com ;" + // unsafe-inline(html 태그 내 직접 작성된 코드)
                                                "font-src 'self' 'unsafe-inline'  https://fonts.gstatic.com ;" + // nonce는 현재 정적페이지로 다박아놔서 사용X
                                                "base-uri 'self';") // base-uri 는 악의적인 <base>태그 주입방지
                        )

                        // Referrer-Policy: 최소 정보만 전송 Referrer정보안줌
                        .referrerPolicy(ref -> ref.policy(ReferrerPolicyHeaderWriter.ReferrerPolicy.NO_REFERRER))

                        // Strict-Transport-Security(HSTS): HTTPS 강제 및 중간자 공격 방지  // 추후 관리인원 없어 문제 생기면 안되니 보류
//                        .httpStrictTransportSecurity(hsts -> hsts
//                                .includeSubDomains(true)  // 모든 서브도메인에도 HSTS 적용
//                                //.maxAgeInSeconds(31536000) // 1년 HSTS 정책의 유효기간
//                                .maxAgeInSeconds(60)
//                                .preload(true) // HSTS Preload 리스트 등록 의도 명시 실제로는 구글이 관리하는 곳에 등록신청해야함
//                        )
                )

                //세션 보안 (필수 보안 속성)
                .sessionManagement(session -> session
                        .sessionCreationPolicy(IF_REQUIRED)
                        .sessionFixation().changeSessionId() // 세션 고정 공격 방지
                        .maximumSessions(1) //  // 동시 세션 제한
                        .maxSessionsPreventsLogin(false) // // true: 기존 사용자가 유지, false:새 로그인으로 세션 변경= 카톡?
                        // 세션 만료 시 이동할 URL (선택적) // 동시 로그인 제한
                        //.expiredUrl("/session-expired")
                        // 세션이 유효하지 않을 때 이동할 URL (선택) // 타임아웃 / 서버가 재시작
                        //.invalidSessionUrl("/invalid-session") // expiredUrl보다 이게 우선적용 그럼 이것만 적용해도..
                )

                //쿠키 보안 정책을 위한 RememberMe(선택)
                .rememberMe(rememberMe -> rememberMe
                        .useSecureCookie(true)// HTTPS에서만 쿠키 전송
                        .rememberMeCookieName("SECURE_REMEMBERME")
                        .tokenValiditySeconds(7 * 24 * 60 * 60) // 1주일
                        .rememberMeParameter("remember-me") // 로그인 폼의 파라미터명(기본값)
                        .userDetailsService(userDetailsService) // 직접 구현한 UserDetailsService 지정  /// 17일에 계속할것
                        //.tokenRepository(persistentTokenRepository) // Persistent RememberMe 사용 시
                )

                //로그아웃 보안 강화(세션 삭제)
                .logout(logout -> logout
                        .deleteCookies("JSESSIONID", "SECURE_REMEMBERME")
                        .invalidateHttpSession(true) //  사용자의 HTTP 세션을 서버에서 완전히 무효화(삭제)
                        .clearAuthentication(true) // SecurityContext(보안 컨텍스트)에서 Authentication(인증 정보) 객체를 제거 // 동시 요청 관련 문제로 인해 필요 -(1차로 세션에서 SecurityContext가 제거되니 일반적으론 안전)
                )


                // 80 포트도 열려있고 443포트도열려있어야 작동 리다이렉트
//                .requiresChannel(channel -> channel
//                        .anyRequest().requiresSecure())

                //.httpBasic(c ->{}) // 브라우저가 제공하는 http basic 방식 base64 -> 암호화가 안되니 꼭 SSL 적용된 사내망 같은곳에서만
                .formLogin(withDefaults())
        ;
        http.addFilterBefore(new NonceFilter(), HeaderWriterFilter.class);
        return http.build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(List.of("http://localhost")); // 허용할 Origin
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));  // 허용할 HTTP 메서드
        config.setAllowedHeaders(List.of("*")); // 허용할 헤더
        config.setAllowCredentials(true); // 인증정보(쿠키 등) 허용 여부

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
    // SavedRequestAwareAuthenticationSuccessHandler는 인증 성공 후 사용자를 원래 요청했던 URL로 리다이렉트합니다.
    @Bean
    public SavedRequestAwareAuthenticationSuccessHandler savedRequestAwareAuthenticationSuccessHandler() {
        SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
        successHandler.setDefaultTargetUrl("/dashboard"); // efaultTargetUrl은 저장된 요청이 없을 경우에만 사용됩니다.
        return successHandler;
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    // AuthenticationProvider 설정 (권장)
    //@Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }
}
```
