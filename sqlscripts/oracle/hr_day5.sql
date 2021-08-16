-- hr ��Ű�� 7���� ���̺��� Ȱ���Ͽ� join ������ ��������.
SELECT * FROM EMPLOYEES ;
SELECT * FROM DEPARTMENTS ;
SELECT * FROM jobs;
SELECT * FROM JOB_HISTORY;
-- ����
-- 1) employee_id, department_name, last_name , hire_date 
-- 2) employee_id, last_name, job_title
-- * �Ʒ� ���� �ۼ��غ�����.
-- 3) 'IT'�μ����� ���� ���� �޿��� �޴� ������ last_name ,hire_date ��ȸ
-- 4) last_name 'Taylor' �� 
--	last_name, hire_date, start_date,end_date,job_id ��ȸ


-- ������ �� ���� ���� : �̿���-----------------------------------------------------------
-- ���޺� ��� ����
SELECT j.JOB_TITLE , AVG(e.SALARY) AS avg_sal 
   FROM JOBS j , EMPLOYEES e WHERE j.JOB_ID = e.JOB_ID  
   GROUP BY j.JOB_TITLE ;
  
SELECT j.JOB_ID , AVG(e.SALARY) AS avg_sal 
   FROM JOBS j , EMPLOYEES e WHERE j.JOB_ID = e.JOB_ID  
   GROUP BY j.JOB_ID ;  

-- ���� : ���ֿ�
--�ּ� ������ 5000�� �̻��� ������ ���̵�,�̸�,����ȣ,������ ��ȸ�Ͻÿ�.
SELECT EMPLOYEE_ID,FIRST_NAME ,LAST_NAME ,PHONE_NUMBER , C.MIN_SALARY 
   FROM EMPLOYEES E ,JOBS  C
   WHERE E.JOB_ID = C.JOB_ID AND MIN_SALARY > 5000  ;
  
-- ���� : �����
-- 2) DEPARTMENTS �̸�, DEPARTMENTS �� ��� �޿�
SELECT D.DEPARTMENT_NAME, AVG(SALARY) FROM EMPLOYEES E, DEPARTMENTS D 
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID GROUP BY D.DEPARTMENT_NAME ;

-- 3) JOB_TITLE ������ �̸�
SELECT JOB_TITLE, FIRST_NAME, LAST_NAME FROM EMPLOYEES E, JOBS J 
WHERE E.JOB_ID = J.JOB_ID;
  
-------------------------------------------------------------------------- 
-- �� �Ʒ� ���� ������ õõ�� Ȯ���� ���ô�.
-- ���� ������ ������ �ӱ� Ȯ��
SELECT e.SALARY, jh.START_DATE 
   FROM EMPLOYEES e , JOB_HISTORY jh 
   WHERE e.EMPLOYEE_ID = jh.EMPLOYEE_ID 
   AND jh.START_DATE =  (SELECT MIN(start_date) FROM JOB_HISTORY);

  
-- 'IT' �μ����� ���� ���� �޿��� �޴� ������ last, first name
SELECT LAST_NAME, FIRST_NAME , SALARY 
   FROM EMPLOYEES
   WHERE SALARY = 
      (SELECT MAX(salary) 
      FROM DEPARTMENTS d , EMPLOYEES e 
      WHERE d.DEPARTMENT_ID = e.DEPARTMENT_ID
      AND DEPARTMENT_NAME = 'IT');

-- last name�� Taylor�� last name, hire date, start date, end date, job id ��ȸ
   SELECT e.LAST_NAME , e.FIRST_NAME, e.HIRE_DATE, jh.START_DATE , jh.END_DATE , jh.JOB_ID 
      FROM JOB_HISTORY jh, EMPLOYEES e 
      WHERE jh.EMPLOYEE_ID = e.EMPLOYEE_ID 
      AND e.LAST_NAME = 'Taylor'; 



--�ٹ��� 2000�� ���� ������ ����� �Ŵ��� �̸�,������ ��¥�� ���Ͻÿ�
SELECT MANAGER_ID ,DEPARTMENT_NAME ,START_DATE
   FROM DEPARTMENTS D ,JOB_HISTORY J 
   WHERE D.DEPARTMENT_ID = J.department_id AND START_DATE >= '2000-01-01';     


-- ���� : �����
-- 1) DEPARTMENT_NAME, FIRST/LAST NAME
SELECT D.DEPARTMENT_NAME, FIRST_NAME, LAST_NAME 
FROM EMPLOYEES E, DEPARTMENTS D WHERE E.MANAGER_ID = D.MANAGER_ID
ORDER BY D.DEPARTMENT_ID DESC;

-- 2) DEPARTMENTS �̸�, DEPARTMENTS �� ��� �޿�
SELECT D.DEPARTMENT_NAME, AVG(SALARY) FROM EMPLOYEES E, DEPARTMENTS D 
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID GROUP BY D.DEPARTMENT_NAME ;

-- 3) JOB_TITLE ������ �̸�
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

-- �ܺ����� �ǽ� �� Ȯ��!!

SELECT first_name,salary,e.department_id,start_date 
   FROM EMPLOYEES e ,JOB_HISTORY jh 
   WHERE e.EMPLOYEE_ID = jh.EMPLOYEE_ID; 
   AND SALARY = (SELECT MIN(SALARY) FROM EMPLOYEES); 
  
SELECT * FROM EMPLOYEES
WHERE SALARY =(SELECT MIN(SALARY) FROM EMPLOYEES);

SELECT * FROM JOB_HISTORY jh ;
  