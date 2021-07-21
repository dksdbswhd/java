package com.jcp.day2;

public class WonToDollar {

	public static void main(String[] args) {
		int dollar;   //달러
		int  won;	 //원
		
		//키보드 입력으로 바꿀수 있게 값을 따로 초기화
		dollar = 1193;     //1달러 1193원
		won = 1000000;	  //100만원을 달러로 환전했을때 금액은?
		
		System.out.println("[환율계산]");
		System.out.println("환율 1달러 = " + dollar + "(원)");
		System.out.println("여행 환전 원화 = " + won + "(원)");
		
		double result;   //838.22296...  예상
		result = won / dollar;        
		//연산식이 실행되는 데이터의 형식 -> 정수 나누기 정수 결과는 정수(몫)
		//						  -> 실수 결과를 원한다면 방법1) won,dollar를 double로 선언한다.(최소 1개)
		//					      -> 			 방법2) won,dolloar 중 하나를 강제로 실수형식으로 변환
		System.out.println("[환전되었습니다.1]..............");
		System.out.println("USD 달러 = " + result + "(달러)");
		//결과값에 대해 다른 요구사항을 생각해보세요.
		
		//실수로 변환된 won으로 나누기를 실행 : ** won을  double 형식 변수에 저장 => 자동변환(casting)
		double doubleWon = won;
		result = doubleWon/dollar;
		//실수로 변환된 won으로 나누기를 실행 : ** won을 강제로 실수형식으로 변환(casting)
		//result = (double)won/dollar;     //캐스팅 할 데이터 앞에 (데이터형식) 지정하면 됩니다.
		System.out.println("[환전되었습니다.2]..............");
		System.out.println("USD 달러 = " + result + "(달러)");
		System.out.printf("%s %12.5f %s","USD 달러 = ",result,"(달러)");
	}

}
