package day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

//입출력 클래스들은 java.io 패키지에 있습니다.
//문자열을 라인 단위로 파일출력하는 println 을 테스트 합니다.(참고) 문자열 단위 파일입력 : Scanner
// -> 파일을 지정할때 , 문자열로 전달 못하고 File 클래스 객체로 전달합니다.
public class PrintWriterTest {
	
	public static void main(String[] args) {
		
		//사용할 파일 객체 생성
		String fname = "C:\\Users\\admin\\Desktop\\프린트테스트.txt";
		File file = new File(fname);
		
		try {
			PrintWriter fpw = new PrintWriter(file);   //File 객체로 출력할 파일 지정합니다.
			fpw.println("모모 90 88 79");
			fpw.println("사나 87 82 93");					//실제로는 반복형태로 코딩됩니다.예)ArrayList 크기만큼 반복
			fpw.close();
			System.out.println("파일 출력이 완료되었습니다.");
		} catch (FileNotFoundException e) {
			System.out.println("파일 경로명/파일명 확인하세요.");
			e.printStackTrace();
		}		
	
	}
	
}
