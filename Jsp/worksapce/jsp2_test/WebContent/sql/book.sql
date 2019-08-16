CREATE TABLE book(
    code NUMBER PRIMARY key,    -- 도서코드
    book VARCHAR2(20) not null, -- 도서명
    writer VARCHAR2(20) not null,   -- 저자
    publisher VARCHAR2(20),         -- 출판사
    price NUMBER                -- 가격
);
insert into book VALUES(001,'도서명','저자','출판사',5000);

select code, book, writer, publisher, price
from (select rownum rn,tt.*from(select * from book order by code asc)tt) where rn>=1 and rn<=10;

select count(*) from book;
commit;