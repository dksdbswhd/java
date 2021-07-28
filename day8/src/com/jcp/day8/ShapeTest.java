package com.jcp.day8;

public class ShapeTest {

	public static void main(String[] args) {

		
		Shape sh = new Shape("작은정사각형", 23, 12);
		
		
		//get메소드로 리턴받은 값 변수에 저장합니다.
		String shape = sh.getShapeName();
		int width = sh.getWidth();
		int height = sh.getHeight();
		int area = sh.getArea();
		
		System.out.println(shape + " - 너비:" + width +",높이:" 
					+height + ",면적:" + area);
		
		Triangle tr = new Triangle("직각삼각형", 34, 10);
		shape = tr.getShapeName();
		width = tr.getWidth();
		height = tr.getHeight();
		area = tr.getArea();
		System.out.println(shape + " - 너비:" + width +",높이:" 
				+height + ",면적:" + area);
		
	}

}
