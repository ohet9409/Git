create table score2(
    hakbun VARCHAR2(20) PRIMARY KEY,
    name VARCHAR2(20) NOT null,
    kor NUMBER,
    eng NUMBER,
    mat NUMBER,
    his NUMBER,
    total NUMBER,
    avg NUMBER
);
-- 글 추가
insert into score2 VALUES('201301061','홍길동',90,90,90,90,360,90);
insert into score2 VALUES('201301033','홍길동',90,90,90,90,360,90);
select count(*) as count from score2;    -- 총 글수
-- 최근 10개 글 출력
select hakbun, name, kor, eng, mat,his, total, avg
from (select rownum rn,tt.*from(select * from score2 order by hakbun asc)tt) where rn>=1 and rn<=10;

select hakbun, name, kor, eng, mat,his, total, avg
from SCORE2;
commit;
drop table score2;