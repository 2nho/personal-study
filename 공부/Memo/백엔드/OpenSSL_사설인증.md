![image](https://github.com/2nho/personal-study/assets/97571604/d35a1bd7-d28f-48b6-8cfa-f15f6591b676)

1. 셀프 사인된 root인증서를 만들것 => 브라우저 인증서에서 신뢰할 수 있는 루트 인증기관에 등록
2. root인증서로 서명된 서버용 인증서를 만들기  (but 여기까지만 하면 여전히 브라우저에서 신뢰할 수 없는 인증서라고 뜸)
   주의사항 : 인증서 계층구조가 루트 - 중간 - 서버용 혹은 루트 - 서버용으로 최상단에 루트가 나타나는 인증서 체인형태로 잘 표시되야함
3. 보안 인증서에 주체 대체 이름(SAN)이 지정되어 있지 않아 인증서가 확실하지 않다 오류를 뱉음 서버용 인증서 생성시  .cnf파일 예시처럼 하나 만들어서
   -config 옵션으로 넘겨줘야 설정이 됨 설정이 잘되면 아래 스크린샷처럼 SAN이 등록됨
   
   (-config 로 설정파일을 넘겨주는 것 말고 cmd창에서 넘겨주는 방법은 나오질 않아서 시도하다 포기)  -- 추가 250429 -addext 옵션을 사용하라!
   

   ![image](https://github.com/2nho/personal-study/assets/97571604/5a48a56a-53a9-4c16-af3d-e56598253b78)


   <SAN 미등록 오류>
   
   ![image](https://github.com/2nho/personal-study/assets/97571604/f442e7b2-2f7f-49c7-a57d-c5658ada2ef8)


.cnf파일 예시
```
[req]
distinguished_name = req_distinguished_name
prompt = no
[ req_distinguished_name ]
CN = 192.168.0.133
[ v3_req ]
subjectAltName = @alt_names
[ alt_names ]
DNS.1 = localhost
IP.1 = 192.168.0.133
```


명령어  
genrsa -out rootCA.key 2048  
req -x509 -new -nodes -key rootCA.key -sha256 -days 1024 -out rootCA.crt  
  
genrsa -out device.key 2048  
req -new -key device.key -out device.csr -config 2nho.conf  
pkcs12 -export -out certificate.p12 -inkey device.key -in device.crt (딱히 확장자 .p12가 아니라 .key 혹은 안적어도 문제없이 톰캣에 돌아가긴함 안가리는거 같음)   
  
참고 사이트 

https://docs.brekeke.com/sip/how-to-create-a-self-signed-certificate-using-openssl  

https://9033.github.io/text/openssl.html  
