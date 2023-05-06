매번 업무할때 자동배포가 안되니 이대로는 안되겠다 싶어서 사용해보는 젠킨스 (사실 웹개발자는 나혼자지만 윈도우 개발자 두명과 나머지 영업쪽에 내가만든 화면과 기능을 보여줘야한다)

설치오류   
오류 1 - 로그인 권한 문제   
https://stackoverflow.com/questions/63410442/jenkins-installation-windows-10-service-logon-credentials  

오류2 - 재설치 시도 후 재설치안되는 문제   (도큐먼트에 다 있는 내용)
https://stackoverflow.com/questions/64308841/jenkins-failed-to-start-verify-that-you-have-sufficient-privileges-to-start-sy  

 젠킨스 윈도우 설치 공식문서 https://www.jenkins.io/doc/book/installing/windows/  
 
젠킨스 설치가 완료되면 자동으로 젠킨스 페이지가 로딩된다 하는데 ... 나는 안뜬다 고로 포트 9090으로 설정했으니 톰캣처럼 구동될거라 생각하고 localhost:9090 인터넷창에 치니 뜬다!  

![image](https://user-images.githubusercontent.com/97571604/230400865-89786a6e-b41b-4139-ab67-efb19e88dd9e.png)
  
 일단 설치까지는 완료!
 
 설정은 너무많아서 또 공식문서랑 앞시대의 사람들의 지식을 강구해야겠다..

++  
젠킨스 설정편 (온프레미스 방식)
오류 1 hudson.plugins.git.GitSCM.ALLOW_LOCAL_CHECKOUT' to true. 

친절하게 어디에 하라는 방법은 없어서 직접 해본 방식 

![image](https://user-images.githubusercontent.com/97571604/236388828-656afd67-5ef1-4e8c-82c7-ba3c3daa1929.png)

일단 빌드는 실행되는데 또 다른 오류가 뜬다..  

bulid.xml이 없다고 뜨는데 나는 단순 젠킨스 테스트하기 위해 다니아믹 웹 프로젝트로 생성만해서 build.xml 파일을 따로 작성해줘여 했나보다 

하지만 일반적인 프로젝트들은 maven이나 gradle이니까 maven 프로젝트로 변경 후 재시도 해야겠다

$ cmd.exe /C "mvn clean install && exit %%ERRORLEVEL%%" 'mvn'은(는) 내부 또는 외부 명령, 실행할 수 있는 프로그램, 또는 배치 파일이  -- 이런 오류가 뜨는데.. 

Global Tool Configuration 에서 maven 을 추가 ! (플러그인 설치해야되는 줄 알고 플러그인만 설치하고 왜 안되지 하고 있었다..)

![image](https://user-images.githubusercontent.com/97571604/236400494-7ca4aa75-eefb-48ae-acc5-43e8700caa5e.png)

++ 나는 로컬로 깃에 push가 발생 시 자동빌드되는 젠킨스를 구성하고 싶었는데 .. 그런 기술은 없고 깃허브를 이용해야지 webhook을 이용해서 push이벤트 발생 시 자동빌드를 구성할 수 있나보다

폴링 = 주기적으로 계속 확인 절차가 필요 - > 변경 발생 시 빌드 !
webhook = 이벤트 발생시에 빌드! 주기적으로 확인 안함 

![image](https://user-images.githubusercontent.com/97571604/236636337-20485fd2-2856-445b-ab16-ea67dc8a5f6d.png)


