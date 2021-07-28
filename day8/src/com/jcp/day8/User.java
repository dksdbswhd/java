package com.jcp.day8;


//필드에 private 접근 권한 - setXXX(setter), getXXX(getter) 메소드로 필드에 접근하는 클래스 입니다. 
public class User {

		private String name;
		private int age;
		
		public User() {
			// 기본생성자
			test();
		}
		
		//필드 초기화를 하는 커스텀 생성자
		public User(String name, int age) {
			this.name = name;
			this.age = age;
		}
		
		
		public String getName() {   //name필드의 형식과 같은 리턴형식
			return name;
		}
		
		public void setName(String name) {   ////name필드의 형식과 같은 인자 형식
			this.name = name;
		}
		
		public int getAge() {   //age 필드의 형식과 같은 리턴형식
			return age;
		}
		 
		public void setAge(int age) {  //age 필드의 형식과 같은 인자 형식
			this.age = age;
		}
		
		
		private void test() {
			System.out.println("test입니다.");
		}
	
}
