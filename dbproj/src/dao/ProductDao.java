package dao;

public class ProductDao {   //Singleton 패턴 적용해보기
	private static ProductDao dao = new ProductDao();
	
	private ProductDao() { }
	
	public static ProductDao getInstance() {
		return dao;
	}
	
	
}
