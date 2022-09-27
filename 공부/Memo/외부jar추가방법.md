기존 외부 라이브러리를 추가한 방법을 탐구하던 중 pom.xml에 
```
<!-- 외부 라이브러리 -->
		<dependency>
			<groupId>com</groupId>
			<artifactId>jfxrt</artifactId>
			<version>1.0.0</version>
			<scope>system</scope>
			<systemPath>${project.basedir}/lib/jfxrt-1.0.0.jar</systemPath>
		</dependency>  
```   
의 형태로 jar파일을 추가한 것을 보았다. 

워크스페이스의 root 디렉토리에 bin 폴더를 만들어서 추가한 형태였는데 
src의 web-inf/lib에 중복해서 파일을 배치한 것을 보고 기이하게 여겨 파본결과 


pom.xml에 정의한 저 형태는 쓸모가 없고 실질적으로  src/main/webapp/WEB-INF/lib에 위치한 라이브러리를 이용하는 것을 여러번 실행한 결과 알아냈다.
프로젝트의 Deployment Assembly를 보면 Maven Dependencies의 빌드 후 위치를 나ㅏㅌ내는 Deploy path를 보면 WEB-INF/lib 에 저장되는 것을 알 수 있는데 

src/main/webapp은 Deploy Path가 "/"  결국 src/main/webapp/WEB-INF/lib 과  Maven Dependencies 의 빌드 후 위치가 같다는 것을 알 수 있다. 
그렇기에 src/main/webapp/WEB-INF/lib 에 외부라이브러리를 위치시키면 메이븐의 라이브러리와 동일하게 빌드 되어 인식된다. 
