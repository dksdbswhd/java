package day13.test;

import java.util.Scanner;

public class MySolution1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//StringBuilder sb = new StringBuilder();
		StringBuilder sb = new StringBuilder("실행결과 ");
		System.out.print("정수 1개 입력  >>> ");
		int num = sc.nextInt();
		
		int result;
		int sum =0;
		do {
	// while(num!=0) {		
			 result=num%10;
			 sum += result;
			 num /= 10;
			 sb.append(result);
			 if (num==0) sb.append("="); else sb.append("+");
		}while(num!=0);
	//}	
		sb.append(sum);
		System.out.println(sb);
		//System.out.println("실행결과  " + sb + sum);
		 
		sc.close();
		
	}
}




