-- Basic Query

drop table pet;

create table pet(
	name varchar(20),
    owner varchar(20),
    species varchar(20),
    gender char(1),
    birth DATE,
    death DATE
);

-- schema 확인
desc pet;

-- 조회
select name,owner,species,gender,birth,death from pet;

-- 데이터 생성
insert into pet(name,owner,species,gender,birth,death) value("성탄이","나","dog","m","2018-12-25",null);

-- 데이터 삭제
delete from pet where name='성탄이';

-- load data local infile (로컬에 있는 파일을 가져옴)
load data local infile "c:\\pet.txt" into table pet;

-- update 
update pet set death=null where name != 'Bowser';

-- 조회 연습 1: where절 사용하기

-- 1990년 이후에 태어난 친구들
select name, species,birth from pet where birth > '1990-12-31';
select * from pet;

-- Gwen 과 함께 사는 친구들은?
select name,owner,birth from pet where owner='Gwen';

-- null 다루기 1 : 살아 있는 얘들은?   --> is null == null이 아닌 애들 찾기
select name,birth,death from pet where death is null;

-- null 다루기 2: 저 세상간 애들  null 비교는 is null or is not null 을 사용한다.   = null, != null 사용 x
select name,birth,death from pet where death is not null;

-- like 패턴(검색) : 이름이 b로 시작하는얘들
select name from pet where name like 'b%';

-- like 패턴(검색) : 이름이 b로 시작하는얘들중에 6자인 친구
select name from pet where name like 'b_____';

-- 집계(통계) : 모든 동물 수
select count(*) from pet;

-- 컬럼이 null 이면 갯수에 제외된다.
select count(death) from pet;
select count(*) from pet where death is not null;

