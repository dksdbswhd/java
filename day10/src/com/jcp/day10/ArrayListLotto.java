package com.jcp.day10;

public class ArrayListLotto {   //step 4 - 작성자 : 김소희  -> 요렇게 해서 제출해주세요.
	public static void main(String[] args) {
// TODO : 1~45 사이의 정수값을 랜덤으로 6개를 배열에 저장한다. 단, 중복된 값은 허용하지 않는다.
	
		int[] lotto = new int[6];  //--> ArrayList 로 바꾸기
		int test,j;
		for(int i=0;i<6;i++) {

			do {		
				double temp = Math.random()*45 +1;   //배열 인덱스 i에 저장할 랜덤값
				test=(int)Math.round(temp-0.5);
		
				//중복된 값은 출력 안하기
				for(j=0;j<i;j++) {    //i가 4이라고 하면 j는 0,1,2,3 :lotto[4]와 그앞의 값비교  
					if(test==lotto[j]) {  //test와 같은값이 배열에 있는지 검사
						System.out.print("*");
						break;		//test는 배열에 저장 안합니다.다시 random 실행.
					}	      
				}//for j - end
				
		//중복값이 없는 상태로 for를 종료할때 j의 값을 활용  (i와 j의 값이 같다.)
			}while(i!=j);   //중복된 값이 있을 때 다시 random 만든다.
			
			lotto[i]=test;    //i==j 일때 실행
			
		}//for i - end
		
		//배열 값 출력할 for문을 작성해서 확인하세요.
		for(int i=0;i<lotto.length;i++)
			System.out.print(lotto[i]+"\t");
	}

}
