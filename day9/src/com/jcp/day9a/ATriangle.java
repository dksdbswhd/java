package com.jcp.day9a;

public class ATriangle extends AShape{
	
	//기본생성자,커스텀 생성자 정의.
	public ATriangle() {
		// TODO Auto-generated constructor stub
	}
	
	public ATriangle(String shapeName,int width,int height) {
		super(shapeName,width,height);
	}
	
	
	//추상메소드는 반드시 정의해야한다.
	@Override
	public int getArea() {
		int result = this.getHeight() * this.getWidth() /2;
		return result;
	}
	//implements(구현) : 정의가 안되어있는 메소드 --> 정의해서 실행코드 작성.
}
