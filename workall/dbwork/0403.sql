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
select FLOOR(3.0),FLOOR(3.1),FLOOR(3.9)from DUAL;--FLOOR:무조건내림
select MOD(7,3),MOD(9,5) FROM DUAL;--MOD:나머지
select POWER(2,3),POWER(3,4) FROM DUAL;--POWER:지수승
SELECT ROUND(23.456,2),ROUND(8927,-1),ROUND(4567890,-4) FROM DUAL;--ROUND:반올림

--문자함수
select CONCAT('HAPPY','DAY') from DUAL;
select 'HAPPY'||'DAY' FROM DUAL;--위와 결과가 같다
select INITCAP('HAPPY'),INITCAP('hello') from DUAL;--첫글자만 대문자로
select lower('heLLOdAy'),upper('HeLLodAy') from dual; --lower소문자, upper대문자로
select lower(ename),initcap(ename) from EMP;
select lpad(sal,10,'*') from EMP; --왼쪽으로 * 채우기
select rpad(sal,10,'*') from EMP; --왼쪽으로 * 채우기
select substr('happy day',2,3) from dual;--2번인덱스부터 3글자(첫글자 인덱스는 1) : app
select substr('happy day',-5,3) from dual;--뒤에서 2번인덱스부터 3글자(첫글자 인덱스는 1) : y d
select ename,length(ENAME) 글자수 from emp;--length:길이,글자수
select replace('Good Day','o','*') from dual;--o 을*로 변경해서 출력
select instr('happy','a') from dual;--happy 에 a의 위치 :2
select instr('happy','x') from dual; --x가 없을경우 0
SELECT instr('have a nice day','nice') from dual;--8번째에 nice가 있음
select trim('    HELLO    ') from dual; --앞뒤 공백 제거후 출력

--기타함수
--NVL 은 널일경우 대체값으로 출력
select  NVL(COMM,1000) from EMP;--null 일경우 1000 으로 출력
--decode : 값에 따라 다른값을 출력할때
select ENAME 사원명,DEPTNO 부서코드,
 decode(DEPTNO,10,'홍보부',20,'교육부',30,'인사부') 부서명 from EMP;

--join : ppt 43페이지
--inner join(내부조인), equi join
select
    emp.empno,emp.ename,emp.job,dept.dname,dept.LOC
    from emp,DEPT
where emp.DEPTNO=dept.deptno;

--방법2, 두테이블에 공통적으로 있는 컬럼일경우에만 앞에 테이블명을 붙이고 나머지는 생략가능
select
    empno,ename,job,dname,LOC
    from emp,DEPT
where emp.DEPTNO=dept.deptno;

--방법 3 : 테이블명이 너무 길경우 별칭을 사용할수 있다
select
    e.empno,ename,job,dname,LOC
    from emp e,DEPT d
where e.DEPTNO=d.deptno;




