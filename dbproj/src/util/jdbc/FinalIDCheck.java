package util.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class FinalIDCheck {
	//DBConnectioTest2.java 와 SelectWhereTest4.java 를 참고하세요.
	//Connection 선언 여기에 - private 접근한정자 사용 
	private static Connection conn = OracleConnectionUtil.connect();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(conn); // 출력값이 null 이면 db연결 안된 상태입니다.

		String sql = "INSERT INTO CUSTOM# (CUSTOM_ID, NAME, EMAIL, AGE) VALUES(?,?,?,?)";
		// CUSTOM_ID 컬럼 : 무결성 PK 제약조건 검사합니다.-> 중복된값 X, null X
		//
		String id=null, name, email;
		int age;
		System.out.println(":::새로운 사용자를 등록합니다");
		
		while(true) {  //입력된 id가 중복값이 아니면 종료
			System.out.print("아이디 입력하세요 >>>");
			id = sc.nextLine();
			if(idcheck(id)) {
				System.out.println("id 확인 중입니다....  사용가능합니다.");
				break;   //반복문 종료
			}else {
				System.out.println("id 확인 중입니다.... 사용중인 아이디 입니다.");
				System.out.println("id를 다른 것으로 만들어 주세요.");
			}
		}
		System.out.print("이름 입력하세요>>>");
		name = sc.nextLine();
		System.out.print("이메일 입력하세요 >>>");
		email = sc.nextLine();
		System.out.print("나이 입력하세요 >>>");
		age = sc.nextInt();
		PreparedStatement pstmt=null;
		try {
			 pstmt= conn.prepareStatement(sql);

			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, email);
			pstmt.setInt(4, age); // sql 을 먼저 전달 -> 필요한 데이터는 그 후에 설정이됩니다.

			pstmt.execute();   //insert,update,delete SQL 문 실행할때는 execute() 메소드입니다.
			System.out.println("insert 정상완료!!");
		} catch (SQLException e) {
			System.out.println("SQL 실행에 오류가 발생했습니다. : " + e.getMessage());
			// e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // pstmt 사용 종료
			OracleConnectionUtil.close(conn); // 연결 종료
		}

	}
	
	
	//ID 중복체크하는 메소드 private (?) boolean idcheck(String id)  
	// -> 출력문은 없으며 리턴값 생성만 잘하면 됩니다.
	//-> true, false 리턴합니다.
	private static boolean idcheck(String id) {  //id 는 테이블에 중복값 있는지 검사할 문자열
		
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
	     
	}// idcheck end	

	
	
	
	
}
