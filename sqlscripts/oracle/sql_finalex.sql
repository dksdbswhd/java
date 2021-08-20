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
values(mem_seq.nextval,'���ϴ�','honey@naver.com','010-9889-0567','1122');
insert into member(idx,stuname,email,tel,password)
values(mem_seq.nextval,'�̼���','jong@daum.net','010-2354-6773','2345');
insert into member(idx,stuname,email,tel,password)
values(mem_seq.nextval,'�����','lucky@korea.com','010-5467-8792','9876');
insert into member(idx,stuname,email,tel,password)
values(mem_seq.nextval,'���浿','nadong@kkk.net','010-3456-8765','3456');
insert into member(idx,stuname,email,tel,password)
values(mem_seq.nextval,'������','haha@korea.net','010-3987-9087','1234');

select * from member;

insert into BOOK (BCODE,TITLE,WRITER,PUBLISHER,CDATE) 
values ('A1101','�ڽ���','Į���̰�','���̾𽺺Ͻ�',to_date('06/12/01','YY/MM/DD'));
insert into BOOK (BCODE,TITLE,WRITER,PUBLISHER,CDATE) 
values ('B1101','��Ŀ������','����Ŀ','��Ŀ����',to_date('18/07/10','YY/MM/DD'));
insert into BOOK (BCODE,TITLE,WRITER,PUBLISHER,CDATE) 
values ('C1101','Ǫ������ �ʹϴ�','����','â��',to_date('15/06/20','YY/MM/DD'));
insert into BOOK (BCODE,TITLE,WRITER,PUBLISHER,CDATE) 
values ('A1102','�佺Ʈ','�˺���Ʈ �','������',to_date('11/03/01','YY/MM/DD'));

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
 *  ��ü ��ȸ ����
step 1 . bookrent ���̺� (���ó�¥�� 2020-10-19)  update �� state �÷� ����.
-�ݳ��������� ���ó�¥���� �����̸� ��ü�̹Ƿ� state �ʵ带 'T'�� ������Ʈ �Ѵ�
-return_date �� null �϶� �̹ݳ�.
step 2 . ���� �����Ͽ� ���(�̹ݳ� ��� : return_date �ʵ� null)
step 3. ������ ��� ���ؼ� book ���̺� ����. decode �Լ� ����Ͽ� 'T' ��� '��ü' ǥ��
���� ��������� ��¿��� ȸ���̸� ������.-> �����ڵ� ���
 * ����÷� : idx , bcode , title,pulisher, rent_date, exp_date,state
 */
-- ��ü row �� state �����ϱ�
update bookrent set state ='T' 
	where exp_date < '2020-10-19' and return_date is null;   -- '2020-10-19': ����

select * from bookrent WHERE return_date IS null;

SELECT * FROM book b,bookrent r WHERE book.BCODE = bookrent.BCODE ;

SELECT idx, b.BCODE , title, publisher, rent_date, exp_date,DECODE(state,'T','��ü') 
FROM book b,bookrent r WHERE b.BCODE = r.BCODE AND return_date IS NULL
ORDER BY idx;


-- �뿩�Ǽ� : where ���Ǿ��� ��� row �� ���� idx �÷����� group BY 

SELECT idx , count(*) cnt FROM BOOKRENT b GROUP BY idx;

-- ���� ����� member ���̺� ���� idx, stuname, �뿩�Ǽ� �÷��� ��ȸ
SELECT m.idx, STUNAME ,cnt FROM "MEMBER" m , 
			(SELECT idx , count(*) cnt FROM BOOKRENT b GROUP BY idx) r_cnt
WHERE m.idx = r_cnt.idx
ORDER BY idx;

SELECT m.idx, STUNAME ,nvl(cnt,0) FROM "MEMBER" m , 
			(SELECT idx , count(*) cnt FROM BOOKRENT b GROUP BY idx) r_cnt
WHERE m.idx = r_cnt.idx(+)
ORDER BY idx;

-- group by �� ����� select �� ���� �ִ� �÷��� �����Լ��� group by �ڿ� �ִ� �÷��� ����մϴ�.

-- ��ü�Ǽ� : where state ='T' ���ǿ� �ش��ϴ� row�� idx �÷����� group by

SELECT m.idx, STUNAME ,nvl(ī��Ʈ,0) FROM "MEMBER" m , 
			(SELECT idx , count(*) "ī��Ʈ" FROM BOOKRENT b 
			 where state ='T' GROUP BY idx) r_cnt
WHERE m.idx = r_cnt.idx(+)
ORDER BY idx;

-- fk �������� ���� : bookrent ���̺� -> idx,bcode

ALTER TABLE BOOKRENT ADD CONSTRAINT rent_idx_fk FOREIGN KEY (idx)
					REFERENCES member(idx);

ALTER TABLE BOOKRENT ADD CONSTRAINT rent_bcode_fk FOREIGN key(bcode)
					REFERENCES book(bcode);





