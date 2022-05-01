-- 문제 1
-- 다음과 같은 형태의 myDB를 만들어라
-- 테이블명 : DEPT
-- 열이름		데이터 형식	NULL 적용		PK
-- DEPTNO	INT			X			O
-- DNAME	VARCHAR(14)	X
-- LOC		VARCHAR(13) O
create database mydb;
use mydb;

CREATE TABLE dept(
	deptno INT NOT NULL,
	dname VARCHAR(14),
	loc VARCHAR(13),
	PRIMARY KEY(deptno)
);
-- 문제 2
-- 만들어진 DEPT테이블에 아래의 데이터를 삽입하라
-- 10, '경리부', '서울'
-- 20, '인사부', '인천'
-- 30, '영업부', '용인'
-- 40, '전산부', '수원'
INSERT INTO dept VALUES(10,'경리부','서울');
INSERT INTO dept VALUES(20,'인사부','인천');
INSERT INTO dept VALUES(30,'영업부','용인');
INSERT INTO dept VALUES(40,'전산부','수원');


-- 문제 3
-- 만들어놓은 mydb에 아래와 같이 테이블을 만들어라.
-- 테이블명 : EMP
-- 열이름
-- - deptNo
-- - deptName 
-- - job 
-- - sal
-- 데이터 형식 : int, char(10), char(5), int
-- PK : deptNo
CREATE TABLE emp(
	deptNo INT,
	deptName CHAR(10),
	job CHAR(5),
	sal INT,
	PRIMARY KEY(deptNo)
);

-- 문제4
-- 만들어진 emp테이블에 아래의 데이터를 삽입하라
-- 10, '인사팀', '사원', 250
-- 20, '재무팀', '대리', 300
-- 30, '법무팀', '과장', 350
-- 40, '영업팀', '사원', 250
-- 50, '설계팀', '부장', 500
INSERT INTO emp VALUES(10, '인사팀', '사원', 250)
,(20, '재무팀', '대리', 300)
,(30, '법무팀', '과장', 350)
,(40, '영업팀', '사원', 250)
,(50, '설계팀', '부장', 500);


-- 문제5
-- emp 테이블에서 job이 '사원'들만 sal을 180으로 고치시오.
UPDATE emp SET sal = 180 WHERE job='사원';

-- 문제6
-- emp테이블에서 '법무팀'을 삭제하세요.
DELETE FROM emp WHERE deptName = '법무팀';

-- 문제 7
-- 만들어놓은 mydb에 아래와 같이 테이블을 만들어라.
-- 테이블명 : videotbl
-- 열이름	    데이터형식		NULL허용	PK	기타
-- video_id int	       	x		O	자동증가(1에서부터 시작)
-- title	varchar(20)	x		x	
-- genre	varchar(8)	x		x	
-- star		varchar(10)	O		X	
CREATE TABLE videotbl(
	video_id INT NOT NULL AUTO_INCREMENT,
	title VARCHAR(20) NOT NULL,
	genre VARCHAR(8) NOT NULL,
	star VARCHAR(10),
	PRIMARY KEY(video_id)
);

-- 문제8
-- 만들어진 videotbl테이블에 아래의 데이터를 삽입하라
-- null, '태극기휘날리며', '전쟁', '장동건'
-- null, '대부', '액션', null
-- null, '반지의제왕', '액션', '일라이저우드'
-- null, '친구', '액션', '유오성'
-- null, '해리포터', '환타지', '다니엘'
-- null, '형', '코미디', '조정석'

INSERT INTO videotbl VALUES
(NULL, '태극기휘날리며', '전쟁', '장동건'),
(null, '대부', '액션', NULL),
(NULL, '반지의제왕', '액션', '일라이저우드'),
(NULL, '친구', '액션', '유오성'),
(NULL, '해리포터', '환타지', '다니엘'),
(NULL, '형', '코미디', '조정석');
  
-- 문제9
--  videotbl 테이블에서 star값이 없는 것만 출력하시오.
SELECT *
FROM videotbl
WHERE star IS NULL;
 
-- 문제10
--  videotbl테이블에서 장르가 액션인것만 출력하시오.
SELECT *
FROM videotbl
WHERE genre = '액션';
 
