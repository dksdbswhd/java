package builder;

public class BuilderTest {

	public static void main(String[] args) {

		Buy b1 = new Buy();
//		Buy b2 = new Buy(3,"aaa","bbb");
	//	Buy b3 = new Buy(3);   //오류 : -> 생성자는 필드가 많아지면 다양한 생성자 작성하기 불편하다.
		
		//Builder 로 다양한 필드 초기화 사용하여 객체 생성
		Buy b4 = Buy.builder().custom_id("momo11").build();   //id필드 초기화하고 객체 생성
		
		Buy b5 = Buy.builder().pcode("SAMSUNG").build();      //pcode 필드 초기화하고 객체 생성
		
		Buy b6 = Buy.builder().buy_no(3).custom_id("TEST").build();
		
		System.out.println(b4);
		System.out.println(b5);
		System.out.println(b6);
		
	}

}
