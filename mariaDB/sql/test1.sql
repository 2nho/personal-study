-- 아래있는 조건을 만족하는 문제를 풀어서 sql 파일로 제출하시기 바랍니다.

-- sql 파일 이름은 [본인이름.sql] 로 지정해서 제출해주세요

 

-- 문제 풀기 전 준비

-- drop database if exists mydb;

create DATABASE mydb;

use mydb;

-- 다음과 같은 형태의 myDB를 만들어라

-- 열이름 데이터 형식 NULL 적용 PK

-- DEPTNO INT X O

-- DNAME VARCHAR(14) X

-- LOC VARCHAR(13) O

-- drop table if exists dept;

create table dept(

deptno int not null,

    dname varchar(14),

    loc varchar(13),

    primary key(deptno)

);

-- 만들어진 DEPT테이블에 아래의 데이터를 삽입하라

-- 10, '경리부', '서울'

-- 20, '인사부', '인천'

-- 30, '영업부', '용인'

-- 40, '전산부', '수원'

insert into dept values(10, '경리부','서울');

insert into dept values(20, '인사부','인천');

insert into dept values(30, '영업부','용인');

insert into dept values(40, '전산부','수원');

-- mydb 스키마에 만들 테이블은 다음과 같다

-- 테이블명 : emp(기존에 존재하는것은 drop합니다.)

-- 열이름 데이터형식 NULL허용 PK 기타

-- EMPNO int x O

-- ENAME varchar(20) x x

-- JOB    varchar(8) x x

-- MGR  varchar(10) O x

-- HIREDATE date x x

-- SAL int x x

-- COMM int O x

-- DEPTNO int x x FK 설정

-- drop table if exists emp;

create table emp(

EMPNO int not null primary key,

    ENAME varchar(20) not null,

    JOB varchar(8) not null,

    MGR varchar(10),

    HIREDATE date not null,

    SAL int not null,

    COMM int null,

    DEPTNO int not null,

    foreign key(deptno) references dept(deptno)

);

-- 만들어진 emp테이블에 아래의 데이터를 삽입한다.

-- 1001, '김사랑', '사원', 1013, '2007-03-01', 300, NULL, 20

-- 1002, '한예슬', '대리', 1005, '2008-10-01', 250,  80, 30

-- 1003, '오지호', '과장', 1005,'2005-02-10', 500,  100, 30

-- 1004, '이병헌', '부장', 1008, '2003-09-02', 600, NULL, 20

-- 1005, '신동협', '과장', 1005, '2010-02-09', 450,  200, 30

-- 1006, '장동건', '부장', 1008, '2003-10-09', 480, NULL, 30

-- 1007, '이문세', '부장', 1008, '2004-01-08', 520, NULL, 10

-- 1008, '감우성', '차장', 1003, '2004-03-08', 500,  0, 30

-- 1009, '안성기', '사장', NULL, '1996-10-04', 1000, NULL, 20

-- 1010, '이병헌', '과장', 1003, '2005-04-07', 500, NULL, 10

-- 1011, '조향기', '사원', 1007, '2007-03-01', 280, NULL, 30

-- 1012, '강혜정', '사원', 1006, '2007-08-09', 300, NULL, 20

-- 1013, '박중훈', '부장', 1003, '2002-10-09', 560, NULL, 20

-- 1014, '조인성', '사원', 1006, '2007-11-09', 250, NULL, 10

insert into emp values (1001, '김사랑', '사원', 1013, '2007-03-01', 300, null, 20);

insert into emp values (1002, '한예슬', '대리', 1005, '2008-10-01', 250, 80, 30);

insert into emp values (1003, '오지호', '과장', 1005, '2005-02-10', 500, 100, 30);

insert into emp values (1004, '이병헌', '부장', 1008, '2003-09-02', 600, null, 20);

insert into emp values (1005, '신동협', '과장', 1005, '2010-02-09', 450, 200, 30);

insert into emp values (1006, '장동건', '부장', 1008, '2003-10-09', 480, null, 30);

insert into emp values (1007, '이문세', '부장', 1008, '2004-01-08', 520, null, 10);

insert into emp values (1008, '감우성', '차장', 1003, '2004-03-08', 500, 0, 30);