-- 문제11
--   videotbl테이블에서 주인공이 유오성이 것만 삭제하시오
DELETE from videotbl WHERE star='유오성';


-- 문제12
--   videotbl테이블에서 제목이 형인 것을 동생으로 바꾸시오.
UPDATE videotbl
SET title = '동생'
WHERE title = '형';


-- 문제13
--   videotbl테이블 있는 모든 데이터를 지우시오.
DELETE FROM videotbl;

-- 문제14
--   videotbl테이블을 제거하시오.
DROP TABLE videotbl;


-- JSON 타입을 컬럼으로 잡고있는 테이블 정의
USE SCOTT;

CREATE TABLE employees (
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
	NAME VARCHAR(200),
	PROFILE json
);

INSERT INTO employees(NAME, PROFILE) VALUES('홍길동','{"age":30, "gender":"man", "부서":"개발"}'),
('유관순','{"age":26, "gender":"woman", "부서":"회계"}'),
('임꺽정','{"age":41, "gender":"man", "부서":"총무"}');

INSERT INTO employees(NAME, PROFILE) VALUES('김갑수','[35, "man", "인사"]');

INSERT INTO employees(NAME, PROFILE) VALUES('김근형',JSON_OBJECT(
	'age',41,
	'gender','man',
	'부서','연구'
));

INSERT INTO employees(NAME, PROFILE) VALUES('신사임당',JSON_OBJECT(
	'age',56,
	'gender','woman',
	'부서','영업',
	'자격증',JSON_ARRAY('리눅스 마스터','정보처리기사','CISA')
));

-- 이름과 부서를 출력하는 select 문장
SELECT id, NAME, JSON_EXTRACT(PROFILE, '$.부서') FROM employees;

-- 나이가 35 이상인 사원들의 id, 이름, 나이를 출력하는 SQL을 만들어라
SELECT id, NAME, JSON_EXTRACT(PROFILE,'$.age') 
FROM employees 
WHERE JSON_EXTRACT(PROFILE, '$.age')>=35;

SELECT JSON_EXTRACT(PROFILE, '$[0]')
FROM employees
WHERE NAME='김갑수';

-- JSON 컬럼에서 값을 치환해서 리턴하는 함수 : JSON_REPLACE
-- age 필드의 값을 30으로 변경

SELECT id, NAME, JSON_REPLACE(PROFILE, '$.age', 30)
FROM employees;

-- age필드의 값을 30, gender 필드를 'none' 으로 수정해서 출력
SELECT JSON_REPLACE(PROFILE,
	'$.age', 30,
	'$.gender', 'none') AS jsontext FROM employees;
	
-- age필드의 값에 +1을 더해서 출력
SELECT id, NAME, JSON_REPLACE(PROFILE, '$.age', JSON_EXTRACT(PROFILE, '$.age')+1)
FROM employees;

-- age가 30인 사람의 id와 name을 출력
SELECT id, NAME
FROM employees
WHERE JSON_EXTRACT(PROFILE, '$.age') = 30;


DESC emp;

DESC information_schema.TABLE_CONSTRAINTS;
SELECT * FROM information_schema.TABLE_CONSTRAINTS;


-- 제약조건 없는 테이블 생성
CREATE TABLE emp01(
	empno DECIMAL(4),
	ename VARCHAR(10),
	job VARCHAR(9),
	deptno DECIMAL(2)
);

-- 데이터 생성
INSERT INTO emp01 VALUES(NULL, NULL, 'salesman', 30);

SELECT * FROM emp01;

DELETE FROM emp01;

ALTER TABLE emp01 MODIFY COLUMN empno DECIMAL(4) NOT NULL;

-- not null 제약 조건과 같이 생성
CREATE TABLE emp02(
	empno DECIMAL(4) NOT null,
	ename VARCHAR(10) NOT null,
	job VARCHAR(9),
	deptno DECIMAL(2)
);

INSERT INTO emp02 VALUES(NULL, NULL, 'salesman', 30);

USE SCOTT;

