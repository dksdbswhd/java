/*
SQL : select 연습
1. JOBS 테이블
2. LOCATIONS 테이블
3. DEPARTMENTS 테이블
4. JOB_HISTORY 테이블
*/
SELECT * FROM jobs;
-- 1.1)min_salary 필드값이 10000이상인 Job_title 조회
SELECT JOB_TITLE FROM JOBS WHERE MIN_SALARY>=10000;
-- 1.2)job_id 필드값이 CLERK 이 포함된 레코드 조회(모든 필드 조회)
SELECT * FROM JOBS WHERE JOB_ID LIKE '%CLERK%';
-- 추가 : count 함수 -> 조건에 맞는(조회) 레코드 개수
SELECT count(*) FROM JOBS;
SELECT count(*) FROM JOBS WHERE JOB_ID LIKE '%CLERK%';
-- 1.3) job_title 필드값이 programmer 인 레코드 조회
SELECT * FROM JOBS WHERE JOB_TITLE='Programmer';
SELECT * FROM jobs WHERE LOWER(JOB_TITLE)='programmer'; 

SELECT * FROM LOCATIONS;
-- 2.1) city 필드값이 London 인 postal_code 조회
SELECT POSTAL_CODE FROM LOCATIONS WHERE CITY='London';
-- 2.2) country_id 필드값이 CA인 레코드 조회
SELECT * FROM LOCATIONS WHERE COUNTRY_ID='CA';

SELECT * FROM DEPARTMENTS ;
-- 3.1) LOCATION_ID 값이 1700 인 department_name 조회
SELECT DEPARTMENT_NAME FROM DEPARTMENTS WHERE LOCATION_ID=1700;
-- 추가 : LOCATION_ID 값이 1700 이고 manager_id 가 null이 아닌 department_name 조회
SELECT DEPARTMENT_NAME FROM DEPARTMENTS 
	WHERE LOCATION_ID=1700 AND MANAGER_ID IS NOT NULL;

-- 3.2) department_name 필드값이 IT를 포함하는 location_id 조회
SELECT LOCATION_ID FROM DEPARTMENTS 
	WHERE DEPARTMENT_NAME LIKE '%IT%';
-- 추가 : 조회된 결과 중에 중복 제거 -> distinct
SELECT DISTINCT LOCATION_ID FROM DEPARTMENTS 
	WHERE DEPARTMENT_NAME LIKE '%IT%';

SELECT * FROM JOB_HISTORY ;
-- 4.1) start_date 가 2005년도 이후인 레코드 조회
-- 날자 date 타입을 문자열형식 'yyyy-mm-dd' 패턴으로 변환하여 비교 -> to_char 함수
SELECT * FROM JOB_HISTORY WHERE TO_CHAR(START_DATE,'yyyy-mm-dd') >'2005-01-01' ;
-- 날짜 date 타입 데이터는 문자열 형식(년-월-일,년/월/일..),으로 비교 가능합니다.
SELECT * FROM JOB_HISTORY WHERE START_DATE>='20050101';
-- 4.2) department_id 필드값이  80인 레코드 조회
SELECT * FROM JOB_HISTORY WHERE DEPARTMENT_ID=80;

-- 데이터 형식 변환 함수
-- ㄴ  to_char 함수는 date , number 타입도 문자열로 변환합니다.
-- ㄴ  to_number 함수는 char, varchar2 문자열 타입을 수치형식(number)로 변환


-- 집계(통계) 함수 : 그룹 함수, 여러행 또는 모든 행에 대해 함수를 실행되고 결과값은 한 개
--      ㄴ  count(갯수) , sum(수치값 합계) , avg(수치값 평균), max ,min 

SELECT * FROM EMPLOYEES ;

SELECT count(*) FROM EMPLOYEES ;	-- 직원 몇명?
SELECT sum(SALARY) FROM EMPLOYEES ;   -- 직원들의 급여 합계
SELECT avg(SALARY) FROM EMPLOYEES ;   -- 직원들의 평균 합계
SELECT max(SALARY) FROM EMPLOYEES ;   -- 직원들의 최고 급여 금액
SELECT min(SALARY) FROM EMPLOYEES ;   -- 직원들의 최소 급여 금액

SELECT avg(SALARY) FROM EMPLOYEES WHERE JOB_ID ='IT_PROG';  -- 정상 실행

-- SELECT JOB_ID , avg(SALARY) FROM EMPLOYEES WHERE JOB_ID ='IT_PROG';  -- 오류
--  ㄴ 행 그룹화 필요합니다. 

-- 그룹화 : group by 컬럼이름
SELECT JOB_ID , count(*) AS "인원수", avg(SALARY) AS "평균급여액"  
	FROM EMPLOYEES
	GROUP BY JOB_ID ;

-- java 프로그래밍에서 사용하기 위해서 영문으로
SELECT JOB_ID , count(*) CNT, avg(SALARY) SAL_AVG  
	FROM EMPLOYEES
	GROUP BY JOB_ID ;

-- job_id 'IT_PROG' 만 조회하고 싶다면...
-- where 그룹화 할 컬럼의 조건을 작성 (먼저) 하고 -> group by
SELECT JOB_ID , count(*) CNT, avg(SALARY) SAL_AVG  
	FROM EMPLOYEES
	WHERE JOB_ID ='IT_PROG'
	GROUP BY JOB_ID ;

-- sal_avg 9000 이상인 값만 출력하고 싶다면....
-- 그룹화 결과로 조건 조회 -> having
SELECT JOB_ID , count(*) CNT, avg(SALARY) SAL_AVG  
	FROM EMPLOYEES
	GROUP BY JOB_ID 
	HAVING avg(SALARY) > 9000;

-- 위의 결과를 sal_avg 순서대로 오름차순 정렬
SELECT JOB_ID , count(*) CNT, avg(SALARY) SAL_AVG  
	FROM EMPLOYEES
	GROUP BY JOB_ID 
	HAVING avg(SALARY) > 9000
	ORDER BY avg(SALARY);

-- 결론 : 그룹화 순서 from -> where -> group by -> having -> order by