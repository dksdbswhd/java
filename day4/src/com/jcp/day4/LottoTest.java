package com.jcp.day4;

public class LottoTest {
	//step1
	public static void main(String[] args) {
		// TODO : 1~45 사이의 정수값 6개 출력하기 (중복 무시)
		for(int i=0;i<6;i++) {
			double temp = Math.random()*45 +1; 
			System.out.println("temp=" + temp);
			System.out.println("int temp1=" + Math.round(temp));
			
			//버림.
			System.out.println("int temp2(버림)=" 
						+ Math.round(temp-0.5));
		}

	}

}
