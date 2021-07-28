package com.jcp.day8;

//Shape 클래스로부터 상속받는다. (extends)
public class Triangle extends Shape{

	
//부모가 사용하지 않는 생성자를 자식클래스가 사용할 수 없습니다.

	public Triangle(String shapeName, int width, int height) {
		//super 키워드 부모클래스 . 부모클래스 생성자 호출
		super(shapeName, width, height);
	}

	//삼각형 넓이를 구하는 메소드로 getArea() 수정-> ※오버라이드※
	//부모클래스의 메소드 동작을 자식클래스가 수정
	int getArea() {
		return (this.getHeight()*this.getWidth())/2;
	}	
}
