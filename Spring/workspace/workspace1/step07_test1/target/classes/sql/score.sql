-- 테이블 생성
create table score (
	studNo varchar2(30) primary key,   
	name varchar2(30) not null,
	kor number, 
	eng number, 
	mat number, 
	tot number,
	avg number(4, 1),
	logtime date
);
-- 테이블 제거
drop table score purge;

-- 데이터 저장
insert into score values
('2019001', '홍길동', 90, 80, 70, 240, 80.0, sysdate);

-- 데이터 검색
select * from score order by studNo asc;
select * from score where studNo='2019001';

-- 데이터 수정
update score set kor=95, eng=85, mat=75, tot=255, avg=85.0
where studNo='2019001';

-- 데이터 삭제
delete score where studNo='2019001';

-- DB 저장
commit;