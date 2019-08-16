-- imageboard 게시판
-- 테이블 생성
CREATE TABLE imageboard (
    seq number not null,            -- 글번호
    imageId VARCHAR2(30) not null, -- 상품코드
    imageName VARCHAR2(40) not null, -- 상품명
    imagePrice number not null,     -- 단가
    imageQty number not null,       -- 개수
    imageContent VARCHAR2(4000) not null, --내용
    image1 VARCHAR2(200),       --파일이름
    logtime date DEFAULT sysdate    --작성일
);
-- 시퀀스 객체 생성
create sequence seq_imageboard nocache nocycle;
-- 테이블 삭제
drop table imageboard purge;
-- 시퀀스 객체 삭제
drop SEQUENCE seq_imageboard;
-- 데이터 저장
INSERT into imageboard VALUES(seq_imageboard.nextval,
'img_001','컵라면',1000,10,'맛있는 컵라면','cupra.jpg',sysdate);
-- 데이터 검색
SELECT * FROM imageboard;
SELECT * from imageboard where seq=1;
-- 데이터 삭제
delete imageboard where seq=1;
--DB 저장
commit;