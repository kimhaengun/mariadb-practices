-- subquery

-- 1)from 절의 서브 쿼리
select now() as n, sysdate() as b, 3 + 1 as c;

select *
from(select now() as n, sysdate() as b, 3 + 1 as c) s;


-- ex)현재 Fai Bale이 근무하는 부서에서 근무하는 직원의 사번, 전체 이름 출력
use employees;
select * from employees;

select b.dept_no
from employees a, dept_emp b
where a.emp_no = b.emp_no
and b.to_date='9999-01-01'
and concat(a.first_name,' ',a.last_name) = 'Fai Bale';

select a.emp_no, a.first_name
from employees a, dept_emp b
where a.emp_no = b.emp_no
and b.to_date = '9999-01-01'
and b.dept_no = 'd004';

select a.emp_no, a.first_name
from employees a, dept_emp b
where a.emp_no = b.emp_no
and b.to_date = '9999-01-01'
and b.dept_no = (select b.dept_no
from employees a, dept_emp b
where a.emp_no = b.emp_no
and b.to_date='9999-01-01'
and concat(a.first_name,' ',a.last_name) = 'Fai Bale');

-- 2-1) 단일행 연산자 : =, >, <, >=, <=, <>, !=   --> 값이 하나 일때만 사용할 수있슴.

-- 예제1) 현재 전체 사원의 평균 연봉보다 적은 급여를 가진 사원의 이름, 급여를 출력하세요
-- 1) 평균 연봉부터 구하기
select avg(salary)
from salaries 
where to_date ='9999-01-01';

-- 2)직원들 연봉 구하기
select a.first_name,b.salary
from employees a, salaries b
where a.emp_no = b.emp_no
and b.to_date = '9999-01-01'
and b.salary < '72012';

select a.first_name,b.salary
from employees a, salaries b
where a.emp_no = b.emp_no
and b.to_date = '9999-01-01'
and b.salary < (select avg(salary)
from salaries 
where to_date ='9999-01-01')
order by b.salary desc;

-- 예제2)현재 가장 적은 평균근여의 직책과 평균 급여를 출력하세여
-- 1) 직책별 평균 급여
select a.title, avg(b.salary) as avg_salary
from titles a, salaries b
where a.emp_no = b.emp_no
and a.to_date ='9999-01-01'
and b.to_date ='9999-01-01'
group by a.title
order by avg_salary;

-- 2) 가장 적은 평균 급여를 구하시오
select min(avg_salary)
from (select a.title, avg(b.salary) as avg_salary
from titles a, salaries b
where a.emp_no = b.emp_no
and a.to_date ='9999-01-01'
and b.to_date ='9999-01-01'
group by a.title
order by avg_salary
) a;

select a.title, avg(b.salary) as avg_salary
from titles a, salaries b
where a.emp_no = b.emp_no
and a.to_date ='9999-01-01'
and b.to_date ='9999-01-01'
group by a.title
having;

select a.title, avg(b.salary) as avg_salary
from titles a, salaries b
where a.emp_no = b.emp_no
and a.to_date ='9999-01-01'
and b.to_date ='9999-01-01'
group by a.title
order by avg_salary asc
limit 0, 1;

-- 2-2) 복수행 연산자 = in, not in, any, all

-- any 사용법
-- 1. =any : in (1,10,20)
-- 2. >any, >=any : 최소값
-- 3. <any, <=any : 최대값
-- 4. <>any, not in 동일

-- all 사용법
-- 1. =all(사용 불가..)
-- 2. >all , >= all : 최대값
-- 3. <all , <= all : 최소값

-- 예제3) 현재 급여가 50000 이상인 직원의 이름
select * from salaries where to_date='9999-01-01';
select * from employees;

select b.first_name, a.salary 
from salaries a, employees b
where a.emp_no = b.emp_no
and a.to_date = '9999-01-01'
and a.salary >= 50000
order by a.salary asc;

select emp_no,salary from salaries where to_date='9999-01-01' and salary >= 50000;

select a.first_name, b.salary from employees a, (select * from salaries where to_date='9999-01-01' and salary >= 50000) as b 
where a.emp_no = b.emp_no;

select * 
from employees a, salaries b
where a.emp_no = b.emp_no
and b.to_date = '9999-01-01'
and (a.emp_no,b.salary) in (select emp_no,salary from salaries where to_date='9999-01-01' and salary >= 50000);

-- 예제4) 각 부서별로 최고 월급을 받는 직원의 이름과, 월급
select emp_no,min(salary) from salaries group by emp_no;


select * from dept_emp a, (select emp_no,max(salary) from salaries where to_date='9999-01-01' group by emp_no) b;

-- 1)최고 월급 구하기
select a.dept_no, max(b.salary)
from dept_emp a, salaries b
where a.emp_no =b.emp_no
and a.to_date ='9999-01-01'
and b.to_date = '9999-01-01'
group by a.dept_no;

select c.first_name, b.salary
from dept_emp a, salaries b, employees c
where a.emp_no = b.emp_no
and b.emp_no = c.emp_no
and a.to_date = '9999-01-01'
and b.to_date = '9999-01-01'
and (a.dept_no, b.salary) in (select a.dept_no, max(b.salary)
from dept_emp a, salaries b
where a.emp_no =b.emp_no
and a.to_date ='9999-01-01'
and b.to_date = '9999-01-01'
group by a.dept_no);

select d.dept_name,c.first_name, b.salary
from dept_emp a, salaries b, employees c, departments d
where a.emp_no = b.emp_no
and b.emp_no = c.emp_no
and a.dept_no = d.dept_no
and a.to_date = '9999-01-01'
and b.to_date = '9999-01-01'
and (a.dept_no, b.salary) in (select a.dept_no, max(b.salary)
from dept_emp a, salaries b
where a.emp_no =b.emp_no
and a.to_date ='9999-01-01'
and b.to_date = '9999-01-01'
group by a.dept_no);


