CREATE TABLE tbl# (
	col1 varchar2(30) CONSTRAINT tbl#_notnull1 NOT NULL,
	col2 varchar2(10) NOT NULL,  -- CONSTRAINT 키워드 생략 
	col3 varchar2(10),
	col4 number(3)
);   -- CREATE 는 1번만 실행합니다.

INSERT INTO tbl#(col1) VALUES ('test1');  -- 오류 : 제약조건 위반
INSERT INTO tbl#(col1,col2) VALUES ('test1','test2');  --정상 실행

-- DML 중에서 insert, update,delete 를 했으면 변경 내용 확인
SELECT * FROM tbl#;

-- alter table   테이블명 [변경내용키워드]  (변경내용)  
-- 1)컬럼 이름 변경                 현재이름 to 새로운 이름
-- ALTER TABLE tbl# RENAME COLUMN co12 TO col2;  

-- 2) 아래 컬럼 추가하면 기존 row(행)들도 값이 추가된 컬럼5 의 값 100
ALTER TABLE tbl# ADD (column5 NUMBER(5) DEFAULT 100); -- 예 : 기본값 100
-- 2) 번 변경후에 데이터 추가합니다.
INSERT INTO tbl#(col1,col2) VALUES ('테스트11','테스트');

-- 오류 : col2 10바이트 초과 -> 한글 3바이트 그외 1바이트 
-- INSERT INTO tbl#(col1,col2) VALUES ('테스트11','테스트22');

-- 컬럼추가 : column6 가변문자열(20) 기본값 'guest' 로 변경해보세요.
ALTER  TABLE tbl# ADD (column6 VARCHAR(20) DEFAULT 'guest');
-- 아래 데이터 추가 후 확인
INSERT INTO tbl#(col1,col2) VALUES ('게스트1','게스트2');

-- 4) 기존 컬럼 형식 변경
ALTER TABLE tbl# MODIFY (col2 varchar2(50)); 

-- 5) 제약조건 추가 : 기존에 저장된 데이터 때문에 오류가 생길 수 있는 내용입니다.
--    col3 기존 데이터 중 null 이 있으면 제약조건 위반하여 오류
ALTER TABLE tbl# ADD CONSTRAINT tbl#_notnull2 CHECK (col3 IS NOT NULL);
--    실행 ? or 오류? -> col4 기존데이터가 제약조건에 맞는 값이다.
ALTER TABLE tbl# ADD CONSTRAINT tbl#_notnull3 CHECK (col4 IS NOT NULL);

-- 7) 제약조건 제거
ALTER TABLE tbl# DROP CONSTRAINT tbl#_notnull3;

-- 제약조건 키워드없는 not null 을 null로 변경할 때
ALTER TABLE tbl# MODIFY COL2 VARCHAR2(50) NULL;

-- col3 데이터 모두 채운 후에 실행확인 해보세요. null -> not null로 변경
ALTER TABLE tbl# MODIFY COL3 VARCHAR2(50) NOT NULL;

-- ((참고))테이블의 제약조건 이름 확인하기 : 오라클의 시스템 테이블
SELECT CONSTRAINT_NAME FROM USER_CONSTRAINTS;
-- 오라클 식별자 대소문자 구분 필요할때 : 조건값 검색
SELECT * FROM USER_CONSTRAINTS;
ALTER TABLE tbl# DROP CONSTRAINT SYS_C0010623; -- 오라클에서 지어준 제약조건이름

SELECT * FROM tbl#;
-- alter table [변경내용키워드] : 
-- 1) *컬럼 이름 변경 : rename column 
-- 2) 테이블 이름 변경 : rename to 
-- 3) *새로운 컬럼 추가 : add
-- 4) *컬럼 데이터 형식 변경 : modify
-- 5) *제약 조건 추가 : add constraint  
-- 6) 기존 컬럼 삭제 : drop
-- 7) *기존 제약 조건 삭제 : drop constraint 제약조건이름

-- 테이블 : 개체/관계를 데이터로 저장합니다. 필드(개체/관계의 속성)로 구성됩니다.
-- student 개체를 요구사항에 따라 필드(속성) 구성합니다.
-- 			ㄴ 필드 : 학번, 이름, 주소, 나이 ,성별
--			ㄴ    가변문자열/고정문자열/수치/...  
-- 제약조건 check 추가 연습합니다.
CREATE TABLE student (
		stu_no char(6) NOT NULL ,
		stu_name varchar2(20) NOT NULL,
		address varchar2(50),
		age number(3) CHECK (age BETWEEN 16 AND 20),  -- age >=16 AND age <=20 
		gender char(1) CHECK(gender IN ('M','F'))  --gender ='M' OR gender = 'F'
);

