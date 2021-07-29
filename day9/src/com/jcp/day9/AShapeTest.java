package com.jcp.day9;

public class AShapeTest {
//AShape 추상클래스를 사용해봅시다.
	public static void main(String[] args) {

//  AShape ash = new AShape();   //객체 생성 new 연산으로 못합니다
		
		AShape tri = new ATriangle();
		AShape rec = new ARectangle();
		
		AShape tri2 = new ATriangle("작은직각삼각형", 34, 27);
		System.out.println(tri2.getArea());
		
		AShape rec2 = new ARectangle("평행사변형", 34, 27);
		System.out.println(rec2.getArea());
		
		System.out.println("print 메소드는 AShape 타입의 인자로 실행됩니다.");
		//다형성 - 메소드의 인자가 AShape 부모타입 입니다.
		print(tri2);    //static 메소드만 호출할 수 있습니다.
		print(rec2);
	}

	
	public static void print(AShape ash) {
		System.out.println("이 도형은 이름이 " + ash.getShapeName());
		System.out.println("면적은 " + ash.getArea() + "입니다.");
	}
	
}
