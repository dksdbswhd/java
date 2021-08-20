-- grant resource,connect to jcpdev
-- resource 권한이 있으므로 테이블 생성할수 있습니다.
CREATE TABLE tblTest(
	col1 varchar2(20),  -- 20바이트
	col2 number(6)    -- 6자리 정수
); 
-- 같은 테이블이름으로 2개를 생성못합니다.
--(왼쪽탐색기에서 f5 새로고침)

--만들어지 tbltest 테이블의 내용 좀 보자.
SELECT * FROM TBLTEST;