insert into emp values (1009, '안성기', '사장', null, '1996-10-04', 1000, null, 20);

insert into emp values (1010, '이병헌', '과장', 1003, '2005-04-07', 500, null, 10);

insert into emp values (1011, '조향기', '사원', 1007, '2007-03-01', 280, null, 30);

insert into emp values (1012, '강혜정', '사원', 1006, '2007-08-09', 300, null, 20);

insert into emp values (1013, '박중훈', '부장', 1003, '2002-10-09', 560, null, 20);

insert into emp values (1014, '조인성', '사원', 1016, '2007-11-09', 250, null, 10);

select *

  from emp;

  

-- 만들어 놓은 mydb에 다음과 같은 테이블을 만든다.

-- 테이블명 : salgrade

-- 열이름    데이터형식 NULL허용 PK 기타

-- GRADE int     x     O 자동증가

-- LOSAL int     x

-- HISAL int     x

-- drop table if exists salgrade;

create table salgrade(

grade int not null auto_increment primary key,

    losal int not null,

    hisal int not null

);

 

-- salgrader테이블에 아래와 같이 데이터를 삽입하라

-- null, 700, 1200

-- null, 1200, 1400

-- null, 1700, 2000

-- null, 2000, 3000

-- null, 3000, 9999

set @@auto_increment_increment = 1;

insert into salgrade values(null, 700, 1200);

insert into salgrade values(null, 1200, 1400);

insert into salgrade values(null, 1700, 2000);

insert into salgrade values(null, 2000, 3000);

insert into salgrade values(null, 3000, 9999);

-- truncate salgrade;

select *

  from salgrade;

COMMIT;

-- 문제1

-- dept테이블을 이용하여 사원의 이름과 급여와 입사일자, 부서명을 출력하시오.
SELECT ename, sal, hiredate, dname
FROM emp INNER JOIN dept
ON emp.deptno = dept.deptno;
 

-- 문제2

-- dept테이블의 컬럼 중 deptno를 “부서번호”,  dname을 “부서명”으로 출력하는 SQL문을 작성하시오.

SELECT deptno '부서번호', dname AS '부서명'
FROM dept;

 
-- 문제3

-- emp테이블의 직책이 중복되지 않고 한 번씩 나열하는 SQL문 작성하시오.

SELECT DISTINCT job FROM emp; 

 

-- 문제4

-- emp테이블을 이용하여 급여가 300 이하인 사원의 사원번호, 사원 이름, 급여를 출력하시오.

SELECT empno, ename, sal
FROM emp
WHERE sal <= 300;

 

 

-- 문제5

-- emp테이블을 이용하여 이름이 '오지호'인 사원의 사원번호, 사원명, 급여를 출력하세요

SELECT empno, ename, sal
FROM emp
WHERE ename = '오지호';


-- 문제6

-- 급여가 250이거나 300이거나 500인 사원들의 사원 번호와 사원명과 급여를 출력하세요.

-- 단, 2가지 방법으로 다 표현하세요. in()이용과 관계연산자를 이용하는 방법으로 하세요

SELECT empno, ename, sal
FROM emp
WHERE sal IN(250, 300, 500);

SELECT empno, ename, sal
FROM emp
WHERE sal = 250
OR sal = 300
OR sal = 500; 

 

-- 문제7

-- 급여가 250, 300, 500이 아닌 사원들을 출력하세요

-- 단, 2가지 방법으로 다 표현하세요. not in()이용과 관계연산자를 이용하는 방법으로 하세요

SELECT empno, ename, sal
FROM emp
WHERE sal not IN(250, 300, 500);

SELECT empno, ename, sal
FROM emp
WHERE sal != 250
and sal != 300
and sal != 500; 

SELECT empno, ename, sal
FROM emp
WHERE NOT (sal = 250
or sal = 300
or sal = 500);  

-- 문제8

-- 사원들 중에서 이름이 '김'으로 시작하는 사람이거나 이름 중에 '기'를 포함하는 사원의 사원번호와 사원이름을 출력하세요
SELECT empno, ename
FROM emp
WHERE ename LIKE '김%'
OR ename LIKE '%기%';
 

 

-- 문제9

-- 상관이 없는 사원(사장이 되겠지요!)을 출력하세요.

