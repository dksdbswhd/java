package com.jcp.day1;

public class RectangleTest2 {

	public static void main(String[] args) {
		double height=22.3;
		double width=12.9;
		
		double area;
		
		//사용자 입력(키보드입력) : height, width 값을 입력/저장하여 넓이 구하는 프로그램으로 변경하세요.
		
		
		System.out.println("-------------------------------------");
	    System.out.println("*사각형(Rectangle)의 너비, 높이, 넓이는 구해보는 코드입니다.*");
	    System.out.printf("사각형의 너비는 %f, 사각형의 높이는 %f 입니다\n", width, height);
	      
	 
	    System.out.println("사각형의 넓이를 구했습니다.............");
	    area =  height*width ; //실수와 정수를 연산(+ - * /) 한 결과는 실수
	    System.out.printf("%f x %f = %.3f \n",height,width,area);

	}		

}
