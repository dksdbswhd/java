package com.jcp.day10;

import java.util.ArrayList;
import java.util.Collections;

//ArrayList 활용한 45개중 6개 랜덤 뽑기 : 확률을 1/45 -> 1/44 -> 1/43.... 로 변경하도록 구현합니다.
public class LottoFinal {

	public static void main(String[] args) {
		
		ArrayList<Integer> lotto = new ArrayList<>();   //뽑힌 공 저장할 배열
		ArrayList<Integer> balls = new ArrayList<>();   //공 45에 대한 리스트
		for(int i=1;i<=45;i++)
			balls.add(i);		//리스트에 i값 1부터 45까지 정수값 저장
		
		//확인
		System.out.println(balls);
		int j;
		int cnt=45;
		//6번 랜덤값 뽑기
		for(int i=0;i<6;i++) {
			double temp = Math.random()*cnt--;   //랜덤값을 뽑아서 리스트의 인덱스로 사용합니다.
			//인덱스값의 범위는 0~n : n이 44,43,42,41,40,39 에 대해서 실행됩니다.(n은 마지막 인덱스값)
			j=(int)Math.round(temp-0.5);    //랜덤값의 범위
			
			int t = balls.get(j);		//랜덤값 인덱스로 balls 리스트에서 값 가져오기
			lotto.add(t);
			//balls 리스트에서 뽑힌 인덱스 삭제하기
			balls.remove(j);
			System.out.println("뽑은 공번호 : " + lotto);
			System.out.println("현재 남은 공번호들 : " + balls);
		//	cnt--;
		}
		
		System.out.println(":::최종 번호:::");
		lotto.sort(null);   //리스트가 오름차순으로 바뀝니다.
		System.out.println(lotto);
		
		Collections.reverse(lotto);   //내림차순
		System.out.println(lotto);
	}

}



