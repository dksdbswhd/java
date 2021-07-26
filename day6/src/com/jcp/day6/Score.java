package com.jcp.day6;

public class Score {
	
	//1.필드정의 (선언)
	String name;    //이름
	int kor;		//국어
	int eng;		//영어
	int math;		//수학
	
	
	//2.메소드 정의
/*
sum(인자없음) : 리턴 타입 int, 3과목 필드의 총점구하기  (kor+eng+math 구해서 리턴)
avg(인자없음) : 리턴 타입 double, 3과목 필드의 평균구하기    sum()/3 리턴, 단 double 값으로
grade(int score) : 리턴 타입 char, 
		    ㄴ score이  90점 이상 'A' 80점~89 'B' 70~79점 'C' 그외 'D'
print(인자없음) : 리턴타입 void, 다음과 같은 예로 출력합니다. -  System.out.printf() 로 하세요.
          홍길동  - 92(A)  88(B)  64(D)  합계=244  평균=81.33 	
*/
	int sum() {
		int result;
		result=kor+eng+math;
		System.out.println("**");
		return result;
		
		//return kor+eng+math;
	}
	
	double avg() {
		//sum() 같은 클래스 안의 다른 메소드를 실행함.
		return (double)sum()/3;       //(double)this.sum()/3;  //this생략가능
	}

	char grade(int score) {
		char result;
		if(score>=90) result='A';
		else if(score>=80) result='B';
		else if(score>=70) result='C';
		else result='D';
		return result;
	}
	
	void print() {
		System.out.printf("%s - %3d(%c)  %3d(%c)  %3d(%c)  합계=%3d  평균=%.2f\n",
				name,kor,grade(kor),eng,grade(eng)
				,math,grade(math),sum(),avg());
	
	
	}  //  %3d 또는 %10.2f  출력 자리수 설정.
	
	
	
}
