-- ���̺� ����
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
-- ���̺� ����
drop table score purge;

-- ������ ����
insert into score values
('2019001', 'ȫ�浿', 90, 80, 70, 240, 80.0, sysdate);

-- ������ �˻�
select * from score order by studNo asc;
select * from score where studNo='2019001';

-- ������ ����
update score set kor=95, eng=85, mat=75, tot=255, avg=85.0
where studNo='2019001';

-- ������ ����
delete score where studNo='2019001';

-- DB ����
commit;