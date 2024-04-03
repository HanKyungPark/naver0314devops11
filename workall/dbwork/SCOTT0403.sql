--ename 이 'A' 나 'S' 로 시작하는 사람의 ENAME,SAL,COMM 조회
SELECT ENAME from EMP where ENAME LIKE 'A%' or Ename LIKE  'S%';
--COMM이 NULL 이 아닌 사람만 조회
SELECT * FROM EMP where COMM IS NOT NULL;
--MGR 이 7698,7566,7782 인 사람 조회 (IN 사용)
SELECT ENAME,JOB,MGR from EMP where MGR IN (7698,7566,7782);
--SAL 이 2500 부터 3000까지 조회(AND연산)
SELECT ENAME,SAL,JOB from EMP where SAL>=2500 AND SAL<=3000;
--SAL 이 2500부터 3000까지 조회 (BETWEEN 사용)
select ENAME,SAL,JOB FROM EMP where  SAL BETWEEN 2500 AND 3000;
--JOB을 중복처리해서 한번씩만 출력하시오
SELECT distinct JOB FROM EMP;
--서브쿼리문제
--ALLEN 의 직업과 같은 직업을 가진 사람들을 조회하시오
select * from EMP where JOB=(SELECT JOB from EMP where ENAME='ALLEN');
--SCOTT 의 MGR 과 같은값을 가진 사람의 정보를 조회하시오
select * from EMP where MGR=(select MGR from EMP where ENAME='SCOTT');

--숫자함수,문자함수 연습
select ABS(-5),ABS(5) from DUAL;--ABS : 절대값
select CEIL(3.0),CEIL(3.1),CEIL(3.9) from  DUAL; --CEIL:무조건 올림