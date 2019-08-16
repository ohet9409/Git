CREATE TABLE score(
    hakbun VARCHAR2(20) PRIMARY KEY, -- 학번
    name VARCHAR2(20) not null,     -- 이름
    kor NUMBER, -- 국어
    eng number, -- 영어
    mat number,  -- 수학
    total number, -- 총점
    avg number
);
-- 글 추가
insert into score VALUES('20130101','홍길동',90,90,90,270,90);
insert into score VALUES('201301033','홍길동',90,90,90,280,100);
select count(*) as count from score;    -- 총 글수
-- 최근 10개 글 출력
select hakbun, name, kor, eng, mat, total, avg
from (select rownum rn,tt.*from(select * from score order by hakbun asc)tt) where rn>=1 and rn<=10;

select hakbun, name, kor, eng, mat, total, avg
from SCORE;
commit;
drop table score;