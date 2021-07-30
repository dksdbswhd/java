package com.jcp.day10;

public class Member {
	private String name;
	private int age;
	
	//생성자 오버로딩 -> 커스텀 생성자 정의하면 인자 갯수와 형식이 달라집니다.
	public Member() {
	}
	public Member(String name,int age) {
		this.name = name;
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getName() {
		return name;
	}
	
	//Object 클래스의 자동상속 (Object의 자식 클래스 Member) -->  Object 메소드 중 재정의 연습.(toString메소드)
	//**일반적으로 클래스의 toString을 다음과 같이 오버라이딩 하여 사용합니다.
	@Override
	public String toString() {

	//	return super.toString();  //Object 클래스의 실행내용
		return "[ 이름 : " + name + ",나이 : " + age + "]";
	}
	
	//**모든 참조타입의 toString 결과형식은 com.jcp.day10.Member@15db9742 --> 패키지명.클래스명@참조값
	
}
