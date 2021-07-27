package com.jcp.day7;

import java.util.Arrays;

//어제 수업의 클래스의 필드&메소드 다시 연습합니다.
public class MyClass3 {
	
	//필드 선언
	String name;
	int level;
	double[] point;    //참조타입 변수
	
	//객체 생성후 필드값을 설정(저장)하는 메소드를 만들어 봅시다. (**)
	//name 필드값 저장하기
	void setName(String name) {   //name 은 참조값
		this.name = name;
	}
	
	//level 필드값 저장하기
	void setLevel(int level) {
		this.level = level;
	}
	
	//point 필드값(참조값) 저장하기
	void setPoint(double[] point) {
		this.point = point;
	}
	
	//
	void print() {
		System.out.println("name : " + name + 
				",level : " + level + ",points : " 
				+ Arrays.toString(point));
	}
}
