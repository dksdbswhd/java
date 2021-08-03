package day12a;

//인터페이스 InterfaceA를 사용하는 구현 클래스 
// -> 객체 생성
public class MyClassA implements InterfaceA {
//InterfaceA 의 추상메소드는 반드시 구현해야한다.

	@Override
	public void methodA() {
		// TODO : methodA 구현 필수!!
		System.out.println("나는 methodA !!");
	}

	@Override
	public int methodB(int num) {
		// TODO : methodB 구현 필수!!
		System.out.println("나는 methodB !! " + num);
		return num;
	}

	@Override
	public void methodC(String message) {
		System.out.println("나는 MyClassA : " + message);
	}

	// InterfaceA 의 static 메소드를 별도로 정의할 수 있습니다.
	// 이름이 같아도 override 로 처리하지 않습니다.
	public static void medthodD() {

	}
}
