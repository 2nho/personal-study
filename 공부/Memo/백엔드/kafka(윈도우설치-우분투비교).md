카프카 설치 및 실행 

- 현재 오류 : 한글로 메시지 작성 시 외계어가 뜸



아무런 정보도 없을 수 없어 확인차 리눅스계열 우분투 설치 후 테스트하니 정상적으로 한글이 출력됨 다만 한글이 2byte라서 인지 글자를 지울때 어떤때는 한번에 한칸 간격이 줄어드는데 어떨때는 반칸이 줄어드는 경우가 있음 반칸의 경우 외계어 등장
![image](https://github.com/2nho/personal-study/assets/97571604/2782b6e0-920b-4074-a4ec-48500663460f)


![image](https://github.com/2nho/personal-study/assets/97571604/8062692e-a35e-46a8-87c4-f35ccbe3d2da)

로그 파일을 확인해보니 윈도우랑 동일하게 아스키코드로 표현가능한 알파벳 숫자 같은 경우는 정상적으로 보임 

한글은 그대로 한글로 나타나지 않고 변환되어 저장되어있음


우분투 참고 사이트 https://depotceffio.tistory.com/entry/%EC%9A%B0%EB%B6%84%ED%88%AC%EC%97%90-%EC%95%84%ED%8C%8C%EC%B9%98-%EC%B9%B4%ED%94%84%EC%B9%B4-%EC%84%A4%EC%B9%98%ED%95%98%EA%B8%B0


토픽삭제  

![image](https://github.com/2nho/personal-study/assets/97571604/d0dc0eec-99e1-4c5b-a108-af0e76555c5c)

++ 추가로 더 해보니 더욱 모르겠음 백스페이스로 글자를 지울 때 제대로 안지워져 글자가 남아있기도 하고 중구난방..
![image](https://github.com/2nho/personal-study/assets/97571604/5fd2e980-c002-4ad8-8302-14fcadbaf683)


반칸 남기면 물음표는 맞는거 같고 지웠던 찌꺼기 글자가 나타는 경우는 잘모르겠음..

![image](https://github.com/2nho/personal-study/assets/97571604/b9f140bd-a5db-4df3-a012-da89f3623945)


++ 추가시도
우분투의 경우 서비스를 올리면 됐는데 윈도우는 서비스를 올려도 잘안되서 배치파일로 일단 서버 켜는 작업이라도 단순화 하기위해 
kafkaServer.bat파일 만듬
```
@echo off

rem ZooKeeper를 실행
start "ZooKeeper" C:\Users\2nho\Desktop\kafka\bin\windows\zookeeper-server-start.bat C:\Users\2nho\Desktop\kafka\config\zookeeper.properties

rem ping 10번 = 10초  
ping 127.0.0.1 -n 10 > nul


rem Kafka를 실행
start "Kafka" C:\Users\2nho\Desktop\kafka\bin\windows\kafka-server-start.bat C:\Users\2nho\Desktop\kafka\config\server.properties
```

초기 아래와 같이 timeout으로 시도했으나 먹히지 않아 다른 방법(위의 방법)을 찾음 timeout이 왜안되는지에 대해서는 명확한 이유를 찾진 못함. start로 시작하는 명령어는 새로운 cmd창을 열기 때문인가? 생각 정도  
```
@echo off
start "ZooKeeper" cmd /c "start_zookeeper.bat"

timeout /t 10

start "Kafka" cmd /c "start_kafka.bat"
```
++ 추가 옵션 /nobreak 을 사용하게 되면 ping처럼 기다렸다가 실행이됨 start로 시작하는 명령어가 timeout일 때 키를 누르는 행위로 인식되는게 맞는거 같음
timeout /t 10 /nobreak

종료하는 명령어
```
@echo off
start "StopZooKeeper" cmd /c C:\Users\2nho\Desktop\kafka\bin\windows\zookeeper-server-stop.bat
start "StopKafka" cmd /c C:\Users\2nho\Desktop\kafka\bin\windows\kafka-server-stop.bat
```


++ 자바로 실행 시 한글오류안남 윈도우 cmd창에서만 인코딩오류 발생 

이클립스 터미널로 utf-8로 설정해서 열어도 오류 
server프로퍼티 파일을 인코딩 명시해도 오류..


시도한 방법
1. chcp 65001로 커맨드창 인코딩 utf-8로 변경
2. 지역 언어 설정 utf-8 설정
3. 커맨드 창에서 --property stringserialilzer 명시
4. key.value 인코딩 utf-8 명시
5. 이클립스에서 터미널창 utf-8로 뜨워서 해보기
6. server 프로퍼티에 utf-8명시하기
7. PS C:\> $OutputEncoding = [System.Console]::OutputEncoding = [System.Console]::InputEncoding = [System.Text.Encoding]::UTF8  
PS C:\> $PSDefaultParameterValues['*:Encoding'] = 'utf8'  
명령어통해 utf8변경  
전부실패


![image](https://github.com/2nho/personal-study/assets/97571604/919903f7-5941-4031-a43c-0c39cdfcb332)  
OUTPUTENCODING , INPUTENCODING 둘다 UTF-8 이여도 여전히 한글깨짐

intl.cpl 실행 후 utf-8로 시스템을 바꿔도 안됨
![image](https://github.com/2nho/personal-study/assets/97571604/3a4fc962-c1b9-4df1-94ea-8d91c126b2a3)

git bash 사용해서 하면 잘들어가짐
 ![image](https://github.com/2nho/personal-study/assets/97571604/8bee8b5d-e19a-46df-8cc8-5132c7fd5487)



참고
 https://stackoverflow.com/questions/49016189/windows-10-cli-utf-8-encoding
 
 https://hyuckkim.tistory.com/30


 윈도우 파워쉘 및 cmd창의 경우 아직은 utf-8입력에 대해 완벽히 지원하지 못하는거 같다.
 
 근데 `add-Content 1.txt 한글넣어지나` 하게되면  정상적으로 또 한글이 텍스트파일에 저장된다..



추가

![image](https://github.com/2nho/personal-study/assets/97571604/bf76986c-5a7f-4235-8207-c69ab15935f1)

파워쉘 코어는 utf-8을 기본사용하는데 왜 안될까 싶어 일단 이모지가 되나 확인해보니 된다. 
그러면 producer.bat을 실행해서 넣을수도 있을까?
시도해본결과 애초에 인코딩깨져서 들어가진다 

-- 여기서 혹시하고 윈도우 cmd에 이모지 입력해보니 동일하게 깨지는걸 봐서 카프카 bat 실행 시 기본적으로 cmd를 이용하는것 같다 생각이든다. 

그래서 시스템환경변수편집에서 comspec변수를 %SystemRoot%\system32\cmd.exe에서 파워쉘 코어 경로로 변경했는데 

![image](https://github.com/2nho/personal-study/assets/97571604/9871bd6c-3519-482f-8c73-1e697410ce0a)

이렇게 바로 깨지는걸로 봐서 기본 cmd를 이용하는게 맞는거로 추측된다.


## 해결

깃허브에서 윈도우 터미널 최신버전 다운받고 실행했더니 된다.. 최신 터미널 버전에서 utf-8 기본 인코딩 설정으로 잘 업데이트 되었나보다
터미널이 파워쉘과 동일한 의미인줄 알고 파워쉘만 파워쉘 코어 버전으로 업데이트 했는데 터미널 업데이트가 제일 중요한거였다.. 파워쉘 인코딩 설정은 따로 할 수 있으니까 버전의 중요도는 낮았고(5.1버전에서 7.3버전으로 업데이트).. 터미널에서 입력과 출력을 utf-8로 온전히 출력할 수 있게 된다는 점이 제일 중요했다

- 파워쉘 코어 기본 인코딩이 utf-8이래서 파워쉘 업데이트를 진행한거였는데 풀리지 않던 문제가 터미널 최신 버전으로 v1.18.2681.0으로 설치하니 풀림

- 괜히 kafka소스랑 jline3소스 뜯어보고 있었다.. 아무튼해결

![image](https://github.com/2nho/personal-study/assets/97571604/3d5c514b-85c4-418a-ae28-6a89e1f53ff9)

추가 + 
터미널로만 실행하면 cmd창으로 카프카 실행되도 상관없이 잘나온다

![image](https://github.com/2nho/personal-study/assets/97571604/fb23b8ad-9721-4f61-a2a5-76adba066f39)




총정리 
파워쉘 코어 버전에 터미널 1.18이후 버전 설치하면 무난히 이모지등의 utf-8 설치 가능 
파워쉘 5.1 버전의 경우
$OutputEncoding = [System.Console]::OutputEncoding = [System.Console]::InputEncoding = [System.Text.Encoding]::UTF8 입력하거나 ps1파일에 입력필수
