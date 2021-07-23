package com.jcp.day5;

public class StringMethodTest4 {

	public static void main(String[] args) {
		// indexOf 메소드와 substring메소드를 같이 사용해서
		// 문자열 찾기 
		// 예: "korHK korTE korSH korea!!" 에서 "kor"이 몇번 있는지 알아내기.
		
		String testStr = "korHK korTE korSH korea!!";
		int index;
		String temp =testStr;	//temp는 testStr과 같은 참조값을 갖는다.
		
		while(true) {
			System.out.println("temp 문자열 : " + temp);
			index = temp.indexOf("kor");   //찾는 문자열 "kor"
			System.out.println("index 확인 : " + index);
			if(index == -1) break;
			temp = temp.substring(index+3);   
			//"kor"의 길이가 3이므로 "kor"뒤의 문자열을 추출한다. 
		
		}

	}

}
