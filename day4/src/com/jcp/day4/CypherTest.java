package com.jcp.day4;

public class CypherTest {

	public static void main(String[] args) {
//  요구사항 :  철수가 미미에게 메시지를 전달하는데 간단한 암호화를 합니다.
//			   철수는 미미와 key값으로 7이라는 숫자를 알고 있어요. 
//  보내고 싶은 메시지는 String 타입 "I like Java."  => 각 문자에 키값 7을 더해서 보냅니다. 
//  암호화된 메시지는 String 타입으로 전달해야 합니다.	(String 타입 결과 출력하세요.)	
		String message="너 어렵구나 자바야~";
		String cypherText;
		int key=99;
		char[] temp;   //message 각 문자를 인덱스로 접근하기 위해서 char[] 배열 사용
			 		  //char 형은 +,- 연산을 할수 있습니다.
		temp = message.toCharArray();
		for(int i=0;i<temp.length;i++) {
			temp[i]+=key;   
			//key 값이 자동으로 casting 되도록 ++ , --, +=, -= 연산자를 사용하세요.
		}
		
		cypherText = String.valueOf(temp);
		System.out.println(cypherText);
		
	}
}
