-- board.sql

-- 현재 계정에 만들어져있는 테이블 확인
select * from tab; 

-- 만들고자 하는 테이블의 이름으로 새로 생성하기 위해 기존 테이블 삭제
drop table board02;

--시퀀스 객체 생성 확인하는 방법
SELECT * FROM user_sequences;
SELECT * FROM user_sequences WHERE sequence_name = 'board02_seq';

--시퀀스 객체 삭제하는 방법
drop sequence board02_seq;
drop sequence board01_seq;

-- board02 테이블 생성
create table board02(
	board02_no number(3) primary key,
	board02_name varchar2(20) not null,
	board02_title varchar2(50) not null,
	board02_cont varchar2(3000),
	board02_pwd varchar2(20) not null,
	board02_hit number(2) default 0,
	board02_regdate date
);

--시퀀스 객체 생성(게시판 번호 속성 값)
create sequence board_seq
	increment by 1 start with 1 nocache;

--게시물 등록(values(게시판 번호, 게시자, 제목, 내용, 비밀번호, 조회수, 등록날짜))
insert into board02
	values(board_seq.nextval,'이순신','추카추카','게시판 오픈을 축하합니다','1234',default,sysdate);
insert into board02
	values(board_seq.nextval,'신사임당','축하해요','진심으로 게시판 오픈을 축하합니다','1234',default,sysdate);
insert into board02
	values(board_seq.nextval,'홍길동','안녕하세요','게시판 오픈을 축하합니다','1234',default,sysdate);
insert into board02
	values(board_seq.nextval,'강감찬','반갑습니다','당신의 게시판 오픈을 축하합니다','1234',default,sysdate);

-- 테이블 보기(연번으로 내림차순 설정)
select * from board02 order by board02_no desc;