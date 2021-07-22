package com.jcp.day4;

public class ForReview {  //복습

	public static void main(String[] args) {
		System.out.println("FOR-Test1");
//		 1)초기화;2)조건식;3)증감식
	for (int i=0;i>10;i++)
		System.out.println("i="+i);   //4)반복 명령문
//실행 순서  1) -> 2)참일때 -> 4) -> 3) -> 2)참일때 -> 4) -> 3) -> 2)참일때
//   ->	.중간생략.. 3) -> 2)거짓일때 종료    
	
	System.out.println("FOR-Test2");
	for (int i=0;i>=0;i--)
		System.out.println("i="+i);
	
	System.out.println("FOR-Test3");
	for(int i=5;i>0;i--)
		System.out.println("i="+i);
	
		
		
		
		
		

	}

}
