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

timeout /t 5

start "Kafka" cmd /c "start_kafka.bat"
```


종료하는 명령어
```
@echo off
start "StopZooKeeper" cmd /c C:\Users\2nho\Desktop\kafka\bin\windows\zookeeper-server-stop.bat
start "StopKafka" cmd /c C:\Users\2nho\Desktop\kafka\bin\windows\kafka-server-stop.bat
```
