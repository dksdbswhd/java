package com.jcp.day7;

public class MyClass4Test {

	public static void main(String[] args) {

		MyClass4 hong = new MyClass4();
		MyClass4 momo = new MyClass4("최모모", 4, new double[] {3.4,5,10.4});
		MyClass4 mina = new MyClass4("kimina", 5);
		
		hong.print();
		momo.print();
		mina.print();
		
		hong.setName("홍길동");
		hong.setLevel(3);
		hong.setPoint(new double[5]);
		
		hong.print();
	}

}
