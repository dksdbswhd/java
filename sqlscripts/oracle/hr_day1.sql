-- jobs 테이블에서 데이터를 모두 보여달라.
-- 컬럼명 : job_id, job_title, min_salary,max_salary
-- row : 컬럼 각각에 데이터가 저장되면 하나의 레코드(row) 생성
SELECT * FROM JOBS;    -- * : 모든 컬럼
SELECT JOB_ID ,MAX_SALARY FROM jobs;

SELECT * FROM DEPARTMENTS;  -- departments 테이블
SELECT * FROM REGIONS;		--regions 테이블