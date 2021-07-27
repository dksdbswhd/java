package com.jcp.day7;

import java.util.Scanner;

public class StudentTest2 {   //함께해보는 테스트
	//과목수는 3개 과목
	static final int SIZE =3;
	
	//static은 메소드 안에서  사용하면 오류가 납니다.
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] scores = new int[SIZE];
		String name;
		//커스텀 생성자를 테스트 합니다.
		System.out.print("이름 입력 >>> ");
		name = sc.nextLine();
		
		for(int i=0;i<scores.length;i++) {
		System.out.print("과목 " + (i+1) + " 점수 입력 >>>  " );
		scores[i] = sc.nextInt();
			
		}
		//System.out.println(Arrays.toString(scores));
		
		//name,score는 반드시 초기화가 되어있어야 합니다. null 가능
		//새로운 객체 생성 - 초기값 인자가  변수
		Student sana 
			= new Student(name, scores);
		sana.print();
		
		//새로운 객체 생성 - 초기값 인자가  상수
		Student momo 
			= new Student("모모", new int[]{88,55,94});
		momo.print();
		
		sc.close();
	}//main end

}
