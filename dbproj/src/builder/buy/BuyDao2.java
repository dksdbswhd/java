package builder.buy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.jdbc.OracleConnectionUtil;

public class BuyDao2 {
//Singleton 패턴 적용
	private static BuyDao2 dao = new BuyDao2();
	private BuyDao2() {  }
	public static BuyDao2 getInstance() {
		return dao;
	}
	
	//insert 메소드 원형(프로토타입?)
	public void insert(BuyVo2 vo) {
//		String sql="INSERT INTO BUY# (BUY_NO,CUSTOM_ID,PCODE,QUANTITY) " +  
//		"	VALUES(buy_seq.nextval, ?,?,?)";
		String sql="INSERT INTO BUY# (BUY_NO,CUSTOM_ID,PCODE,QUANTITY,del_date) " +  
		"	VALUES(buy_seq.nextval, ?,?,?,?)";
		Connection conn = OracleConnectionUtil.connect();
		PreparedStatement pstmt=null;
		try {
			pstmt = conn.prepareStatement(sql);
			//? -> sql 문자열에서 동적으로 설정(대입)될 데이터
			pstmt.setString(1, vo.getCustom_id());    //첫번째 ?
	        pstmt.setString(2, vo.getPcode());		  //두번째 ?
	        pstmt.setInt(3, vo.getQuantity());			//세번째 ?
	        pstmt.setDate(4, vo.getDel_date());			//네번째 ?
			pstmt.execute();
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
			} catch (SQLException e) {	e.printStackTrace(); }
			OracleConnectionUtil.close(conn);
		}
		
		
	}
}
