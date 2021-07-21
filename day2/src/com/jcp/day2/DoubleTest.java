package com.jcp.day2;

public class DoubleTest {

	public static void main(String[] args) {
		
		//실수 데이터(double과 float)의 출력과 연산결과를 확인해봅시다.
		double d2 = 1.12345678901234567890123456789;   //실수의 기본형식,8바이트
		float f2 = 1.12345678901234567890123456789f;   //4바이트
		System.out.println( "double 1.12345678901234567890123456789 : " + d2 ); // 소수점이하 자리 최대 ? 16자리
		System.out.println( "float 1.12345678901234567890123456789f : " + f2 ); //                 ?  7자리
		
		System.out.println( "지수형식 2e3 :" +2e3 );       // 2000.0 => 2x10의 3승
		System.out.println( "지수형식 2e-3 :" +2e-3 );       // 0.002 => 2x10의 -3승
		//실수 : 부동소수점형식(0과1)으로 처리하는데 있어서 발생하는 문제점. (연산결과 2진수를 10진수로 변환해서 출력할때)
		System.out.println( 0.1 + 1.6 ); // 1.7000000000000002 
		System.out.println( 3.0 / 0.0 ); // Infinity (무한대) : 실수 0.0 으로 나눈결과.
		System.out.println( 0.0 / 0.0 ); // NaN : Not a Number (실수 0.0을 나눌때)
		System.out.println( 3 / 0 ); // Error :정수 0으로 나눌때.

	}

}
