package com.jcp.day5;

import java.util.Scanner;

//Scanner 클래스를 이용하여 문자열 입력을 테스트 해봅니다. step 1
public class StringTest1 {

	public static void main(String[] args) {
		// TODO : 객체란? 메모리에 저장된 데이터 뭉치이다. 클래스 타입으로 만들어지므로 이에 해당하는 필드,메소드를 사용할 있다.
		
		Scanner sc  = new Scanner(System.in);    
		//Scanner 클래스 타입의 참조변수 sc -> Scanner 객체를 사용할 수 있습니다.
		
		String name;    //String 클래스 타입의 참조변수 name -> String 객체를 사용할 수 있습니다.
		
		//Scanner 클래스의 문자열 입력 메소드 : next() , nextLine() 
		
		System.out.print("이름 1 입력하세요. >>> ");
		name = sc.next();							
		//공백 문자이전까지 저장합니다. 예를 들면 입력: 홍 길동 -> 버퍼에 " 길동" 남아있습니다. 
		System.out.println("next() 입력확인 : " + name);   //저장,출력은 "홍"
		
		System.out.print("이름 2 입력하세요. >>> ");
		name = sc.nextLine();						//공백,엔터 까지 버퍼에서 가져가 저장합니다.
//	    nextLine() 메소드의 리턴타입이 String 이므로 String 타입변수에 대입되어야 한다.
		
		System.out.println("nextLine() 입력확인 : " + name);
		
		//문자열 입력은 일반적으로 nextLine() 메소드를 사용합니다.

//		메소드 프로토타입(구조)  --> 메소드마다 다른형태입니다.
//		String java.util.Scanner.nextLine()
//		1)     2)패키지명.클래스명    3)      4)
		
//      1)리턴타입   : String
//		2)메소드의 소속  :   java.util.Scanner
//		3)메소드 이름  : nextLine
//		4)argument  : 없음. 
		
//     메소드를 사용할때에는 2)번 부분이 참조변수(인스턴스 메소드) or 클래스명(클래스 메소드)이 된다.		
		
		sc.close();
	}

}
