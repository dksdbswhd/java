package com.jcp.day2;

import java.util.Scanner;

public class IfTest2 {

	public static void main(String[] args) {

		//논리연산 포함하는 조건 ( 또는 || , 그리고 && )
		int intValue=124;    //intValue 값을  52, 80,100,124,60  순서대로 테스트 해보세요.
		
		Scanner sc = new Scanner(System.in);
		System.out.print("검사할 아스키코드값 입력 >>>" );
		intValue=sc.nextInt();
		
		char ch = (char)intValue;
		
		//요구사항: intValue 에 저장된 코드값이 대문자,소문자,숫자 인지 검사하는 if문
		//        intValue 에 저장된 아스키코드값으로 문자의 종류를 알아냅니다.
		
		if(ch >='A' && ch <='Z')   //대문자 검사 : 'A'보다 크거나 같고 'Z'보다 작거나 같은가?
			System.out.println("입력한 아스키코드값 : " + intValue + ",분류 : 대문자" );
		else if(ch >='a' && ch <='z')   //소문자 검사 : 'a'보다 크거나 같고 'z'보다 작거나 같은가?
			System.out.println("입력한 아스키코드값 : " + intValue + ",분류 : 소문자" );
		else if(ch >='0' && ch <='9')	//숫자 검사  : '0'보다 크거나 같고 '9'보다 작거나 같은가?	
			System.out.println("입력한 아스키코드값 : " + intValue + ",분류 : 숫자" );
		else
			System.out.println("입력한 아스키코드값 : " + intValue + ",분류 : unknown" );
		//대문자,소문자,숫자에 해당하는 값이 아니면  "분류 : unknown" 출력 
		
	}

}
