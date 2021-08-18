package jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.jdbc.OracleConnectionUtil;

//sql 쿼리(조회, select 문) 실행을 테스트 합니다.
public class SelectTest1 {

	public static void main(String[] args) {
		//custom# 테이블에서 모든 데이터 가져오기 
		//1.Connection 2.PreparedStatement 
		//조회에서는 3. ResultSet : 조회결과를 참조할 수 있는 클래스와 그 메소드를 사용합니다.
		
		Connection conn = OracleConnectionUtil.connect();
		
		String sql ="SELECT * FROM CUSTOM#";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();   //pstmt객체로 select 쿼리 실행->조회된 결과를 메모리에저장 -> rs 로 참조
			System.out.println("조회결과 있습니까? " + rs.next());     //조회결과가 있으면 rs.next()는 참
			System.out.println("현재 row의 커스텀 아이디 : " + rs.getString("CUSTOM_ID"));
			System.out.println("현재 row의 커스텀 이름 : " + rs.getString("NAME"));
			//날짜 형식 컬럼 출력테스트 : getDate() 또는 getTimestamp() 메소드
			System.out.println("현재 row의 커스텀 가입날짜 : " + rs.getDate("REG_DATE"));
			System.out.println("현재 row의 커스텀 가입날짜 : " + rs.getTimestamp("REG_DATE"));
			
			System.out.println("조회결과 있습니까? " + rs.next());     //다음 조회결과가 또 있으면 rs.next()는 참
			System.out.println("현재 row의 커스텀 아이디 : " + rs.getString("CUSTOM_ID"));
			System.out.println("현재 row의 커스텀 이름 : " + rs.getString("NAME"));
			//날짜 형식 컬럼 출력테스트 : getDate() 또는 getTimestamp() 메소드
			System.out.println("현재 row의 커스텀 가입날짜 : " + rs.getDate("REG_DATE"));
			System.out.println("현재 row의 커스텀 가입날짜 : " + rs.getTimestamp("REG_DATE"));
			
			
			
		} catch (SQLException e) {
			System.out.println("SQL 실행에 오류가 발생했습니다. : " + e.getMessage());
			//e.printStackTrace();
		}
		
	}

}



