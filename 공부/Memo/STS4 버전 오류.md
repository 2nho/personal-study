Unable to make protected final java.lang.Class java.lang.ClassLoader.defineClass(java.lang.String,byte[],int,int) 
throws java.lang.ClassFormatError accessible: module java.base does not "opens java.lang" to unnamed module @28393e82

회사 프로젝트를 집에서도 코드를 분석해보기 위해 회사 개발환경인 sts3 대신 최신 버전의 sts4를 설치해 사용했으나 지속적으로 오류 발생
초기 lombok 설치의 문제가 있는 줄 알고 다른 해결방법을 찾기위해 영어, 중국어, 일본어 가리지 않고 모든 사이트를 방문해 찾아봤으나 
명확하게 해결되는 것이 하나도 없었음

그러다 STS4로 실행하는 외주업체 개발자를 보고 "sts3로 실행하던 것을 sts4로 실행했을 때 나는 안되던데 IDE 버전 문제는 없냐" 질문을 함 
"자바 버전만 맞으면 문제 없다"라는 답변을 받았고 동일하게 개발환경을 구성해보자 시도 

하지만 개인 데스크톱의 문제인가 싶을 정도로 지속적으로 퇴근 후나 주말에도 시간투자했으나 해결하지 못함

-일주일을 헤매던 중- 

회사와 동일하게 sts3로 실행하면 되나 싶어 회사버전의 sts3를 깔아 프로젝트를 import해봤지만 다른 오류 발생 
이 문제도 console의 뜬 에러코드를 해석해가며 인터넷의 도움을 받아 해결해보려 했지만 인터넷에 나온 방법을 전부 이용해도 진전이 없었음
2주간의 결과물 없는 시간투자만 지속하기를 반복 
그러다 시스템 환경변수에 기존 초기에 설정했던 jdk1.8과 달리 oracle/java 형식의 다른 path가 있는것을 이상하게 여겼고 삭제했더니 
sts3에서 실행이 무사히 됨 (기존 집에서 혼자하던 프로젝트 혹은 sts4를 설치하며 자동으로 추가되면서 충돌난 것으로 결론) 

sts3에서는 이제 무사히 실행되기에 컴퓨터 문제는 아니란 결론에 도달 이후 다시 sts4로 동일하게 시도했으나 sts4에서는 실행오류가 지속
https://stackoverflow.com/questions/35842751/lombok-not-working-with-sts <br>
https://stackoverflow.com/questions/56523530/lombok-installation-in-spring-tool-suite-4-for-windows<br>
https://github.com/spring-projects/sts4/issues 등을 참고해 

.ini 파일에 
--illegal-access=warn
--add-opens java.base/java.lang=ALL-UNNAMED
-javaagent:lombok.jar
등을 추가해봤지만 진전X  마지막줄의 문제인가 싶어 -javaagent:C:\Users\golde\Desktop\sts-4.14.1.RELEASE\lombok.jar 등으로도 해봤지만 
해답을 찾지 못함

이클립스 최신버전을 설치해서 lombok을 설치했지만 동일문제 발생 혹시나 싶어 lombok의 버전을 기존 1.18.20에서 1.18.22로 버전을 올리니
롬복 오류는 사라짐 그러나 기존 pom.xml 과 다른 부분에서 오류 표시가 났고 하나씩 찾아갔지만 해결 X 

하지만 기존 프로젝트의 버전을 올리는 것은 사이드 이펙트가 많기에 기존 버전을 유지하는 방법을 찾기위해 다시 
STS4로 실행하는 방법을 찾기 시작 sts4최신 버전의 기본 jdk가 17버전으로 잡혀있기에 컴퓨터에 설치했던 1.8버전으로 bulid path 수정 하지만
오류는 계속 발생

ini파일의 vm의 경로를 java - jdk 1.8 경로로 설정해주었더니 sts4가 실행조차 되지 않는 오류로 발전 로그를 확인하라는 오류메세지를 
보고 확인해보니 
!ENTRY org.springframework.ide.eclipse.boot.dash.docker 2 0 2022-05-05 23:57:05.558
!MESSAGE Could not resolve module: org.springframework.ide.eclipse.boot.dash.docker [556]
  Unresolved requirement: Import-Package: org.eclipse.core.runtime
    -> Export-Package: org.eclipse.core.runtime; bundle-symbolic-name="org.eclipse.core.runtime"; bundle-version="3.24.100.v20220211-2001"; version="3.7.0"
       org.eclipse.core.runtime [132]
         Unresolved requirement: Require-Capability: osgi.ee; filter:="(&(osgi.ee=JavaSE)(version=11))"
         Unresolved requirement: Require-Bundle: org.eclipse.equinox.registry; bundle-version="[3.11.0,4.0.0)"; visibility:="reexport"
           -> Bundle-SymbolicName: org.eclipse.equinox.registry; bundle-version="3.11.100.v20211021-1418"; singleton:="true"
              org.eclipse.equinox.registry [237]

