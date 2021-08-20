-- 쇼핑몰 : 고객이 상품을 구매한다.
-- 고객(custom) 테이블 생성 : 필드(컬럼) 구성은 이름과 데이터형식 중요.
CREATE TABLE custom (    
	-- 고객 아이디(문자열,var:가변적인 char:문자 , 바차2,문자인코딩 utf-8)
	-- 고객 이름(문자열)
	-- 이메일(문자열)
	-- 나이(정수,number) 3자리 *number : int,long,float,doble
	-- 가입일자(날짜 타입)
	custome_id varchar2(20), --바이트 지정
	name varchar2(20),
	email varchar2(20),
	age number(3),
	reg_date date
);

-- 상품(product) 테이블 : 상품코드,카테고리(코드:2자리),상품명,가격 
--								ㄴ 00:전자제품,10:식품,20:생활용품..
CREATE TABLE product(
	pcode varchar2(10),  -- 가능한 데이터 고려해서 적절하게 큰 사이즈값
	category char(2),   --고정길이로 2바이트
	pname varchar2(50),  -- utf-8 한글일때 문자 16개
	price number(9)
);

-- 구매(buy)테이블 : 고객 who , 상품 what 구매했는가?
CREATE TABLE buy(
	custome_id varchar2(20),  --who
	pcode varchar2(10), --what
	quantity NUMBER(5), --how many?
	buy_date DATE --when
);

-- inset(DML) 형식 : 테이블에 새로운 데이터 추가합니다.
-- insert into 스키마이름.테이블이름 (컬럼1,컬럼2,,,,)
-- values (컬럼1값,컬럼2값,,,,,);
INSERT INTO JCPDEV.CUSTOM (CUSTOME_ID,NAME,EMAIL,AGE,REG_DATE)
VALUES ('mina2012','김미나','kim@gmail.com',20,'2020-05-23');

-- 스키마이름 같으면 생략가능 , 모든 컬럼이 null 허용하므로 아래 insert 가능합니다.
INSERT INTO custom(custome_id) VALUES ('dayeon11');
INSERT INTO custom(reg_date) VALUES ('2021-08-10');
INSERT INTO custom(reg_date) VALUES (sysdate);   -- 현재 날짜 : sysdate
INSERT INTO custom(CUSTOME_ID,NAME,EMAIL)
			VALUES ('soon1234','도봉순','test@daum.net');
-- 문자열 '' , 수치값은 기호없이 작성.
INSERT INTO CUSTOM (age) VALUES (33);

-- 모든 컬럼값을 추가할때, 테이블이름 뒤에 컬럼이름들 생략합니다.
INSERT INTO CUSTOM
	VALUES ('mina2014','이미나','lee@gmail.com',21,'2020-05-23');

/*   테이블에 저장된 데이터 변경 : update(수정) ,delete(삭제)
 *   update 테이블이름 set 컬럼이름1=수정할값1,컬럼이름2=수정할값2,,,,,
 *          where 조건;
 */
-- where 조건없는 UPDATE : 모든 row 들에 적용 --> 매우 위험한 작업.(바람직X)
UPDATE CUSTOM SET REG_DATE = SYSDATE ;
UPDATE CUSTOM SET age=25 WHERE CUSTOME_ID ='dayeon11';
-- name 값이 null 인 경우 name='손님' 으로 update 
UPDATE custom SET name='손님' WHERE name is NULL;
-- custome_id 값이 null 인 경우 custome_id='guest' 로 update
UPDATE CUSTOM SET CUSTOME_ID ='guest' WHERE CUSTOME_ID IS NULL;

-- age 값이 20보다 작으면 age=99 로 update
UPDATE custom SET age=99 WHERE age < 20;  --null포함 안됩니다.

-- and , or --> 값을 범위로 검사  
-- 비연속적인 값을 개별적으로 검사 --> in 
UPDATE custom SET age=98 WHERE age IN (20,25);
UPDATE custom SET age=97 WHERE age=98 OR age=33; -- age IN (98,33)
-- set 뒤에 여러개의 컬럼 변경할 수 있습니다.
UPDATE custom SET age=37,EMAIL='koreait@korea.com' 
		WHERE age IS NULL AND EMAIL IS NULL;
	
-- delete 형식
DELETE FROM CUSTOM WHERE EMAIL IS null;	
DELETE FROM custom WHERE age=99;	

-- 진짜로 테이블의 데이터를 모두 삭제하고 싶다면....
TRUNCATE TABLE CUSTOM ;

