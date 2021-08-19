package jcpdev;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.jdbc.OracleConnectionUtil;
import vo.CustomVo;

//고객 리스트를 db에서 가져오기
public class CustomListMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<CustomVo> list = custom_list();
		System.out.println("List 타입 toString() 실행 : " + list);
		
		for(CustomVo vo : list)
			System.out.println(vo);
		
	}//main end
	
	
	private static List<CustomVo> custom_list(){
		//상품목록 리스트를 db에서 가져와 리턴해준다.
		//        ㄴ 테이블 컬럼값을 vo 역할 클래스와 매핑합니다.
		Connection conn = OracleConnectionUtil.connect();
		PreparedStatement pstmt=null;
		ResultSet rs=null;        
		String sql="SELECT * FROM custom#";   //--> 실행예측 : row의 최대갯수는 많음.
		CustomVo vo;
		List<CustomVo> list = new ArrayList<CustomVo>();
		try {
			pstmt = conn.prepareStatement(sql);
			
			//select? 또는 insert? update? delete?
			rs = pstmt.executeQuery();
			while(rs.next()) {
				//vo 클래스 객체와 조회 결과 각 컬럼을 매핑
				vo = new CustomVo(rs.getString(1), 
						rs.getString(2), rs.getString(3), rs.getInt(4),rs.getDate(5));
				list.add(vo);    //리스트에 추가합니다.
			}
			return list;
		} catch (SQLException e) {
			System.out.println("custom List 조회에 문제가 있습니다. : " + e.getMessage());
			e.printStackTrace();   //오류 추적할때 필요합니다.(개발 중일때는 작성)
		}finally {
			try {
				rs.close(); 
				pstmt.close();
			} catch (SQLException e) { System.out.println("close 오류 : " + e.getMessage());
			}
			OracleConnectionUtil.close(conn);
		}
		
		return null;
	}  // list end


}
