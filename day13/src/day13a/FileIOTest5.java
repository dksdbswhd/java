package day13a;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

//표준입출력 반복문으로 테스트합니다.
//파일시스템(바탕화면 이미지파일) -> 프로그램 -> 파일시스템 출력(다운로드경로에 복사)
public class FileIOTest5 {

	public static void main(String[] args) {
		System.out.println("작성자 : 김소희- 실행시간 테스트 합니다.");
		int b;
		long start = System.currentTimeMillis();
		long end;
		//프로그램에서 입출력 크기를 1바이트 단위에서 임의의 크기(버퍼사용)로 수정해봅시다.
		byte[] buf = new byte[1024];
		try {   
			System.out.println("바탕화면에 hoya.jpg 파일을 다운로드 경로로 [[바이트단위로]]복사합니다.......");
			int count=0;
			FileInputStream fis = new FileInputStream("C:\\Users\\admin\\Desktop\\hoya.jpg");  //파일소스(입력)
			FileOutputStream fos = new FileOutputStream("C:\\Users\\admin\\Downloads\\hoya.jpg");  //파일출력

			while((b=fis.read())!=-1) {  //입력스트림을 파일로 변경합니다.
			//while((b=fis.read(buf))!=-1) {   //buf 크기만큼 읽어옵니다. 위의 코드와 실행시간 비교해보세요.
				count++;  
			
				fos.write(b);   //문자기반의 메소드로 콘솔 출력
			//fos.write(buf,0,b);  	
			}
			System.out.println(":::" + count + " 바이트 복사되었습니다.! :::");
			System.out.println("바탕화면에 hoya.jpg 파일을 다운로드 경로로 [[바이트단위로]]복사 완료!!!.......");	
			
			end = System.currentTimeMillis();
			System.out.println("실행 시간 : " + (end-start) + " ms 소요되었습니다.\n\n");
			fos.close(); fis.close(); 		//사용하던 모든 파일을 닫기
			
			System.out.println("바탕화면에 hoya.jpg 파일을 다운로드 경로로 [[1024바이트 buf 크기단위로]]복사합니다.......");
			count=0;
			fis = new FileInputStream("C:\\Users\\admin\\Desktop\\hoya.jpg");    //다시 객체 생성하기
			String filename;
			//filename 변수 사용자 입력
			Scanner sc = new Scanner(System.in);
			System.out.print("경로명 입력 >>> ");
			filename = sc.nextLine();
			System.out.print("파일명 입력 >>> ");
			filename = filename + "\\" + sc.nextLine();
			fos = new FileOutputStream(filename);
			
			start=System.currentTimeMillis();    //새로운 start 시간 저장
			while((b=fis.read(buf))!= -1) {   
				//read메소드는 읽어온 바이트 크기를 return 합니다.-마지막 실행때는 1024보다 작거나 같습니다.
				count+=b;
				fos.write(buf, 0, b);   //buf 배열의 0번 인덱스부터 읽어온 크기 b 만큼 fos 파일에 출력합니다.
	 		}
			System.out.println(":::" + count + " 바이트 복사되었습니다.! :::");
			System.out.println("바탕화면에 hoya.jpg 파일을 다운로드 경로로 [[1024바이트 buf 크기단위로]]복사 완료!!!.......");	
			end = System.currentTimeMillis(); //새로운 end 시간 저장
			System.out.println("실행 시간 : " + (end-start) + " ms 소요되었습니다.\n\n");   //1024 바이트 단위 입출력 시간
		
			fos.close();
			fis.close();    
			
		}catch (FileNotFoundException e) {  //자식(하위) 타입을 먼저 검사해야 합니다.순서가 바뀌면 컴파일오류 발생
			System.out.println("선택한 파일과 경로명이 잘못되었습니다." + e.getMessage());
		}catch (IOException e) {  //IOException 의 하위클래스를 모두 처리할수 있습니다.
			System.out.println("입력 오류 : " + e.getMessage());
			e.printStackTrace();   //오류내용 추적하여 출력
		} 
		
	}

}





