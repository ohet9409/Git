-- 글 관리
-- 테이블 생성
create table board (
    seq number not null,                -- 글번호
    id varchar2(20) not null,           -- 아이디
    name varchar2(40) not null,         -- 이름
    subject varchar2(255) not null,     -- 제목
    content varchar2(4000) not null,    -- 내용    
    hit number default 0,               -- 조회수
    logtime date default sysdate        -- 작성일
);

-- 테이블 삭제
drop table board purge;

-- 시퀀스 객체 생성 (시퀀스 객체: 일렬번호 생성 관리)
create sequence seq_board nocache nocycle;

-- 시퀀스 객체 삭제
drop sequence seq_board;

-- 데이터 저장
insert into board values (seq_board.nextval, 'num1', '홍길동','내일은','웃으리...',0,sysdate);

-- 데이터 검색
select * from board ORDER BY seq desc;
select * from board where seq=1;

-- 최근 글 5개만 출력하기
select * from (select rownum rn, tt.* from(select * from board order by seq desc) tt)
where rn>=1 and rn <=5;

-- 최근 글 5개만 출력하기
select seq, id, name, subject, content, hit, to_char(logtime, 'YYYY.MM.DD')as logtime
from (select rownum rn,tt.*from(select * from board order by seq desc)tt) where rn>=1 and rn<=5;

-- 총 데이터 수 구하기
SELECT count(*) as count from BOARD;

-- 조회수 증가
UPDATE BOARD set HIT = hit+1 where seq = 43;

-- 데이터 수정
update board set subject='오늘은',CONTENT='1234' where seq=12;
select subject, content from BOARD where SEQ=12;
-- 데이터 삭제
delete BOARD;
delete board where seq=1;

-- DB 저장
commit;

--ex) 1~9사이에서 2씩 증가됨
CREATE SEQUENCE test19 INCREMENT by 2 minvalue 1 MAXVALUE 9 NOCACHE cycle;
select test19.nextval from board;
drop SEQUENCE test19;