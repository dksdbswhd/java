package com.jcp.day5;

import java.util.Scanner;

public class UserIdCheckTeacher {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean result = true;        //아이디가 조건 만족하지 않으면 false로
		String userId;
		String message=null; 	//결과 출력 메시지. null 로 초기화.
		//"" -> 문자열 데이터
		
		//1. 메시지 표시
		System.out.println("회원가입을 환영합니다. ");
		System.out.println("✔ 아이디는 6글자 이상이고 숫자로 시작할수 없습니다.");
		System.out.println("✔ 특수문자 @는 사용할수 없습니다.");
		System.out.println("-----------------------------------------");
		System.out.print("사용할 아이디를 입력하세요. >>> ");
		
		//2.사용자 아이디 입력
		userId = sc.nextLine();
		
		System.out.println("입력한 아이디를 검사합니다...............");
		//3.입력받은 아이디 6글자 인지 검사
		if(userId.length() < 6) {   //6글자 미만이면 result를 false로
			result = false;
			message = "아이디를 6글자 이상해주세요.";
		}else {  //6글자 이상 이면
			char ch = userId.charAt(0);   //charAt(0) 은 문자열의 첫번째 글자
			if(ch >='0' && ch <= '9'){   //첫글자가 숫자인지 검사 - result를 false로
				result=false;
				message = "아이디는 숫자로 시작할수 없습니다.";
			}else {
				//특수문자 '@' 있는지 검사 - result를 false로
				//방금한 반복문으로 검사합니다.
				for(int i=0;i<userId.length();i++) {
					ch = userId.charAt(i);
					if(ch == '@') {
						result=false;
						message="@ 기호를 사용할 수 없습니다.";
						break;
					}
				}//for end
				
			} //숫자 검사 if end	
		} //길이 검사 if end
		
		//출력 - result 가 true일때 , false 일때 다르게 메시지를 표시
		if(result){
			System.out.println("사용할 수 있는 아이디 입니다.");
		}else {	
			System.out.println("사용할수 없는 아이디입니다. -" + message);
			//변수 선언이 String message; 로 되어있으면 초기화 되어 있지 않은 오류 발생합니다. 
			//if { } 안에서 값이 대입된 것은 아직 정해지지 않은 값  --> String message=null;
			//null은 빈(empty) 값. 
		}	
		
		sc.close();
	} //main end

}  //class end
