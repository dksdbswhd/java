package com.jcp.day2;

import java.util.Scanner;

//문자열 데이터를 사용합니다. 핵심: 자바에서 문자열은 기본데이터형식이 없고  String 클래스로 사용합니다.
public class StringTest {

	public static void main(String[] args) {
		String name="kim";      //클래스 타입의 변수(참조변수)     
//문자열 "kim"이 메모리에 저장되고 그 위치(주소)는 name이 저장한다.-> name을 참조변수라고 한다.
		System.out.println(name);

		name="choi";     
//문자열 "choi"가 메모리에 저장되고 name은  그 위치(주소)를  저장하도록 변경된다.
		System.out.println(name);
		
		Scanner sc = new Scanner(System.in);   //Scanner 클래스의 객체를 참조하는 sc 변수
		String nickname;
		System.out.print("닉네임 입력하세요 >>> ");
		//nickname = sc.next();    //next() 메소드는 문자열 입력.- 공백이전까지만 저장
		nickname = sc.nextLine();   //입력된 공백을 저장하는지 확인! - 줄 단위(엔터 입력)로 입력 처리
		System.out.println("닉네임 확인 : " + nickname);
		
	}

}
