package com.jcp.day1;

public class CircleTest {

	public static void main(String[] args) {
		// 원의 반지름 저장할 변수
		int r = 11; // 반지름 테스트 정수값 저장
		// 원의 넓이 저장할 변수
		double area;

		System.out.println("-------------------------------------");
		System.out.println("*원(circle)의 넓이를 구하는 프로그램입니다.*");
		System.out.println("원의 반지름 (단위 : m) >>> " + r);

		System.out.println("\n원의 넓이를 구했습니다.............");
		area = 3.14 * r * r;           //실수와 정수를 연산(+ - * /) 한 결과는 실수
		System.out.printf("3.14 x %d x %d =  %.3f  (단위:㎡)  \n", r, r, area);
		//format: %d는 정수, %f는 실수(double,float 둘다) , %s는 문자열
		System.out.println("--------------------------------------");
	}

}
