package com.jcp.day5;

import java.util.Scanner;

public class StringTest3 {

	public static void main(String[] args) {
		// TODO : nextInt() 와 nextLine()을 함께 사용하는 테스트 --> StringTest2 의 문제점 수정
		// step 3
		Scanner sc = new Scanner(System.in);
		
		int age; 
		String name;
		
		System.out.print("이름 입력하세요. >>> ");
		name = sc.nextLine();			//위의 숫자입력 후 마지막 엔터를 버퍼에서 가져옵니다.
// 345 는 정수 , "345"는 문자열 입니다.
		
		System.out.print("나이 입력하세요. >>> ");
		age = sc.nextInt();				//엔터 이전까지만 버퍼에서 가져가 처리(저장)합니다.
// "ab" 문자열은 nextInt() 메소드는 정수로 변환 못하고 오류
// "123" 문자열은 nextInt() 메소드가 정수로 변환하여 처리,저장.		
		
		System.out.println("name : " + name + "(" + age + ") 환영합니다.!");
		
		sc.close();
		
	}

}
