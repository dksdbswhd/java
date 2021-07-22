package com.jcp.day4;

public class LottoTest2 {
	//step 2
	public static void main(String[] args) {
		// TODO : 1~45 사이의 정수값 6개 배열에 저장하기 (중복 무시)
		int[] lotto = new int[6];
		
		for(int i=0;i<6;i++) {
			double temp = Math.random()*45 +1; 
			//배열 인덱스 i 로 랜덤값 저장하기
			lotto[i]=(int)Math.round(temp-0.5);
		}
		
		//생성된 6개 랜덤값 출력하기
		System.out.println("--- 생성된 6개 랜덤값(난수) 출력");
		for(int i=0;i<6;i++)
			System.out.print(lotto[i] + "\t");
	}

}
