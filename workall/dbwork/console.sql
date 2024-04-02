
-- 계정 생성(system 에서만 가능) :실행은 ctrl+enter
create user ParkHanKyung identified by a1234; -- 오류 발생
--최신버전에서는 앞에 공통문자 c##을 붙여서 계정생성을 해야만 한다
create user c##ParkhanKyung identified by a1234;
--system 계정에 생성된 계정 확인하기
select username from dba_users;
--c##angel 계정 삭제하기
drop user c##angel;
--c## 공통문자를 안붙이고 계정생성을 하려면 세션변경을 해야만 한다
alter session set "_ORACLE_SCRIPT"=true;
-- angel 계정을 생성해보자(비번은 a1234)
create user angel identified by a1234;
grant connect,resource to ParkHanKyung;
create user scott_table identified  by a1234;


select *
from "ParkHanKyung_DEPT"


--emp 테이블의 구조 확인
desc "ParkHanKyung_EMP";

--전체 컬럼으로 emp 테이블 조회
select * from "ParkHanKyung_EMP";
--ename,job 컬럼만 조회
select ename,job from "ParkHanKyung_EMP";

--전체 컬럼으로 emp 테이블 조회, emane 의 오름차순(asc) 또는 내림차순으로 조회(desc)
select ename, job from "ParkHanKyung_EMP" order by ename asc;--asc 인경우 생략가능,오름차순 출력
select ename, job from "ParkHanKyung_EMP" order by ename desc;

--job을 조회
select  job from "ParkHanKyung_EMP";

--job 을 조회하는데 같은 직업은 한번만 나오게, 오름차순으로  출력
select distinct  job from "ParkHanKyung_EMP" order by job asc;
select distinct JOB from "ParkHanKyung_EMP" order by 1;

--ename 이 SMITH 인 사람 조회
select * from "ParkHanKyung_EMP" where ENAME='SMITH';
select * from "ParkHanKyung_EMP" where ENAME='ward';--Sql 명령어는 대소문자 상관없지만 데이타는 정확히 써야한다

--ENAME 이 SMITH 이거나 WARD 인 사람 조회(or)
select * from "ParkHanKyung_EMP" where ENAME='SMITH' or ename='WARD';

--ENAME,SAL 을 조회
select  ENAME, SAL from "ParkHanKyung_EMP";

--컬럼제목을 변경
select  ENAME "사 원 명",SAL "급 여" FROM "ParkHanKyung_EMP"; --제목변경시 공백이 포함되어있을경우 반드시 ""로 묶어준다
select  ENAME 사원명,SAL 급여 FROM "ParkHanKyung_EMP";

--여러컬럼을 합해서 하나의 컬럼으로 출력할경우
select '내이름은 '||ENAME||'이고 직업은 '||"ParkHanKyung_EMP".JOB||'입니다' from  "ParkHanKyung_EMP";
select '내이름은 '||ENAME||'이고 직업은 '||"ParkHanKyung_EMP".JOB||'입니다' "사원"from  "ParkHanKyung_EMP";
--예) SMITH 님의 연봉은 800만원입니다 : 제목은"연봉"
select ENAME||'님의 연봉은' ||SAL||'만원입니다' 연봉 FROM "ParkHanKyung_EMP";

--SAL 연봉이 2000~3000 사이 조회(컬럼은 ENAME,SAL)
SELECT  ENAME,SAL FROM  "ParkHanKyung_EMP" WHERE SAL>=2000 and SAL<=3000;
--BETWEEN 을 이용해서 조회할수도 있다
select ENAME,SAL from "ParkHanKyung_EMP" WHERE SAL BETWEEN  1000 AND 2000;

--직업이 SAILSMAN, MANAGER, CLERK 조회
select ENAME,job from "ParkHanKyung_EMP" WHERE  JOB='SAILMAN' OR Job='MANAGER' OR JOB='CLERK';
--IN 을 이용해서 여러직업으로 출력해보자
select ENAME,job from "ParkHanKyung_EMP" WHERE JOB IN('SAILSMAN','MANAGER','CLERK');

--MGR이 7902,7839,7788 조회 (컬럼은 ENAME,JOB,MGR)-IN 사용해서
SELECT ENAME,JOB,MGR FROM  "ParkHanKyung_EMP" WHERE MGR IN (7902,7839,7788);

