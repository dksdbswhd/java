package com.jcp.day3;

import java.util.Scanner;

public class ForTest2 {
	
	public static void main(String[] args) {
		int i,n;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("마지막 n값을 입력하세요. >>> ");
		n = sc.nextInt();
	
		//합계(중간결과값,최종결과값) 저장할 변수는 초기값이 필요합니다.
		int sum=0;
		//1부터 n까지의 합계
		for(i=1;i<=n;i++) {   //i=11일때 조건이 거짓.
			//{ } 안에서 선언한 변수는 { } 밖에서 알수 없음. --> 지역변수  , for(int i=1;i<=n;i++)로 했을때.
			//sum = sum +i;   //(새로운)sum = (현재)sum +i;
			//int sum=0;   //sum 을 매번 0으로 초기화
			sum+=i;
			System.out.println("i="+i +",sum="+sum);   //중간결과값 확인
		}
		System.out.println("확인 i = " + i);   //for가 끝나면 i=11
		System.out.println("1부터 ~" + n + "까지의 합계는 " + sum + "입니다.");
		
		//	System.out.println("[[옵션]]1:짝수   2:홀수   3:기본(모든값)");
		//  --> for문보다는 while 문이 적합.
		
	}
	

}
