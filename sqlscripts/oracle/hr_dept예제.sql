-- 3) 'IT'부서에서 가장 높은 급여를 받는 직원의 last_name ,hire_date 조회
select * from EMPLOYEES;
select * from DEPARTMENTS;

select DEPARTMENT_ID , max(salary) max_sal
        from employees 
        GROUP BY DEPARTMENT_ID;

select d.department_id id, d.department_name dept , max_sal from departments d,
        (select DEPARTMENT_ID id, max(salary) max_sal
        from employees 
        GROUP by DEPARTMENT_ID) max_sal# 
    where d.DEPARTMENT_ID = max_sal#.id;        

with max_dept as (
select d.department_id id, d.department_name dept , max_sal from departments d,
        (select DEPARTMENT_ID id, max(salary) max_sal
        from employees 
        GROUP by DEPARTMENT_ID) max_sal# 
    where d.DEPARTMENT_ID = max_sal#.id and d.department_name='IT'
)

select e.last_name , e.hire_date 
from employees e 
where e.department_id = (select id from max_dept) 
        and e.salary = (select max_sal from max_dept);

-- select id from max_dept where dept='IT';

with max_dept as (
     select max(salary) max_sal
        from employees 
        where department_id=60       
)

select e.last_name , e.hire_date 
from employees e 
where e.department_id = 60
        and e.salary = (select max_sal from max_dept);