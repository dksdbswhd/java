-- java와 연동하면서 필요한 sql 테스트 합니다.

-- 사용자가 등록될때 입력한 id 중복값이 있는지 검사하자.
SELECT count(*) FROM CUSTOM# WHERE CUSTOM_ID ='nana';  -- 있을 때 결과 단일값 1
SELECT count(*) FROM CUSTOM# WHERE CUSTOM_ID ='nana2';  -- 없을 때 결과 단일값 0


SELECT * FROM CUSTOM# WHERE CUSTOM_ID ='nana';  -- 있을 때 결과 행(row) 1개 조회
SELECT * FROM CUSTOM# WHERE CUSTOM_ID ='nana2';  -- 없을 때 결과 행(row) 없음
--                 ㄴ 자바에서는 조회한 결과가 null 인지? 조건 검사하여 확인합니다.


-- 모든 행 조회하는 select 부터 먼저 자바에서 코딩을 해봅니다. 그리고 위에 것에 적용합니다.

SELECT * FROM CUSTOM#; 

--custom_id 컬럼은 PK -> 중복값이 없다. -> 1개 또는 0개 row 조회됩니다.
SELECT * FROM CUSTOM# WHERE custom_id = 'momo';    

SELECT * FROM CUSTOM# WHERE age= 25 ;    -- age 중복값을 갖는 컬럼 -> 조회된 ROW 개수 0개,1개,2개 이상

SELECT * FROM product#;

SELECT * FROM "CUSTOM#" c ;

-- 이메일 정보만 수정
UPDATE CUSTOM# SET EMAIL ='momo2@gmail.com'
WHERE CUSTOM_ID ='momo';

-- 이메일과 최근 정보 수정날짜를 reg_date 값에 적용
UPDATE CUSTOM# SET EMAIL ='momo2@gmail.com' , REG_DATE = sysdate
WHERE CUSTOM_ID ='momo';


SELECT buy_seq.nextval FROM dual;







