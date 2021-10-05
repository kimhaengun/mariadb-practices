-- DDL 맛보기
use webdb;
drop table member;
create table member(
	no int(11) not null auto_increment,
    email varchar(200) not null,
    password varchar(64) not null,
    name varchar(100) not null,
    deparment varchar(100),
    primary key(no)
);
-- 수정 email 밑에 주소 만들기
alter table member add juminbunho char(13) not null after email;
alter table member add join_date datetime not null;
alter table member add self_intro text;


-- 삭제 juminbunho 삭제
alter table member drop juminbunho;

-- 수정 / 이름만 바꿀 수 없다
alter table member change deparment department varchar(100) not null;

-- 삽입
insert into member() value(null, 'naver@naver.com', password('1234'),'김김김','개발팀',now(),null);
insert into member(email, password, name, department, join_date) value('naver2@naver.com',password('1234'),'나나나','개발팀',now());
select * from member;

-- 

-- 삭제
delete from member where no =2;
desc member;

commit;
set autocommit = 1;