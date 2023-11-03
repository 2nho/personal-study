DispatcherServlet의 RequestMappingHandlerMapping, RequestMappingHandlerAdapter, ExceptionHandlerExceptionResolver, MessageConverter 등 Web에 필요한 빈들을 대부분 자동으로 설정해준다

 <context:component-scan base-package="">  controller를 등록하는 곳엔 반드시 있어야 됨 root-에 한번에 스캔을 하더라도 필요    
 - root-servlet에 있는 것을 action-servlet에서 사용할 수 있다고들 해서 root에 mvc:annotation-driven 선언하면 action에 선언된 것처럼 사용할 줄 알았는데 그게 아닌거 같음   
 - @Controllers를 빈으로 등록하는 곳에 존재해야 정상 작동하는거 같다. 레퍼런스, 스택오버플로우 뒤졌지만 찾질 못함.. 코드를 직접 따라가봐야 알거 같음    
 
 


@Controllers에 요청을 발송하는 데 필요한 HandlerMapping 및 HandlerAdapter를 등록합니다. 또한 클래스 경로에 있는 항목에 따라 합리적인 기본값을 적용합니다. 이러한 기본값은 다음과 같습니다.


Spring 3 Type ConversionService 를 JavaBeans PropertyEditors에 대한 더 간단하고 강력한 대안으로 사용   
@NumberFormat 을 사용하여 숫자 필드 서식 지정 지원   
Joda 시간이 클래스 경로에 있는 경우 @DateTimeFormat 을 사용하여 날짜, 달력 및 Joda 시간 필드 서식 지정 지원   
JSR-303 공급자가 클래스 경로에 있는 경우 @Valid로 @Controller 입력 유효성 검사 지원   
JAXB가 클래스 경로에 있는 경우 XML 읽기 및 쓰기 지원    
Jackson 이 클래스 경로에 있는 경우 JSON 읽기 및 쓰기 지원   



++
java로 구성 시 
```
@Configuration
@EnableWebMvc <- (equivalent to <mvc:annotation-driven />)
@ComponentScan(basePackageClasses = { MyConfiguration.class })
```

xml 구성 시 
```
<mvc:annotation-driven />
<context:component-scan base-package="package.*" />
```
자바코드로 구성 시 같은 locatiobn에서 처리 하는 것을 보면 xml 에서도 같은 위치에 있는게 맞는거 같다!


++ 생략해도 
context:component-scan 만 잘되어있다면 오류안남  종속성X - + <mvc:default-servlet-handler /> ,  <mvc:resources location="/" mapping="/**"></mvc:resources> 도 없어야 오류 안남

하지만 .do를 / 로 바꾸려면 mvc:resources가 필요하기 때문에 mvc:annotation-driven 이 있어야 정상작동한다.





++2023-11-03 추가 

servlet 설정  

웹 레이어어 관련된 Controller만 등록
```
<context:component-scan base-package="guardian" use-default-filters="false">
		<context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
		<!-- <context:include-filter type="annotation" expression="org.springframework.stereotype.Service"/>
		<context:include-filter type="annotation" expression="org.springframework.stereotype.Repository"/> -->
	</context:component-scan>
```

context 설정
비즈니스 로직과 데이터 액세스 계층 
use-default-filters 생략시 true 설정으로 어노테이션 빈들 자동등록 

! Controller만 제외시키기 

```
<context:component-scan base-package="guardian">
		<context:exclude-filter type="annotation"	expression="org.springframework.stereotype.Controller" />
	</context:component-scan>
```
