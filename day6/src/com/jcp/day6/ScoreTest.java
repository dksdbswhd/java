package com.jcp.day6;

import java.util.Scanner;

public class ScoreTest {

/*
1) Score 타입  객체 생성  ==> 변수 hong으로 참조합니다.
2) hong 객체의 name 필드에 "홍길동" 참조
3) kor,eng,math 점수값은 키보드 입력 받는다.
4) print 메소드를 실행하여 처리결과를 출력합니다.
 * 	
 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//1)
		Score hong = new Score();
		
		//2)
		hong.name = "홍길동";
		
		//3)
		System.out.print("국어 점수 입력 >>> ");
		hong.kor = sc.nextInt();
		System.out.print("영어 점수 입력 >>> ");
		hong.eng = sc.nextInt();
		System.out.print("수학 점수 입력 >>> ");
		hong.math = sc.nextInt();
		
		//참고
		//int sum = hong.sum();
		
		//4)
		hong.print();    //Score 클래스에서 정의된 print메소드가 hong객체의 필드값(hong객체의 다른 메소드 호출)으로
						//실행이 됩니다.
		
		sc.close();
		
	}

}
