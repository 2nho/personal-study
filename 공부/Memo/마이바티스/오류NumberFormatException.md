Error querying database. Cause: java.lang.NumberFormatException: For input string "스트링값"

마이바티스 문제라기보단 
OGNL문제 !   

OGNL 인터프리터에서는 위 구문의 ‘Y’를 char 형으로 인식하고, ‘YY’나 “Y”는 String으로 인식한다고 한다.
그래서 <if test=”stringValue == ‘Y’”> 이와 같은 구문을 비교할 때  NumberFormat으로 비교를 시도하여 Exception이 발생한다.
이유는 java의 char형은 실제로 문자의 코드값을 저장하기 때문

char y = 'Y';

int code = (int)y; // code에는 Y의 코드값인 89가 저장된다

그래서 위와 같은 상황을 피하기 위해서는 다음과 같은 해결책이 존재한다.

1. <if test=’stringValue == “Y”‘> – 쌍따옴표와 홑따옴표의 위치를 변경
```
2. <if test=”stringValue == &quot;Y&quot;”> – 쌍따옴표를 HTML 코드로 변경
```
3. <if test=”stringValue == ‘Y’.toString()”> – toString() 함수를 사용해 String 형으로 변환
  
  
 나의 경우   
 <when test='approverSearchOption == "all" and approverKeyword !=""'> 1조건
   
   
 <when test='approverSearchOption == 2'> 2 조건
   
 의 형태로 진행해서 발생한 오류였다. 2를 char로 보고 변환을 시도한다음 all도 변환하려다 발생한 문제인거 같다.
 all을 -> 0으로 바꾸면 오류 X    (그러나 '0'으로 바꾸면 해당조건을 만족하지 않음 sql에서 '5'(문자) 와 5(숫자)와 다르기 때문 )
   