등으로 남아있어 하나씩 살펴본 결과 Require-Capability: osgi.ee; filter:="(&(osgi.ee=JavaSE)(version=11))" 에서 혹시 하고 검색해본 결과
https://okky.kr/article/1046999?note=2504885 에서 답을 얻을 수 있었다! 


## 중요 ! 이클립스 버전별로 사용가능한 java버전이 있다는 것!!!!!!!!!!!!!!
https://hermeslog.tistory.com/506  이 글을 통해 이클립스 별 지원하는 JDK를 찾아볼 수 있었고
그 중 2020-06에 나온 Eclipse 4.16버전이 JDK 1.8을 지원하는 마지막 버전인 것을 알 수 있었다.
그렇게 Eclipse 4.16버전을 깔고 프로젝트를 실행해본 결과 무사히 실행완료 !


스프링 공식 문서에서 제한사항과 이슈에 관해서
https://github.com/spring-projects/sts4/wiki/Known-Limitations-&-Issues 
롬복 문제라고만 생각해 롬복과 관련된
<Lombok>
The Lombok installer doesn't know about the changed name of the STS4 executable and therefore doesn't find it.
Nevertheless you can install Lombok manually by modifying the SpringTools4.ini file yourself.

이것만을 읽고 SpringToolSuite4.exe 와 SpringToolSuite4.ini를 STS4.exe STS4.ini 로 변경하거나 위에 적은 
--illegal-access=warn
--add-opens java.base/java.lang=ALL-UNNAMED
-javaagent:lombok.jar 을 이용해 해결하려 했던 것이 무의미한 짓이었다.

물론 덕분에 ini파일을 열어보며 -Dosgi.requiredJavaVersion=11 부분에서 곧 자바 버전 문제 일수도 있다라는 생각까지 도달은 했지만 
sts4의 최소 jdk 요구 조건이 11이상이라는 것을 ini파일의 최소요구조건을 1.8로 바꾸거나 vm 을 jdk 1.8 경로로 하면 바뀔 줄 알았던 내 생각이 오만하고 잘못된거였다
괜히 plugin 폴더나 configuration을 찾아보며 어렵게 생각했던거 같다..

스프링 공식 깃허브에서 Java 11+ required의 뜻에 좀 더 집중했더라면 좋았을 거 같다. 
(물론 로그 파일의 내용을 알려주는 OKKY 글이 없엇다면 쭉 몰랐을 수 도 있을거 같다. 괜히 build path와 installed JREs에서 해결할 수 있지 않을까 하며 헤맸던 것이 그 증거)


흔히 검색하면 가장 쉽게 나오는 정보가 alt+ f5 해서 메이븐 업데이트하거나 레파지토리 폴더를 지워서 전부 새로 받으라는 글들이 많았는데
단순히 그런 글들 수준에서 멈췄으면 절대 풀지 못할 난제였다(스스로에게). 4월에서 5월로 이어져온 긴 여정이었지만
이리저리 설정파일도 건들여 보고 하면서 조금 더 배우는 부분이 생겼다 


++ jdk 와 jre의 차이는 jdk는 jre를 포함에 javadoc등 개발을 위한 더 많은 것들이 포함되어 있다는 것!


드디어 약 4주간의 긴 여정(22년 4월 11일 ~ 22년 5월 6일)끝에 해결했다! 
그동안 오류도 찾으며 틈틈히 공부도 병행하며 깃허브에 기록으로 열심히 남겼지만.. git 이용 방법을 익히다가 다날렸다 .. 무엇이든 신중할 것 교훈.. 
git push origin +master는 평생 잊지 못할 것 같다..
  
  
 22-11-07 추가   
 lombok 1.18.20 버전은 이클립스 2021-06 버전까지만 유효   
 sts4는 4.11버전까지   
 이유를 찾아보고자 롬복버그 픽스, 깃허브 , 스택오버플로우 , 중국사이트 까지 알아봤지만..   
 그냥 다들 ide버전을 낮추거나 lombok을 최신버전으로 올리는 형태로 문제해결에만 그치는거 같다.  
  
  
