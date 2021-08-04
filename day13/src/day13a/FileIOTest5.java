package day13a;

import java.io.FileInputStream;
import java.io.IOException;

//표준입출력 반복문으로 테스트합니다.
//파일시스템(바탕화면 이미지파일) -> 프로그램 -> 파일시스템 출력(다운로드경로에 복사)
public class FileIOTest5 {

	public static void main(String[] args) {
		int b;
		System.out.println("바탕화면에 hoya.jpg 파일을 다운로드 경로로 복사합니다.......");
		try {   
			int count=0;
			FileInputStream fis = new FileInputStream("C:\\Users\\admin\\Desktop\\hoya.jpg");
			//prob1.txt 파일이 바탕화면에 없으면 FileNotFoundException 발생합니다.
			while((b=fis.read())!=-1) {  //입력스트림을 파일로 변경합니다.
				count++;  
			
				System.out.write(b);   //문자기반의 메소드로 출력
			}
			System.out.println(":::" + count + " 바이트 입력! :::");
			System.out.println("바탕화면에 hoya.jpg 파일을 다운로드 경로로 복사 완료!!!.......");	
			
			fis.close();    
			
		} catch (IOException e) {
			System.out.println("입력 오류 : " + e.getMessage());
			e.printStackTrace();   //오류내용 추적하여 출력
		}
	
		
	}

}
