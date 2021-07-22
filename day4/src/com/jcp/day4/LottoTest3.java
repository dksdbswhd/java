package com.jcp.day4;

public class LottoTest3 {   //step 3
	
	public static void main(String[] args) {
		// TODO : 1~45 사이의 정수값 6개 배열에 저장하기 (랜덤값 중복검사하기)
		//int[] lotto = new int[6];
		int[] lotto = {34,13,24,9,13,45};
		for(int i=0;i<6;i++) {
			//double temp = Math.random()*45 +1; 
			//배열 인덱스 i 로 랜덤값 저장하기
			//lotto[i]=(int)Math.round(temp-0.5);
	
			//중복된 값은 출력 안하기
			int j;
			for(j=0;j<i;j++) {    //i가 4이라고 하면 j는 0,1,2,3 :lotto[4]와 그앞의 값비교  
				if(lotto[i]==lotto[j])  //현재 인덱스 i와 같은값이 배열에 있는지 검사
					      break;
			}
	//중복값이 있어서  for를 종료할떄 j의 값과  (i와 j의 값이 다르다.) 
	//중복값이 없는 상태로 for를 종료할때 j의 값을 활용  (i와 j의 값이 같다.)
			if(i==j)
			     System.out.println(lotto[i] + "\t");
			
		}
	}

}
