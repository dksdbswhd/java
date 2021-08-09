package day15.mydict1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

//메소드 생성 연습 : 파일에서 읽어오기(파일명 인자)-> mydicts 리스트에 저장, 파일에 저장하기(파일명 인자), 단어추가하기, 단어전체보기
public class MyDictApp_ListTest {
	static Scanner sc = new Scanner(System.in);
	static List<Word> mydicts = new ArrayList<>();   //단어장 역할을 하는 컬렉션(List)입니다.
	public static void main(String[] args) {
		
		String filename ="C:\\Users\\admin\\Desktop\\listDict.txt";		//사용자가 선택할수 있는 내용-> main메소드에서 합니다.
		boolean flag=true;
		try {
			dictRead(filename);	//지정된 파일에 저장된 데이터 읽어와서 mydicts 리스트에 저장하기
		}catch(FileNotFoundException e) { System.out.println(filename + " 파일이 존재하지 않습니다."); }
		
		while(flag) {
			System.out.println("-------------------------------------------------------------- ");
			System.out.println("1.새로운 단어 추가     2.저장된 단어 전체보기     3.파일에 저장    4.프로그램 종료     ");
			System.out.println("-------------------------------------------------------------- ");
			System.out.print("선택 : ");
			String sel = sc.nextLine();   //***Integer.parseInt(sc.nextLine()) 메소드 사용해서 int 처리할수 있습니다.
			
			switch(sel) {   //if로 한다면 sel이 String이므로 equals메소드로 비교합니다.
				case "1":	//switch문에서 case 에 문자열 비교 가능합니다.
					wordAdd();    //리턴값,인자가 없는 메소드
					break;
				case "2":
					wordList();
					break;
				case "3":
					try {
						dictSave(filename);		//dictSave메소드가 익셉션을 떠넘긴것을 처리합니다.
					}catch(FileNotFoundException e) { System.out.println("선택한 폴더위치가 잘못되었습니다."); }
					break;
				case "4":
					System.out.println("프로그램 종료 선택했습니다.");
					flag=false;
					break;
				default:
					break;
			} //switch end		
					
			
		}//while end
		System.out.println("프로그램 종료합니다.");	
	}//main end		
	
	//filename 에 저장된 데이터를 mydicts 리스트로 저장하기.
	private static void dictRead(String filename) throws FileNotFoundException {
		Scanner fsc=null;   //파일입력 객체 참조 변수
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		File file = new File(filename);   //파일이 없으면 익셉션 처리
		fsc = new Scanner(file);
		while(fsc.hasNextLine()) {
			sb.append(fsc.nextLine()).append("*");
		}	
/*		
		System.out.println("---파일입력결과---");
		System.out.println(sb);  //확인용 출력
		System.out.println("---------------");
*/		
		st= new StringTokenizer(sb.toString(),"*");
		List<String> kor;
		while(st.hasMoreTokens()) {
			Word w = new Word(st.nextToken());   //첫번째 읽은 토큰은 english 필드값 초기화에 사용합니다.
			String temp=st.nextToken();			//koreans필드값 -> List<String> 타입 객체로 변환해야 합니다.
			System.out.println("--토큰스트링--" + temp + "----");
			temp=temp.substring(1, temp.length()-1);   //[공허한, 빈] ==> 공허한, 빈 => 배열로 변환 split(분리기준) 메소드
			//kor = Arrays.asList(temp.split(", "));     //split 메소드로 분리된 문자열 배열을 리스트 객체로 생성합니다.(고정길이)
			kor = new ArrayList<String>(Arrays.asList(temp.split(", ")));  //가변길이 리스트로 생서합니다.
			w.setKoreans(kor);
			System.out.println("--리스트--" + kor + "----");
			mydicts.add(w);					//리스트에 Word 객체 추가합니다.
		}
		fsc.close();
	}
	

	//mydicts 리스트를 filename 인자값 파일로 저장합니다.- 익셉션 처리 방법1)
	private static void dictSave_(String filename) {
		PrintWriter fpw = null;
		
		try {
			fpw = new PrintWriter(filename);   //filename 이 존재하지 않으면 ? 파일을 만들어 준다.
			//파일 출력 print
			fpw.println(mydicts.get(0));   //mydicts.get(0).toString() 리턴값은 문자열입니다.
			fpw.println(mydicts.get(1));
			fpw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
//mydicts 리스트를 filename 인자값 파일로 저장합니다.- 익셉션 처리 방법2) 현재 메소드에서 익셉션 처리 안하고 호출한 main 메소드로 처리를 떠넘긴다.
	private static void dictSave(String filename) throws FileNotFoundException {
		
		PrintWriter fpw = new PrintWriter(filename);   //filename 이 존재하지 않으면 ? 파일을 만들어 준다.
		for(Word w: mydicts)	//mydicts.get(i) 동작을 알아서 하고 w로 참조합니다.
			fpw.println(w);
			
		fpw.close();
	}
	

	//mydicts 모두 보기
	private static void wordList() {
		for (Word w : mydicts)
			System.out.println(w);
	}

	//단어 추가 메소드
	private static void wordAdd() {
		System.out.println("[새로운 단어 추가] 입니다.");
		do {
			System.out.print("English : ");		String eng = sc.nextLine().trim();   //입력받고 양끝 공백제거
			System.out.print("우리말 뜻 : "); 		String kor = sc.nextLine().trim();
			
			//지금 입력된 eng 단어가 mydicts 리스트 있는지?
			int index = -1;
			for(int i=0;i<mydicts.size();i++) {
				//인덱스 i번째 Word 객체 가져오기
				Word w = mydicts.get(i);
				if(w.getEnglish().equals(eng)) {  //w객체의 english 필드 값을 eng와 비교
					index = i;
					break;
				}	
			}
			
			List<String> koreans;
			if(index==-1) {		// //mydicts에 지금 입력된 eng 가 이미 있는지 검사
				koreans = new ArrayList<>();  //없을때
				koreans.add(kor);
				mydicts.add(new Word(eng,koreans));   //mydicts 리스트에 Word 객체 추가 - 필드값 eng, kor
			}else {  //있을때 : mydicts 리스트에서 index 위치의 Word 객체를 가져와서 koreans필드에 kor 추가
				Word w = mydicts.get(index);
				koreans = w.getKoreans();   //Word 객체의 현재 저장된 한글 뜻(List 타입 참조값) 가져오기
				koreans.add(kor);
				
				//mydicts.get(index).getKoreans().add(kor);
			}
			//mydicts에 지금 입력된 eng 가 이미 있을 수 있습니다. -> 지금 입력된 내용은 새로운 뜻으로 추가되게 합니다.
			System.out.print("단어 추가 계속 하시겠습니까?(y/n) >>> ");
		}while(sc.nextLine().toLowerCase().equals("y"));   //sc.nextLine() 리턴 String 타입  
			//사용자 입력이 Y 또는 y 이면 계속 반복합니다.
	}//wordAdd end
	
}






