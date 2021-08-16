-- hr 스키마 7개의 테이블을 활용하여 join 예제를 만들어보세요.
SELECT * FROM EMPLOYEES ;
SELECT * FROM DEPARTMENTS ;
SELECT * FROM jobs;
SELECT * FROM JOB_HISTORY;
-- 샘플
-- 1) employee_id, department_name, last_name , hire_date 
-- 2) employee_id, last_name, job_title
-- * 아래 조인 작성해보세요.
-- 3) 'IT'부서에서 가장 높은 급여를 받는 직원의 last_name ,hire_date 조회
-- 4) last_name 'Taylor' 의 
--	last_name, hire_date, start_date,end_date,job_id 조회


-- 연습해 볼 조인 예제 : 이우진-----------------------------------------------------------
-- 직급별 평균 봉급
SELECT j.JOB_TITLE , AVG(e.SALARY) AS avg_sal 
   FROM JOBS j , EMPLOYEES e WHERE j.JOB_ID = e.JOB_ID  
   GROUP BY j.JOB_TITLE ;
  
SELECT j.JOB_ID , AVG(e.SALARY) AS avg_sal 
   FROM JOBS j , EMPLOYEES e WHERE j.JOB_ID = e.JOB_ID  
   GROUP BY j.JOB_ID ;  

-- 예제 : 유주용
--최소 월급이 5000원 이상인 직원의 아이디,이름,폰번호,봉급을 조회하시오.
SELECT EMPLOYEE_ID,FIRST_NAME ,LAST_NAME ,PHONE_NUMBER , C.MIN_SALARY 
   FROM EMPLOYEES E ,JOBS  C
   WHERE E.JOB_ID = C.JOB_ID AND MIN_SALARY > 5000  ;
  
-- 예제 : 김범진
-- 2) DEPARTMENTS 이름, DEPARTMENTS 별 평균 급여
SELECT D.DEPARTMENT_NAME, AVG(SALARY) FROM EMPLOYEES E, DEPARTMENTS D 
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID GROUP BY D.DEPARTMENT_NAME ;

-- 3) JOB_TITLE 구성원 이름
SELECT JOB_TITLE, FIRST_NAME, LAST_NAME FROM EMPLOYEES E, JOBS J 
WHERE E.JOB_ID = J.JOB_ID;
  
-------------------------------------------------------------------------- 
-- 이 아래 연습 예제는 천천히 확인해 봅시다.
-- 가장 오래된 직원의 임금 확인
SELECT e.SALARY, jh.START_DATE 
   FROM EMPLOYEES e , JOB_HISTORY jh 
   WHERE e.EMPLOYEE_ID = jh.EMPLOYEE_ID 
   AND jh.START_DATE =  (SELECT MIN(start_date) FROM JOB_HISTORY);

  
-- 'IT' 부서에서 가장 높은 급여를 받는 직원의 last, first name
SELECT LAST_NAME, FIRST_NAME , SALARY 
   FROM EMPLOYEES
   WHERE SALARY = 
      (SELECT MAX(salary) 
      FROM DEPARTMENTS d , EMPLOYEES e 
      WHERE d.DEPARTMENT_ID = e.DEPARTMENT_ID
      AND DEPARTMENT_NAME = 'IT');

-- last name이 Taylor의 last name, hire date, start date, end date, job id 조회
   SELECT e.LAST_NAME , e.FIRST_NAME, e.HIRE_DATE, jh.START_DATE , jh.END_DATE , jh.JOB_ID 
      FROM JOB_HISTORY jh, EMPLOYEES e 
      WHERE jh.EMPLOYEE_ID = e.EMPLOYEE_ID 
      AND e.LAST_NAME = 'Taylor'; 



--근무를 2000년 이후 시작한 사람의 매니저 이름,시작한 날짜를 구하시오
SELECT MANAGER_ID ,DEPARTMENT_NAME ,START_DATE
   FROM DEPARTMENTS D ,JOB_HISTORY J 
   WHERE D.DEPARTMENT_ID = J.department_id AND START_DATE >= '2000-01-01';     


-- 예제 : 김범진
-- 1) DEPARTMENT_NAME, FIRST/LAST NAME
SELECT D.DEPARTMENT_NAME, FIRST_NAME, LAST_NAME 
FROM EMPLOYEES E, DEPARTMENTS D WHERE E.MANAGER_ID = D.MANAGER_ID
ORDER BY D.DEPARTMENT_ID DESC;

-- 2) DEPARTMENTS 이름, DEPARTMENTS 별 평균 급여
SELECT D.DEPARTMENT_NAME, AVG(SALARY) FROM EMPLOYEES E, DEPARTMENTS D 
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID GROUP BY D.DEPARTMENT_NAME ;

-- 3) JOB_TITLE 구성원 이름
SELECT JOB_TITLE, FIRST_NAME, LAST_NAME FROM EMPLOYEES E, JOBS J 
WHERE E.JOB_ID = J.JOB_ID;

-- 4) LOCATION_ID COUNTRY_ID
SELECT DISTINCT D.LOCATION_ID, L.COUNTRY_ID 
FROM DEPARTMENTS D, LOCATIONS L 
WHERE D.LOCATION_ID = L.LOCATION_ID;

-- 5)
SELECT LAST_NAME, FIRST_NAME, SALARY FROM EMPLOYEES
WHERE SALARY = 
(SELECT MAX(salary) FROM DEPARTMENTS D , EMPLOYEES E 
 WHERE D.DEPARTMENT_ID = E.DEPARTMENT_ID AND DEPARTMENT_NAME = 'IT');

-- 6)
SELECT E.LAST_NAME, E.HIRE_DATE, JH.START_DATE, JH.END_DATE, JH.JOB_ID
FROM EMPLOYEES E, JOB_HISTORY JH
WHERE E.EMPLOYEE_ID = JH.EMPLOYEE_ID AND E.LAST_NAME = 'Taylor';

-- 외부조인 실습 후 확인!!

SELECT first_name,salary,e.department_id,start_date 
   FROM EMPLOYEES e ,JOB_HISTORY jh 
   WHERE e.EMPLOYEE_ID = jh.EMPLOYEE_ID; 
   AND SALARY = (SELECT MIN(SALARY) FROM EMPLOYEES); 
  
SELECT * FROM EMPLOYEES
WHERE SALARY =(SELECT MIN(SALARY) FROM EMPLOYEES);

SELECT * FROM JOB_HISTORY jh ;
  