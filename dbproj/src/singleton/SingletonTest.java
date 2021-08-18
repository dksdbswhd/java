package singleton;

public class SingletonTest {

	public static void main(String[] args) {

		//SingleObj obj1 = new SingleObj();           //2)번 때문에 오류 : 지금까지 객체 생성했던 방법입니다.
		SingleObj obj1 = SingleObj.getInstance();		//싱글톤 객체 리턴합니다.
		
		obj1.print();     
	}

}
