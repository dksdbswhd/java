/*
custom -> ���Ӱ� ���� custom#
product ->  product#
buy -> buy#

1. �������� 
1) pk - �ʼ�
2) fk - �ʼ� : �������� �ִ� ��쿡 �����մϴ�.
3) not null
4) check
5) date Ÿ�� �⺻���� ���糯¥�� �մϴ�. -> default sysdate

2. ������ insert - ������ ���� �մϴ�.


3. buy : �⺻Ű �÷� buy_no number(9) �� ���弼��. -> ���Ӱ� �߰��Ǵ� row �� ���� �ڵ����� ��Ű��
	                                             �Ϸù�ȣ�� ������ �����Դϴ�.
	                          -> ������ �̸� buy_seq �� �����ϼ���.   (�� �Ʒ� ����)                
	                                             
*/
DROP TABLE CUSTOM#;  -- �ʿ��� �� ���̺� �����ϼ���.
CREATE TABLE custom# (    
	custom_id varchar2(20) CONSTRAINT custom_pk PRIMARY KEY, --����Ʈ ����
	name varchar2(20) NOT null,
	email varchar2(20),
	age number(3),   -- CHECK (age >=14)
	reg_date DATE DEFAULT sysdate
);

DROP TABLE "PRODUCT#" ;  -- �ʿ��� �� ���̺� �����ϼ���.

CREATE TABLE product#(
	pcode varchar2(10) constraint product_pk primary key,  
	category char(2) CHECK (category IN ('10','11','12')),   
	pname varchar2(50) not null,  
	price number(9) CHECK (price > 0)
);

CREATE TABLE buy#(
    buy_no number(9) constraint buy_pk primary key,  -- buy_seq ������ ������ �÷��Դϴ�.
	custom_id varchar2(20) not null,  --"CUSTOM#"  ���̺� ����
	pcode varchar2(10) not null, -- "PRODUCT#"  ���̺� ����
	quantity NUMBER(5) CHECK(quantity > 0), --how many?
	buy_date DATE default sysdate ,
	CONSTRAINT custom_id_fk FOREIGN KEY (custom_id)
			REFERENCES custom#(custom_id),
	CONSTRAINT pcode_fk FOREIGN KEY (pcode)
			REFERENCES product#(pcode)
);

INSERT INTO "CUSTOM#"(CUSTOM_ID, NAME, EMAIL, AGE)
VALUES('nayeon', '�ӳ���', 'na@korea.com', 25);
INSERT INTO "CUSTOM#"(CUSTOM_ID, NAME, EMAIL, AGE)
VALUES('jungYu', '������', 'jung@daum.net', 27);
INSERT INTO "CUSTOM#"(CUSTOM_ID, NAME, EMAIL, AGE)
VALUES('momo', '�����̸��', 'momo@gmail.com', 24);
INSERT INTO "CUSTOM#"(CUSTOM_ID, NAME, EMAIL, AGE)
VALUES('dahyeon', '�����', 'da@naver.com',33);


INSERT INTO JCPDEV."PRODUCT#"(PCODE, CATEGORY, PNAME, PRICE)
VALUES('SAV1245-01', '10', '����ũ û�ұ�', 176000);
INSERT INTO JCPDEV."PRODUCT#"(PCODE, CATEGORY, PNAME, PRICE)
VALUES('ACH991', '11', '�����е����� 5', 270000);
INSERT INTO JCPDEV."PRODUCT#"(PCODE, CATEGORY, PNAME, PRICE)
VALUES('H49452', '12', '������������', 90400);
INSERT INTO JCPDEV."PRODUCT#" (PCODE, CATEGORY, PNAME, PRICE)
VALUES('LG98T2', '10', '��Ʈ��', 392300);
INSERT INTO JCPDEV."PRODUCT#"(PCODE, CATEGORY, PNAME, PRICE)
VALUES('MU98', '12', 'USB 1TB', 14000);

-- TRUNCATE TABLE buy#;  -- �����͸� ����.

CREATE SEQUENCE buy_seq;

-- �� buy# ���̺� ������ insert ���� custom#, product# ������ insert ���� ������ �Ǿ�� �մϴ�.
-- �� ����: buy# ���̺��� �ܷ�Ű�� �����Ͽ� ���� ���Ἲ�� �˻��ϰ� �ֽ��ϴ�. 
INSERT INTO buy# (buy_no,CUSTOM_ID,PCODE,QUANTITY)    -- �÷� ������ �����Ͱ����� ��ġ�ؾ� �մϴ�.
	VALUES(buy_seq.nextval,'jungYu','H49452',1);
INSERT INTO "BUY#"(buy_no,CUSTOM_ID,PCODE,QUANTITY)  --���̺�� ����ǥ��ȣ ����Ҷ��� �ݵ�� �빮�ڷ� ǥ���մϴ�.
	VALUES(buy_seq.nextval,'momo','MU98',3);
INSERT INTO "BUY#"(buy_no,CUSTOM_ID,PCODE,QUANTITY) 
	VALUES(buy_seq.nextval,'dahyeon','SAV1245-01',2);
INSERT INTO "BUY#"(BUY_NO, CUSTOM_ID, PCODE, QUANTITY)
VALUES(buy_seq.nextval, 'nayeon', 'MU98', 2);
INSERT INTO "BUY#"(BUY_NO, CUSTOM_ID, PCODE, QUANTITY)
VALUES(buy_seq.nextval, 'dahyeon', 'ACH991', 3);
INSERT INTO "BUY#"(BUY_NO, CUSTOM_ID, PCODE, QUANTITY)
VALUES(buy_seq.nextval, 'jungYu', 'LG98T2', 2);
INSERT INTO "BUY#"(BUY_NO, CUSTOM_ID, PCODE, QUANTITY)
VALUES(buy_seq.nextval, 'nayeon', 'LG98T2', 2);
INSERT INTO "BUY#"(BUY_NO, CUSTOM_ID, PCODE, QUANTITY)
VALUES(buy_seq.nextval, 'jungYu', 'ACH991', 4);


-- ����Ŭ �����ͺ��̽� ��ü : ������ - ������ n ~ m ���� +/- k ��ŭ ���� ����ؼ� 
--                      �Ϸù�ȣ ���� ���� �ڵ����� ����(nextval �Լ�) 
--					    �������� ���� ������ ���� �� �����Ƿ� ���� �̸����� 1���� �����ϰ� ������
--						drop sequence [�̸�] -> �����ϰ� �ٽ� �����մϴ�.

--1)
CREATE SEQUENCE test_seq; -- n�� 1���� , k�� +1 �� �⺻������ �����մϴ�.
-- increment by ��  start with �� MINVALUE �� MAXVALUE ��
					CREATE TABLE tblseq# (
							column1 number(3)
					);

-- *) ������ ����
DROP SEQUENCE test_seq;
-- *) ���̺� ������ ����
TRUNCATE TABLE tblseq# ;

--2) ������ �߰� -> ������ 2) 3) �� �����մϴ�.
INSERT INTO tblseq#(column1) VALUES (test_seq.nextval);
--3) Ȯ��
SELECT * FROM tblseq#;





