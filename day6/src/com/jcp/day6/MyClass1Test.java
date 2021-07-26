package com.jcp.day6;

import java.util.Scanner;

public class MyClass1Test {

	public static void main(String[] args) {
		// 우리가 정의한 MyClass1 클래스를 테스트합니다
	
		//1) MyClass1 클래스의 객체를 생성 : new 연산자
		// my1,my2는 식별자 : 프로그래머가 이름을 정합니다.
		// new 뒤에 MyClass1() 은 생성자 메소드 입니다.
		//   ㄴ 객체가 생성될 때 (메모리에 로드될때) 실행
		//   ㄴ 생성자 메소드 이름은 클래스이름과 같습니다.
		//   ㄴ 기본생성자는 인자가 없는 형식입니다.
		
		MyClass1 my1 = new MyClass1();
		MyClass1 my2 = new MyClass1();
		
		//되돌아보기 : Scanner(인자) 인 생성자 실행되었습니다.
		//          ㄴ 커스텀 생성자
		Scanner sc = new Scanner(System.in);
		
		//2) MyClass1 타입의 객체 필드 접근(읽기/쓰기)
		//출력해보기
		System.out.println(my1.field1);   //참조형 타입은 기본값 null
		System.out.println(my1.field2);   //수치 기본형 타입은 기본값 0
		//객체의 필드에 값을 저장
		my2.field1="class test";
		my2.field2=999;
		my2.field3 = new double[5];  
		//배열 객체을 생성(크기 5는 예시)해야 합니다.
		System.out.println("my 객체의 필드값 확인-----");
		System.out.println(my2.field1);
		System.out.println(my2.field2);
		System.out.println(my2.field3[2]);  
		//31번의 배열 객체 선언이 없으면 2번 요소 접근할 수 없으므로 오류 발생합니다.
		
		sc.close();
	}

}
