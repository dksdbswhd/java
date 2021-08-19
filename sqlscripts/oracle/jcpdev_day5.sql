/*
SQL 쿼리(select) 복습 문제

1. custom# 테이블에서 age 가 25세 이상 모든 내용 조회
2. custom# 테이블에서 custom_id 'momo' 의 email 조회
3. product# 테이블에서 category '12' 의 pname 조회
4. product# 테이블에서 price 의 최고값 조회
5. product# 테이블에서 category '10' 의 갯수 조회
6. buy# 테이블에서 custom_id 'nayeon' 의 모든 내용 조회
7. buy# 테이블에서 pcode 가 'LG'로 시작하는 것 조회
8. buy# 테이블에서 cusom_id 'momo' 가 구매한 상품의 이름과 가격 조회(서브쿼리 사용)

*/

-- 11시 30분까지 각자 연습하고 답을 만들어 보세요.(제출: 이메일 koreait.2021@gmail.com) 미완성해도 제출.


-- 풀이

--1. custom# 테이블에서 age 가 25세 이상 모든 내용 조회
SELECT * FROM "CUSTOM#" WHERE age >=25;

--2. custom# 테이블에서 custom_id 'momo' 의 email 조회
SELECT EMAIL FROM "CUSTOM#" WHERE CUSTOM_ID ='momo';

--3. product# 테이블에서 category '12' 의 pname 조회
SELECT pname FROM "PRODUCT#"  WHERE CATEGORY ='12';

--4. product# 테이블에서 price 의 최고값 조회
SELECT MAX(PRICE) FROM "PRODUCT#";

--5. product# 테이블에서 category '10' 의 갯수 조회
SELECT count(*) FROM "PRODUCT#" WHERE CATEGORY ='10';

--6. buy# 테이블에서 custom_id 'nayeon' 의 모든 내용 조회
SELECT * FROM buy# WHERE CUSTOM_ID ='nayeon';

--7. buy# 테이블에서 pcode 가 'LG'로 시작하는 것 조회
SELECT * FROM buy# WHERE PCODE LIKE 'LG%';

--8. buy# 테이블에서 cusom_id 'momo' 가 구매한 상품의 이름과 가격 조회(서브쿼리 사용)
--  buy# 테이블의 상품 내용은 같은 고객ID가 여러번 저장될 수 있습니다. 
SELECT  PNAME,PRICE FROM "PRODUCT#" 
		WHERE PCODE IN (SELECT PCODE FROM "BUY#" WHERE CUSTOM_ID ='nayeon');

SELECT pcode FROM "BUY#" WHERE CUSTOM_ID ='nayeon';
SELECT pcode FROM "BUY#" WHERE CUSTOM_ID ='momo';

SELECT PNAME,PRICE FROM "PRODUCT#" WHERE PCODE = 'MU98';


-- JOIN : 둘 이상의 테이블을 연결하나 데이터를 검색하는 방법.
--		  두 개의 테이블에 공통된 컬럼을 사용한다.
-- 동등 조인 (내부 조인) : 예를 들면  buy# , product# 테이블을 조인하면

-- 형식 from 테이블1 a,테이블2 b where a.중복컬럼1 = b.중복컬럼1 : a,b테이블은 서로 참조관계(참조관계설정컴럼동등값)

SELECT * FROM buy#, product# WHERE buy#.pcode = product#.pcode;      
-- ㄴ 기본형식으로 간단 확인

--SELECT pcode,price FROM buy#, product# WHERE buy#.pcode = product#.pcode;  -- 조인 후 특정컬럼 선택

SELECT buy#.pcode,price FROM buy#, product# WHERE buy#.pcode = product#.pcode;

-- 테이블명, 컬럼명을 alias (별칭)을 설정합니다. -> 이름을 간단하게 합니다.

-- buy# 테이블에서 pcode 값으로 price 를 알고 싶다. PCODE = 'MU98'
-- buy# 테이블에서 각각 모든  buy_no 별로 구매금액 계산 : price * quantity(수량)
SELECT CUSTOM_ID , b.pcode,pname,price,quantity , price*quantity AS total  -- 컬럼명은 AS 써도 됩니다.
		FROM buy# b, product# p        -- 오라클은 테이블명 뒤에 AS 안씁니다.
		WHERE b.pcode = p.pcode;    -- AS는 앞으로 생략하고 씁니다.

