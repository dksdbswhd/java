package com.jcp.day6;

import java.util.Arrays;

public class StringMethodTest5 {

	//문자열 비교 : 사전식비교(A<B<C...<Z<a<b<c<..<z) 메소드
	public static void main(String[] args) {
		// 문자 char , 정수 데이터 형은 값의 비교를 관계연산자(<,>,<=,>=)로 했습니다.
		// 문자열 비교는 못합니다. compareTo 메소드로 합니다.
		String str = "hello";
		
		//str.compareTo(비교문자열) : str - 비교문자열 형식으로 실행합니다.
		
		System.out.println(str.compareTo("cat"));     //str보다 앞에 있는 문자열 일때  결과값 > 0
		System.out.println(str.compareTo("hello"));   //str과 같은 문자열  일때  결과값 == 0
		System.out.println(str.compareTo("switch"));  //str보다 뒤에 있는 문자열 일때  결과값 < 0
		
		//문자열의 비교는 대표적인 예로 순서대로 정렬하고 싶을 때 사용할수 있습니다.
		String[] strArray 
		= {"continue","break","switch","constant","identifier","array","break","print"};

		//정렬을 제공하는 클래스와 그의 메소드.  java.util.Arrays클래스의 sort 메소드
		Arrays.sort(strArray);   //strArray 배열이 가리키는 문자열을 오름차순 정렬한 순서로 참조시킵니다.
		//정렬이 잘 되었는지 출력해 보세요.
		for(int i=0;i<strArray.length;i++)
			System.out.print(strArray[i] + "\t");
		
		System.out.println();
		//Arrays 클래스에는 배열의 값을 인덱스 순서대로 하나의 String으로 리턴하는 메소드 toString 도 있습니다.
		System.out.println(Arrays.toString(strArray));
		
	}

}
