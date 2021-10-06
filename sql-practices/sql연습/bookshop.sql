-- scheme 확인
use webdb;
desc book;
desc author;

-- 1.insert author
insert into author values(null, '스테파니메이어');
select no, name from author;

-- 2.insert book
insert into book values(null,'이클립스', 1, '대여가능');
select *from book;

-- select book
select b.no, b.title,b.status, a.name from book b, author a 
where b.author_no = a.no order by no desc; 
-- update book`s status(no,status)

update book set status = '대여중' where no=1;
select * from book;
