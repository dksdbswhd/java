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


-- 위에 조인한 결과로 그룹화 
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
			WHERE b.pcode = p.pcode) 
	GROUP BY p_code;

-- SELECT * FROM sale;  -- 테스트용











