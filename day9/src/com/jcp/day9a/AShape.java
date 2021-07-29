package com.jcp.day9a;

//추상클래스 : 부모클래스로 사용됩니다. 
//          객체를 new 연산으로 직접 생성안합니다.
//          abstract 메소드가 있습니다.
//추상 : 구체화되지 않은 상태.추상클래스는 공통점으로 구성된 상태.
//구체화 : 자식클래스가 구체화하여 객체 생성합니다.
public abstract class AShape {
	
	private String shapeName;		//도형 이름
	private int width;				//도형의 크기 중 너비
	private int height;	
	
	public AShape() {
		// TODO Auto-generated constructor stub
	}
	
	public AShape(String shapeName, int width,int height) {
		this.shapeName=shapeName;
		this.width=width;
		this.height=height;
	}
	
	//추상메소드 선언만 합니다. 메소드 실행내용 정의{.. }가 없습니다.
	//공통메소드이나 실행내용은 구체화됬을때 다릅니다.
	//		ㄴ 추상클래스는 추상메소드가 있을 때입니다.
	//		ㄴ 추상메소드는 강제로 오버라이딩하도록 합니다.
	public abstract int getArea();
	
	
	//일반 인스턴스 메소드
	public String getShapeName() {
		return shapeName;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	
}
