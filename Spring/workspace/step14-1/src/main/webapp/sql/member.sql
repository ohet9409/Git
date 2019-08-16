-- 회원 관리
-- 테이블 생성
CREATE TABLE member(
    name VARCHAR2(30) not null,
    id VARCHAR2(30) PRIMARY key, -- 기본키, unique, not null - 무결성 제약 조건
    pwd VARCHAR2(30) not null,
    gender VARCHAR2(3),
    email1 VARCHAR2(20),
    email2 VARCHAR2(20),
    tel1 varchar2(10),
    tel2 varchar2(10),
    tel3 varchar2(10),
    addr VARCHAR2(100),
    logtime date
);
-- 회원5명
select name,id, pwd, gender, email1, email2, tel1, tel2, tel3, addr, to_char(logtime, 'YYYY.MM.DD')as logtime
from (select rownum rn,tt.*from(select * from member order by name desc)tt) where rn>=1 and rn<=5;

-- 테이블 구조 확인
desc member;
-- 테이블 삭제
drop TABLE member purge;
-- 데이터 추가
INSERT into MEMBER VALUES('홍길동','hong','1234','남','hong','naver.com','010','1234','5678','경기도 수원시',sysdate);
-- 데이터 검색
SELECT * FROM MEMBER order by id;
SELECT * FROM MEMBER where id='hong' and pwd='1234';
SELECT * from MEMBER where id ='hong';
-- 데이터 수정
update member set name='홍기동', pwd='1234', gender='m', email1='123', email2='naver.com',tel1='010', tel2='1234', tel3='2345', addr='경기도' where id ='hong';
-- 데이터 삭제
DELETE MEMBER WHERE id='hong';
-- DB 저장
commit;