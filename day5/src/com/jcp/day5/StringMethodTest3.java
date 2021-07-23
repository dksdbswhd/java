package com.jcp.day5;

public class StringMethodTest3 {

	public static void main(String[] args) {
		//**** 많이 쓰이는 문자열 메소드
		
				String testStr="koreait.2021@gmail.com";
				//문자열의 위치를 표시하는 인덱스는  0 부터 입니다.
				
				System.out.println("1.contains");
				System.out.println(testStr.contains("gmail"));	//포함하다. testStr참조문자열이 "gmail" 을 포함하는가?
				//인자? String 과 비슷한 CharSequence 1개 ,  리턴형식? boolean
				System.out.println(testStr.contains("1998"));   //거짓
				
				System.out.println("2.charAt");			
				System.out.println(testStr.charAt(6));    //char배열의 인덱스 접근과 동작이 같지만 읽기만 됩니다.
				//인자? int 1개 , 리턴형식?  char	 //  문자 1개씩 인덱스로 변경하는 것은 어제 예제처럼 char[] 배열로 변경이 가능합니다.
		
				System.out.println("3.indexOf");  //문자열객체.indexOf("arg문자열") →문자열객체에서 "arg문자열" 위치를 알려줍니다.
				System.out.println(testStr.indexOf("com")); // 19
				System.out.println(testStr.indexOf("."));  //7  //첫번째 "." ,만약에 "."이 3번이상 있다면 indexOf를 반복합니다.
				System.out.println(testStr.indexOf("*"));     //결과는? -1  (없을 때 리턴값)
				//인자? String 타입 1개,   리턴형식? int
				System.out.println("4.lastIndexOf");
				System.out.println(testStr.lastIndexOf(".")); //18 //"." 이 여러번 있을때 마지막 "."
				//인자? String 타입 1개,   리턴형식? int

				//"koreait.2021@gmail.com";
				System.out.println("5.endsWith");  
				//문자열객체.endsWith("arg문자열") →문자열 객체가 "arg문자열"로 끝나는가?
				System.out.println(testStr.endsWith("com"));   //true
				System.out.println(testStr.endsWith("net"));   //false
				//시작문자열을 검사합니다.
				System.out.println(testStr.startsWith("kor"));   //true
				System.out.println(testStr.startsWith("sec"));   //false
				//인자? String 타입 1개,   리턴형식? boolean
				
				System.out.println("6.subString");
				System.out.println(testStr.substring(10, 15));   //21@gm
				//인덱스 10부터 개수는 15-10 
				//문자열 일부 추출 : 인자? int 2개(시작인덱스,끝인덱스), 리턴형식? String
				System.out.println(testStr.substring(17));		//l.com
				//문자열 일부 추출 : 인자? int 1개(시작인덱스), 리턴형식? String
				
				System.out.println("7.replace");
				System.out.println(testStr.replace("2021", "1995"));
				System.out.println(testStr.replace("1", "777"));    
				//문자열 내용 찾아서 바꾸기
				//인자? String 과 비슷한 CharSequence 2개,   리턴형식? String
				
				
				
	}

}
