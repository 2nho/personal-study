오류정리 및 코드

스프링 레거시 버전 

pom.xml 기입내용 
( DB접속정보는 IV값이 매번 달라지면 암호화된 정보도 달라지므로 문제가 생김. 그래서 StringFixedIvGenerator 를 이용해 고정된 IV를 사용 이때 jasypt-spring31이 아닌 일반버전 jasypt에 해당클래스가 존재하므로 의존주입.) --# 생각이 틀림 random 으로 해도 잘만 복호화된다.. IV가 암호문 제일앞 블록에 붙어서 setPassword로 설정한 키값으로 복호화될 때, IV 값이 추출되어 사용되어 진다.
(원래는 jasypt만 사용하려했는데 org.jasypt.spring31.properties.EncryptablePropertyPlaceholderConfigurer를 사용하기 위해서 jasypt-spring31 후에 추가)
```
<dependency>
			<groupId>org.jasypt</groupId>
			<artifactId>jasypt-spring31</artifactId>
			<version>1.9.2</version>
			<scope>compile</scope>
		</dependency>
		<dependency>
			<groupId>org.jasypt</groupId>
			<artifactId>jasypt</artifactId>
			<version>1.9.3</version>
		</dependency>
```
XML 기입내용
```
<bean id="configurationEncryptor"
		class="org.jasypt.encryption.pbe.StandardPBEStringEncryptor">
		<property name="algorithm"
			value="PBEWithHmacSHA256AndAES_256" />
		<property name="password" value="test" />
		<property name="ivGenerator">
			<bean class="org.jasypt.iv.StringFixedIvGenerator">
				<constructor-arg value="1234567890111213" />
			</bean>
			<bean class="org.jasypt.iv.RandomIvGenerator" /> 
		</property>
	</bean>
	<bean
		class="org.jasypt.spring31.properties.EncryptablePropertyPlaceholderConfigurer">
		<constructor-arg ref="configurationEncryptor" />
		<property name="location"
			value="/WEB-INF/properties/db.properties" />
	</bean>

```


DB.properties파일 기입내용
```
 db.password = ENC(rtQOVxxzxxxE0hZmc2iFRhMuBlV3y9CMc0LCW+s4JO8=) 이런식으로 암호화된 스트링값을 ENC()로 감싼다.
```

암호화방법 (아래의 main을 실행시켜 원하는 값을 인코딩 후 사용)
```
public class JasyptConfig extends PropertyPlaceholderConfigurer {

	public static void main(String[] args) {
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setAlgorithm("PBEWithHmacSHA256AndAES_256");
        encryptor.setPassword("test");
        encryptor.setIvGenerator(new StringFixedIvGenerator("1234567890111213"));
        String encryptedRoot = encryptor.encrypt("root");
        String encrypted1234 = encryptor.encrypt("1234");

        System.out.println("Encrypted root: " + encryptedRoot);
        System.out.println("Encrypted 1234: " + encrypted1234);
	}
}
```

++  자바로 설정버전
```
@Configuration
public class JasyptConfig implements ServletContextAware {
	public static void main(String[] args) {
        String classPath = System.getProperty("java.class.path");
        System.out.println("Classpath: " + classPath);
    }
	private ServletContext servletContext;
	
	@Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
	
	@Bean
	public StandardPBEStringEncryptor configurationEncryptor() {
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setAlgorithm("PBEWithHmacSHA256AndAES_256");
		encryptor.setPassword("test");
		encryptor.setIvGenerator(new RandomIvGenerator());
		return encryptor;
	}
	@Bean
    public EncryptablePropertySourcesPlaceholderConfigurer propertyConfigurer(StandardPBEStringEncryptor configurationEncryptor) {
        EncryptablePropertySourcesPlaceholderConfigurer configurer = new EncryptablePropertySourcesPlaceholderConfigurer(configurationEncryptor);
        Resource resource = new ServletContextResource(servletContext, "/WEB-INF/properties/db.properties");
        configurer.setLocation(resource);
        return configurer;
    }
	
}
```

