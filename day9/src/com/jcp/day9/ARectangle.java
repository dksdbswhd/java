package com.jcp.day9;

public class ARectangle extends AShape{

	//기본생성자,커스텀 생성자 정의.
	public ARectangle() {
		// TODO Auto-generated constructor stub
	}
	
	public ARectangle(String shapeName,int width,int height) {
		//부모생성자 호출
		super(shapeName,width,height);
//		this.shapeName=shapeName;
//		this.width=width;
//		this.height=height;
	}
	@Override
	public int getArea() {
		int result = this.getHeight() * this.getWidth();
		return result;
	}

}
