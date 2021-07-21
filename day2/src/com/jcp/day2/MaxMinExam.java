package com.jcp.day2;

import java.util.Scanner;

public class MaxMinExam {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//소스데이터
		int n1,n2,n3;
		int max,min;
		
		//n1,n2,n3의 키보드 입력(사용자입력)추가
		System.out.print("n1 >>> ");
		n1 = sc.nextInt();
		System.out.print("n2 >>> ");
		n2 = sc.nextInt();
		System.out.print("n3 >>> ");
		n3 = sc.nextInt();
		System.out.printf("n1=%d\t n2=%d\t n3=%d\n",n1,n2,n3);
		
		
		//n1,n2,n3 중에 최대값 구하기
		if(n1>n2) {
			max = n1;
			min = n2;
		}
		else {
			max = n2;     //max --> 86
			min = n1;
		}
		
		if(max<n3) max = n3;   //max --> 86
		if(min>n3) min = n3;   //max --> 86
		System.out.println("max =" + max +",min = " + min);

	}

}
