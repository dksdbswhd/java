package vo;

//product# 테이블 컬럼과 매핑될수있게 합니다.
public class ProductVo {
	private String pcode;
	private String category;
	private String pname;
	private int price;
	
	public ProductVo() {
		// 초기화가 필요한 다른작업 있을때 코딩합니다.
	}

	public ProductVo(String pcode, String category, String pname, int price) {
		super();   //상속받았을 때 부모클래스 기본생성자 호출 실행
		this.pcode = pcode;
		this.category = category;
		this.pname = pname;
		this.price = price;
	}

	
	@Override
	public String toString() {
		return "ProductVo [pcode=" + pcode + ", category=" + category + 
				", pname=" + pname + ", price=" + price + "]";
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
