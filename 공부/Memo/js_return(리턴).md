return 함수 중단 , + undefined 반환  

return false 함수중단 + false 반환 


return false 또는 retrun ture 사용할 경우는 함수의 결과값을 이용해 다른 곳에서 true , false 값을 이용할 경우 , 또는 명시적으로 디버깅할 경우 






+추가

undefined == null  // true

undefined == false // false 

fasle == 0 // true



```
<script>
  function handler() {
    alert( "..." );
    return false;
  }
</script>

<a href="https://w3.org" onclick="handler()">브라우저가 w3.org로 이동합니다.</a>
```
위 경우 w3.org로 이동

브라우저는 onclick 같은 on* 속성을 읽을 때, 속성값을 그대로 가져와 핸들러를 생성합니다.  
( 참고 : 1.f12 -> elements -> event Listner를 통해 등록된 모든 이벤트 확인가능 , 2 .console.dir(document.querySelector("찾을id").onclick) 역시 해당 이벤트 보여줌

따라서 onclick="handler()"의 경우 생성되는 핸들러 함수는 다음과 같습니다.
```
function(event) {
  handler() // onclick 속성에 할당된 값이 그대로 핸들러 함수 본문이 됩니다.
}
```
그런데 여기서 보면 함수 handler를 괄호를 붙여서 호출하기만 했지, 호출시 반환된 값은 그 어디에서도 사용하지 않고 있습니다. 따라서 아무런 변화가 없습니다.

우리가 원하는 대로 링크로 이동하지 않게 하려면 다음과 같이 코드를 수정하면 됩니다.
```
<script>
  function handler() {
    alert("...");
    return false;   // handler 내에 return false 가 있는 경우
  }
 
-------------------------------------------------------------------------  

  function handler() {
    alert("..."); // handler 내에 return false 가 없는 경우
  }
</script>

<a href="https://w3.org" onclick="return handler()">w3.org</a>
```
+++ event.preventDefault() 사용하는 것이 더 최신방법

요약 : html 내에서 함수 호출 시 이벤트 막기 위한 방법 
```
1. <a href="https://naver.com." onclick="return handler()">naver</a> ( handler 내에 return false 가 있는 경우 )
2. <a href="https://naver.com." onclick="handler(); return false">naver</a> ( handler 내에 return false 가 없는 경우 )
```
출처 참고한사이트 중 정리잘된 곳  : https://ko.javascript.info/task/why-return-false-fails

+++ 추가 
( 왜 일반 js 에서 return; 과 return false; 의 결과는 차이가 없는데 브라우저에서 on이벤트를 발생시킬 때는 return;은 안먹히나 궁금해서 찾아봄 ) 
- 브라우저 내부 코드 보기에는 나오질 않아서 정확한 코드는 찾질 못함...


<핸들러에서 false를 반환하는 것은 예외 상황입니다.
이벤트 핸들러에서 반환된 값은 대개 무시됩니다.

하나의 예외사항이 있는데 바로 on<event>를 사용해 할당한 핸들러에서 false를 반환하는 것입니다.

이 외의 값들은 return 되어도 무시됩니다. true 역시 무시되죠.>
참고 : https://ko.javascript.info/default-browser-action
