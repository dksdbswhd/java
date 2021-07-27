package com.jcp.day7;

import java.util.Arrays;

//모두 완성되면 제출하세요.
//작성자 : 김소희
public class Student {
	//필드
	String name;   //학생 이름
	int[] scores;   //배열의 크기는 동적입니다.
	
	//기본생성자
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	//커스텀 생성자 : 2개 필드 초기화
	public Student(String name, int[] scores) {
		this.name=name;
		this.scores=scores;
	}
	
	int sum() {
		int result=0;
		//scores 배열의 합계 구하기
		for(int i=0;i<scores.length;i++)
			result+=scores[i];
		return result;
	}
	
	void print() {
		System.out.println("name : " + name + ",scores :" +
					Arrays.toString(scores));
		//수정할 예정  : 점수(학점) 표시
	}
	
	char grade(int score) {
		char result;
		if(score>=90) result='A';
		else if(score>=80) result='B';
		else if(score>=70) result='C';
		else result='D';
		return result;
	}
	
	
	
}
