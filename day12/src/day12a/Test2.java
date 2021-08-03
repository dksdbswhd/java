package day12a;

public class Test2 {
	
	InterfaceA ifa;			//필드 타입으로 인터페이스 사용합니다.
	InterfaceA[] ifas = new InterfaceA[10];   
	//참조값 저장할 배열 크기를 선언합니다. 인터페이스 타입으로 사용합니다.
	
	void test() {
		ifas[0] = new MyClassA();		//배열 인덱스 0번에 구현 클래스 객체를 참조 시킵니다.
	}

}
