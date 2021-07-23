package com.jcp.day5;

import java.util.Scanner;

public class StringTest2 {

	public static void main(String[] args) {
		// TODO : nextInt() 와 nextLine()을 함께 사용하는 테스트 - step 2
		
		Scanner sc = new Scanner(System.in);
		
		int age; 
		String name;
		
		System.out.print("나이 입력하세요. >>> ");
		age = sc.nextInt();				//엔터 이전까지만 버퍼에서 가져가 처리(저장)합니다.
//	    nextInt() 메소드의 리턴타입이 int 이므로  int 타입변수에 대입되어야 한다.
		
		System.out.print("이름 입력하세요. >>> ");
		name = sc.nextLine();			//위의 숫자입력 후 마지막 엔터를 버퍼에서 가져옵니다.
		
		System.out.println("name : " + name + "(" + age + ") 환영합니다.!");
		
		sc.close();
		
	}

}
