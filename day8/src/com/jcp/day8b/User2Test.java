package com.jcp.day8b;

//다른패키지 클래스는 꼭 import
import com.jcp.day8a.User2;

public class User2Test {

	public static void main(String[] args) {
		// public 접근제한 User2클래스 테스트
		User2 sana = new User2();
		
		sana.name = "사나";
		sana.age=25;
		
		System.out.println(sana.name + "(" + sana.age + ")");

	}

}