--MGR 이 NULL 인경우만 출력
SELECT * FROM  "ParkHanKyung_EMP" WHERE MGR IS  NULL;

--COMM 이 NULL 인 경우
SELECT * FROM  "ParkHanKyung_EMP" WHERE COMM IS NULL;

--COMM 이 NULL 이 아닌경우
SELECT * FROM  "ParkHanKyung_EMP" WHERE COMM IS NOT NULL;

--문자조회시 %,_를 이용해서 조회
--ENAME 이 A 로 시작하는 사람 조회
select  ENAME,SAL from "ParkHanKyung_EMP" WHERE ENAME LIKE  'A%';

--ENAME 이 N으로 끝나는 사람
select  ENAME,SAL from "ParkHanKyung_EMP" WHERE ENAME LIKE  '%N';

--이름의 두번째 글자가 A 인사람 조회
select  ENAME,SAL from "ParkHanKyung_EMP" WHERE ENAME LIKE  '_A%';
--이름의 세번째 글자가 A 인사람 조회
select  ENAME,SAL from "ParkHanKyung_EMP" WHERE ENAME LIKE  '__A%';

--이름이 S나M으로 시작하는사람
select  ENAME,SAL from "ParkHanKyung_EMP" WHERE ENAME LIKE  'S%' or ENAME LIKE 'M%';
--이름이 S로 시작하는 사람중에 연봉이 2000 이상인 사람 조회
select  ENAME,SAL from "ParkHanKyung_EMP" WHERE ENAME LIKE  'S%' and SAL >=2000;
--MGR 이 7902,7788,7566 이 아닌사람을 조회
SELECT ENAME,JOB,MGR FROM  "ParkHanKyung_EMP" WHERE  MGR NOT IN  (7902,7566,7788);

--COMM, COMM+1000 의 결과 출력
SELECT  COMM,COMM+1000 FROM  "ParkHanKyung_EMP"; -- NULL 인 경우는 더해도 결과는 NULL

--함수중 NVL(컬럼명,널일경우초기값),MYSQL 은 ifnull 이다
SELECT  NVL(COMM,0),NVL(COMM,0)+1000 FROM  "ParkHanKyung_EMP";

--위의 SQL문을 컬럼제목을 추가하여 완성하시오 "COMM', "COMM2"
SELECT  NVL(COMM,0) COMM,NVL(COMM,0)+1000 COMM2 FROM  "ParkHanKyung_EMP";

--SAL 이 2000~3000 이 아닌경우 조회, 두가지 방법으로 해보기
select ENAME,SAL FROM "ParkHanKyung_EMP" WHERE SAL<2000 OR SAL>3000;
select ENAME,SAL FROM "ParkHanKyung_EMP" WHERE SAL NOT BETWEEN 2000 and 3000;

--GROUP 함수(COUNT,MAX,Min<AVG,SUM)
SELECT COUNT(*) FROM "ParkHanKyung_EMP"; -- 전체 인원수
SELECT MAX(SAL) FROM "ParkHanKyung_EMP";--최고연봉
select min(SAL) FROM "ParkHanKyung_EMP"; --최소연봉
select SUM(SAL) FROM "ParkHanKyung_EMP"; --SAL의 합계
select avg(SAL) FROM "ParkHanKyung_EMP"; --SAL의 평균

--AVG는 소숫점이하가 많이 나오는경우가 많아서 ROUND,CEIL,FLOOR 등과 같이 많이 사용
--평균은 소숫점이하 2자리까지만 나오게 하기
select ROUND(avg(SAL),2) from "ParkHanKyung_EMP"; --2073,21
select CEIL(AVG(SAL))from "ParkHanKyung_EMP";--무조건 올림
select  FLOOR(avg(SAL)) from "ParkHanKyung_EMP";--무조건 내림

--PPT 57페이지 GROUP BY절
--JOB 을 그룹으로 직업별 각 인원수를 구해보자
select JOB 직업,count(*) 인원수 From "ParkHanKyung_EMP" group by job;

--위의 결과에 직업의 오름차순으로 출력
SELECT JOB 직업,COUNT(*) 인원수 FROM "ParkHanKyung_EMP" GROUP BY JOB ORDER BY  직업;--컬럼명으로 순서정하기
SELECT JOB 직업,COUNT(*) 인원수 FROM "ParkHanKyung_EMP" GROUP BY JOB ORDER BY  1;--컬럼번호로 순서정하기

