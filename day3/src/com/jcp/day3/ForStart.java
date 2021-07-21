package com.jcp.day3;

import java.util.Scanner;

public class ForStart {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int point,i;
		System.out.println("[영화감상 후기]");
		System.out.print("평점을 몇 점 주시겠습니까?(1~5) >>> ");
		point = sc.nextInt();

		//1)
		System.out.println(":::테스트1:::");
		for (i=0; i<point; i++) {
			System.out.print("★");
		}
		for (i=0; i<5-point; i++) {
			System.out.print("☆");
		}
		
		//2)
		System.out.println(":::테스트2:::");
		for (i=0;i<point;i++) {
			System.out.print("★");
		}
		for (;i< 5; i++) {
			System.out.print("☆");
		}
	
		//3)
		System.out.println(":::테스트3:::");
		for (i=0;i<5;i++) {
			if(i<point) System.out.print("★");
			else System.out.print("☆");
		}
		
		
		if (point >= 3)  System.out.println("\n감사합니다.");
		else System.out.println("\n아쉽군요!!");
	}
}
