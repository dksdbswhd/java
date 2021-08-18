package jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import util.jdbc.OracleConnectionUtil;

// 연습 : Scanner 클래스로 id,name,email,age 사용자 입력받고 테이블에 insert 합니다.
public class DBConnectionTest2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(conn); // 출력값이 null 이면 db연결 안된 상태입니다.

		// CUSTOM_ID 컬럼 : 무결성 PK 제약조건 검사합니다.-> 중복된값 X, null X
		//
		String id, name, email;
		int age;
		System.out.println(":::새로운 사용자를 등록합니다");
		System.out.print("아이디 입력하세요 >>>");
		id = sc.nextLine();
		System.out.print("이름 입력하세요>>>");
		name = sc.nextLine();
		System.out.print("이메일 입력하세요 >>>");
		email = sc.nextLine();
		System.out.print("나이 입력하세요 >>>");
		age = sc.nextInt();
		Connection conn = OracleConnectionUtil.connect();
		String sql = "INSERT INTO CUSTOM# (CUSTOM_ID, NAME, EMAIL, AGE) VALUES(?,?,?,?)";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, email);
			pstmt.setInt(4, age); // sql 을 먼저 전달 -> 필요한 데이터는 그 후에 설정이됩니다.

			pstmt.execute();   //insert,update,delete SQL 문 실행할때는 execute() 메소드입니다.
			pstmt.close(); // pstmt 사용 종료
			System.out.println("insert 정상완료!!");
		} catch (SQLException e) {
			System.out.println("SQL 실행에 오류가 발생했습니다. : " + e.getMessage());
			// e.printStackTrace();
		} finally {
			OracleConnectionUtil.close(conn); // 연결 종료
		}

	}

}
