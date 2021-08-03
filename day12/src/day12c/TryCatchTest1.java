package day12c;

//Exception 처리를 테스트 합니다.
public class TryCatchTest1 {	
//형식 : try { 변수선언..... } catch() { .... }
	public static void main(String[] args) {

		String message = null;   //Exception 발생하는 경우
//		message = "hello";
		boolean result=false ;
		try {
			result = message.equals("hello");  //null객체가 equals 실행 못합니다.  
			
			//A 익셉션 가능성  --> 여기서 생기면 중단하고 catch
			//		       --> A 익셉션이 발생안하면 B에서 익셉션 발생할수 있습니다.
			//B 익셉션 가능성 --> 여기서 생기면 중단하고 catch
		
		}catch (Exception e) {   //Exception e 는 타입을 검사 -> 타입이 맞으면...
			//NullPointerException이 발생해서 NullPointerException 객체가 생성됩니다.-> 변수 e로 참조
			// Exception e : 모든 Exception 처리(모든 Exception의 부모클래스이기 때문입니다.)
			// NullPointerException e : NullPointerException 만 처리합니다.
			System.out.println("exception 이 발생했습니다. - " + e.getMessage());
													//e개체의 필드값 중 오류 메시지를 가져와 출력하기
//			e.printStackTrace();          //오류의 원인을 추적하고 출력
		}  //프로그램이 비정상적으로 중단되지 않고 끝까지 실행됩니다.
		
		if(message!=null && result)
			System.out.println("원하는 메시지 입니다.");
		else if(message!=null && !result)		//result 가 거짓일때 
			System.out.println("보고싶은 메시지가 아닙니다.");
		
		System.out.println("끝");
		
	}

}
