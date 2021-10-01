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

-- ex) 남자 직원의 전체 이름, 성별, 입사일을 입사일 순(선입순)으로 출력하라
select * from employees;
select concat(first_name,'',last_name), gender, hire_date from employees where gender='M' order by hire_date asc;

-- ex) 직원들의 사번, 월급을 사번,월급,이름 순으로 출력
select * from salaries;
select * from employees;
select * from salaries join employees where salaries.emp_no=employees.emp_no; 
select salary, first_name from salaries join employees where salaries.emp_no=employees.emp_no order by salary asc;
select emp_no,salary from salaries order by emp_no asc,salary desc;

-- 함수 : 문자열 함수
-- upper() - 모든 문자열 대문자로 만들어줌
select upper('buSan'), upper('busan'), upper('Douzone');
select upper(first_name) from employees;

-- lower() - 모든 문자열 소문자로 만들어줌
select lower('buSan'), lower('busan'), lower('Douzone');

-- substring(문자열, index, length)
-- ll
select substring('hello world',3,2);

-- ex) 1989년에 입사한 사원들의 이름, 입사일 출력
select first_name, hire_date from employees where hire_date=substring(hire_date, 1, 4);
select * from employees;

-- lpad(오른쪽 정렬), rpad
-- 10자리 공간을 생성하고 빈공간을 -로 채운다analyze
select lpad('1234', 10, '-');
select rpad('1234', 10, '-');

-- ex) 직원들의 월급을 오른쪽 정렬로 빈공간을 *
select lpad(salary,10,'*') from salaries;

-- trim(공백 제거)  ltrim = 왼쪽 공백 없애줌, rtrim = 오른쪽 공백 없애줌
select concat('---',ltrim('   hello   '),'---');
select concat('---',rtrim('   hello   '),'---');

select concat('---',ltrim('   hello   '),'---'),
       concat('---',rtrim('   hello   '),'---'),
       concat('---',trim(both 'X' from 'xxhelloxxx'),'---');          
       
-- abs
select abs(-1), abs(1);

-- mod 
select mod(10,3);

-- floor
select floor(3.14);

-- ceil
select ceil(3.14);
select ceiling(3.14);

-- round : 반올림
-- round(x) : x에 가장 근접한 정수
select round(1.598);

-- round(x,d) : x값 중에 소수점d자리에 가장 근접한 실수
select round(1.598, 1);

-- pow(x,y) : x의 y승
select pow(2,10), pow(10,2);

-- sign(x)
select sign(20), sign(-100), sign(0);

-- greatest(x,y, .......), least(x,y, ........)
select greatest(10,40,20,30), least(10,40,20,30);
select greatest('b','A','C'), least('hello','HELLO','HelloH');

-- 함수 : 날짜 함수
-- CURDATE(), CURRENT_DATE
select curdate(), current_date();

-- 시간
-- CURTIME(), CURRENT_TIME
select curtime(),current_time();

-- now(), sysdate()
select now();
select sysdate();
select now(), sysdate();
select now(),sleep(2),now();
select sysdate(),sleep(2),sysdate();

-- date_format(date, format)
select date_format(now(),'%Y년 %m월 %d일  %h시%i분%s초');
select date_format(now(),'%Y년 %c월 %d일  %h시%i분%s초');

-- period_diff : 두 날짜의 차이를 알려줌
-- YYMM, YYYYMM
-- ex) 근무 개월 수를 출력하시오
select first_name, period_diff(date_format(curdate(), '%Y%m'), date_format(hire_date,'%Y%m')) as 근속날짜 from employees order by 근속날짜 desc;

-- date_add(=adddate), date_sub(=subdate) 
-- 날짜를 date에 type(day, month, year) 형식으로 더하거나 뺀다.
-- ex) 각 사원들의 근무 년수가 5년이 되는 날은 언제인가.
-- interval 5 year = 5년 / month = 5개월
select first_name, hire_date, date_add(hire_date, interval 5 month) from employees;

-- cast 데이터 타입 바꾸기 cast('바꿀거' as 타입)
select '1234'+10, cast('12345' as int) + 10;
select date_format(cast('2021-10-01' as date), '%Y-%m-%d');
select cast(1-2 as unsigned);
select casT(cast(1-2 as unsigned)as signed);

-- mysql, type
-- 문자 : varchar() < cahr < text < CLOB(Character Large OBject)
-- 정수 : signed(unsigned), int(integer), medium int, big int, int(11)
-- float, double
-- 날짜 : time, date, datetime
-- LOB : CLOB, BLOB

