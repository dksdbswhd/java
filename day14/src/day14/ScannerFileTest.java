package day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerFileTest {

	public static void main(String[] args) {
		
		//사용할 파일 객체 생성
		String fname = "C:\\Users\\admin\\Desktop\\프린트테스트.txt";
		File file = new File(fname);
		
		try {
			Scanner fsc = new Scanner(file);    //지정된 File 객체에서 문자열을 읽어옵니다.
			
			System.out.println(fsc.nextLine());   //라인(줄) 단위로 읽어 옵니다.
			System.out.println(fsc.nextLine());   //라인(줄) 단위로 읽어 옵니다.
			
			//hasNext() - Iterator 반복자 인터페이스 추상메소드. 토큰은 데이터 단위.반복자는 다음 토큰을 접근하는 메소드
			while(fsc.hasNext()) {	//읽어올 다음 데이터가 있는지 검사 - 위에 2개 라인 읽고 데이터가 더 있으면 출력합니다.
				System.out.println(fsc.nextLine());
				
				
			}
			
			fsc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
