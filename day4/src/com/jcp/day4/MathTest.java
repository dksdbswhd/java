package com.jcp.day4;

//다양한 데이터 활용을 위해서 Math 클래스를 사용합시다.
//Math 클래스 : 수학적인 기능을 메소드로 제공합니다.(랜덤값 생성, 반올림) 
public class MathTest {

	public static void main(String[] args) {
		// 데이터 생성 : 1) 코드에서 리터럴 사용 int num=10;  2) 사용자 키보드 입력 
		
		System.out.println("랜덤값 생성합니다.....");
		System.out.println(Math.random());  //랜덤값 x의 범위  :  0< x < 1 인 double
		System.out.println(Math.random());
		System.out.println(Math.random());
		System.out.println(Math.random()*100);
		System.out.println(Math.random()*100);
		
		System.out.println("--- floor, round 메소드 사용하기 ---");
		double temp = Math.random();   //랜덤값(난수) 생성하여 저장
		System.out.println(temp);
		System.out.println(Math.floor(temp*100));   //소수점이하 버림
		System.out.println(Math.round(temp*100));   //반올림
		temp = 123.567;
		System.out.println("--- 123.567 실행결과 ----");
		long test = Math.round(temp*100);   //temp*100 -> 12356.7 를 반올림한 결과
		System.out.println(test);
		
//random()은 0~1 사이의 double 형식 변수 x --> 응용 -> 1~45 사이의 임의의 정수값을 만들어 보자.
// a부터 b사이의 임의 정수값  (Math.random() * (b-a+1)) + a
		
		//로또테스트 : 1~45 정수값 6개를 랜덤으로 생성합니다. LottoTest.java
		//1) for문으로 출력만 합니다.
		//2) 중복된 값이 나오는 것은 일단은 무시.
	}
	//클래스의 구성 : 필드, 메소드  
	//메소드의 분류
	//1) 클래스 메소드  : 클래스이름.random()   
	//2) 인스턴스 메소드 (객체참조변수.nextInt())
	//메소드의 형식 : 인자, 리턴값             ->   예를 들면 Math.round(temp*100);
	//-리턴값 : 메소드 실행한  결과값          ->   정수형 long
	//-인자,인수,매개변수 : 메소드 실행에 필요한 데이터    ->   temp*100 (double 형식 1개)
	
}