CREATE TABLE emp03(
	empno DECIMAL(4) unique,
	ename VARCHAR(10) NOT null,
	job VARCHAR(9),
	deptno DECIMAL(2)
);

INSERT INTO emp03 VALUES(7499, 'ALLEN', 'SALESMAN', 30);
INSERT INTO emp03 VALUES(7499, 'JONES', 'MANAGER', 20);
INSERT INTO emp03 VALUES(NULL, 'JONES', 'MANAGER', 20);

CREATE TABLE emp04(
	empno DECIMAL(4),
	ename VARCHAR(10) NOT NULL,
	job VARCHAR(9),
	deptno DECIMAL(2),
	CONSTRAINT UNIQUE emp04_empno_uk(empno)
);

SELECT * FROM information_schema.TABLE_CONSTRAINTS WHERE TABLE_NAME='emp04';

SELECT empno, job FROM emp;

CREATE TABLE emp05(
	empno DECIMAL(4),
	ename VARCHAR(20),
	job VARCHAR(9),
	deptno DECIMAL(2),
	CONSTRAINT PRIMARY KEY emp05_empno_pk(empno)
);

INSERT INTO emp05 VALUES(7499, 'ALLEN', 'SALESMAN', 30);
INSERT INTO emp05 VALUES(7499, 'JONES', 'MANAGER', 20);
INSERT INTO emp05 VALUES(NULL, 'JONES', 'MANAGER', 20);


CREATE TABLE emp05(
	empno INT UNSIGNED auto_increment,
	ename VARCHAR(20),
	job VARCHAR(9),
	deptno DECIMAL(2),
	CONSTRAINT PRIMARY KEY emp05_empno_pk(empno)
);

INSERT INTO emp05 VALUES(null, 'ALLEN', 'SALESMAN', 30);
INSERT INTO emp05 VALUES(null, 'JONES', 'MANAGER', 20);
INSERT INTO emp05 VALUES(null, 'JONES', 'MANAGER', 20);
INSERT INTO emp05 VALUES(null, 'ALLEN', 'SALESMAN', 30);

SELECT * FROM emp05;

/*
CREATE TABLE emp06(
	empno INT UNSIGNED,
	ename VARCHAR(20),
	job VARCHAR(9),
	deptno DECIMAL(2) auto_increment,
	CONSTRAINT PRIMARY KEY emp06_empno_pk(empno)
);
*/

SHOW TABLE STATUS WHERE NAME='EMP05';
ALTER TABLE emp05 AUTO_INCREMENT =100;


SELECT * FROM emp;


CREATE TABLE emp06(
	empno DECIMAL(4) PRIMARY KEY,
	ename VARCHAR(20),
	job VARCHAR(9),
	deptno INT,
	CONSTRAINT emp06_DEPTNO_FK FOREIGN KEY (DEPTNO) REFERENCES dept(DEPTNO)
);

INSERT INTO emp06 VALUES(7566, 'jones', 'manager', 60);
INSERT INTO emp06 VALUES(7566, 'jones', 'manager', NULL);


-- check 제약 조건
CREATE TABLE emp07(
	empno DECIMAL(4) PRIMARY KEY,
	ename VARCHAR(10) NOT NULL,
	sal DECIMAL(7, 2),
	gender VARCHAR(1),
	CONSTRAINT emp07_sal_ck CHECK(sal BETWEEN 500 AND 5000),
	CONSTRAINT emp07_gender_ck CHECK(gender IN('M','F'))
);

INSERT INTO emp07 VALUES(1111,'John',7000,'M');
INSERT INTO emp07 VALUES(1111,'John',3000,'A');

-- DEFAULT 제약 조건 
CREATE TABLE dept03(
	deptno DECIMAL(2) PRIMARY KEY,
	dname VARCHAR(14),
	loc VARCHAR(13) DEFAULT 'seoul'
);

INSERT INTO dept03(deptno, dname) VALUES(10, 'accounting');


USE mydb;

SELECT tb2.tec, tb1.ec, tb1.eavg
FROM (
	SELECT 
		COUNT(*) ec, 
		AVG(sal) eavg
	from
		emp
	WHERE job='사원') tb1,
	(SELECT COUNT(*) tec FROM emp) tb2;
