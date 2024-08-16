![image](https://github.com/user-attachments/assets/427a36a5-4070-4d76-8437-6337f883300f)

  Seq : 해당 seq 넘버부터 Tcp segment Len 길이 까지 데이터를 보낼게~ 

  (참고 : len이 0인 경우 +1해줌 안겹치게 하기 위해) 

  Ack : 여기까지 잘받았으니 다음 Seq를 이걸로 해서 보내줘~   
  
  Win : 수신 측에서 현재 수신할 수 있는 데이터의 양을 나타냄 

  경고 :   
  가. TCP Spurious Retransmission  : Spurious(불필요한) Retransmission   
      실제로 필요한 상황이 아님에도 불구하고 패킷이 재전송된 경우  
      일반적으로, 패킷이 손실되거나 ACK(확인 응답)가 제때 도착하지 않으면 TCP는 해당 패킷을 다시 전송  
      그러나 Spurious Retransmission은 이러한 재전송이 실제로는 필요하지 않은 상황에서 발생  
      
  나. TCP Dup ACK   
      동일한 ACK 번호를 가진 응답이 연속적으로 두 번 이상 수신될 때 발생  
      특정 시점에 예상했던 데이터가 도착하지 않았음  
      1. 패킷 손실 2. 패킷 순서 뒤바뀜 3. 네트워크 혼잡

  다. TCP ZeroWindow     
      송신측에서 수신측에 ack + window size를 보낼 때 window size가 0이 계속 발생하여 실패  
      수신측에 소켓 버퍼가 가득차서 TCP 패킷을 제대로 처리하지 못해서 발생
      * 부하테스트 중 발생 window가 가득찼다는 메시지 


## 추가 참고자료 패킷이 커서 나눠보내는 경우 URL: https://blog.naver.com/hoan123432/221540351927
  
![image](https://github.com/user-attachments/assets/b6fe6ee6-c63d-44b4-90df-1afaeceae2d6)  

ACK 를 중간 중간 보내서 잘받고 있음을 표시   
[ACK] Seq=532 Ack=18476 (이부분 나 잘받고있어요 표시)
[PSH,ACK] Seq=18476 Ack=532 (위의 ACK이후로 이하 쭉 HTTP/1.1 200 OK 신호 받기 전까지 반복 중간중간 또 ACK로 잘받고 있다는 표시가 등장할 수 있음)
  
* 
