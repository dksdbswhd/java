package jcpdev;

import dao.BuyDao;
import vo.BuyVo;

public class BuyMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1)BuyVo 객체를 생성하세요. - 임의값으로 초기화
//		BuyVo vo = new BuyVo(0,"momo","aaa",3,null);   //FK 위반 --> 오류
		BuyVo vo = new BuyVo(0,"momo","LG98T2",3,null);   //정상 실행

		//2)BuyDao 의 insert 를 위의 객체로 실행.
		BuyDao buy = BuyDao.getInstance();
		buy.insert(vo);
		//-->디비버에서 확인.
		System.out.println("프로그램 종료!!!");
	}

}
