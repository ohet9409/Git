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
-- ������ ����
INSERT INTO score VALUES ('0001','ȫ�浿',100,100,100,300,100,SYSDATE);

-- ������ �˻�
SELECT * FROM score ORDER BY studNo asc;
SELECT * FROM score WHERE studNo ='0001';

-- ������ ����
DELETE score where studNo = '0001';

-- ����
UPDATE score SET name = '��浿', kor=100, eng=100,mat=100,tot=100,avg=100
where studNo ='0001';

-- DB ����
commit;
DROP TABLE score purge;
-----------------------------------
-- ���̺� ����
create table goods(
    code VARCHAR2(10),  -- å�ڵ�
    name VARCHAR2(50),  -- å����
    price NUMBER,       -- å����
    maker VARCHAR2(20)  -- ���ǻ�
);
-- ���̺� ����
drop TABLE goods PURGE;

-- ������ ����
INSERT INTO goods VALUES ('p0001','�ڹٹ�����',25000,'��������');

-- ������ �˻�
SELECT * FROM goods ORDER BY code asc;
SELECT * FROM goods WHERE code ='p0001';

-- ������ ����
DELETE goods where code = 'p0001';

-- ����
UPDATE goods SET name = '������������', price=30000, maker='�������ǻ�'
where code ='p0001';

-- DB ����
commit;