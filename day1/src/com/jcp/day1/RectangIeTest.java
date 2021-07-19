package com.jcp.day1;

import java.util.Scanner;

public class RectangIeTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		double height; //높이의 값지정안함
		double width;  //너비의 값지정안함
		System.out.println(":::계산 할려는 높이와 너비를 적기:::");
		System.out.print("높이의 값을 입력하세요 :"); //입력한 높이의 값 출력
		height = sc.nextDouble(); // 높이 입력받기
		System.out.print("너비의 값을 입력하세요 :"); //입력한 너비의 값 출력
		width = sc.nextDouble();  // 너비 입력받기
		
		
		double area;
		area = height*width;  // 넓이area = height(넓이) * width(너비)
		System.out.printf("넓이의 값 : %.2f * %.2f = %f", height,width,area); 
		// 소숫점 2째까지만 받음.			height   *  width = area	

	}

}
