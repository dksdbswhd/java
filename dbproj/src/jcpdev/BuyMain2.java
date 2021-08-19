package jcpdev;

import java.util.Scanner;

import dao.BuyDao;
import dao.ProductDao;
import vo.BuyVo;
import vo.ProductVo;

public class BuyMain2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BuyDao buy_dao = BuyDao.getInstance();
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
		System.out.print("배송날짜 " + "2021-08-22 입니다." );		//(+)
		
		buy_dao.insert(new BuyVo(0, id, pcode, quan, null));	//FK 제약조건 발생하지 않도록 데이터 입력
		
		System.out.println("구매 완료되었습니다.감사합니다.");
		System.out.println("프로그램 종료!!!");
	}

}
