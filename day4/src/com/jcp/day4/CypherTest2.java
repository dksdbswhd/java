package com.jcp.day4;

public class CypherTest2 {

	public static void main(String[] args) {
//  요구사항 :  미미가 철수로부터 암호화된 메시지를 전달받았어요.
//			   철수와 미미는 key값으로 7이라는 숫자를 알고 있어요. 
//  받은  메시지는 String 타입 "P'sprl'Qh}h5"   
//  암호화된 메시지를 복호화하기 위해 => 각 문자에 키값 7을 뺼셈을 합니다.
//  그리고 복화화 메시지를 String 타입으로 수신하여 봅니다.	(String 타입 결과 출력하세요.)
		
		String message;
		String cypherText="녫옗뢘귏냻쟳뱷엟á";
		int key=99;
		char[] temp;   //message 각 문자를 인덱스로 접근하기 위해서 char[] 배열 사용
			 		  //char 형은 +,- 연산을 할수 있습니다.
		temp = cypherText.toCharArray();
		for(int i=0;i<temp.length;i++) {
			temp[i]-=key;   
			//key 값이 자동으로 casting 되도록 ++ , --, +=, -= 연산자를 사용하세요.
		}
		
		message = String.valueOf(temp);
		System.out.println(message);
		
	}
}
