package com.jcp.day6;

import java.util.Scanner;

/*
 * String 타입의 배열 
 * 1) String 타입 변수는 참조형 변수였다.
 * 2) String[] , String 배열도 인덱스로 접근한 메모리의 값은 문자열의 참조값이다.
 * 
 */
public class StringArrayTest {

	public static void main(String[] args) {
		// String 배열 테스트
		
		String[] strArray 
		= {"continue","break","switch","constant","identifier","array","print"};
		//배열의 요소 출력
		for(int i=0;i<strArray.length;i++)
			System.out.println("i="+i + ",문자열 =" + strArray[i]);
		
		//배열 요소에 문자열 입력, 먼저 new 연산으로 참조값을 저장할 메모리 공간을 확보한다.
		String[] arr = new String[4];
		Scanner sc = new Scanner(System.in);
		
		for(int i=0;i<arr.length;i++) {
			System.out.print("문자열 입력 >>> ");
			arr[i] = sc.nextLine();   //입력하는 문자열의 참조값을 arr[i] 에 저장한다.
			
		}
		
		//입력한 문자열 확인
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i] + "\t");
		
		sc.close();
	}

}






