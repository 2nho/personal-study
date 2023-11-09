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



RequestMappingHandlerMapping은 서블릿 매핑이 "/path/*" 형식이면, "/path" 이후 부분을 사용해서 컨트롤러 검색    
따라서 컨트롤러에서 경로상 .do를 생략해도 해당 경로를 찾아감 (<url-pattern>*.do</url-pattern> 일 경우)

요청 URL	서블릿 매핑 URL 패턴	컨트롤러 매핑 경로
       요청 URL                 서블릿매핑 URL패턴    컨트롤러 매핑 경로   
/프로젝트명/path/list.do	            /path/*	       /list 또는 /list.do
