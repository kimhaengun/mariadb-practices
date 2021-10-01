use employees;
desc employees;

-- select 연습
select * from departments;

select dept_no, dept_name  from departments;

-- alias (as 별칭)
-- ex) employees 테이블에서 직원의 이름, 성별, 입사일을 출력
select first_name as 이름, gender as 성별, hire_date as 입사일 from employees;

-- ex) employees 테이블에서 직원의 이름, 성별, 입사일을 출력
-- concat() - 문자열을 합쳐줌
select concat(first_name,'',last_name) as 이름, gender as 성별, hire_date as 입사일 from employees;

-- ex) titles 테이블에서 모든 직급의 이름을 출력 
-- distinct - 중복 제거
select title from titles limit 0,3;
select title from titles limit 3,3;
-- 계시판 5개씩 출력할때 limit (i-1)*5,5
select distinct title from titles;

-- ex)1991년 이전에 입사한 직원의 이름, 성별, 입사일을 출력
select * from employees;
select concat(first_name,'',last_name), gender, hire_date from employees where hire_date < '1991-01-01' order by hire_date desc;

-- ex)1989년 이전에 입사한 여직원
-- 논리 연산자
select first_name, gender, hire_date from employees where hire_date < '1989-01-01' and gender ='F';

-- ex)dept_emp 테이블에서 부서 번호가 d005나 d009에 속한 사원의 사번, 부서 번호
-- in 연산자
select * from dept_emp;
select emp_no, dept_no from dept_emp where dept_no = 'd005' or dept_no ='d009';
select emp_no, dept_no from dept_emp where dept_no  in('d005','d009');
-- 서브쿼리  select, from, where 절에 올 수 있다.
select emp_no, dept_no from dept_emp where dept_no  in(select 'd005');

-- ex)1989년에 입사한 직원의 이름, 입사일을 출력하시오
-- like 검색
select first_name, hire_date from employees where hire_date like '1989%';

