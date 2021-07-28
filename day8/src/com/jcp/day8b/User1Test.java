package com.jcp.day8b;

//다른 패키지의 클래스 사용할때 꼭 import
//class 가 public 일때 import 가능합니다.
import com.jcp.day8a.User1;
public class User1Test {

	public static void main(String[] args) {
		
/*		
//오류:다른패키지에서는 사용할수 없는 생성자 , 필드		
		User1 momo = new User1();
		
		momo.name ="모모";
		momo.age = 25;
*/
		User1 momo = new User1("모모");
//		momo.age = 23;   //접근권한 오류
//		System.out.println(momo.name);
	}

}
