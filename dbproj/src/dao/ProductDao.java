package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.jdbc.OracleConnectionUtil;
import vo.ProductVo;

public class ProductDao {   //Singleton 패턴 적용해보기
	private static ProductDao dao = new ProductDao();
	
	private ProductDao() { }
	
	public static ProductDao getInstance() {
		return dao;
	}
	
	//상품 전체 리스트 가져오기
	public List<ProductVo> getList(){
		Connection conn = OracleConnectionUtil.connect();
		PreparedStatement pstmt=null;
		ResultSet rs=null;        
		String sql="SELECT * FROM product#";   //다수의 row 결과
		ProductVo vo;
		List<ProductVo> list = new ArrayList<ProductVo>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();  	//select
			while(rs.next()) {
				//vo 클래스 객체와 조회 결과 각 컬럼을 매핑
				vo = new ProductVo(rs.getString(1), 
						rs.getString(2), rs.getString(3), rs.getInt(4));
				list.add(vo);    //리스트에 추가합니다.
			}
			return list;
		} catch (SQLException e) {
			System.out.println("product List 조회에 문제가 있습니다. : " + e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				rs.close(); 
				pstmt.close();
			} catch (SQLException e) { System.out.println("close 오류 : " + e.getMessage());
			}
			OracleConnectionUtil.close(conn);
		}
		
		return null;
	}
	
	//상품 카테고리 검색 리스트 - 미완성(SQL 비교하세요.)
	public List<ProductVo> getCategoryList(String category){
		String sql = "SELECT * FROM PRODUCT#  WHERE CATEGORY =?";	
			
		return null;
	}
	
}
