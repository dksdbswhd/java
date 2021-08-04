package day13a;

import java.io.IOException;

//표준입출력 간단하게 테스트합니다.
public class StandartIOTest {

	public static void main(String[] args) {

		int b;
		System.out.println("저장할 내용을 입력하세요. ↓");
		
		try {   //예시 - a 입력하고 enter 입력하면
			b=System.in.read();    //a
			//입력한 문자(아스키코드값)를 정수로 리턴합니다.
			//입력스트림에서 읽어올것 없으면 -1 리턴합니다.
			//read메소드는 Exception 가능성이 있으므로 try ~ catch 필요합니다.
			System.out.println(b);
			
			//엔터는 아스키코드 13+ 10의 결합   \\r\\n
			b=System.in.read();		//13
			System.out.println(b);

			b=System.in.read();		//10
			System.out.println(b);
			
			
		} catch (IOException e) {
			System.out.println("입력 오류 : " + e.getMessage());
			e.printStackTrace();   //오류내용 추적하여 출력
		}		
		
	
		
	}

}
