<url-pattern>.do</url-pattern> 가 아닌 restful 한 (+내가 뒤에 확장자가 없는 깔끔한 uri 를 좋아하는 점)  
uri 주소를 만들기 위해 기존 프로젝트 uri주소들이 .do로 되어있는 걸   
<url-pattern>/</url-pattern> 로 변경 하였다.  

이때 / 가 아닌 /*으로 설정할 경우 톰캣 web.xml의 jsp servlet도 덮어 씌워지기 때문에 /를 쓰며  

정적서비스 파일들이 맵핑되는 defalutServlet의 패턴인 /을 사용했기 때문에   

기존 defalutServlet로 가던 정적파일들을 맵핑시켜주기위해

<mvc:resources location="/" mapping="/**"></mvc:resources> 을 설정해주었다. 

--mvc:resources는 Dispatcher Servlet에서 해당 요청에 대한 컨트롤러를 찾을 수 없는 경우 
2차적으로 설정된 경로에서 탐색하는 것!
 
<mvc:annotation-driven /> 도 필수 !
