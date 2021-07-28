package com.jcp.day8;

//Shape 클래스로부터 상속받는다. (extends)
public class Triangle extends Shape{
//보이지는 않지만 자동으로 부모의필드를 상속 받음.
//		ㄴ shapeName, width, height 필드를 사용한다.	
	
	static final int MAX_WIDTH=90;
	//삼각형 도형의 특성상. 어떤 정보가 필요할까요? 각도
	//자식클래스에서 필요하니까 추가로 필드를 정의.
	boolean rightAngle;     //초기값 false
	
//부모가 사용하지 않는 생성자를 자식클래스가 사용할 수 없습니다.

	public Triangle(String shapeName, int width, int height) {
		//super 키워드 부모클래스 . 부모클래스 생성자 호출
		super(shapeName, width, height);
	}

	//삼각형 넓이를 구하는 메소드로 getArea() 수정-> ※오버라이드※
	//부모클래스의 메소드 동작을 자식클래스가 수정(재정의)
	//부모클래스의 getArea() 메소드 공식은 삼각형에서는 필요가 없어요.
	//리턴타입과 인자의 형식은 동일하도록 합니다.
	public int getArea() {
		return (this.getHeight()*this.getWidth())/2;
		//return width*height/2;
		//     ㄴ 부모클래스 width,height 가 protected 일때
	}	
	
	//자식클래스가  추가로 정의한 메소드
	void printName() {
		System.out.println("삼각형 이름 : " + getShapeName());
	}
}
