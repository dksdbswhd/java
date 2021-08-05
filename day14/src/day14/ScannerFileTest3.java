package day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

//student2.txt 파일을 읽어와서 StringTokenizer 객체를 한번만 생성해서 ArrayList로 만듭시다.
public class ScannerFileTest3 {

	public static void main(String[] args) {
		List<Student> stus = new ArrayList<>();
		//사용할 파일 객체 생성
		String fname = "C:\\Users\\admin\\Desktop\\student2.txt";
		File file = new File(fname);
		
		try {
			Scanner fsc = new Scanner(file);    //지정된 File 객체에서 문자열을 읽어옵니다.
			
			//hasNext() - Iterator 반복자 인터페이스 추상메소드. 토큰은 데이터 단위.반복자는 다음 토큰을 접근하는 메소드
				
				//student.txt에서 읽어온 한 줄로 Student객체를 생성하고 list에 추가합시다.
				StringTokenizer stk=new StringTokenizer(fsc.nextLine());    //temp는 분리할 대상 문자열. 분리 기준 문자열 기본값은 "공백"
				Student s=null;
				while(stk.hasMoreTokens()) {  
				//	System.out.println(stk.nextToken());
					s = new Student(stk.nextToken(), 
								Integer.parseInt(stk.nextToken()),
								Integer.parseInt(stk.nextToken()),
								Integer.parseInt(stk.nextToken()));
				//?
					stus.add(s);
				}
			
			System.out.println(stus);  //확인!!
			fsc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
