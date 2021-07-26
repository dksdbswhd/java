package com.jcp.day6;


//클래스의 구성요소인 메소드에 대해서 정리합니다.
public class MyClass2 {
	
	//필드 선언. 전역변수
	int num1;
	int num2;
	
	//메소드 형식
	//리턴형식  메소드이름(인자형식과 개수){ 실행할 코드들...  }
	
	//1) void 는 리턴값이 없다. 2)인자는 String 타입 1개
	void methodA(String name) { 
		//name은 지역변수-methodA에서만 사용한다.
		System.out.println("이름 : " + name);
	}
	
	void methodB(String name, int cnt) { //인자 2개 
		System.out.println("이름 : " + name 
				+",멤버수: " + cnt);
	}

	int methodC() {
		return num1+num2;
	}
	
	void setNum1(int num1) {//필드 num1값 변경
		this.num1 = num1;   
	//this는 지역변수와 전역변수를 구별하는 키워드
	//  ㄴ 자기자신 객체를 지정합니다.
	}
	
	void setNum2(int num2) { //필드 num2값 변경
		this.num2=num2;
	}
	
	static void print() {
		System.out.println("MyClass2입니다.");
// 공유영역은 공유영역에 저장된 필드와 메소드만 접근합니다.
//    ㄴ static 끼리만 접근.공유영역에서 객체필드&메소드 사용 못합니다. 
		
//		System.out.println(this.num1); //오류
//		System.out.println(num2);  //오류
//		methodC();		//오류
		test();
	}
	
	static void test() {
		System.out.println("test중입니다.");
	}
	
}







