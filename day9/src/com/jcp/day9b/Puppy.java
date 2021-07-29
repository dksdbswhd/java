package com.jcp.day9b;

public class Puppy extends Animal {
	static final String TYPE ="강아지";
	
	public Puppy() {
	}
	
	public Puppy(String color) {
		super(color);
		//this.setColor(color);
	}

	@Override
	public void sound() {
		System.out.println(this.getColor() +" 강아지는 멍멍 🐶🐶하고 짖습니다. ");

	}

}
