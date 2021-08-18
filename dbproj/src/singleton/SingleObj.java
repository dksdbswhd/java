package singleton;

//이 클래스는 객체를 only 1개만 생성해서 공유하도록 생성자와 메소드를 수정합니다.
public class SingleObj {
//싱글톤 과 static 이 비슷한데요? 싱글톤은 일반적인 클래스의 성격(객체인스턴스 생성하고 오버라이드...)을 갖고 있다.
//프로그램 실행시 클래스가 먼저 메모리에 로드됩니다.클래스와 static 저장되는 영역은 이름이 메소드라고 부릅니다. 
//                      ㄴ 객체(사본,인스턴스)가 만들어지는 원본(클래스)이 실행시에 가장 먼저 메모리에 로드된다.
//객체가 저장되는 메모리 영역은 heap
//	
	private static SingleObj obj = new SingleObj();    //1)obj 타입은 자기자신 클래스 타입 & 객체 생성하여 대입
													//  --> 이른 초기화
	private SingleObj() {
		//2) 생성자 private :  다른 클래스에서 new SingleObj() 할 수 없습니다.
	}
	
	public static SingleObj getInstance() {   //3) getXXXX() 메소드 정의 : 자기 자신 타입 객체를 리턴합니다.
		return obj;							  //항상 똑같은 객체를 리턴합니다.
	}
	
	public void print() {
		System.out.println("싱글톤 객체로 연습 중 입니다.");
	}
	
}
