![image](https://github.com/2nho/personal-study/assets/97571604/93d23963-f939-448b-a955-06e024f6a592)

SSL 인증서를 등록하고 https 접속을 확인한 후 다시  
http(ex:8080) 포트로 접근시 https(8443)로 정상 리다이렉트가 되는지 확인하려 했는데 위와 같이 뜨면서 계속해서 https 포트로  
리다이렉트가 안되고 처음 http로 호출한 8080에서 멈추는 오류가 발생했다.

톰캣에서 아래와 같이 설정하면 문제가 생기지 않았는데 왜 포트번호가 안나타나게 하면 되고 나타나게하면 안되지 하고 고민중
```
<Connector connectionTimeout="20000" port="80" protocol="HTTP/1.1" redirectPort="443"/>  
<Connector SSLEnabled="true" port="443" protocol="org.apache.coyote.http11.Http11NioProtocol">  
        <SSLHostConfig>  
            <Certificate certificateKeystoreFile="file" certificateKeystorePassword="password" type="RSA"/>  
        </SSLHostConfig>  
</Connector>
```
경로를 자세히보니 HTTP로 접근한 경로(http://localhost:8080/test/) 가 강제로 HTTPS로 변경되어서(https://localhost:8080/test/)    
  
원인을 찾다보니 크롬엔진 기반에서는 HSTS(HTTP Strict Transport Security)를 사용하고 있어 한번 https로 접근 성공하게되면   
이후에는 강제로 http로 접근하더라도 https로 변경해서 접근하게 만드는 기능을 사용하고 있어     

http://localhost:8080/test/로 처음 접근 시    -1  
톰캣에서 https://localhost:8443/test/으로 리다이렉트 시키고 https가 성공적으로 접근되면    -2  
이후 http://localhost:8080/test/로 다시 접근 시 강제로 https://localhost:8080/test/ 이렇게 경로를 바꿔버리므로  8080포트 커넥터에는 ssl인증서를 등록해놓지 않아 발생하는 오류였다.  -3

<해결방법>  
인터넷 캐시를 삭제하거나 해당 기능을 비활성화 하면 된다고 한다.  
- 보안을 위해 필요한 기능이니 굳이 기능을 비활성화 하지 않고 캐시 삭제해가며 테스트했다.



*추가 
톰캣 sever.xml 설정에서 http로 접근하는 설정을 지우면 https로 자동으로 바로 될까? 싶어서 
```
<Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="443"/>
```
을 지워봤더니 이클립스에서 톰캣 실행이 제대로 안되는것처럼 브라우저 실행창이 안뜸  
그래서 아 톰캣이 기본적으로 http가 필수인가? 하고 오픈소스를 뒤져보니 그런 내용은 안나옴 그러면 이클립스의 문제일가?    
싶어서 직접 url을 치니 https접근은 되고 http는 ERR_CONNECTION_REFUSED 에러가 나면서 뜨지 않았다.   
이클립스 자체적으로 http를 먼저 호출하기 때문에 https설정만 있으면 브라우저 실행이 되지 않고 안되는 것처럼 보일 수가 있다.(*정상실행되고있음)    

결론적으로는 사용자가 혹시 http로 초기 접근할수도있으니 redirect설정으로 사용자편의를 해주는것이 맞는거 같다.    
(물론 도메인으로 돈주고 사용하면 고려할 필요없긴한거 같다)
