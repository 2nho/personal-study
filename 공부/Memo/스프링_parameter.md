@requestparam - 쿼리스트링으로 url 에 값을 보낼 때 

@resquestbody - body에 담아서 값을 보낼 때
- 클라이언트가 전송하는 JSON(application/json) 형태의 HTTP Body 내용을 Java Object로 변환시켜주는 역할을 합니다.
(MessageConverter들 중 하나인 MappingJackson2 HttpMessageConverter를 통해 Java 객체로 변환된다)
가장 큰 특징은 바인딩이 아닌 변환을 시키는 것이기 때문에 변수들의 Setter 함수가 없어도 정상적으로 저장
- Content-Type을 multipart/form-data 형태로 전송
- setter 가 없어도 getter를 찾아 바인딩 
- json or xml 가능

@modelttribute 
- Content-Type을 application/json이 아닌 ※ multipart/form-data 형태로 전송
- Setter를 통해 일대일 객체에 바인딩하기 위해 사용된다. (setter 필수)


++ 

<application/x-www-form-urlencoded> 
폼의 가장 기본적인 타입입니다.
일반적으로 우리가 그냥 사용하는 폼이 대부분 이 타입
- enctype 옵션을 지정하지 않으면 웹 브라우저는 요청 HTTP 메세지의 헤더에 Content-Type: application/x-www-form-urlencoded을 붙여 알아서 타입을 지정합니다.
EX.
```
POST /save HTTP/1.1
Host: localhost:8080
Content-Type: application/x-www-form-urlencoded
```
username=kim&age=20

폼에 입력한 항목을 HTTP body에 '&'으로 구분지어 전송합니다. (query parameter와 같음)

<multipart/form-data> 
파일을 업로드하기 위해서는 문자가아닌 바이너리 데이터를 전송해야합니다.
바이너리 데이터는 온갖 조합이 다 나오기 때문에 &로 구분할 수 없습니다.

또한 파일을 전송할 때 파일만 '띡' 전송하는 경우는 드물고 다른 정보도 함께 전송하는 경우가 많습니다.

예를 들어 username, age, FILE 이렇게 세가지를 함게 전송 하는 것 처럼 말이지요.

요때 사용되는 아이가 바로! multipart/form-data!!

multipart/form-data으로 지정된 폼에서 만들어진 HTTP 요청 메세지는 조금 다른 형태를 띄고있습니다.
```
POST /save HTTP/1.1
Host: localhost:8080
Content-Type: multipart/form-data; boundary=-----%%%
Content-Length: 12309

-----%%%
Content-Disposition: form-data; name="username"

steve
-----%%%
Content-Disposition: form-data; name="age"

25
-----%%%
Content-Disposition: form-data; name="file"; filename="profile.png"
Content-Type: image/png

2q432#@$%#%#@REWFfsf3e3f3@4ewR$f4r4wF4gs4t4obvy734or84r4v#%Y^&B$%^$%&E^%$^@%C%$QRTA$f4btwRWwa3rw3r ...
-----%%%
```
위처럼 각 폼 항목마다 Content-Disposition 헤더가 붙고 부가정보가 붙어있습니다.
file의 경우 Content-Type이 추가되고 바이너리 데이터가 전송됩니다.

모든 항목은 "-----%%%" 처럼 임의로 생성되는 바운더리를 통해 구분되고, 이 바운더리는 UUID로 매번 임의로 생성됩니다.

바운더리로 구분된 각 항목을 Part라 합니다!