오류 
![image](https://github.com/2nho/personal-study/assets/97571604/3e664723-145f-4dbd-8377-c509f1f2a363)


![image](https://github.com/2nho/personal-study/assets/97571604/7499d36d-18a3-4c56-a1f5-f7041604c1e1)



![image](https://github.com/2nho/personal-study/assets/97571604/7d2e5767-2271-472a-ae5b-14ef359b03c6)

- IV값은 16바이트 이상 필수
- 
- 보안상 오류 메세지를 제대로 보여주지 않는다고 한다. 그래서 디버깅으로 일일이 오류원인을 찾아야한다.


내용추가

@value를 통해 외부 환경변수로 setpassword의 인자값을 숨기려 시도하다 null로 뜨는 오류발생 

원인을찾고자 @postconstruct로 value값을 확인해보고 했는데 여전히 null로 나왔다.

xml설정으로 JasyptConfig을 빈으로 등록해주면 @postconstruct가 잘실행되고 @value값도 잘 주입되었다.   
근데 왜 @configuration으로 @bean을 등록하면 안될까?

이유를 못찾던중 아래의 링크를 통해 원인을 추측할 수 있었는데 

출처 https://reiphiel.tistory.com/entry/postconstruct-not-called-by-propertyplaceholder
```
BeanFactoryPostProcessor (BFPP) 타입을 반환하는 @Bean 메서드에 대해서는 특별한 주의가 필요. 왜냐하면 BFPP 객체는 컨테이너 라이프사이클의 매우 초기에 인스턴스화되어야 하며,
이로 인해 @Configuration 클래스 내의 @Autowired, @Value, @PostConstruct와 같은 어노테이션 처리에 간섭이 발생할 수 있습니다. 
이 라이프사이클 이슈를 피하려면 BFPP를 반환하는 @Bean 메서드를 static으로 표시하십시오.

결론적으로는 EncryptablePropertySourcesPlaceholderConfigurer가 BeanFactoryPostProcessor와 연관된 클래스여서 문제가 생기는걸로 추측된다. 

그럼 왜 xml에서 bean설정을 하는것과 @configuration으로 설정하는게 다른가? 
XML 설정 파일에서 빈을 정의할 때는 클래스에 직접적인 영향을 주지 않음
빈의 정의를 제공할 뿐이며, 빈이 생성되고 초기화되는 방식은 스프링 컨테이너가 제어, 스프링은 XML에서 정의한 빈들의 초기화와 종속성 주입을 담당

@Configuration 클래스에서 @Bean 메서드를 정의할 때는 클래스 자체가 스프링 빈이 되고, 해당 빈은 스프링의 라이프사이클에 직접적으로 연관.
따라서 @value, @PostConstruct는 BeanFactoryPostProcessor 타입 메소드때문에 제약을 받음
```


그러나 나의 경우 프로퍼티파일이 WEB-INF 에 있어서 servletContext를 static으로 처리할 수 없어서 결국 SRC/MAIN/RESOURCES  리소스폴더로 프로퍼티를 옮긴 후 
Resource resource = new ClassPathResource("db.properties"); 이렇게 변경하였다.

@Configuration과 XML에 JasyptConfig를 두번 빈으로 등록하면 문제가 해결되긴 하는데 정석적인 방법인 아니니 제외. (스프링부트의 경우 같은 빈의 경우 오류를 뱉는다고 한다.)



++추가   

암호화 jar

```
import java.util.Scanner;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.iv.RandomIvGenerator;

public class Main {
	public static void main(String[] args) {
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setAlgorithm("PBEWithHmacSHA256AndAES_256");
		//encryptor.setPassword("2nho's Legacy");
		encryptor.setPassword("vDFlJ1FKzzd5fhL9+flP7xNmafun2LZ4ZLPZlsovelYjAOYkM+EF5BpcVTiAeLnm");
		encryptor.setIvGenerator(new RandomIvGenerator());
		
		// Scanner 객체를 생성하여 System.in (콘솔 입력)과 연결
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // 사용자에게 입력을 요청하는 메시지 출력
            System.out.print("Please enter a value (type 'exit' to quit): ");

            // 사용자로부터 문자열 입력 받기
            String str = scanner.nextLine();

            // 'exit' 또는 'quit'을 입력하면 루프 종료
            if (str.equalsIgnoreCase("exit")) {
                break;
            }

            // 입력받은 내용을 암호화하고 출력
            String encrypted = encryptor.encrypt(str);
            System.out.println("Encrypted Output: " + encrypted);
        }

        // Scanner 객체를 닫아 자원 해제
        scanner.close();
	}
}
```
