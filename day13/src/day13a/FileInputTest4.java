package day13a;

import java.io.FileInputStream;
import java.io.IOException;

//표준입출력 반복문으로 테스트합니다.
//파일시스템(바탕화면 prob1.txt) -> 프로그램 -> 표준출력
public class FileInputTest4 {

	public static void main(String[] args) {

		int b;
		System.out.println("파일에서 입력받은 내용을 출력합니다......");
		try {   
			int count=0;
			FileInputStream fis = new FileInputStream("C:\\Users\\admin\\Desktop\\prob1.txt");
			//prob1.txt 파일이 바탕화면에 없으면 FileNotFoundException 발생합니다.
			while((b=fis.read())!=-1) {  //입력스트림을 파일로 변경합니다.
				count++;  
			
				System.out.write(b);   //문자기반의 메소드로 출력
			}
			System.out.println(":::" + count + " 바이트 입력! :::");
			fis.close();
			
		} catch (IOException e) {
			System.out.println("입력 오류 : " + e.getMessage());
			e.printStackTrace();   //오류내용 추적하여 출력
		}		
		
	
		
	}

}