SELECT CUSTOM_ID , b.pcode,pname, price,quantity , price*quantity total 
		FROM buy# b, product# p 
		WHERE b.pcode = p.pcode AND b.pcode = 'MU98'; 
 


SELECT * FROM "BUY#";


-- 위에 조인한 결과로 그룹화 : 
--				방법1) with  방법2) from 뒤에 조인 sql 을 직접쓴다.  방법3) create view
--       ㄴ  1.고객별 총 구매금액 -> sum(total) -> group by custom_id(FK)
--       ㄴ  2.상품별 총 판매금액 -> sum(total) -> group by pcode(FK)

WITH sale as(  -- 임시테이블 -> 단 한번 사용 합니다.이름은 sale
	SELECT CUSTOM_ID , b.pcode AS p_code,pname,price,quantity , 
		   price*quantity AS total  -- 컬럼명은 AS 써도 됩니다.
	FROM buy# b, product# p        -- 오라클은 테이블명 뒤에 AS 안씁니다.
	WHERE b.pcode = p.pcode
)
--1. 고객별 총 구매금액
-- SELECT custom_id, sum(total) FROM sale GROUP BY custom_id;

--2. 상품별 총 판매금액
SELECT p_code ,sum(total) FROM sale GROUP BY p_code;

-- with 안쓸때
SELECT p_code ,sum(total) 
	FROM  (SELECT CUSTOM_ID , b.pcode AS p_code,pname,price,quantity , 
		          price*quantity AS total  
			FROM buy# b, product# p        
			WHERE b.pcode = p.pcode)   -- from 뒤의 select 결과는 인라인뷰(1회사용)
	GROUP BY p_code;

-- SELECT * FROM sale;  -- 테스트용


-- select * from role_sys_privs where role='RESOURCE';  -- 시스템테이블(관리자 권한)
-- View : 가상테이블(물리적공간을 갖지 않는다.) 기본 테이블들 이용해서 출력하고 싶은것 select 
--        하여 사용자(개발자)가 테이블 처럼 사용할 수 있게 한다.
--        view 를 생성하기 위해 resource,connect 권한 외에 create view 권한 필요합니다.
CREATE VIEW v_sale   -- DROP VIEW 는 뷰 제거, ALTER VIEW 는 없습니다.
AS
SELECT CUSTOM_ID , b.pcode AS p_code,pname,price,quantity , 
		          price*quantity AS total  
			FROM buy# b, product# p        
			WHERE b.pcode = p.pcode;

SELECT * FROM V_SALE; 
-- 뷰는 제한적인 데이터입력과 수정도 가능하지만 일반적으로 select (데이터조회) 목적으로 사용합니다.

SELECT * FROM V_SALE WHERE CUSTOM_ID ='nayeon';


-- 아우터 조인 outer join : 외부 조인 (+) 연산기호로 표시
--		    정상적으로 조인조건을 만족하지 않는 행들도 조인결과에 포함 합니다.

SELECT * FROM "BUY#" b,"CUSTOM#" c WHERE b.CUSTOM_ID = c.CUSTOM_ID ;         --동등(equal) 조인

DELETE  FROM "BUY#" b WHERE b.CUSTOM_ID ='momo';
SELECT * FROM "BUY#" b,"CUSTOM#" c WHERE b.CUSTOM_ID = c.CUSTOM_ID ;    -- 'momo' 내용을  buy#에서 삭제 

-- custom# 테이블에는 momo 있구요, buy# 에는 momo가 없습니다.(구매가 없습니다.) -> 포함해서 join 하고 싶다면
SELECT * FROM "BUY#" b,"CUSTOM#" c WHERE b.CUSTOM_ID(+) = c.CUSTOM_ID;


SELECT c.custom_id AS id, name, reg_date,age, nvl(pcode,'구매없음'),nvl(QUANTITY,0)
FROM "BUY#" b ,"CUSTOM#" c WHERE b.CUSTOM_ID(+) = c.CUSTOM_ID;

--SELECT c.custom_id AS id, name, reg_date,age, nvl(pcode,'구매없음'),nvl(QUANTITY,0)
--FROM  "CUSTOM#" c LEFT OUTER JOIN "BUY#" b on b.CUSTOM_ID = c.CUSTOM_ID;

-- 오늘은 수업한 내용은 최대한 오늘 복습합니다. 미루지 맙시다.!!!


