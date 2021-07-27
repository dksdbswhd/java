package com.jcp.day7;

import java.util.Arrays;

public class MyClass3Test {

	public static void main(String[] args) {
		
		MyClass3 mc = new MyClass3();
		
		//mc 객체 필드값 저장하기
		mc.name="최모모";  //-> 필드 직접 사용해서 저장 대신에 setXXX 를 만들었어요.
		mc.setName("이나연");
		mc.setLevel(10);

		double[] point = new double[5];
		mc.setPoint(point);
		
		//double[] 변수 생략하고 직접 배열 생성해서 참조값 전달합니다.
		mc.setPoint(new double[3]);    //**
		
		System.out.println(Arrays.toString(mc.point));
		
	}

}
