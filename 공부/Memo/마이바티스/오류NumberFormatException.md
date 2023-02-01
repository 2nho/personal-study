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
  
  
 "all " => 문자열  
  all   => 변수 로 인식  
  
  all변수가 없을 때  
   <if test=” all == null ”>  
   하면 참으로 인식   
     
   따라서  <if test= ”stringValue == all ”>  
   하게되면 stringValue가 null이 아닌이상   
    
