1. jdbc 라이브러리 추가
	ㄴ 프로젝트 우클릭 -> 메뉴중에 Build Path
	  -> Configure build path...
	  -> Libraries 탭 -> Add External jar
	  -> 파일 ojdbc6. jar 찾아서 추가
	ㄴ 프로젝트 탐색기에 확인 - Referenced Libraries

2. 데이터베이스 연결 : Connection 클래스 메소드를 사용
   ㄴ	그 전에 JDBC 드라이버를 메모리에 로드 시켜야 합니다.
           ㄴ  Class.forName("패키지명.클래스")
	                                            ㄴ 오라클 드라이버 클래스 


3. OracleConnectionUtil.java : 오라클 DB연결 및 종료 메소드 작성. 	                                          
	                                          
4. DBConnectionTest.java : DB연결 테스트와 insert sql 실행 테스트1	                                            
   DBConnectionTest2.java : DB연결 테스트와 insert sql 실행 테스트2	-> 값을 sql 전달 뒤에 설정
5. SelectTest1.java : select 쿼리테스트1
   SelectTest2.java : select 쿼리테스트2 -> 여러개의 row를 반복문으로 가져오기
   SelectWhereTest3.java : select 쿼리테스트3 -> where 조건 실행
   SelectWhereTest4.java : select 쿼리테스트3 -> where 조건 실행 , 중복된 id값 존재여부 확인
   FinalIDCheck.java : 사용자 입력할 때 PK무결성 위반하지 않도록 하는 id검사 예제
   
JDBC 둘째 날

1. ProductListMain.java
2. 			ㄴ ProductVo.java
* Lombok.jar 설치
3. CustomListMain.java
* Singleton 연습 : singleton 패키지
4. CustomDao.java
5. CustomUpdateMain.java   --> 오늘의 미션!   


JDBC 셋째 날
- 어제 마지막 과제 : CustomUpdateMain.java
-vo와 dao 클래스 역할 (mvc 패턴의 시작)
-FK 제약조건 위배 돼지 않도록 buy# 테이블 row 추가
	1) BuyVo.java
	2) BuyDao.java
	2) BuyMain.java
	3) BuyMain2.java 
-롬복라이브러이 사용해서 *Builder 패턴
	1) builder 패키지
	2) builder.buy 패키지
-날짜타입데이터 변환 메소드(클래스별로 다릅니다.)






   