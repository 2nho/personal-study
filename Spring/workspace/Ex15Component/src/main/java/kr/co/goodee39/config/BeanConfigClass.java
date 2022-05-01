package kr.co.goodee39.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import kr.co.goodee39.beans.TestBean1;
import kr.co.goodee39.beans.TestBean2;

@Configuration
// 지정된 패키지 안에 있는 Bean 클래스들의 어노테이션을 분석하도록 지정한다.
@ComponentScan(basePackages = "kr.co.goodee39.beans2")
public class BeanConfigClass {
	@Bean
	public TestBean1 java1() {
		return new TestBean1();
	}
	
	@Bean
	public TestBean2 java2() {
		return new TestBean2();
	}
	
	@Bean
	public TestBean2 java3() {
		return new TestBean2();
	}
}