-- custom 테이블 모든 데이터 보여줘~~
SELECT * FROM CUSTOM;

INSERT INTO PRODUCT VALUES ('ipad10','00','아이패드10',880000);
INSERT INTO PRODUCT VALUES ('snk099','10','쌀새우깡',2200);
INSERT INTO PRODUCT VALUES ('dk_14','20','컴퓨터책상',199900);

INSERT INTO BUY VALUES ('mina2012','ipad10',2,sysdate);
INSERT INTO BUY VALUES ('mina2012','snk099',11,sysdate);
INSERT INTO BUY VALUES ('mina2021','dk_144',1,sysdate);
INSERT INTO BUY VALUES ('mina2014','snk099',1,'2020-11-22');
SELECT * FROM PRODUCT;
SELECT * FROM BUY;


-- 지금까지의 select 는 테이블의 모든 값을 보여주기
--1. 특정 컬럼만 보고싶다.
SELECT custome_id,age FROM CUSTOM;
SELECT LOWER(custome_id),age FROM CUSTOM;

--2. 특정 row (검색조건에 맞는) 보고싶다. --> where
-- 나이 조건으로 조회 : 40세 미만
SELECT * FROM CUSTOM WHERE age <40;
SELECT * FROM CUSTOM WHERE age IN (37,97);
SELECT * FROM CUSTOM WHERE age NOT IN (37,97); -- NULL 제외
SELECT * FROM custom ;
-- 이름 조건으로 검색
SELECT * FROM CUSTOM WHERE name ='손님';
SELECT * FROM custom WHERE name NOT IN ('손님');

-- 유사 비교 : 예, custome_id 가 mina로 시작하는 데이터 조회
SELECT * FROM custom WHERE custome_id LIKE 'mina%' ; 
--							  mina로 끝나는 데이터 조회
SELECT * FROM custom WHERE custome_id LIKE '%mina' ;  
--                            mina가 포함된 데이터 조회
SELECT * FROM custom WHERE custome_id LIKE '%mina%' ;

SELECT * FROM custom WHERE custome_id LIKE '%Mina%' ;    


-- 오라클에서 테이블명,컬럼명 등등 객체식별자 이름은 대소문자 구분안합니다.
-- 저장된 문자열 데이터는 대소문자 구별합니다.

-- dual 테이블 : 어떤 권한에서나 사용이 가능한 임시테이블
SELECT 22*33 AS result FROM DUAL ; -- AS 뒤에 별칭
SELECT LOWER('MiNa') FROM dual;   --소문자 변환
SELECT UPPER('MiNa') FROM dual;   --대문자 변환
SELECT sysdate AS today FROM DUAL ;

--3. 보여주는 순서 : order by 컬럼이름 [asc(기본값생략)|desc]
SELECT * FROM CUSTOM ORDER BY NAME ;
-- 나이 많은사람 -> 적은사람 순서 : 내림차순 desc(descending)
SELECT * FROM custom ORDER BY age DESC ;
SELECT * FROM custom ORDER BY age DESC , name; 
					-- 정렬 기준이 age 먼저, 2차 기준(age같을때) name





/*  테이블 사이의 관계 설정과 테이블 각 컬럼에 여러가지 요구사항 적용 필요합니다.
 *  앞으로 진도 나갈 내용입니다.!!
 *  제약조건(contraints) 을 설정합니다. --> 데이터의 무결성 유지.
 * 		ㄴ not null
 * 		ㄴ 기본값 설정 : 예를 들면 reg_date, buy_date를 현재날짜로 한다.
 * 		ㄴ 값의 제한 : quntity(수량) 이 1보다 큰값으로 한다.
 * 		ㄴ 유일한 값(unique) 컬럼 : custom_id , pcode (어떤 테이블에서 유니크컬럼은 1개이상)
 * 		ㄴ 기본키(primary key) : 검색,rows 식별 컬럼을 표시-> unique 컬럼 중에서 고릅니다.
 * 							: 기본키는 2개 이상 컬럼을 그룹화할 수 있습니다.
 *  	ㄴ 외래키(foreign key) : 참조키. 다른 테이블의 어떤컬럼 값을 참고하고 있는지?
 * 					:buy테이블의 custom_id 값으로 custom 테이블을 참조한다.
 * 					:데이터의 중복제거/일관성 유지를 위한 방법입니다.
 * 					:--> buy 테이블에서 신라면 구입한 고객의 이름을 알고 싶다.
 */




