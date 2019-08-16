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
-- 테이블 구조 확인
desc member;
-- 테이블 삭제
drop TABLE member purge;
-- 데이터 추가
INSERT into MEMBER VALUES('홍길동','hong','1234','남','hong','naver.com','010','1234','5678','경기도 수원시',sysdate);
-- 데이터 검색
SELECT * FROM MEMBER;
SELECT * FROM MEMBER where id='hong' and pwd='1234';
SELECT * from MEMBER where id ='hong';
-- 데이터 수정
UPDATE MEMBER set TEL2='2345' where id='hong';
-- 데이터 삭제
DELETE MEMBER WHERE id='hong';
-- DB 저장
commit;