--위의 결과에 인원수의 오름차순으로 출력
SELECT JOB 직업,COUNT(*) 인원수 FROM "ParkHanKyung_EMP" GROUP BY JOB ORDER by 인원수;--컬럼명으로 순서정하기
SELECT JOB 직업,COUNT(*) 인원수 FROM "ParkHanKyung_EMP" GROUP BY JOB ORDER BY  2;--컬럼명으로 순서정하기


 --직업별 인원수와 최고연봉,최저연봉,평균연봉(무조건올림) 을 구해보시오
select JOB,COUNT(*),MAX(SAL),MIN(SAL),CEIL(AVG(SAL)) FROM  "ParkHanKyung_EMP" GROUP BY JOB;
select JOB 직업,COUNT(*) 인원수,MAX(SAL) 최고연봉,MIN(SAL) 최저연봉,CEIL(AVG(SAL)) 평균연봉 FROM  "ParkHanKyung_EMP" GROUP BY JOB;

--HAVING 은 GROUP 절에서 그룹함수를 이용해서 조건을 나타낼경우
--직업별 인원수와 최고연봉을 구하는데 직업별 인원수가 3명 이상인경우만 조회를 하시오
SELECT JOB,COUNT(*),MAX(SAL) FROM  "ParkHanKyung_EMP" GROUP BY JOB HAVING COUNT(JOB)>=3;

--오라클에서는 현재날짜를 구할때 SYSDATE,MYSQL 은 NOW()
SELECT SYSDATE FROM DUAL;--현재 콜솔에 현재 날짜출력
--3일뒤
SELECT SYSDATE+3 FROM DUAL;
--30일뒤
SELECT SYSDATE+30 FROM DUAL;

--날짜타입을 문자열로 변환 TO_CHAR : 기호 Y<M,D,HH,HH24,MI,SS,AM/PM등
select TO_CHAR(SYSDATE,'YYYY') FROM DUAL;--2024
select TO_CHAR(SYSDATE,'YEAR') FROM DUAL;--영문자로 나옴,잘안씀

select TO_CHAR(SYSDATE,'MM') FROM DUAL;--04
select TO_CHAR(SYSDATE,'MONTH') FROM DUAL;--영어/한글로 월이 나옴

--기호를 많이 쓰는데 다양한 기호로 날짜를 출력해보자
SELECT TO_CHAR(SYSDATE,'YYYY-MM-DD') FROM DUAL;
SELECT TO_CHAR(SYSDATE,'YYYY-MM-DD AM HH:MI') FROM DUAL; --AM 또는 PM시간상관없이 사용
SELECT TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI') FROM DUAL;

--EMP 에서 HIREDATE(날짜타입)를 이용해서 출력해보자
SELECT ENAME,TO_CHAR(HIREDATE,'YYYY-MM-DD') FROM "ParkHanKyung_EMP";

--고용년도가 1987 인 사람 출력
SELECT *FROM "ParkHanKyung_EMP" WHERE TO_CHAR(HIREDATE,'YYYY')='1987';
SELECT *FROM "ParkHanKyung_EMP" WHERE TO_CHAR(HIREDATE,'YYYY')=1987;
--고용월이 5월인 사람 출력
SELECT *FROM "ParkHanKyung_EMP" WHERE TO_CHAR(HIREDATE,'MM')='05';
SELECT *FROM "ParkHanKyung_EMP" WHERE TO_CHAR(HIREDATE,'MM')=5;

--SUBQUERY(SELECT 문 안에 또 SELECT 문이 있는경우)
--SCOTT 의 연봉과 같은 연봉을 가진 사람을 구하시오
SELECT * FROM "ParkHanKyung_EMP" WHERE SAL= (SELECT  SAL FROM "ParkHanKyung_EMP" WHERE ENAME='SCOTT');
--평균연봉보다 많이 받는 사람의 정보를 출력하시오
SELECT * FROM  "ParkHanKyung_EMP" WHERE SAL>(SELECT  AVG(SAL) FROM "ParkHanKyung_EMP");
--select * from "ParkHanKyung_EMP" where ENAME = 'SCOTT


