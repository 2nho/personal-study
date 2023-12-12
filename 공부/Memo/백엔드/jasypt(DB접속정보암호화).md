오류정리 및 코드

스프링 레거시 버전 

pom.xml 기입내용 
( DB접속정보는 IV값이 매번 달라지면 암호화된 정보도 달라지므로 문제가 생김. 그래서 StringFixedIvGenerator 를 이용해 고정된 IV를 사용 이때 jasypt-spring31이 아닌 일반버전 jasypt에 해당클래스가 존재하므로 의존주입.)
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
				<constructor-arg value="korecenfighting123" />
			</bean>
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

암호화방법 (아래의 main을 실행시켜 원하는 값을 인코딩 후 사)
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



오류 
![image](https://github.com/2nho/personal-study/assets/97571604/3e664723-145f-4dbd-8377-c509f1f2a363)


![image](https://github.com/2nho/personal-study/assets/97571604/7499d36d-18a3-4c56-a1f5-f7041604c1e1)



![image](https://github.com/2nho/personal-study/assets/97571604/7d2e5767-2271-472a-ae5b-14ef359b03c6)

- IV값은 16바이트 이상 필수
- 
- 보안상 오류 메세지를 제대로 보여주지 않는다고 한다. 그래서 디버깅으로 일일이 오류원인을 찾아야한다.


