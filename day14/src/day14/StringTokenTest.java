package day14;

import java.util.StringTokenizer;

public class StringTokenTest {

	public static void main(String[] args) {
		String temp ="모모 90 88 79";        //하나의 문자열로 된 데이터를 분리. Student 객체 또는 각각 변수에 저장.

		//방법2)
		StringTokenizer stk=new StringTokenizer(temp);    //temp는 분리할 대상 문자열. 분리 기준 문자열 기본값은 "공백"
		System.out.println("::::::방법(2)::::::::");
		Student s=null;
		while(stk.hasMoreTokens()) {  
		//	System.out.println(stk.nextToken());
			s = new Student(stk.nextToken(), 
						Integer.parseInt(stk.nextToken()),
						Integer.parseInt(stk.nextToken()),
						Integer.parseInt(stk.nextToken()));
		}
		System.out.println("Student 객체 확인1 : " + s);
		System.out.println("s 객체 이름 :" +s.getName());
		System.out.println("s 객체 점수 :" +s.getJumsu1() + "," + s.getJumsu2() + "," +s.getJumsu3());
		System.out.println("s 객체 점수 총점 :" +(s.getJumsu1()+s.getJumsu2()+s.getJumsu3()));
		System.out.println("-----------");
//			System.out.println(stk.nextToken());   //Exception - NoSuchElement
/*		while(stk.hasMoreTokens()) {
			System.out.println(stk.nextToken());
		}
*/			
		Student	s2=null;
		while(stk.hasMoreTokens()) {    //false
			//	System.out.println(stk.nextToken());
			 s2= new Student(stk.nextToken(), 
							Integer.parseInt(stk.nextToken()),
							Integer.parseInt(stk.nextToken()),
							Integer.parseInt(stk.nextToken()));
		}
		System.out.println("Student 객체 확인2 : " + s2);   //null
		System.out.println("s2 객체 이름 : " + s2.getName()); //null객체로 메소드 실행 : NullPointer
		
		System.out.println("::::::방법(1)::::::::");
		//방법1) String 클래스 split 메소드를 이용합니다. -> 분리 기준 문자열에 따라 -> 데이터를 분리한 결과 String 배열로 리턴.
		temp ="모모,,,90,,,88,,,79";
		String[] datas = temp.split(",,,");
		System.out.println(datas[0]);
		System.out.println(datas[1]);
		System.out.println(datas[2]);
		System.out.println(datas[3]);
		//3개의 데이터에 대한 총점? 
		System.out.println("총점 : " +(datas[1]+datas[2]+datas[3]));   //908879
		
		//문자열데이터 -> int 로 변환한다.
		int sum = Integer.parseInt(datas[1]);
		sum += Integer.parseInt(datas[2]);
		sum += Integer.parseInt(datas[3]);
		System.out.println("총점 : " + sum);
		
		//sc.nextInt -> sc.nextLine 실행 순서  문제를  해결 : 무조건 sc.nextLine으로 필요하다면 parseXXXX(데이터타입)
		//  parseInt 메소드 실행할 때 인자 데이터가 문자가 포함되어있다면 NumberFormatException 이 발생합니다.
		
	}

}
