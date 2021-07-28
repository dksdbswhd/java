package test;

import com.jcp.day8.Shape;
import com.jcp.day8.Triangle;

public class ShapeTest2 {

	
//이 클래스는 다른 test 패키지 입니다.
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
		
		Rectangle re = new Rectangle("직사각형", 22, 15);
		System.out.println(re.getShapeName() + " - 너비:" + re.getWidth() +",높이:" 
				+re.getHeight() + ",면적:" + re.getArea());
				
		
		
	}

}
