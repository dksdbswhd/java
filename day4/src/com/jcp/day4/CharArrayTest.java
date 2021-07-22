package com.jcp.day4;

//문자 배열을 연습합시다.
public class CharArrayTest {

	public static void main(String[] args) {
		
		
		//char 형 데이터는 문자('')를 2바이트 크기로 저장합니다.
		char[] charArr = {'하','이','~','자','바','!','재','밌','다','.'};
		
		System.out.println("--- char 배열의 값을 출력 ---");
		for(int i=0;i<charArr.length;i++)
			System.out.println(charArr[i]);
		
		System.out.println("--- char 배열의 인덱스 2값을 수정하고 출력 ---");
		charArr[2]='*';
		System.out.println(charArr);   //참조변수를 이용하여 출력하면 문자배열은 String 형태로 출력
		
		System.out.println("--- char 배열과 String 타입과의 변환 ---");
		System.out.println("1.String 타입을 char 배열로 변환");   //예를 들면, char 배열로 바꿔서 처리하는 작업이 더쉬울때
		String temp = "헬로우!!자바**";
		
		char[] tempArr = temp.toCharArray();  //Quiz : 클래스 메소드? or 인스턴스 메소드?
											//
		for(int i=0;i<tempArr.length;i++)
			System.out.println(tempArr[i]);  //인덱스로 접근
		
		System.out.println("2.char 배열을 String으로 변환");      //예를들면, 처리가 완료된 char배열을 String으로 변환해야할때
		char[] tempArr2 = {'p','l','e','a','s','e','~','!','.'};
		String chString =String.valueOf(tempArr2);    //Quiz : 클래스 메소드? or 인스턴스 메소드?
		//System.out.println(chString[4]);   //chString은 배열이 아니므로 인덱스 사용 못합니다.
		System.out.println(tempArr2[5]);
		
		
		//객체 타입이 바뀌는게 무슨 의미가 있나요?  
		//      - 사용할 수 있는 필드와 메소드가 달라집니다. 
		
	}

}
