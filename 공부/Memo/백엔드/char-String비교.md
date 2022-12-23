다른 언어에서는 큰따옴표("") 와 작은 따옴표('') 의 구분이 없는 경우가 많지만

자바의 경우 ""는 문자열(String)을 감싸는 기호 - 문자 여러개   
''는 문자(character)를 감싸는 기호 - 문자 하나  

// String 은 빈문자열과 null로 초기화 가능  
String str = "";   
String str1 = null;  



// char 는 빈문자열(공백X) 과 null로 초기화 불가능  
char ch = ''; // X  
char ch = null; // X                       -----------null은 아무것도 참조하지 않는다는 뜻이라 참조형변수에만 사용되는게 아닐가 생각 

++ char ch =' ' // O 공백 가능  

char 타입 변수에 리터럴로 유니코드를 작성하면 null로 초기화가 가능  

ex) char ch = '\u0000' // 10진수로는 0에 해당하는 유니코드, null로 표현이 가능 ,  char의 기본값 = '\u0000'  




![image](https://user-images.githubusercontent.com/97571604/209304663-50a28c2a-1f96-4228-abed-419fb703a539.png)
