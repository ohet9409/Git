-- ȸ�� ����
-- ���̺� ����
CREATE TABLE member(
    name VARCHAR2(30) not null,
    id VARCHAR2(30) PRIMARY key, -- �⺻Ű, unique, not null - ���Ἲ ���� ����
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
-- ȸ��5��
select name,id, pwd, gender, email1, email2, tel1, tel2, tel3, addr, to_char(logtime, 'YYYY.MM.DD')as logtime
from (select rownum rn,tt.*from(select * from member order by name desc)tt) where rn>=1 and rn<=5;

-- ���̺� ���� Ȯ��
desc member;
-- ���̺� ����
drop TABLE member purge;
-- ������ �߰�
INSERT into MEMBER VALUES('ȫ�浿','hong','1234','��','hong','naver.com','010','1234','5678','��⵵ ������',sysdate);
-- ������ �˻�
SELECT * FROM MEMBER order by id;
SELECT * FROM MEMBER where id='hong' and pwd='1234';
SELECT * from MEMBER where id ='hong';
-- ������ ����
update member set name='ȫ�⵿', pwd='1234', gender='m', email1='123', email2='naver.com',tel1='010', tel2='1234', tel3='2345', addr='��⵵' where id ='hong';
-- ������ ����
DELETE MEMBER WHERE id='hong';
-- DB ����
commit;