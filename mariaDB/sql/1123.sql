use sqldb;
-- 이름이 '김경호'인 사람보다 키가 큰 사람들의 이름과 키를 출력하라
SELECT NAME, height
FROM usertbl
WHERE height > (SELECT height FROM usertbl WHERE NAME='김경호');

-- 주소가 "경남" 인 사람들의 최소 키보다 큰 사람들에 대한 이름과 키를 출력하라
SELECT NAME, height
FROM usertbl
WHERE height > (SELECT min(height) FROM usertbl WHERE addr='경남');

-- 주소가 "경남" 인 모든 사람들의 키보다 큰 사람들에 대한 이름과 키를 출력하라
SELECT NAME, height
FROM usertbl
WHERE height > all(SELECT height FROM usertbl WHERE addr='경남');

-- userid를 기준으로 해당 회원의 id, name, prodname, addr, 연락처를 출력하라
SELECT U.userid, U.name, B.prodName, U.addr, CONCAT(U.mobile1, U.mobile2) AS '연락처'
FROM usertbl U INNER JOIN buytbl B
ON U.userid = B.userid
ORDER BY U.userid;

USE scott;
-- create table 테이블 만들기
CREATE TABLE emp01(
	EMPNO DECIMAL(4),
	ENAME VARCHAR(20),
	SAL DECIMAL(7,2)
);
-- EMP 테이블을 복사해서 새로운 테이블을 만들 경우
CREATE TABLE emp02
AS
SELECT * FROM emp;
-- EMP 테이블을 복사하는데 empno, ename 두개의 열만 복사하고 싶을 경우
CREATE TABLE emp03
AS
SELECT empno, ename FROM emp;
-- 부서가 10번 부서의 데이터만 가져와서 테이블 EMP04를 생성할 경우
CREATE TABLE emp04
AS
SELECT * FROM emp
WHERE deptno=10;
-- 구조만 따오고 싶은 경우
CREATE TABLE emp05
AS
SELECT * FROM emp WHERE 1=0;

-- JOB 컬럼 추가
ALTER TABLE emp01 ADD JOB VARCHAR(9);
-- JOB 컬럼 수정
ALTER TABLE emp01 MODIFY JOB VARCHAR(30);
ALTER TABLE emp01 MODIFY JOB VARCHAR(20);
ALTER TABLE emp01 MODIFY JOB VARCHAR(10);
-- JOB 컬럼 삭제
-- ALTER TABLE emp01 DROP COLUMN JOB;

-- 테이블 삭제
-- DROP TABLE emp01;

-- 데이터만 삭제 할 경우
-- TRUNCATE TABLE emp02;

-- 테이블 이름을 바꿀경우
-- RENAME TABLE emp02 TO test;


-- DROP TABLE dept01;
/*
CREATE TABLE dept01
AS
SELECT * FROM dept WHERE 0=1;
*/
-- SELECT @@AUTOCOMMIT;
-- SET @@AUTOCOMMIT = 0;

-- TRUNCATE TABLE dept01;
INSERT INTO dept01(deptno, dname, loc) VALUES(10, 'ACCOUNTING', 'NEW YORK');
ROLLBACK;
-- COMMIT;