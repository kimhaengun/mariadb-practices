select count(*) from employees;

select * from employees;

-- 문제1
select first_name from employees where emp_no='10944';

-- 문제2
select first_name, gender, hire_date from employees order by hire_date asc;

-- 문제3 킵
select gender from employees;
select count(gender) from employees where gender = 'M';
select count(gender) from employees where gender = 'F';
select count(gender='M') as M,count(gender='F') as F from employees;

-- 문제4
select * from salaries;
select count(*) from salaries where to_date='9999-01-01';

-- 문제5
select count(dept_no) from departments;

-- 문제6 kip
select * from departments;
select * from employees;
select * from dept_manager;
select * from dept_emp;
select * from titles;
select * from salaries;

-- 문제7 CHAR_LENGTH -> char 문자 길이를 반환

select * from departments;
select dept_name from departments order by CHAR_LENGTH(dept_name) desc;

-- 문제8 kip
select * from salaries;


-- 문제9
select distinct title from titles order by CHAR_LENGTH(title) desc;

-- 문제10
select * from titles;
select * from titles where title like 's%';
select * from titles where title like '%Engineer%';
select count(title) from titles where title like '%Engineer%';

-- 문제11
select * from titles where emp_no=13250 order by from_date asc;
