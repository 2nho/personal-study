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
EX.예 중요(쉽게 이해 안됐음)
```
//named function expression
var foo = function foo() {
    console.log('hello');
};
+++
var foo = function A() {
    A(); // 실행가능 
}

A(); //  Syntax Error
위 코드에서named function expression는 매우 특이하다. foo 라는 변수에 이름있는 함수를 할당하고 있다. 
흔히 알고 있는 함수리터럴과는 좀 거리가 있다. 하지만 이 named function expression에는 한가지 특징이 있다. 
바로 해당 함수의 이름은 함수밖에서는 사용할수 없다는 것이다!!!!

즉 재귀호출외에는 그다지 쓸대가 없다. 하지만 이런 표현식이 가능하다는 것은 알고 있다고 나쁠것은 없지 않은가? 
함수표현은 자기호출함수을 이용하여 콘솔에서 실행결과를 받을 수 있다.
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
