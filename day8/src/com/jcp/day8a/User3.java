package com.jcp.day8a;

/*
접근제어자(접근권한)
☆public : 공공의 , 공용의 ...다 함께 같이 쓰자. (모든클래스)
☆☆private☆☆ : 개인의, 사적인....나만 쓰겠다.(현재클래스)
☆기본적용 default : 같은 패키지이면 같이쓰자. 패키지가 다르면 접근 금지.
*/
//일반적으로 class 는 public
public class User3 {

	//필드 : 테스트용 접근제어자 private
	//다른 클래스에서 필드에 직접 접근하지 못하도록 접근 금지.
	//private는 주로 필드에만(메소드도 사용가능) 적용합니다.
	String name;
	private int age;
	
	public User3() {
		// 생성자 : 접근제어자 public
	}
	
	//setXXX 메소드
	
	
	
}
