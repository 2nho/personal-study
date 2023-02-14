![image](https://user-images.githubusercontent.com/97571604/218755500-23cd722d-fb36-4eaa-875b-e0252cfe1bc1.png)



JSON_OBJECT의 반환 row수가 1개 초과인 2개이상일 경우 
오류를 반환하는데 

이를 해결하기 위해 DB(mysql)에서 GROUP_CONCAT 을 이용해 한줄의 문자열값으로 반환한다음 구분자를 통해 분리해서 파싱해서 해결
