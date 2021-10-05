-- 문제1.
-- 현재 평균 연봉보다 많은 월급을 받는 직원은 몇 명이나 있습니까?
select avg(salary) as avg from salaries where to_date='9999-01-01' ;
-- 70212

select count(*) from employees e, salaries s where e.emp_no = s.emp_no
and s.salary > (select avg(salary) as avg from salaries where to_date='9999-01-01' ) order by s.salary asc;



-- 문제2.
-- 현재, 각 부서별로 최고의 급여를 받는 사원의 사번, 이름, 부서 연봉을 조회하세요. 단
-- 조회결과는 연봉의 내림차순으로 정렬되어 나타나야 합니다.
select emp_no, max(salary) from salaries where to_date = '9999-01-01' group by emp_no;
select * from employees;

select e.emp_no, e.first_name, s.salary from employees e, (select emp_no, max(salary) as salary from salaries where to_date = '9999-01-01' group by emp_no) as s
where e.emp_no = s.emp_no order by salary desc;

select * from departments d , dept_emp de, (select e.emp_no, e.first_name, s.salary from employees e, (select emp_no, max(salary) as salary from salaries where to_date = '9999-01-01' group by emp_no) as s
where e.emp_no = s.emp_no order by salary desc) as e where d.dept_no = de.dept_no and de.emp_no=e.emp_no group by dept_name;

select * from departments d , dept_emp de, (select e.emp_no as emp_no, e.first_name as first_name, s.salary as salary from employees e, 
(select emp_no, max(salary) as salary from salaries where to_date = '9999-01-01' group by emp_no) as s
where e.emp_no = s.emp_no order by salary desc) as g where d.dept_no = de.dept_no and de.emp_no=e.emp_no group by dept_name;

--
select * from employees e, dept_emp de, salaries;

select * from titles;
select * from dept_emp group by dept_no;

select e.emp_no, e.first_name, s.salary from employees e, 
(select emp_no, max(salary) as salary from salaries where to_date = '9999-01-01' group by emp_no) as s
where e.emp_no = s.emp_no order by salary desc;
--
select e.emp_no,max(s.salary) as salary,e.first_name from salaries s , employees e where s.emp_no = e.emp_no 
and s.to_date='9999-01-01' group by e.emp_no order by s.salary desc; 

select de.dept_no as 부서_no, fin.emp_no as 사원번호,fin.first_name as 이름, fin.salary as 연봉 from dept_emp as de,(select e.emp_no,max(s.salary) as salary,e.first_name from salaries s , employees e where s.emp_no = e.emp_no 
and s.to_date='9999-01-01' group by e.emp_no order by s.salary desc) as fin where de.emp_no = fin.emp_no and de.to_date = '9999-01-01' group by dept_no;


select * from departments group by dept_no;

-- 현재 근무중인 사람들 급여
select e.emp_no, s.salary
from salaries s, employees e 
where s.emp_no = e.emp_no
and s.to_date='9999-01-1' group by s.emp_no;

select s.emp_no, s.salary, e.first_name as salary
from salaries s, employees e 
where s.emp_no = e.emp_no
and s.to_date='9999-01-01' group by s.emp_no;

select * from departments d, dept_emp de
where d.dept_no = de.dept_no
and de.to_date ='9999-01-01';


select s.emp_no as emp_no,e.first_name, s.salary as salary
from salaries s, employees e 
where s.emp_no = e.emp_no
and s.to_date='9999-01-1'
and s.salary = '158220';

select d.dept_name, sub.emp_no, sub.first_name, max(sub.salary)
from departments d, dept_emp de,
(select s.emp_no as emp_no,e.first_name, s.salary as salary
from salaries s, employees e 
where s.emp_no = e.emp_no
and s.to_date='9999-01-1' group by s.emp_no) as sub
where d.dept_no = de.dept_no
and de.emp_no = sub.emp_no
and de.to_date ='9999-01-01'
group by d.dept_no;

-- 문제3.
-- 현재, 자신의 부서 평균 급여보다 연봉(salary)이 많은 사원의 사번, 이름과 연봉을 조회하세요

select d.dept_no, avg(s.salary) from employees e, salaries s,dept_emp de, departments d
where e.emp_no = s.emp_no
and e.emp_no = de.emp_no
and de.dept_no = d.dept_no
and s.to_date = '9999-01-01'
group by d.dept_no;

select sub.dept_no, s.emp_no, e.first_name, s.salary from salaries s, employees e, dept_emp de, (select d.dept_no, avg(s.salary) as salary from employees e, salaries s,dept_emp de, departments d
where e.emp_no = s.emp_no
and e.emp_no = de.emp_no
and de.dept_no = d.dept_no
and s.to_date = '9999-01-01'
group by d.dept_no) as sub 
where s.emp_no = e.emp_no
and e.emp_no = de.emp_no
and de.dept_no = sub.dept_no
and s.to_date = '9999-01-01'
and s.salary > sub.salary
group by s.emp_no;


-- 문제4.
-- 현재, 사원들의 사번, 이름, 매니저 이름, 부서 이름으로 출력해 보세요.

select * from dept_manager;
select * from dept_emp;
    
-- 문제5.
-- 현재, 평균연봉이 가장 높은 부서의 사원들의 사번, 이름, 직책, 연봉을 조회하고 연봉 순으로
-- 출력하세요.

-- 문제6.
-- 평균 연봉이 가장 높은 부서는?

-- 문제7.
-- 평균 연봉이 가장 높은 직책?

-- 문제8.
-- 현재 자신의 매니저보다 높은 연봉을 받고 있는 직원은?
-- 부서이름, 사원이름, 연봉, 매니저 이름, 메니저 연봉 순으로 출력합니다.
-- 
