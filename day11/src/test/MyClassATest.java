package test;

//java.lang 패키지 클래스 이외의 다른 패키지 클래스 사용에서 꼭 필요합니다.
import day11a.InterfaceA;
import day11a.MyClassA;

//인터페이스의 접근 한정자 public 확인을 합니다.
public class MyClassATest {

	public static void main(String[] args) {
		//구현 클래스로 객체 생성
		MyClassA my = new MyClassA();

		//인터페이스 상수 출력
		System.out.println(InterfaceA.SIZE);
		
		//구현 클래스 상수 출력
		System.out.println(MyClassA.SIZE);
		
		//추상메소드를 구현한 것 호출
		my.methodA();
		my.methodB(23);
		
		my.methodC("hi");  //인터페이스의 default 메소드
		
		//static 메소드는 인터페이스 이름으로 호출
		InterfaceA.medthodD();
	
	}

}
