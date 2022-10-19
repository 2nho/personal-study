보통 in 은 where 절에서만 사용하는 경우가 많은데 
```
SELECT T2.A IN (select T1.A from TABLE1 AS T1 )
	FROM TABLE2 AS T2
```
이처럼 select문에서 조회결과로도 이용할 수  있다. 
이때 T2.A 값이 null이라면 무조건 null 반환   -- NULL 은 어떤 연산을 하더라도 NULL 반환

T2.A 의 값이 있고  T1.A 값과 같다면  1 반환( TRUE )

아니라면 
0 반환 (FALSE)


https://dev.mysql.com/doc/refman/8.0/en/comparison-operators.html MYSQL 공식 문서 확인 

mysql> SELECT 2 IN (0,3,5,7);

        -> 0
	
mysql> SELECT 'wefwf' IN ('wee','wefwf','weg');

        -> 1
        
--------------------------------------------------

mysql> SELECT (3,4) IN ((1,2), (3,4));

        -> 1
	
mysql> SELECT (3,4) IN ((1,2), (3,5));

        -> 0
        
