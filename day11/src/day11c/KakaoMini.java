package day11c;

import java.text.DecimalFormat;
/*
2. CreditCard 클래스를 상속받아 KakaoMini 클래스를 생성합니다. -> 카카오미니 카드
1) 이용한도 금액의 최대값 상수 MAX_LIMIT 을 선언하여 초기값을 10만으로 합니다.
2) 생성자 : 상위클래스의 생성자를 호출하여 실행합니다.
3) 추상메소드 구현 : **upLimit , pay 는 실행결과를 참고하여 구현합니다.**
4) 재정의 메소드 toString :  3개의 필드값을 문자열로 리턴.
*/
public class KakaoMini extends CreditCard{
	
	public static final int MAX_LIMIT = 100000;   //1)
	public KakaoMini(String name) {  //2)
		super(name);
	}
	//3) limit+plus 가 MAX_LIMIT을 초과하지 못하도록 한다. 초과하면 0을 리턴 
	// 초과하지 않으면 limit을 plus만큼 더하고,  plus를 리턴합니다.
	@Override
	public int upLimit(int plus) {
		if (limit+plus > MAX_LIMIT) return 0;    
		else {
			limit +=plus;
			return plus;
		}		
	}
	
	//money 가 결제 금액입니다. money를 결제했을때 limit 를 초과하지 못하도록 합니다.
	//money+payTotal 이 limit 보다 크면 0을 리턴
	//초과하지않으면 money 금액 결제를 처리하여 payTotla에 더하고, money를 리턴합니다.
	@Override
	public int pay(int money) {
		if(payTotal+money>limit) return 0;
		else { payTotal+=money;
		return money;
		}
	}
	@Override
	public String toString() { //4)
		DecimalFormat df = new DecimalFormat("###,###,### 원");   //정수 또는 실수 값 출력패턴을 설정하는 클래스입니다.
		return owner + " 님. 이번 달 결제 예정 금액 " + df.format(payTotal) 
				+" 입니다.[이용한도 " + df.format(limit) + " ]";
	}

}
