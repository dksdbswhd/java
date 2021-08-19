package builder.buy;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

import dao.ProductDao;
import vo.ProductVo;
//BuyVo2 : builder 패턴 클래스 사용
public class BuyMain3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BuyDao2 buy_dao = BuyDao2.getInstance();
		ProductDao p_dao = ProductDao.getInstance();
		
		System.out.println("::: 상품 구매 :::");
		System.out.println("상품 리스트 입니다.");
		for(ProductVo vo : p_dao.getList())
			System.out.println(vo);
		
		
		System.out.print("\n구매 고객 아이디 입력 >>> "); 				//(+)고객ID 존재하는지 확인 필요
		String id = sc.nextLine();
		System.out.println("고객님 환영합니다.~!!");
		System.out.print("구매 상품 코드 입력 >>>");                   //(+)상품코드 존재하는지 확인 필요
		String pcode = sc.nextLine();
		System.out.print("구매 수량 입력 >>>");
		int quan = sc.nextInt();               //Integer.parseInt() 로 기억합시다.
		
		
		System.out.print("배송날짜 " +  "2021-08-22 입니다." );		//(+)
		
		BuyVo2 vo2 = BuyVo2.builder().custom_id(id)
								.pcode(pcode).quantity(quan).build();
		buy_dao.insert(vo2);	//FK 제약조건 발생하지 않도록 데이터 입력
		
		
		System.out.println("구매 완료되었습니다.감사합니다.");
		System.out.println("프로그램 종료!!!");
	}

}


