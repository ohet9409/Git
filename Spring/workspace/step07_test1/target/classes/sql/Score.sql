CREATE TABLE score(
    studNo varchar(20) primary key,
    name VARCHAR2(30) not null,
    kor number,
    eng number,
    mat number,
    tot number,
    avg number(4,1),
    logtime date
);
-- 데이터 저장
INSERT INTO score VALUES ('0001','홍길동',100,100,100,300,100,SYSDATE);

-- 데이터 검색
SELECT * FROM score ORDER BY studNo asc;
SELECT * FROM score WHERE studNo ='0001';

-- 데이터 삭제
DELETE score where studNo = '0001';

-- 수정
UPDATE score SET name = '고길동', kor=100, eng=100,mat=100,tot=100,avg=100
where studNo ='0001';

-- DB 저장
commit;
DROP TABLE score purge;
-----------------------------------
-- 테이블 생성
create table goods(
    code VARCHAR2(10),  -- 책코드
    name VARCHAR2(50),  -- 책저자
    price NUMBER,       -- 책가격
    maker VARCHAR2(20)  -- 출판사
);
-- 테이블 제거
drop TABLE goods PURGE;

-- 데이터 저장
INSERT INTO goods VALUES ('p0001','자바무따기',25000,'공갈닷컴');

-- 데이터 검색
SELECT * FROM goods ORDER BY code asc;
SELECT * FROM goods WHERE code ='p0001';

-- 데이터 삭제
DELETE goods where code = 'p0001';

-- 수정
UPDATE goods SET name = '스프링무따기', price=30000, maker='마춤출판사'
where code ='p0001';

-- DB 저장
commit;