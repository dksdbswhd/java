package com.jcp.day6;

import java.util.Scanner;

/*
 * 반복문 안에서 String 배열이 참조하는 문자열을 비교(equals)하는 테스트
 */
public class StringArrayCompare {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//처리조건: 문자열 중복이 가능한 데이터 저장이다.
		String[] strArray 
		= {"continue","break","switch","constant","identifier","array","break","print"};
		String[] korArray
		= {"계속","종료","선택","상수","식별자","배열","탈출","출력"};
		
		//***비교 : equals 메소드(완전일치), contains 메소드(부분일치) 
		//찾고 싶은 문자열
		String find;     //String find ="continue"; 로 테스트하고 사용자 입력으로 변경했습니다.
		boolean result=false;    //초기값을 실행 흐름에 따라 결정.
		System.out.print("find 문자열 입력하세요. >>> ");     //keyword 입력
		find = sc.nextLine();
		for(int i=0;i<strArray.length;i++) {  //순서대로 모두 비교. 찾을 떄까지
			System.out.println("i="+ i +", 찾는값 ? " + strArray[i].equals(find));
			
			if(strArray[i].equals(find)) {  //배열에 문자열 중복이 허용되지 않을 때는  break 사용합니다.
				result=true;
				System.out.println("find 를 찾았습니다......");
				System.out.println("i="+ i +",영문 =" + strArray[i]+ ",한글=" + korArray[i]) ;
			}
		}
		//찾는 문자열이 한번도 없었다면.... result는 초기값 false 이다.
		if(!result)   //result가 false일때 출력하기 위해서입니다.    
			//! 연산자는 true 는 false 로, false 는 true 로 바꾸는 not 부정연산자(논리연산자 종류)
			System.out.println("검색 결과 : 찾는 문자열이 없습니다.");
		
	} //main end

}




