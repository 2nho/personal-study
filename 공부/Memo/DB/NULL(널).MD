NULL이란?
칼럼의 값을 모를 때 사용하는 표식으로, 값이 존재하지 않거나 분명하지 않음을 나타낸다.

흔히들 NULL값이라고하지만, 이것은 잘못된 표현이다. 

NULL이 들어있는 속성 값은 존재하지 않는 것이며 NULL은 값이 없다! NULL값이 아니라 단순히 NULL이라고 표현하도록 하자.

특징
- 연산 불가 

-> 어떤 연산을 하더라도 NULL을 반환 (참(1)이나 거짓(0)이 절대 반환되지 않음)

- 옵티마이저에 대한 폐해

-> SQL 개발자가 쿼리를 작성하고 실행할 때 옵티마이저는 sql을 어떻게 실행할지 계획해주는 소프트웨어이다. 

동일한 결과가 나오는 쿼리문이라도 쿼리를 어떻게 실행하느냐에 따라서 성능이 달라지고, 그에 따른 예상 비용도 달라진다.

그런데 테이블에 NULL이 존재하면 옵티마이저가 수학적으로 증명할 수 있는 쿼리의 조합이 제한된다. 

즉 최적의 성능을 낼 수 있는 쿼리의 조합을 찾지 못하는 것이다. 자연스럽게 쿼리의 비용 계산에도 악영향을 끼칠 수밖에 없다.

--------------------------------------------------------------------------
In MySQL, 0 or NULL means false and anything else means true 
1. 의문 : select null like false  / select null = false 는 무조건 null과의 연산이기에 null만나옴. 여기서 의문! 왜 null이 false를 의미한다 했을까?  
- SQL does not really treat NULL as false. Instead, conditional statements are considered true only when the condition evaluates to true.  
SQL은 실제로 NULL을 거짓으로 처리하지 않습니다. 대신 조건문은 조건이 참인 것으로 평가될 때만 참으로 간주됩니다.  
The effect is that NULL is treated as false. But this does not mean that NULL is equivalent to false.  
그 결과 NULL은 거짓으로 처리됩니다. 그러나 이것은 NULL이 거짓과 같다는 것을 의미하지는 않는다.  



It is not that NULL is treated as false. It is that TRUE is true and nothing else (to a close approximation). In particular, NULL is not TRUE, so it fails all   conditionals except IS NULL (and perhaps some extensions in particular languages).

### Don't focus on NULL, focus on TRUE.  
참고 https://dev.mysql.com/doc/mysql-tutorial-excerpt/8.0/en/working-with-null.html

참고2 https://stackoverflow.com/questions/60017275/why-null-is-not-equal-to-anything-is-a-false-statement

참고3 https://en.wikipedia.org/wiki/Null_(SQL)

참고4 https://stackoverflow.com/questions/31040409/why-sql-does-finally-treat-a-null-value-as-false  

Now what happens in WHERE clause? It is designed in such a way that it returns rows where predicate evaluates to TRUE only!  
If predicate evaluates to FALSE or UNKNOWN  
then corresponding row is just filtered out from resultset.

결론 : 내추측이 맞았던거 같다 true가 아니면 전부 false로 보기에 null 또한 false처럼 여겨지기 때문에  
In MySQL, 0 or NULL means false and anything else means true 라고 한거 같다. (꽤.. 헷갈리게 불친절하다)

