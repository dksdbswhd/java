package util.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//sql 쿼리(조회, select 문) 실행을 테스트 합니다. -> where 조건 추가
public class SelectWhereTest3 {

	public static void main(String[] args) {
		Connection conn = OracleConnectionUtil.connect();
		
//		String sql ="SELECT * FROM CUSTOM# WHERE CUSTOM_ID ='nana'";   //조건 검색 비교값이 sql포함되어 pstmt 전달
		String sql ="SELECT * FROM CUSTOM# WHERE CUSTOM_ID =?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);   //sql 쿼리 전달
			pstmt.setString(1, "momo2");
			rs = pstmt.executeQuery();   //pstmt객체로 select 쿼리 실행->조회된 결과를 메모리에저장 -> rs 로 참조
			//System.out.println("rs 상태 : " + rs);
			
			while(rs.next()) {
				System.out.println("현재 row 넘버 : " + rs.getRow());
				System.out.println("현재 row의 커스텀 아이디 : " + rs.getString("CUSTOM_ID"));
				System.out.println("현재 row의 커스텀 이름 : " + rs.getString("NAME"));
				System.out.println("현재 row의 커스텀 나이 : " + rs.getInt("AGE"));
				//날짜 형식 컬럼 출력테스트 : getDate() 또는 getTimestamp() 메소드
				System.out.println("현재 row의 커스텀 가입날짜 : " + rs.getDate("REG_DATE"));
				System.out.println("현재 row의 커스텀 가입날짜 : " + rs.getTimestamp("REG_DATE"));
			}
			// 위에서 rs.next() 로 조회된 row와 자바의 클래스를 mapping시킵니다.
			//				ㄴ Custom 클래스를 만들고 테이블의 컬럼과 매핑되는 변수들을 선언합니다.  
			//                 -> 데이터를 저장 Value Object
			
		} catch (SQLException e) {
			System.out.println("SQL 실행에 오류가 발생했습니다. : " + e.getMessage());
			//e.printStackTrace();
		}
		
	}

}



