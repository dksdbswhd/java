create table MEMBER (
    idx number(5) PRIMARY key,
    stuname varchar2(20) not null,
    email varchar2(20) not null,
    tel varchar2(20),
    password varchar2(10)
   
);

create table book(
    bcode char(5) primary key,
    title varchar2(30) not null,
    writer varchar2(20),
    publisher varchar2(20),
    cdate date
);

create table bookrent(
    idx number(5) not null,
    bcode char(5) not null,
    rent_date DATE NOT null,
    exp_date DATE NOT null,
    state char(1) DEFAULT 'F',
    return_date date,
    constraint rent_pk primary key(idx,bcode)
);

create sequence mem_seq;

insert into member(idx,stuname,email,tel,password)
values(mem_seq.nextval,'이하니','honey@naver.com','010-9889-0567','1122');
insert into member(idx,stuname,email,tel,password)
values(mem_seq.nextval,'이세종','jong@daum.net','010-2354-6773','2345');
insert into member(idx,stuname,email,tel,password)
values(mem_seq.nextval,'최행운','lucky@korea.com','010-5467-8792','9876');
insert into member(idx,stuname,email,tel,password)
values(mem_seq.nextval,'나길동','nadong@kkk.net','010-3456-8765','3456');
insert into member(idx,stuname,email,tel,password)
values(mem_seq.nextval,'강감찬','haha@korea.net','010-3987-9087','1234');

select * from member;

insert into BOOK (BCODE,TITLE,WRITER,PUBLISHER,CDATE) 
values ('A1101','코스모스','칼세이건','사이언스북스',to_date('06/12/01','YY/MM/DD'));
insert into BOOK (BCODE,TITLE,WRITER,PUBLISHER,CDATE) 
values ('B1101','해커스토익','이해커','해커스랩',to_date('18/07/10','YY/MM/DD'));
insert into BOOK (BCODE,TITLE,WRITER,PUBLISHER,CDATE) 
values ('C1101','푸른사자 와니니','이현','창비',to_date('15/06/20','YY/MM/DD'));
insert into BOOK (BCODE,TITLE,WRITER,PUBLISHER,CDATE) 
values ('A1102','페스트','알베르트 까뮈','민음사',to_date('11/03/01','YY/MM/DD'));

select * from book;

DROP TABLE bookrent;

insert into bookrent(idx,bcode,rent_date,exp_date)
values(1,'A1101','2020-10-11','2020-10-25');
insert into bookrent(idx,bcode,rent_date,exp_date,state,return_date)
values(1,'B1101','2020-09-01','2020-09-15','F','2020-09-14');
insert into bookrent(idx,bcode,rent_date,exp_date,state,return_date)
values(2,'C1101','2020-09-12','2020-09-26','T','2020-09-29');
insert into bookrent(idx,bcode,rent_date,exp_date,state,return_date)
values(3,'A1102','2020-10-04','2020-10-18','F','');
insert into bookrent(idx,bcode,rent_date,exp_date,state,return_date)
values(4,'B1101','2020-09-03','2020-09-17','F','2020-09-17');
insert into bookrent(idx,bcode,rent_date,exp_date,state,return_date)
values(4,'C1101','2020-10-02','2020-10-16','F','');

select * from bookrent;

/*
 *  연체 조회 과정
step 1 . bookrent 테이블 (오늘날짜는 2020-10-19)  update 로 state 컬럼 수정.
-반납예정일이 오늘날짜보다 과거이면 연체이므로 state 필드를 'T'로 업데이트 한다
-return_date 이 null 일때 미반납.
step 2 . 조건 적용하여 출력(미반납 목록 : return_date 필드 null)
step 3. 도서명 출력 위해서 book 테이블 조인. decode 함수 사용하여 'T' 대신 '연체' 표시
문제 변경사항은 출력에서 회원이름 빼세요.-> 도서코드 출력
 * 출력컬럼 : idx , bcode , title,pulisher, rent_date, exp_date,state
 */
-- 연체 row 를 state 수정하기
update bookrent set state ='T' 
	where exp_date < '2020-10-19' and return_date is null;   -- '2020-10-19': 오늘

select * from bookrent WHERE return_date IS null;

SELECT * FROM book b,bookrent r WHERE book.BCODE = bookrent.BCODE ;

SELECT idx, b.BCODE , title, publisher, rent_date, exp_date,DECODE(state,'T','연체') 
FROM book b,bookrent r WHERE b.BCODE = r.BCODE AND return_date IS NULL
ORDER BY idx;


-- 대여건수 : where 조건없이 모든 row 에 대해 idx 컬럼으로 group BY 

SELECT idx , count(*) cnt FROM BOOKRENT b GROUP BY idx;

-- 위의 결과와 member 테이블 조인 idx, stuname, 대여건수 컬럼을 조회
SELECT m.idx, STUNAME ,cnt FROM "MEMBER" m , 
			(SELECT idx , count(*) cnt FROM BOOKRENT b GROUP BY idx) r_cnt
WHERE m.idx = r_cnt.idx
ORDER BY idx;

SELECT m.idx, STUNAME ,nvl(cnt,0) FROM "MEMBER" m , 
			(SELECT idx , count(*) cnt FROM BOOKRENT b GROUP BY idx) r_cnt
WHERE m.idx = r_cnt.idx(+)
ORDER BY idx;

-- group by 한 결과로 select 에 쓸수 있는 컬럼은 집계함수와 group by 뒤에 있는 컬럼만 사용합니다.

-- 연체건수 : where state ='T' 조건에 해당하는 row만 idx 컬럼으로 group by

SELECT m.idx, STUNAME ,nvl(카운트,0) FROM "MEMBER" m , 
			(SELECT idx , count(*) "카운트" FROM BOOKRENT b 
			 where state ='T' GROUP BY idx) r_cnt
WHERE m.idx = r_cnt.idx(+)
ORDER BY idx;



