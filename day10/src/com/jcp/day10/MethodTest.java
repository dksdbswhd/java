package com.jcp.day10;

import java.util.Arrays;

//메소드 오버로딩을 확인하는 연습입니다.
public class MethodTest {

	public static void main(String[] args) {
		//1. Math클래스의 메소드 중에서 메소드 오버로딩 찾아봅시다.
		int ires;
		ires = Math.min(12, 156);
		System.out.println("작은 값은 " + ires);
		
		
		//2. Arrays 클래스의 메소드 중에서 메소드 오버로딩 찾아봅시다.
		double[] datas= {23.45,34.12, 7.8,4.5,3.14};
		
		System.out.println("double 배열 Arrays.toString 결과.");
		System.out.println(Arrays.toString(datas));
		
		//3. 대표적인 메소드 오버로딩 - 커스텀 생성자
		
		
		//4. 클래스 타입 배열로 Arrays.toString 테스트
		Member[] members = new Member[3];    //Member 타입 참조값 저장할 배열.
		members[0] = new Member("사나", 23);
		members[1] = new Member("미나", 25);
		members[2] = new Member("다연", 21);
		System.out.println("Object 타입 배열로 Arrays.toString 실행결과 ");
		System.out.println(Arrays.toString(members));  
		//members 배열의 참조값으로 Member 객체 하나씩 가져와 toString 결과를 연결한다.
		
		System.out.println(members);		//members 배열이름의 toString()	
		//**참조타입.toString() 에서 toString() 일반적으로 생략. 
		
		System.out.println(members[0]);    
		//Member 클래스 toString 재정의 전에는  com.jcp.day10.Member@15db9742 형식
//		    ㄴ  System.out.println(members[0].toString());  에서 toString() 생략

//Arrays.toString(members) 실행결과 ↘
//[com.jcp.day10.Member@15db9742, com.jcp.day10.Member@6d06d69c, com.jcp.day10.Member@7852e922]
//--> 실행결과를 필드값 출력으로 변경하고 싶다. --> Object 클래스로부터 상속받은 toString 메소드를 재정의합니다.
		
		
		
		
	}

}






