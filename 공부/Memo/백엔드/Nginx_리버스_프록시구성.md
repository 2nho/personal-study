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


5. nginx.conf 설정파일에서 리버스 프록시 설정  
![image](https://github.com/2nho/personal-study/assets/97571604/547a8fc6-67b3-4089-a2e5-d0073ae35a00)

위와같이 설정하면 프로젝트 경로에 따라 각각의 서버를 알맞게 찾아간다!



하게된 이유 : 도메인은 하나인데 기존 프로젝트들은 1.8이하 버전에서만 돌아가게 되어있었다.  
그러나 새로만든 프로젝트가 오라클 DB를 사용해야만해서 자바17버전이 강제되었는데 이때 모듈 오류로   
자바 버전에 따라 프로젝트가 호환이 안됐다. 이를 극복하기 위해 가상머신으로 서버를 나누고 url 도메인은 같게 해야할 필요성을 느껴 하게 됐다.


내용추가 ++   
nginx의 경우 pem형태의 ssl인증서를 이용하고 key로 개인키를 넣어준다




내용추가 2024-04-12  

https://nginx.org/en/docs/http/ngx_http_proxy_module.html#proxy_pass  

![image](https://github.com/2nho/personal-study/assets/97571604/2a217279-b892-47ac-904b-303effab68ef)

만약 proxy_pass 지시문이 URI와 함께 지정된다면, 서버에 요청이 전달될 때 정규화된 요청 URI의 일부분이 위치와 일치하는 URI로 대체  
예)  
```
location /name/ {  
    proxy_pass http://127.0.0.1/remote/;  
}
``` 
/name/foo로 요청을 보내면 NGINX는 대상 서버로 /remote/foo로 요청  
http://127.0.0.1/remote/foo;  

만약 proxy_pass가 URI 없이 지정된다면, 원래 요청이 처리될 때 클라이언트가 보낸 형태와 동일한 형태로 요청 URI가 서버로 전달되거나 변경된 URI를 처리할 때 전체 정규화된 요청 URI가 전달  
예)  
```
location /some/path/ {  
    proxy_pass http://127.0.0.1;  
}
``` 
/some/path/foo로 요청을 보내면 NGINX는 대상 서버로 요청 URI를 변경하지 않고 전달합니다. 즉, 클라이언트가 보낸 요청 URI와 동일한 형태로 대상 서버에 전달   
http://127.0.0.1/some/path/


1.1.12이전 버전을 쓸 일은 없겠지만 내용이 이해가지 않아 AI의 힘을 빌렸다. chatGPT는 답을 주지 못했지만 코파일럿이 그나마 신빙성있음  
  ![image](https://github.com/2nho/personal-study/assets/97571604/727c001b-61ac-4d09-b693-affd262e942e)  

  ![image](https://github.com/2nho/personal-study/assets/97571604/755fdb51-e385-4897-bc02-dbe859631242)

