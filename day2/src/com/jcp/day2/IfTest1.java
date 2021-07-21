package com.jcp.day2;

import java.util.Scanner;

public class IfTest1 {

	public static void main(String[] args) {

		//관계연산자 : 연산결과값은 boolean 값(true,false)
		//  ==, != , >= , <= , < , > , !(not)
		/*
		boolean bval = 3==4;
		System.out.println("결과값 : " + bval);
		bval = (4==4);
		System.out.println("결과값 : " + bval);
		*/
		
		//int point 값(사용자 입력)이  1~100 이면 "일반회원", 100초과이면 "VIP"
		//
		
		int point;
		Scanner sc = new Scanner(System.in);
		System.out.print("point 입력하세요 . >>> ");
		point = sc.nextInt();
		
		System.out.println("[[회원 정보 출력]]");
		//요구사항1
		if(point > 100)
			System.out.println("VIP" + " 회원입니다.");
		else   //100이하의값.
			System.out.println("일반" + " 회원입니다.");
		
		//요구사항2
		if(point > 100)
			System.out.println("VIP" + " 회원입니다.");
		else if(point >=1)   //100이하의값.
			System.out.println("일반" + " 회원입니다.");
		else
			System.out.println("잘못된 값입니다.");
		
		
		
		
		
	}
	
}
