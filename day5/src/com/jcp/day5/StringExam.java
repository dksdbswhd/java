package com.jcp.day5;

public class StringExam {
//문제
	public static void main(String[] args) {
		// 문자열  "kor_sec20_21@gmail.com";
		// -> 숫자의 갯수를 출력합니다. 위의 예는 숫자 갯수 총 4개 입니다.
		// 메소드는 charAt 사용하여 문자를 1개씩 검사합니다. 
		// 반복횟수는 문자열의 길이를 구하는 length 메소드를 이용합니다.
		String email = "kor2_s0ec_2@gmail1.com";
		//email ="java8te st4 ";
		char ch; int cnt=0;   //문자 char 는  문자모양 - ''기호.
		for(int i=0;i<email.length();i++) {
			ch=email.charAt(i);   //ch는 순서 'k','o','r','2'.....
			if(ch >='0' && ch <='9')  //숫자인지 검사 
					cnt++;		//카운트 증가
		}
		
		System.out.println("문자열 email 의 숫자 갯수는 " + cnt +" 입니다.");
		
	}

}
