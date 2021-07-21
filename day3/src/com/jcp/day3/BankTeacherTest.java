package com.jcp.day3;

import java.util.Scanner;

public class BankTeacherTest {

	public static void main(String[] args) {
	//연습문제 : 가상은행의 예금/출금/잔고조회 실행
		Scanner sc = new Scanner(System.in);
		boolean run=true;     //반복을 제어할 변수
		int sel;    //선택 사항 저장
		int balance=0;	//잔고

		
		while(run) {   //초기값은 참
			int money;    //while문에서만 사용할 변수
			System.out.println("------------------------------");
			System.out.println("  1:예금 | 2:출금 | 3:잔액 | 4:종료");
			System.out.println("------------------------------");
			System.out.print("메뉴 선택 >>> ");
			sel = sc.nextInt();
			
			switch(sel) {
				case 1:   //예금 처리(예금금액입력->잔액에 더하기)
					System.out.print("예금액 >");
					money = sc.nextInt();
					balance +=money;   //balance=balance+money;
					//잔고출력
					System.out.println("고객님의 잔액은" + balance + "원입니다");
					break;
				case 2:   //출금 처리(출금금액입력->잔액에 빼기)
					System.out.print("출금액 >");
					money = sc.nextInt();
					if(money>balance)
						System.out.println("잔고가 부족합니다.출금할수 없습니다.");
					else 
						balance -= money;
					//잔고 출력
					System.out.println("고객님의 잔액은" + balance + "원입니다");
					break;
				case 3:   //잔고(balance) 출력
					System.out.print("현재 잔고 : " + balance);
					System.out.println();   //줄바꿈
					break;
				case 4:   //반복 종료
					System.out.println("프로그램을 종료합니다.");
					run = false;   //while(조건식)을 거짓으로 함.
					break;
				default:  //1,2,3,4 외 나머지 값일 때
					System.out.println("잘못된 선택입니다.값은 1~4 만 입력하세요.");
				
			}
			//while 반복실행부분의 끝
		}
		
		

	}

}
