/*
custom -> 새롭게 생성 custom#
product ->  product#
buy -> buy#

1. 제약조건 
1) pk - 필수
2) fk - 필수 : 참조관계 있는 경우에 생성합니다.
3) not null
4) check
5) date 타입 기본값은 현재날짜로 합니다. -> default sysdate

2. 데이터 insert - 데이터 통일 합니다.


3. buy : 기본키 컬럼 buy_no number(9) 를 만드세요. -> 새롭게 추가되는 row 에 대해 자동증가 시키는
	                                             일련번호를 적용할 예정입니다.
	                          -> 시퀀스 이름 buy_seq 를 생성하세요.   (맨 아래 참고)                
	                                             
*/
DROP TABLE CUSTOM#;  -- 필요할 때 테이블 삭제하세요.
CREATE TABLE custom# (    
	custom_id varchar2(20) CONSTRAINT custom_pk PRIMARY KEY, --바이트 지정
	name varchar2(20) NOT null,
	email varchar2(20),
	age number(3),   -- CHECK (age >=14)
	reg_date DATE DEFAULT sysdate
);

DROP TABLE "PRODUCT#" ;  -- 필요할 때 테이블 삭제하세요.

CREATE TABLE product#(
	pcode varchar2(10) constraint product_pk primary key,  
	category char(2) CHECK (category IN ('10','11','12')),   
	pname varchar2(50) not null,  
	price number(9) CHECK (price > 0)
);

CREATE TABLE buy#(
    buy_no number(9) constraint buy_pk primary key,  -- buy_seq 시퀀스 적용할 컬럼입니다.
	custom_id varchar2(20) not null,  --"CUSTOM#"  테이블 참조
	pcode varchar2(10) not null, -- "PRODUCT#"  테이블 참조
	quantity NUMBER(5) CHECK(quantity > 0), --how many?
	buy_date DATE default sysdate ,
	CONSTRAINT custom_id_fk FOREIGN KEY (custom_id)
			REFERENCES custom#(custom_id),
	CONSTRAINT pcode_fk FOREIGN KEY (pcode)
			REFERENCES product#(pcode)
);

INSERT INTO "CUSTOM#"(CUSTOM_ID, NAME, EMAIL, AGE)
VALUES('nayeon', '임나연', 'na@korea.com', 25);
INSERT INTO "CUSTOM#"(CUSTOM_ID, NAME, EMAIL, AGE)
VALUES('jungYu', '유정연', 'jung@daum.net', 27);
INSERT INTO "CUSTOM#"(CUSTOM_ID, NAME, EMAIL, AGE)
VALUES('momo', '히라이모모', 'momo@gmail.com', 24);
INSERT INTO "CUSTOM#"(CUSTOM_ID, NAME, EMAIL, AGE)
VALUES('dahyeon', '김다현', 'da@naver.com',33);


INSERT INTO JCPDEV."PRODUCT#"(PCODE, CATEGORY, PNAME, PRICE)
VALUES('SAV1245-01', '10', '비스포크 청소기', 176000);
INSERT INTO JCPDEV."PRODUCT#"(PCODE, CATEGORY, PNAME, PRICE)
VALUES('ACH991', '11', '아이패드프로 5', 270000);
INSERT INTO JCPDEV."PRODUCT#"(PCODE, CATEGORY, PNAME, PRICE)
VALUES('H49452', '12', '블루투스헤드폰', 90400);
INSERT INTO JCPDEV."PRODUCT#" (PCODE, CATEGORY, PNAME, PRICE)
VALUES('LG98T2', '10', '노트북', 392300);
INSERT INTO JCPDEV."PRODUCT#"(PCODE, CATEGORY, PNAME, PRICE)
VALUES('MU98', '12', 'USB 1TB', 14000);

-- TRUNCATE TABLE buy#;  -- 데이터만 삭제.

CREATE SEQUENCE buy_seq;

-- ※ buy# 테이블 데이터 insert 전에 custom#, product# 데이터 insert 먼저 실행이 되어야 합니다.
-- ※ 이유: buy# 테이블은 외래키를 설정하여 참조 무결성을 검사하고 있습니다. 
INSERT INTO buy# (buy_no,CUSTOM_ID,PCODE,QUANTITY)    -- 컬럼 갯수와 데이터갯수가 일치해야 합니다.
	VALUES(buy_seq.nextval,'jungYu','H49452',1);
INSERT INTO "BUY#"(buy_no,CUSTOM_ID,PCODE,QUANTITY)  --테이블명에 따옴표기호 사용할때는 반드시 대문자로 표기합니다.
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


-- 오라클 데이터베이스 객체 : 시퀀스 - 정수값 n ~ m 까지 +/- k 만큼 값을 계산해서 
--                      일련번호 등의 값을 자동으로 생성(nextval 함수) 
--					    시퀀스는 값을 앞으로 돌릴 수 없으므로 같은 이름으로 1부터 시작하고 싶으면
--						drop sequence [이름] -> 실행하고 다시 생성합니다.

--1)
CREATE SEQUENCE test_seq; -- n은 1부터 , k는 +1 씩 기본값으로 동작합니다.
-- increment by 값  start with 값 MINVALUE 값 MAXVALUE 값
					CREATE TABLE tblseq# (
							column1 number(3)
					);

-- *) 시퀀스 삭제
DROP SEQUENCE test_seq;
-- *) 테이블 데이터 삭제
TRUNCATE TABLE tblseq# ;

--2) 데이터 추가 -> 실행은 2) 3) 만 실행합니다.
INSERT INTO tblseq#(column1) VALUES (test_seq.nextval);
--3) 확인
SELECT * FROM tblseq#;





