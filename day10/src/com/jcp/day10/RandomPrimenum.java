package com.jcp.day10;

import java.util.Arrays;
import java.util.Random;

public class RandomPrimenum {

	public static void main(String[] args) {
		
		long startTime = System.nanoTime(); //System.currentTimeMillis();  //실행시작시간.시간을 ms 0.001초 단위로 표현
		
		int[] datas = new int[20];
		int[] primenums = new int[20];		//소수여부 표시
		int cnt=0;
		while(cnt!=7) {   //의도 : 실행시간 재는 코드 테스트
			cnt=0;
			
			for (int i=0;i<20;i++)  {   //난수 생성
				datas[i]=(int)(Math.random()*89 + 11 - 0.5);
			}
			
			System.out.print(Arrays.toString(datas));   //배열 20개 값 확인 출력
			
			for(int i=0;i<datas.length;i++) {    //소수 검사
			
				boolean result=true;		//***여기서 초기화
				for (int k=2;k<=datas[i]/2;k++) {
					if(datas[i] % k ==0) {
						result=false; break;	
					}	
				}	
				
				if(result) {  cnt++; primenums[i]=1; }  //소수이면 cnt증가, 배열에 표시 1
				else primenums[i]=0;
			} //배열 20개 값 검사 끝
			
			System.out.println( ":::" + cnt);			//소수 갯수 확인 출력
		}//while 끝
		
		//while 종료 . 배열의 소수갯수가 7개일 때
		for (int i=0;i<datas.length;i++)
			System.out.println(datas[i] + "\t" + primenums[i]);
			
		long endTime = System.nanoTime();  //System.currentTimeMillis();		//현재 실행 종료 시간
		System.out.println("실행시간 : " + (endTime-startTime)/1000  +" us 소요되었습니다.");
	}  //ms : 0.001초  ,  us : 0.000001초  , ns : 0.000000001초 

}
