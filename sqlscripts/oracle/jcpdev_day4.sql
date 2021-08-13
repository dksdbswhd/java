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











