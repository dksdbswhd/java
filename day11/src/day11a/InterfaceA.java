package day11a;

//인터페이스 형식 알아보는 연습 
public interface InterfaceA {
	//생성자는 없습니다. -> 직접 객체를 생성하지 않습니다.
	//필드는 상수만 가능합니다. public static final 생략함. 
	int SIZE = 100;
	
	
//메소드는  *1)추상메소드(public abstract 생략함.) 선언
//     ,2)인스턴스(default)메소드와 3)static메소드는 정의하며  
//	3가지 모두 가능합니다.
	
	//1)추상 메소드
	void methodA();
	int methodB(int num);
	
//2) default 키워드는 default 한정자 의미가 아니고 인스턴스 메소드 의미
	default void methodC(String message) {
		System.out.println("메시지 수신 : " + message);
	}
	
	//3)
	static void medthodD() {
		System.out.println("나는 static 메소드입니다.");
	}
	
}
