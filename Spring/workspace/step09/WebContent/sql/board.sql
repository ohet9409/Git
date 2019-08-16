-- �� ����
-- ���̺� ����
create table board (
    seq number not null,                -- �۹�ȣ
    id varchar2(20) not null,           -- ���̵�
    name varchar2(40) not null,         -- �̸�
    subject varchar2(255) not null,     -- ����
    content varchar2(4000) not null,    -- ����    
    hit number default 0,               -- ��ȸ��
    logtime date default sysdate        -- �ۼ���
);

-- ���̺� ����
drop table board purge;

-- ������ ��ü ���� (������ ��ü: �ϷĹ�ȣ ���� ����)
create sequence seq_board nocache nocycle;

-- ������ ��ü ����
drop sequence seq_board;

-- ������ ����
insert into board values (seq_board.nextval, 'num1', 'ȫ�浿','������','������...',0,sysdate);

-- ������ �˻�
select * from board ORDER BY seq desc;
select * from board where seq=1;

-- �ֱ� �� 5���� ����ϱ�
select * from (select rownum rn, tt.* from(select * from board order by seq desc) tt)
where rn>=1 and rn <=5;

-- �ֱ� �� 5���� ����ϱ�
select seq, id, name, subject, content, hit, to_char(logtime, 'YYYY.MM.DD')as logtime
from (select rownum rn,tt.*from(select * from board order by seq desc)tt) where rn>=1 and rn<=5;

-- �� ������ �� ���ϱ�
SELECT count(*) as count from BOARD;

-- ��ȸ�� ����
UPDATE BOARD set HIT = hit+1 where seq = 43;

-- ������ ����
update board set subject='������',CONTENT='1234' where seq=12;
select subject, content from BOARD where SEQ=12;
-- ������ ����
delete BOARD;
delete board where seq=1;

-- DB ����
commit;

--ex) 1~9���̿��� 2�� ������
CREATE SEQUENCE test19 INCREMENT by 2 minvalue 1 MAXVALUE 9 NOCACHE cycle;
select test19.nextval from board;
drop SEQUENCE test19;