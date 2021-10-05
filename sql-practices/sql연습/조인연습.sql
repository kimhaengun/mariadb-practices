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


-- outer join
-- insert into dept values(null,'총무');
-- insert into dept values(null,'영업');
-- insert into dept values(null,'개발');
-- insert into dept values(null,'기획');
select * from dept;

-- insert into emp values(null,'둘리',1);
-- insert into emp values(null,'마이콜',2);
-- insert into emp values(null,'또치',3);
-- insert into emp values(null,'길동',null);
select * from emp;

select e.name as '이름', d.name as '부서' from emp e join dept d on e.dept_no = d.no;

-- left join
select e.name as '이름', ifnull(d.name, '없음') as '부서' from emp e left join dept d on e.dept_no = d.no;

-- right join
select e.name as '이름', d.name as '부서' from emp e right join dept d on e.dept_no = d.no;

-- 예제) 현재 상황을 반영한 직원별 근무 부서를 사번, 이름, 근무 부서로 출력해보세요
select * from departments;
select * from employees;
select * from departments join employees on departments.dept_no = employees.emp_no;

select a.emp_no,a.first_name, c.dept_name
from employees a, dept_emp b, departments c
where a.emp_no = b.emp_no
and b.dept_no = c.dept_no
and b.to_date = '9999-01-01';

-- 예제) 현재 회사에서 지급되고 있는 급여체계를 반영한 결과 출력하세요
--      사번, 이름, 연봉 형태로 출력하세요.
select a.emp_no, a.first_name, b.salary
from employees a, salaries b
where a.emp_no = b.emp_no
and b.to_date = '9999-01-01'
order by b.salary desc;

-- 예제) 현재 직책별로 평균 연봉과 인원 수를 구하되 직책별로 인원이 100명 이상인 직책만 출력하세요.
select a.title, avg(salary), count(*)
from titles a, salaries b
where a.emp_no = b.emp_no
and a.to_date = '9999-01-01'
and b.to_date = '9999-01-01'
group by a.title
having count(*) >= 100
order by avg(salary) desc;

-- 현재 부서별로 현재 직책이 engineer인 직원의 평균만 구하시오
select d.dept_name, avg(b.salary)
from dept_emp a, salaries b, titles c, departments d
where a.emp_no = b.emp_no
and b.emp_no = c. emp_no
and a.dept_no = d.dept_no
and a.to_date = '9999-01-01'
and b.to_date = '9999-01-01'
and c.to_date = '9999-01-01'
and c.title = 'Engineer'
group by d.dept_name;

-- 현재 직책별로 급여의 총합을 구하되 Engineer 직책은 제외
-- 단, 총합이 2,000,000 이상인 직책만 나타내며 급여 총합에 대해 내림차순 desc 로 정렬
select a.title, sum(salary) as sum
from titles a, salaries b
where a.emp_no = b.emp_no
and a.to_date='9999-01-01'
and b.to_date='9999-01-01'
and a.title != 'Engineer'
group by a.title
having sum(salary) >= '2000000'
order by sum desc;






