package com.jcp.day1;


//정수 데이터를 저장하는 변수를 연습합니다.
public class DataTest1 {

	public static void main(String[] args) {
		//변수의 선언(이름,크기-형식을 지정합니다.)
		//정수 기본데이터형
		byte num0=23;		//1바이트, -128 ~ 127
		short num1= 23;		//2바이트, -32768 ~ 32767
		int num2=23;		//4바이트, -2147483648 ~ 2147483647
		long num3=23;		//8바이트, -9223372036854775808 ~ 9223372036854775807
		
		System.out.println("num0 :" + num0);   //한줄복사 단축키 ctrl+alt+아래화살표
		System.out.println("num1 :" + num1);   
		System.out.println("num2 :" + num2);   
		System.out.println("num3 :" + num3);   
		
		System.out.println(":::Byte 클래스로 byte 데이터타입 정보확인 :::");
		System.out.println("byte 변수의 크기 : " + Byte.BYTES +" 바이트");  //Byte클래스의 BYTES 필드
		System.out.println("byte 변수의 최대값 : " + Byte.MAX_VALUE);	//Byte클래스의 MAX_VALUE필드
		System.out.println("byte 변수의 최소값 : " + Byte.MIN_VALUE);  //Byte클래스의 MIN_VALUE필드
		
		//기본형 데이터가  필요에 따라 클래스로 변환되어야 할때 각 기본형에 대한 Wrapper 클래스를 사용합니다.
		//---> Integer, Byte, Short, Long, Character 등
		//Integer 클래스로 int 데이터형의 크기/최대값/최소값도 확인해보세요.!!
		System.out.println(":::Integer 클래스로 int 데이터타입 정보확인 :::");
		System.out.println("int 변수의 크기 : " + Integer.BYTES +" 바이트");
		System.out.println("int 변수의 최대값 : " + Integer.MAX_VALUE );
		System.out.println("int 변수의 최소값 : " + Integer.MIN_VALUE );
		
	}

}
