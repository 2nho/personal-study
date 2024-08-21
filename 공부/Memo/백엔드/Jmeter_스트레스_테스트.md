
![window 사이즈](https://github.com/user-attachments/assets/a577caef-5173-4241-8d42-01c47149918b)

처음에는 zero windowsize오류가 뜨길래 이때 오류가 뜨는건가 싶어서 위와 같이 레지스트리에서 사이즈를 최대로 늘려줬지만 동일하게   
동일하게 5만건 중 30~110건 정도의 에러가 남

netsh interface tcp show global 확인 시   
![image](https://github.com/user-attachments/assets/4c06128f-b302-4209-aa41-ac91cd36274a)

최대 SYN 재전송 : 4인걸 확인가능(= Max SYN Retransmissions : 4) 

wireshark로 이걸 다시 확인해보면   
과부하오면 윈도우의 경우 아래와 같이 4번의 재요청후 응답이 안오면 Jmeter에서 에러처리 
![wireshark](https://github.com/user-attachments/assets/b682aacc-4a80-4299-a62c-c0247a503095)




## 참고 

netstat 명령어로 어떤 포트가 실패했는지 알 수 없으므로  
wireshark 통계 메뉴에서 종단점으로 오름차순으로 확인하면 byte 가 수신 0 인걸로 파악하면 쉽다
