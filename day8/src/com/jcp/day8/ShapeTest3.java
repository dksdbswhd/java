package com.jcp.day8;

import test.Rectangle;

//다형성(polymorphism)을 확인하는 예제입니다.
//  ㄴ 의미는 하나지만 실제 형태는 여러 가지가 될 수 있음. --> 메소드 오버라이딩으로 구현합니다.
public class ShapeTest3 {

	public static void main(String[] args) {
		//객체 참조타입이 자기자신의 타입이 아닌 부모(상위)클래스 타입으로 했습니다.
		Shape sh1 = new Triangle("작은 삼각형", 32, 16);   //업캐스팅 : 슈퍼클래스로 참조되는 것.
		Shape sh2 = new Rectangle("큰 직사각형", 56, 87);
		
		//sh1,sh2객체가 Shape 타입이지만 실제 객체는 다릅니다.그래서 getArea 실행 동작도 다릅니다.
		System.out.println(sh1.getArea());    //getArea 재정의(오버라이딩)
		System.out.println(sh2.getArea());
//  다형성을 이용해서 하위클래스를 모두 부모클래스 타입 Shape 배열에 참조시킬수 있습니다.
		
//		System.out.println("sh1 삼각형 직각?" + sh1.rightAngle);
		
		Triangle tri = (Triangle)sh1;	//자식클래스 타입으로 (다운)캐스팅 -> 자식클래스 필드,메소드 사용합니다.
		System.out.println("sh1 삼각형 직각?" + tri.rightAngle);
		
	}

}