SELECT *
FROM emp
WHERE mgr IS NULL;

 

-- 문제10

-- emp테이블에서 급여가 500이 초과되는 사원들을 출력하는 쿼리문을 작성하시오.
SELECT *
FROM emp
WHERE sal > 500;
 

-- 문제11

-- emp를 이용하여 서브쿼리를 이용해서 ‘이문세’와 동일한 직급을 가진 사원을 출력하는 

-- SQL문을 완성하시오.

SELECT *
FROM emp
WHERE job = (SELECT job FROM emp WHERE ename='이문세');
 

-- 문제12

-- 서브쿼리를 이용하여 ‘이문세’의 급여와 동일하거나 더 많이 받는 사원명과 급여를 

-- 출력하는 SQL문을 작성하시오.

SELECT ename, sal
FROM emp
WHERE sal >= (SELECT sal FROM emp WHERE ename='이문세');

 

-- 문제13

-- 서브쿼리를 이용하여 ‘인천’에서 근무하는 사원의 이름, 부서 번호를 출력하는 SQL문을 작성하시오.
SELECT ename, deptno
FROM emp
WHERE deptno = (SELECT deptno FROM dept WHERE loc='인천');

 

-- 문제14

-- 급여가 500을 초과하는 사원과 같은 부서에 근무하는 사원의 이름, 월급, 부서번호를 출력하시오

-- (서브쿼리에 중복된 값이 나올 수 있으니 distinct 를 이용하자)

SELECT ename, sal, deptno
FROM emp
WHERE deptno IN (SELECT DISTINCT deptno FROM emp WHERE sal > 500);

 

 

-- 문제15

-- 서브쿼리를 이용하여 30번 부서의 최대급여보다 많은 급여를 받는 사원의 이름과 월급을 출력하시오

SELECT ename, sal
FROM emp
WHERE sal > (SELECT MAX(sal) FROM emp WHERE deptno = 30);

 

 

-- 문제16

-- 30번 부서의 최소급여보다 많은 급여를 받는 사원의 이름과 월급을 출력하시오

SELECT ename, sal
FROM emp
WHERE sal > (SELECT MIN(sal) FROM emp WHERE deptno = 30); 

 

 

-- 문제17

-- emp테이블을 이용하여 급여 최고액, 최저액, 총액 및 평균 급여 출력하시오.

SELECT
	MAX(sal) AS '급여 최고액', 
	MIN(sal) AS '급여 최저액', 
	SUM(sal) AS '급여 총액',
	AVG(sal) AS '급여 평균'
FROM
	emp;

  

-- 문제18

-- emp테이블에서 부서 유형별로 급여 최고액, 최저액, 총액 및 평균 급여 출력하시오.
SELECT
	MAX(sal) AS '급여 최고액', 
	MIN(sal) AS '급여 최저액', 
	SUM(sal) AS '급여 총액',
	AVG(sal) AS '급여 평균'
FROM
	emp
GROUP BY
	deptno;
 

 

 

-- 문제19

-- emp테이블에서 직급별 명수 출력하세요.

SELECT job, COUNT(*)
FROM emp
GROUP BY job; 

 

 

-- 문제20

-- emp테이블에서 과장의 수 출력하세요.

SELECT job, COUNT(*)
FROM emp
WHERE job='과장';

 

 

-- 문제21

-- emp테이블에서 급여 최고액, 급여 최저액의 차액 출력하세요

SELECT MAX(sal)-MIN(sal)
FROM emp;

 

 

-- 문제22

-- emp테이블에서 직급별 사원의 최저 급여를 내림차순 출력하세요.

 SELECT job, MIN(sal)
 FROM emp
 GROUP BY job
 ORDER BY MIN(sal) DESC;

 

 

-- 문제23

-- emp테이블에서 부서별 사원수, 평균 급여를 부서별로 오름차순 출력하세요

SELECT deptno, COUNT(*), AVG(sal)
FROM emp
GROUP BY deptno
ORDER BY deptno;
 

 

-- 문제24

-- emp테이블에서 소속 부서별 최대급여와 최소급여 구하여 출력하시오

SELECT deptno, MAX(sal), MIN(sal)
FROM emp
GROUP BY deptno;

 

 

