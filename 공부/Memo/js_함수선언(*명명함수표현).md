1. named function declaration (명명 함수 선언)
```
function hello() {
  // ...
}
```
2.anonymous function expression (익명 함수 표현)
```
var hello = function () {
  //...
}
```
자바스크립트 엔진이 이름을 변수명으로 추정하여 넣는다.  hello.name -> hello 
3. named function expression (명명 함수 표현)
```
var hello = function namedfnc() {
  // ...
}
```
JS 엔진에 의해 추론되지 않음 

4. Immediately-invoked expression (즉시 실행 표현)
```
var hello = (function () {
  //...
})()
```
EX.예
```
var myCounter = (function (initialValue = 0) {
  let count = initialValue
  return function () {
    count++
    return count
  }
})(1) /// 1로 대입 

myCounter() // 2
myCounter() // 3
myCounter() // 4
```
5. function constructor
var hello = new Function()

EX.예
```
const adder = new Function('a', 'b', 'return a + b')
adder(2, 6)
// 8
```
6. arrow function (화살표 함수)
```
var hello = () => {
  //...
}
```



++
렉시컬 스코프 
- 함수를 어디서 호출하는지가 아니라 어디에 선언하였는지에 따라 결정되는 것을 말한다.
- 즉, 함수를 어디서 선언하였는지에 따라 상위 스코프를 결정한다는 뜻이며, 가장 중요한 점은 함수의 호출이 아니라 함수의 선언에 따라 결정된다는 점이다.
- 다른 말로, 정적 스코프(Static scope)
```
var x = 1; // global

function first() {
  var x = 10;
  second();
}

function second() {
  console.log(x);
}

first(); // ?   => 1
second(); // ?  => 1
```
그 이유는?
자바스크립트에서는 위와 같은 코드를 작성할 때, 이미 실행 단계에서 코드들의 스코프를 결정한다.

- global 범위에 있는 변수 x

- first() 함수 안에 있는 변수 x

- second() 함수 안에 있는 변수 x

위 예제의 실행 결과는 함수 second()의 상위 스코프가 무엇인지에 따라 결정된다.

자바스크립트는 렉시컬 스코프(Lexical Scope)를 따르므로 함수를 선언한 시점에 상위 스코프가 결정된다.

즉, 이 말은 함수를 어디에서 호출하였는지는 스코프 결정에 아무런 의미를 주지 않는다는 말이다.

그렇기 때문에, second() 함수가 first() 함수 안에서 호출된 것과 상관없이 second() 함수는 global 범위에 선언되어 있으므로, global 범위에 있는 변수 x의 값 1이 두 번 출력된 것이다.

어떻게 global 변수를 인식하는지를 알려면 스코프 체인 참고!

스코프 체인 참고 
https://ljtaek2.tistory.com/140
