package exam;

import java.util.Scanner;

public class AddQuizTest {
	static final int COUNT = 5;
	
	public static void main(String[] args) {
		// AddQuiz 를 테스트 해봅니다.
		Scanner sc = new Scanner(System.in);
		AddQuiz[] quiz = new AddQuiz[COUNT];    //AddQuiz 객체가 아직 생성안됬습니다.배열은 참조값 저장합니다.
		int cnt = 0;	//맞은 갯수 카운트하면서 저장
		
		//문제를 내봅시다. 정수값 범위  11~99
		//System.out.println((int)(Math.random()*89) +11);
		System.out.println("덧셈  10문제 퀴즈를 시작합니다.");
		for(int i=0;i<quiz.length;i++) {

			quiz[i]	= new AddQuiz();		//AddQuiz객체를 생성하여 배열의 i 인덱스가 참조하도록 합니다.
			quiz[i].data1 = (int)(Math.random()*89) +11;
			quiz[i].data2 = (int)(Math.random()*89) +11;

			System.out.println((i+1) +"번. " + quiz[i].data1 + "+" 
										    + quiz[i].data2 +"= ?" );
			System.out.print("답 입력하세요. >>> ");
			quiz[i].userAns = sc.nextInt();
			//정답이면 cnt 증가
			if(quiz[i].makeResult()) cnt++;
		}	

		System.out.println(":::::: 채점 하고 있습니다. ::::::");
		System.out.println("\t문제\t\t제출한답\t정답\t채점");
		for(int i=0;i<quiz.length;i++) {
			System.out.println((i+1) +"번. \t" + quiz[i].data1 + "+" + quiz[i].data2 +"\t\t" 
					+ quiz[i].userAns + "\t" + (quiz[i].data1 + quiz[i].data2) + "\t"
					+ quiz[i].resultPrint());
			
		}
		System.out.println("\n:::맞은 갯수 " + cnt + " 입니다.:::");
	}

}
/*
 * 기능적으로 추가로 개선할 수 있는 내용
 * 1. 랜덤값의 범위 예를 들면 11, 99를 커스텀생성자에서 인자로 전달받아
 *    생성자에서 Math.random 실행하고 data1,data2를 초기화한다.  
 * 2. 연산종류를 +, -, * , / 선택할수 있고
 *    AddQuiz 클래스를 OpQuiz 로 변경해서 연산결과 메소드 추가한거나
 *    또는 기존의 makeResult 메소드에 switch 문으로 구현한다.
 * 3. 랜덤값은 중복된 문제 만들수 있습니다. 중복문제 처리 필요.
 * 
 *    등등 실제 사용할 수 있는 프로그램으로 만들수 있습니다.
 */