SELECT * FROM STUDENT ;
-- insert 문을 제약조건 위반 발생하는 경우 포함해서 10개 테스트 해보기
-- 학번 : 예, 2021A1
INSERT INTO STUDENT(STU_NO ,STU_NAME)
		VALUES ('2021A1','최사나');   --CHECK 값 범위 지정하면 null은 허용합니다.

-- INSERT INTO STUDENT(STU_NO ,STU_NAME,AGE,GENDER)
-- 		       VALUES ('2021B2','김미나',15,'F');  -- violated : 위반하다.
		
INSERT INTO STUDENT(STU_NO ,STU_NAME,ADDRESS,AGE,GENDER)
		VALUES ('2021B2','김미나','서울시 강남구 역삼동',17,'F');

INSERT INTO STUDENT(STU_NO ,STU_NAME,ADDRESS,AGE,GENDER)
		VALUES ('2021C5','박찬호','경기도 성남시',19,'M');
INSERT INTO STUDENT(STU_NO ,STU_NAME,ADDRESS,AGE,GENDER)
		VALUES ('2021B5','박찬호','경기도 성남시',19,'M');
		
-- 이름 최사나 학생의 주소를 '경기도 고양시'로 값 수정하세요.
UPDATE STUDENT SET ADDRESS ='경기도 고양시' WHERE STU_NAME ='최사나';
	
-- student 테이블에서 학생이름과 나이,성별을 보여줘~~
SELECT stu_name , age, gender FROM STUDENT ;

-- select 결과 출력되는 값을 변경하는 함수
-- decode(검사필드,'비교값','출력값','비교값','출력값',...,'else 출력값') 함수 사용해봅시다.
-- nvl(필드,'널대체값')
SELECT stu_name , NVL(age,0) ,DECODE(GENDER,'M','남자','F','여자','unknown') 
FROM STUDENT ;

-- 기본키 제약 조건 : null 값을 허용안함, 유일한 값(unique)  -> 개체인스턴스(row) 식별(구별)합니다.
-- student 테이블의 기본키를 stu_no 필드로 한다. -> null or 중복값 있으면 제약조간 위반
ALTER TABLE STUDENT ADD CONSTRAINT student_pk PRIMARY key(stu_no);

-- score 테이블 
--     ㄴ 필드 : 학번(stu_no char(6)), subject_id ,mid_score, final_score , grade
--                                   고정5바이트, 정수3자리,    정수3자리,     고정1바이트
--     ㄴ 제약조건 : 기본키는 (학번,subject_id) , 중간/기말점수는 not null
CREATE TABLE score (
		stu_no char(6) NOT NULL,    -- PK를 설정한 컬럼은 자동으로 NOT NULL과 UNIQUE 적용
		subject_id char(5) NOT NULL,
		mid_score number(3) NOT NULL,
		final_score number(3) NOT NULL,
		grade char(1),
		-- create table 로 pk,fk 생성할때는 아래와 같이 합니다.
		CONSTRAINT score_pk PRIMARY KEY (stu_no,subject_id),
		-- 외래키(테이블 사이의 참조관계를 설정합니다.)
		CONSTRAINT stuno_fk FOREIGN KEY (stu_no)    --stu_no는 score테이블 컬럼
		      REFERENCES student(stu_no)			--참조하는테이블(컬럼) 
);


INSERT INTO SCORE (STU_NO, SUBJECT_ID, MID_SCORE,FINAL_SCORE,GRADE)
VALUES ('2021A1','KO211',88,85,'B');
INSERT INTO SCORE (STU_NO, SUBJECT_ID, MID_SCORE,FINAL_SCORE,GRADE)
VALUES ('2021B2','EN211',94,91,'A');
INSERT INTO SCORE (STU_NO, SUBJECT_ID, MID_SCORE,FINAL_SCORE,GRADE)
VALUES ('2021A1','PR211',78,83,'B');

SELECT * FROM score;

-- insert, update : FK 제약조건 위반 발생할 수 있습니다.-> 실행오류

-- 1)  integrity constraint (JCPDEV.STUNO_FK) violated - parent key not found
-- INSERT INTO SCORE (STU_NO, SUBJECT_ID, MID_SCORE,FINAL_SCORE,GRADE)
-- VALUES ('2021A4','KO211',88,85,'B');   -- FK 위반

-- 2) integrity constraint (JCPDEV.STUNO_FK) violated - child record found
-- DELETE FROM STUDENT WHERE STU_NAME ='최사나';

DELETE  FROM STUDENT WHERE STU_NO ='2021B5';   -- 참조되지 않는 값은 삭제 가능합니다.
-- 잘못 만들어진 테이블 제거하기
DROP TABLE SCORE;




-- 결론 : 오늘의 주제는 alter table 과 제약조건(pk,fk)


	