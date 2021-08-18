package jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.jdbc.OracleConnectionUtil;

public class DBConnectionTest {

	public static void main(String[] args) {
		// OracleConnectionUtil 클래스로 db연결을 시도해 봅니다.
		
		Connection conn = OracleConnectionUtil.connect();
		System.out.println(conn);   //출력값이 null 이면 db연결 안된 상태입니다.
		
		//실행할 sql 문 : 지금 방법은 매우 기본적이고 원초적인 방법 -> 좀더쉽게 sql 실행 코딩을 할 수있도록 발전되어집니다.
		String sql="INSERT INTO CUSTOM# (CUSTOM_ID, NAME, EMAIL, AGE) " + 
//				"VALUES('sana1000', '박사나', 'sana@korea.com', 29)";   //1)변수 처리 할 예정입니다.(데이터를 직접작성)
					"VALUES(?,?,?,?)";   //2)변수 처리(문자열,문자열,문자열,정수) 준비
		//CUSTOM_ID 컬럼 : 무결성 PK 제약조건 검사합니다.-> 중복된값 X, null X 
		//
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);   //실행할 sql 전달-> Connect객체로 실행합니다.
			
			//2)번으로 할때 ? 에 해당하는 값을 sql 전달 후에 설정.-> pstmt 객체 메소드로 합니다.
			pstmt.setString(1, "nana");    //전달할 값의 첫번째 인덱스 1 (0번부터 아닙니다.)
			pstmt.setString(2, "이나나");
			pstmt.setString(3, "lee@naver.com");
			pstmt.setInt(4, 28);			//sql 을 먼저 전달 -> 필요한 데이터는 그 후에 설정이됩니다.
			
			pstmt.execute();			//sql 실행.-> PreparedStatement 객체로 실행합니다.
			pstmt.close();				//pstmt 사용 종료
			System.out.println("insert 정상완료!!");
		} catch (SQLException e) {
			System.out.println("SQL 실행에 오류가 발생했습니다. : " + e.getMessage());
			//e.printStackTrace();
		} finally {
			OracleConnectionUtil.close(conn);   //연결 종료
		}
		
		
	}

}