-- 문제25

-- emp테이블에서 부서별 사원수와 커미션(comm)을 받는 사원들의 수를 출력하시오.

SELECT deptno, COUNT(*), COUNT(comm)
FROM emp
GROUP BY deptno;

 

 

-- 문제26

-- emp테이블에서 부서별 평균 급여가 500이상인 부서의 번호와 평균급여를 구하여 출력하시오.

SELECT deptno, AVG(sal)
FROM emp
GROUP BY deptno
HAVING AVG(sal) >= 500;

 

 

-- 문제27

-- emp테이블에서 부서별 최대급여가 500을 초과하는 부서에서 최대급여와 최소급여를 출력하시오.

SELECT deptno, MAX(sal), MIN(sal)
FROM emp
GROUP BY deptno
HAVING MAX(sal) > 500;

 

 

-- 문제28

-- emp테이블에서 부서별 급여총액을 중간합계로 출력하고 사원전체에 대한 총합계를 출력하시오

SELECT deptno, SUM(sal)
FROM emp
GROUP BY deptno
WITH ROLLUP;

 

 

-- 문제29

-- emp테이블에서 부서별 급여 총액을 구하되 부서 내 다시 직급별로 급여총액을 구하여 출력하시오 

SELECT deptno, job, SUM(sal)
FROM emp
GROUP BY deptno, job
WITH ROLLUP;

 

 

-- 문제 30

-- 경리부 부서 소속사원의 이름과 입사일을 출력하시오.(emp, dept테이블 활용.)

SELECT E.ename, E.hiredate
FROM emp E INNER JOIN dept D
ON E.deptno = D.deptno
WHERE D.dname = '경리부';

SELECT ename, hiredate
FROM emp
WHERE deptno = (SELECT deptno FROM dept WHERE dname='경리부');

 

 

-- 문제 31

-- 직급이 과장인 사원의 이름, 부서명을 출력하시오.

SELECT E.ename, D.dname
FROM emp E INNER JOIN dept D
ON E.DEPTNO = d.deptno
WHERE E.job = '과장';

 

 

-- 문제 32

-- 사원이름과 부서이름을 출력하세요.

SELECT E.ename, D.dname
from emp E INNER JOIN dept D
ON E.deptno = D.deptno;

 

 

-- 문제 33

-- 인천에서 근무하는 사원의 이름과 급여를 출력하시오

SELECT E.ename, E.sal
FROM emp E INNER JOIN dept D
ON E.deptno = D.deptno
WHERE D.loc = '인천';

 

 

-- 문제 34

-- emp이용하여 모든 사원의 매니저가 누구인지 다 출력하세요(셀프조인)

SELECT A.ENAME '사원명', B.ENAME '매니저'
FROM emp A LEFT OUTER JOIN emp B
ON A.mgr = B.empno;

 

 

-- 문제 35

-- 이문세의 부서명을 조회하여 출력하시요.

SELECT E.ename '사원명', D.dname '부서명'
FROM emp E INNER JOIN dept D
ON E.DEPTNO = D.deptno
WHERE E.ENAME = '이문세';

 

 

-- 문제 36

-- 부서명, 지역명, 사원수, 부서 내의 모든 사원의 평균 급여를 출력하시오(emp, dept테이블 이용)

SELECT D.dname, D.loc, COUNT(E.EMPNO), avg(E.sal)
FROM emp E RIGHT outer join dept D
ON E.DEPTNO = D.deptno
WHERE E.job = '사원'
GROUP BY D.dname;

 

 

-- 문제 37

-- case문을 이용하여 emp테이블에서 직급에 따라 직급이 '부장'인 사원은 5%, '과장'인

-- 사원은 10%, '대리'인 사원은 15%, '사원'인 사원은 20% 급여를

-- 인상하는 SQL문을 작성하시오.

-- (단, 컬럼은 empno, ename, job, sal을 같이 출력한다.)

SELECT 
	empno, 
	ename, 
	job, 
	sal,
	case
		when job='부장' then sal*1.05
		when job='과장' then sal*1.1
		when job='대리' then sal*1.15
		when job='사원' then sal*1.2
		else sal*1
	END inc
FROM
	emp;