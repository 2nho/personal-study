```
let e = "😀";

for(let i=0; i<e.length; i++) {
  console.log(e[i]);
}
와

for(const i of e) {
  console.log(i);
}

의 결과가 왜 다른지 이해하기도 힘들어진다.

아무튼.. 자바스크립트를 잘 하는건 꽤 어렵다. 언어 자체가 업데이트가 많기도 하고. 
```
라고 트윗을 쓴 글을 발견하고 왜 위에 경우에는 이상한 문자가 반환이 되면서 두번 실행이 되고 

아래는 정상적으로 이모지 하나만을 반환하나 궁금하기에 열심히 혼자 파헤쳐본 결론은

이모지는 일반적인 글자가 아니라 유니코드가 2개이상 합쳐진 형태이기에 String.length 를 하게 되면 2(혹은 그이상) 을 반환하게 되는데 이는 length 메서드가 utf-16으로 변환했을때의 값을 기준으로 해서 그렇다고한다.

그렇다면 for of 문에서는 왜 그런일이 일어나지 않을까?에 대한 답은 

for of문은 length값을 이용하지 않고 값(value)에 접근하기 때문에 이에 따른 문제가 발생하지 않는다.

(Symbol.iterator값이 있어야 for of문 실행 가능 (iterator라는 것을 알려줌) / symbol : 상위나 하위 객체에 영향을 받지 않는 내부 객체로서 사용가능하게 하는 역할) 

@

![image](https://user-images.githubusercontent.com/97571604/224547922-9da59d43-46d5-40ef-a6f7-939ddc299a28.png)  

생각을 확인하기위해 길이가 2인 스마일 이모지를 

e[i]+e[i+1] 로 합치니 정상적으로 스마일 이모지가 출력되었다.

---------------------------------------------------------------------



이모지에 알아보다보니 그럼 이모지를 어떻게 삽입하는가에 대한 궁금증으로 이어졌는데 html상으로 넣는거야 복사붙여넣기나 유니코드를 넣으면 바로 출력이되는데 

동적으로 페이지를 다루고싶을때는 자바스크립트로 사용할 일이 있을거 같아 미리 알아두고자 시도했는데 잘되지않았다. 

물론 자바스크립트도 이모지 자체를 복붙하는 형태로는 들어가졌지만 문자형태로는 넣는것이 어려웠는데 그러다 발견한것이 

String.fromCodePoint(0x1F525); 형태로 넣는 것이 었고 

document.getElementById("emoji").append(String.fromCodePoint(0x1F525)) 이렇게 테스트 코드를 넣어본결과  

 ![image](https://user-images.githubusercontent.com/97571604/224541140-fde4354c-3d8e-40aa-8e40-d2b2c80208ae.png)  
 
 이렇게 잘 나오게됐다.
 
 
 @ 
   
   String.fromCodePoint() 메소드  
이 메소드는 쉼표로 구분되는 일련의 코드 포인트(code point)에 해당하는 문자들로 구성된 문자열을 반환

String.prototype.codePointAt(n) :  n번째에 해당하는 글자의 유니코드 포인트 값 반환 

'😀'.codePointAt(0) => 128512 반환 

String.fromCodePoint(128512) => '😀'  



