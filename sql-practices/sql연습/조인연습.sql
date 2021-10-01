-- inner join
-- ex) employees 테이블과 title 테이블을 join하여 직원의 이름과 직책을 모두 출력하라
select * from employees;
select * from titles;
select first_name, title from employees join titles where employees.emp_no = titles.emp_no;
select e.first_name, t.title from employees e, titles t where e.emp_no = t.emp_no and t.to_date = '9999-01-01';

-- ex) employees 테이블과 titles 테이블을 join 하여 직원의 이름과 직책을 출력하되, 여성 엔지니어만 출력하시오
select e.first_name, t.title, e.gender from employees e, titles t where e.emp_no = t.emp_no and t.to_date = '9999-01-01'
and e.gender='F' and t.title like '%Engineer%';

-- ANSI/IOS SQL1999 JOIN 표준 문법
-- 1. natural join
-- ex) 두 테이블에 공통 컬럼이 있으면 별다른 조인 조건 없이 암묵적으로 조인이 됨.
select e.first_name, t.title from employees e, titles t where e.emp_no = t.emp_no and t.to_date = '9999-01-01';

-- 쓸일 없다
select e.first_name, t.title from employees e natural join titles t
 -- on e.emp_no = t.emp_no 생략
where t.to_date='9999-01-01';

-- 2. join ~ using
select e.first_name, t.title from employees e join titles t using (emp_no)
where t.to_date='9999-01-01';

-- 3. joing ~ on
select e.first_name, t.title from employees e join titles t on e.emp_no=t.emp_no
where t.to_date='9999-01-01';


