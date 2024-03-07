목표 : NGINX를 통해 request요청을 받으면 url을 보고 분기태우기   



1.각각의 서버에서 톰캣돌리기   
192.168.0.2에 프로젝트1  
192.168.0.4에 프로젝트2  


이때 192.168.0.4는 서버는 vmware대신 전체화면도 편하게 가능한 윈도우의 hyper-v를 사용해 가상머신을 생성했다.  
![image](https://github.com/2nho/personal-study/assets/97571604/e381111f-b76c-41fd-9548-fc70085e320f)

(hyper-v 관리자에서 생성)

2.외부네트워크설정 필수
가상스위치 관리자에서 외부네트워크 생성 후 
가상스위치를 외부네트워크로 설정한다 
![image](https://github.com/2nho/personal-study/assets/97571604/5f71d64a-b68f-41e5-b893-ae3f46995c1c)


3.공유기에서 포트포워딩 설정  
  
![image](https://github.com/2nho/personal-study/assets/97571604/75c24fd5-2428-4038-aded-1cd57f935e92)


4. nginx 설치 

https://nginx.org/en/download.html 링크

주의사항! : 바탕화면에 설치하지 말 것 !! 명령어 안먹힘 C드라이브나 D드라이브에 설치 권장

5. nginx.conf 설정파일에서 리버스 프록시 설정  
![image](https://github.com/2nho/personal-study/assets/97571604/547a8fc6-67b3-4089-a2e5-d0073ae35a00)

위와같이 설정하면 프로젝트 경로에 따라 각각의 서버를 알맞게 찾아간다!
