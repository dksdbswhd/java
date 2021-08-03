package day12a;

//추상클래스는 상속하는 하위클래스가 있고, 인터페이스는 구현클래스를 사용합니다.
//공통점은 추상메소드를 갖는다. -> 익명클래스는 임시로 사용할때 활용합니다.
public class Test {

	public static void main(String[] args) {
		//InterfaceA 를 익명클래스 구현으로 객체 생성합니다.-> 스레드 프로그래밍에서 주로 사용합니다.
		InterfaceA ifa = new InterfaceA() {   //임시로 한번만 사용할 인터페이스 구현체
			
			@Override
			public int methodB(int num) {
				// TODO Auto-generated method stub
				return 12;
			}
			
			@Override
			public void methodA() {
				
				
			}
		};
		
		
		System.out.println(ifa.methodB(10));
	}

}
