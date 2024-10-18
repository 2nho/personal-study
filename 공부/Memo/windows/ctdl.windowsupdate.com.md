폐쇄망에서 https 통신 시 초기 12~20초 이상 지연이 발생

wireshark를 통해 패킷분석결과 ctdl.windowsupdate.com이 dns호출이 되는걸 확인

확인해보니 windows에서는 루트인증서가 검증이 되지 않은 경우 따로 ctdl.windowsupdate.com를 호출해서 새로 root ca인증서들을 다운받고 그안에서 검증하려고 함 

하지만 폐쇄망에서는 ctdl.windowsupdate.com에 연결할 수 없었고 이에 따라 timeout시간까지 지연이 발생했던것 

![image](https://github.com/user-attachments/assets/2514d0b4-6dfe-462a-a7a1-ce010666c525)

![image](https://github.com/user-attachments/assets/6660b0db-a99d-41e7-9727-308abbd0ebab)


# wireshark

![증거](https://github.com/user-attachments/assets/0a17f12a-3a5c-4fce-98f0-438d91d7ef15)
