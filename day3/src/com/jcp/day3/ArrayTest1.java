package com.jcp.day3;

import java.util.Scanner;

//먼저 정수 배열을 테스트 합니다.
public class ArrayTest1 {

	public static void main(String[] args) {

		//선언방법 
		//1) 정수데이터 4개를 초기값을 주고 선언-배열의 크기는 4
		int[] arr1 = {78,65,89,94};   //배열값의 초기화
		
		//2) 정수 데이터 10개를 저장할 수 있음 - 배열의 크기 5
		int[] arr2 = new int[5];     //new는 객체를 생성하는 연산자
				  //배열의 크기만 정하고 값은 주지 않는다.- 초기값은 기본 0
		
		//*자바에서 배열 변수 arr1, arr2 는 참조타입 입니다.
		
		//배열의 하나씩 값을 출력.- 인덱스(위치를 나타내는 값)
		for(int i=0;i<arr1.length;i++) {   //배열의 length 필드값 만큼 반복
			System.out.printf("arr1[%d]=%d\n",i,arr1[i]);
		}
		//배열의 값들이 모두 0(기본값)으로 출력
		for(int i=0;i<arr2.length;i++) {
			System.out.printf("arr2[%d]=%d\n",i,arr2[i]);
		}
		
		//arr2 배열에 사용자가 입력한 값으로 데이터를 저장하고 
		//1)전체출력. 2)짝수 만 출력  3)소수 출력
		Scanner sc = new Scanner(System.in);
		//입력
		for(int i=0;i<arr2.length;i++) {   //5번 실행
			System.out.print("배열에 저장할 값 >>> ");
			arr2[i]=sc.nextInt();
		}
		System.out.println("::사용자 입력 배열 값 출력 ::");
		System.out.println("[[모두 출력]]");
		for(int i=0;i<arr2.length;i++) 
			//1)
			System.out.printf("arr2[%d]=%d\n",i,arr2[i]);
		
		System.out.println("[[짝수만 출력]]");	
		for(int i=0;i<arr2.length;i++) 	{
			//2)
			if(arr2[i] % 2==0) {  //2로 나눈 나머지 0이면 짝수
				System.out.printf("arr2[%d]=%d\n",i,arr2[i]);
			}
		}	
			//소수 n은 1과 n으로 나누었을 때만 나머지가 0입니다.
			//n=9 가 소수인지?  k= 2 ~ 4 (n/2) 로 하고  n % k == 0 인 값이 있으면
			//n은 소수가 아닙니다.  다른 예 : n=13, k=2~6  --> 소수
			//소수값 : 2,3,5,7,11,13,17,23,29,31,37,.....
		System.out.println("[[소수만 출력]]");	
		for(int i=0;i<arr2.length;i++) 	{
			int n = arr2[i];
			boolean result = true;   //소수이다.
			
			for(int k=2;k<=n/2;k++) {    //n=2일때 처리가 잘되는지 - true인지 확인!!
				if( n % k == 0 ) {
					result=false;   //소수가 아니다.
					break;
				}
			}
			if(n==1) result=false;   //1은 소수가 아니므로
			//result=true ? false?
			if(result) 
				System.out.printf("arr2[%d]=%d\n",i,arr2[i]);
			
		}
	}
}

/*
 * 
 * 			
 * 
 * 
 * 
 */
