-- board.sql

-- ���� ������ ��������ִ� ���̺� Ȯ��
select * from tab; 

-- ������� �ϴ� ���̺��� �̸����� ���� �����ϱ� ���� ���� ���̺� ����
drop table board02;

--������ ��ü ���� Ȯ���ϴ� ���
SELECT * FROM user_sequences;
SELECT * FROM user_sequences WHERE sequence_name = 'board02_seq';

--������ ��ü �����ϴ� ���
drop sequence board02_seq;
drop sequence board01_seq;

-- board02 ���̺� ����
create table board02(
	board02_no number(3) primary key,
	board02_name varchar2(20) not null,
	board02_title varchar2(50) not null,
	board02_cont varchar2(3000),
	board02_pwd varchar2(20) not null,
	board02_hit number(2) default 0,
	board02_regdate date
);

--������ ��ü ����(�Խ��� ��ȣ �Ӽ� ��)
create sequence board_seq
	increment by 1 start with 1 nocache;

--�Խù� ���(values(�Խ��� ��ȣ, �Խ���, ����, ����, ��й�ȣ, ��ȸ��, ��ϳ�¥))
insert into board02
	values(board_seq.nextval,'�̼���','��ī��ī','�Խ��� ������ �����մϴ�','1234',default,sysdate);
insert into board02
	values(board_seq.nextval,'�Ż��Ӵ�','�����ؿ�','�������� �Խ��� ������ �����մϴ�','1234',default,sysdate);
insert into board02
	values(board_seq.nextval,'ȫ�浿','�ȳ��ϼ���','�Խ��� ������ �����մϴ�','1234',default,sysdate);
insert into board02
	values(board_seq.nextval,'������','�ݰ����ϴ�','����� �Խ��� ������ �����մϴ�','1234',default,sysdate);

-- ���̺� ����(�������� �������� ����)
select * from board02 order by board02_no desc;