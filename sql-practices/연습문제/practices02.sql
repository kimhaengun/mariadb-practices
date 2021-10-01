-- 문제 1.
-- 최고임금(salary)과 최저임금을 “최고임금, “최저임금”프로젝션 타이틀로 함께 출력해
-- 보세요. 두 임금의 차이는 얼마인가요? 함께 “최고임금 – 최저임금”이란 타이틀로 출력해
-- 보세요.
-- 집계 쓰면됨
select * from salaries;
select max(salary) as 최고임금, min(salary) as 최저임금, abs(max(salary)-min(salary)) as "최고임금-최저임금" from salaries;

-- 문제2.
-- 마지막으로 신입사원이 들어온 날은 언제 입니까? 다음 형식으로 출력해주세요.
-- 예) 2014년 07월 10일
select * from dept_emp;
select max(from_date) from dept_emp;
select date_format(max(from_date), '%Y년 %m월 %d일') as "마지막 신입" from dept_emp;
select date_format(max(hire_date), '%Y년 %m월 %d일') as "마지막 신입" from employees;

-- 문제3. kip
-- 가장 오래 근속한 직원의 입사일은 언제인가요? 다음 형식으로 출력해주세요.
-- 예) 2014년 07월 10일
--     6월 5일
select * from dept_emp;
select DATEDIFF(DAY, from_date, to_date) from dept_emp;
select DATEDIFF(to_date,from_date) from dept_emp;
select max(DATEDIFF(to_date,from_date)),from_date from dept_emp;

-- 제일 위에 있는 데이터를 가지고 오는것
-- select max(DATEDIFF(to_date,from_date)) as "근속날짜", date_format(from_date, '%Y년 %m월 %d일') as "입사일" from dept_emp;

select * from titles;
select * from dept_emp where from_date = (select max(DATEDIFF(to_date,from_date)) from dept_emp);

select min(from_date) from dept_emp;
select date_format(min(from_date), '%Y년 %m월 %d일') as "입사일"  from dept_emp;
-- 문제4.
-- 현재 이 회사의 평균 연봉은 얼마입니까?
-- 현재 : where 절에서 골라주기
select avg(salary) as "평균 연봉" from salaries where to_date='9999-01-01';

-- 문제5.
-- 현재 이 회사의 최고/최저 연봉은 얼마입니까?
select max(salary) as "최고 연봉", min(salary) as "최저 연봉" from salaries where to_date='9999-01-01';


-- 문제6. kip
-- 최고 어린 사원의 나이와 최 연장자의 나이는?
-- 현재 기준 birth_date로 
select * from employees where birth_date > '1965-02-01';
select min(birth_date) as "어린 사원", max(birth_date)as "연장자" from employees;

select date_format(cast('2021-10-01' as date), '%Y-%m-%d');
select abs(cast(now() as int) - cast(min(birth_date) as int)) from employees;