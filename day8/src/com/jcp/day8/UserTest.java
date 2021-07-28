package com.jcp.day8;

public class UserTest {

	public static void main(String[] args) {

		User sana = new User();
		User mina = new User("미나", 23);
		
		
		//User 클래스 객체의 필드 name,age 접근을위해 set,get 메소드 사용합니다.
		sana.setAge(11);
		sana.setName("사나");
		
		System.out.println(sana.getName() + "(" + sana.getAge() +")");
		
	}

}
