package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.jdbc.OracleConnectionUtil;
import vo.CustomVo;

public class CustomDao { // Singleton 패턴 적용해보기
	private static CustomDao dao = new CustomDao();

	private CustomDao() {
	}

	public static CustomDao getInstance() {
		return dao;
	}
	
	// CUSTOM# 테이블 대상으로 sql 실행할 메소드 정의합니다.
	public List<CustomVo> getList() { // 전체 조회
		Connection conn = OracleConnectionUtil.connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM custom#"; // --> 실행예측 : row의 최대갯수는 많음.
		CustomVo vo;
		List<CustomVo> list = new ArrayList<CustomVo>();
		try {
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new CustomVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5));
				list.add(vo); // 리스트에 추가합니다.
			}
			return list;
		} catch (SQLException e) {
			System.out.println("custom List 조회에 문제가 있습니다. : " + e.getMessage());
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				System.out.println("close 오류 : " + e.getMessage());
			}
			OracleConnectionUtil.close(conn);
		}

		return null;
	}

	public CustomVo getCustom(String id) { // custom_id 컬럼값으로 조회 -> 인자로 전달 받습니다.
		Connection conn = OracleConnectionUtil.connect();

		String sql = "SELECT * FROM CUSTOM# WHERE CUSTOM_ID =?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
//		String id = null;
		String name, email;
		int age;
		Date regdate;
		CustomVo vo = null; // 선언만.
		try {
			pstmt = conn.prepareStatement(sql); // sql 쿼리 전달
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) { // where 검색컬럼이 PK,unique 일 때 -> while x , if 문으로
				// 테이블 컬럼과 CustomVo 타입 객체와 매핑 -> 자동으로 할 때가 옵니다.
				id = rs.getString("CUSTOM_ID");
				name = rs.getString("NAME");
				email = rs.getString(3); // rs.getString("EMAIL") 과 동일합니다.
				age = rs.getInt("AGE");
				regdate = rs.getDate("REG_DATE");
				vo = new CustomVo(id, name, email, age, regdate); // 객체 생성하고 초기화
			}
			//System.out.println(vo); // vo는 null 초기화 필요

		} catch (SQLException e) {
			System.out.println("SQL 실행에 오류가 발생했습니다. : " + e.getMessage());
			// e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
			}
			OracleConnectionUtil.close(conn);
		}
		
		return vo;
	}

	public boolean idcheck(String id) {
		Connection conn = OracleConnectionUtil.connect();
		String sql ="SELECT * FROM CUSTOM# WHERE CUSTOM_ID =?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);   //sql 쿼리 전달
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();   
			if(rs.next()) {   //id는 중복id -> 사용할수 없다.
				return false;    //중복값이면 false 리턴
			} else return true;
			
		} catch (SQLException e) {
			System.out.println("SQL 실행에 오류가 발생했습니다. : " + e.getMessage());
			//e.printStackTrace();
		} finally {  //try 안에서 return 할때 finally 실행하고 리턴합니다.
				     //익셉션 발생하여 catch 실행하고 finally 실행. 
			try {
				rs.close();  //꼭 닫기
				pstmt.close();   //꼭 닫기
			} catch (SQLException e) {
				System.out.println("close 오류 : " + e.getMessage());
				//e.printStackTrace();
			}
		}
		
		return false;
	}

	public void insert(CustomVo vo) {
		Connection conn = OracleConnectionUtil.connect();
		String sql = "INSERT INTO CUSTOM# (CUSTOM_ID, NAME, EMAIL, AGE) VALUES(?,?,?,?)";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getCustom_id());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getEmail());
			pstmt.setInt(4, vo.getAge()); // sql 을 먼저 전달 -> 필요한 데이터는 그 후에 설정이됩니다.

			pstmt.execute();   
			pstmt.close(); 
			System.out.println("insert 정상완료!!");
		} catch (SQLException e) {
			System.out.println("SQL 실행에 오류가 발생했습니다. : " + e.getMessage());
			// e.printStackTrace();
		} finally {
			OracleConnectionUtil.close(conn); // 연결 종료
		}
	}

	public void update(CustomVo vo) {
		Connection conn = OracleConnectionUtil.connect();
//		String sql="UPDATE CUSTOM# SET EMAIL = ? WHERE CUSTOM_ID =?";   
		String sql="UPDATE CUSTOM# SET EMAIL = ? , REG_DATE = sysdate WHERE CUSTOM_ID =?";   
		//custom_id 를 조건으로하여 email 을 수정할 수 있도록 합니다.(+)추가 reg_date 도 지금시간으로 변경
		//               ㄴ sql문 수정해서 reg_date 변경 추가.
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getEmail());
			pstmt.setString(2, vo.getCustom_id());
//현재 날짜 
			
			pstmt.execute();
			pstmt.close();
		}catch (SQLException e) {
			System.out.println("SQL 실행에 오류가 발생했습니다. : " + e.getMessage());
		}finally {
			OracleConnectionUtil.close(conn);
		}
		
		
	}

}
