-- java와 연동하면서 필요한 sql 테스트 합니다.

-- 사용자가 등록될때 입력한 id 중복값이 있는지 검사하자.
SELECT count(*) FROM CUSTOM# WHERE CUSTOM_ID ='nana';  -- 있을 때 결과 단일값 1
SELECT count(*) FROM CUSTOM# WHERE CUSTOM_ID ='nana2';  -- 없을 때 결과 단일값 0


SELECT * FROM CUSTOM# WHERE CUSTOM_ID ='nana';  -- 있을 때 결과 행(row) 1개 조회
SELECT * FROM CUSTOM# WHERE CUSTOM_ID ='nana2';  -- 없을 때 결과 행(row) 없음
--                 ㄴ 자바에서는 조회한 결과가 null 인지? 조건 검사하여 확인합니다.


-- 모든 행 조회하는 select 부터 먼저 자바에서 코딩을 해봅니다. 그리고 위에 것에 적용합니다.