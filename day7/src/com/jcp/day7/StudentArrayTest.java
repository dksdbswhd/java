package com.jcp.day7;

import java.util.Scanner;

//Student 클래스 배열을 연습합니다.
public class StudentArrayTest {
	static final int SIZE =3;
	public static void main(String[] args) {
		
		//5명의 학생을 처리할 수 있는 배열.
		//stus 배열의 인덱스에 저장된값은 Student 객체를 참조하는 값이다.
		Student[] stus = new Student[5];
		
		stus[0] = new Student("사나", new int[] {78,56,98});
		stus[1] = new Student("다현", new int[] {68,76,83});
		stus[2] = new Student("모모", new int[] {78,56,98});
		stus[3] = new Student("미나", new int[] {85,91,67});
		stus[4] = new Student("정연", new int[] {88,77,66});
		
		for(int i=0;i<stus.length;i++)
			stus[i].print();   //***stus[i] 는 Student 객체의 참조값
		
		System.out.println("::총점 230점 이상 학생 출력1:: ");
		//배열에 저장된 학생 중에 총점이 230 이상인 학생만 출력(이름,총점,평균)하기
		for(int i=0;i<stus.length;i++) {
			if(stus[i].sum() >= 230)
				System.out.printf("%s - 총점 : %3d  평균 : %6.2f\n",
						stus[i].name,stus[i].sum(),(double)stus[i].sum()/SIZE);
		}
		System.out.println("::총점 230점 이상 학생 출력2:: ");
		//향상된 for문 (또는 빠른 for문, foreach) 를 사용합니다.
		for(Student s : stus) {		
			//인덱스 변수 i를 사용하는 대신에 stus 의 객체를 하나씩 변수 s가 참조하게 코딩 합니다.
			if(s.sum() >= 230)
				System.out.printf("%s - 총점 : %3d  평균 : %6.2f\n",
						s.name,s.sum(),(double)s.sum()/SIZE);
		}
		
		System.out.println("::학생이름 미나 찾아서 출력:: ");
		//이름이 "미나" 인 학생의 데이터 출력하기 : print() 메소드 사용.
		for(int i=0;i<stus.length;i++) {
			String temp = stus[i].name;
			if(temp.equals("미나"))
				stus[i].print();
		}
		
		//검색할 학생 이름 사용자 입력으로 코드 추가
		Scanner sc = new Scanner(System.in);
		String find="미나";
		System.out.print("검색할 학생 이름 입력하세요. >>>");
		find = sc.nextLine();
		//foreach 로 수정해보세요.
		for(Student s : stus) {   //stus 는 Student 클래스 타입 배열
			String temp = s.name;
			if(temp.equals(find)) {
					System.out.println("검색 결과 학생 이름 : " + s.name); 
					//이 실행 위치에서 find,temp,s.name 모두 같은 문자열 참조
					System.out.println("과목별 성적.......");
					for(int jumsu : s.scores) {   //s.scores 는 int 타입 배열
						//점수(학점)
						System.out.println( jumsu + "(" + s.grade(jumsu) +")");  //+ 는 문자열 연결
					}
			}//if end	
		}//for Student end
		
		sc.close();
	}

}








