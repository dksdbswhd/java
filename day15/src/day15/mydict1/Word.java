package day15.mydict1;

import java.util.List;

public class Word {
	private String english;
	private List<String> koreans;    //컬렉션(List 계열) 타입은 인터페이스로 선언합니다.
	
	//코딩하면서 커스텀 생성자 정의 합니다.
	public Word(String english) {
		this.english=english;
	}
	
	public Word(String english,List<String> koreans) {
		this.english=english;
		this.koreans=koreans;
	}
	
	//파일 저장형식 예 : static [정적인, 실행중에 변화가 없는] -> 한 줄씩(Word객체 하나씩) println
	@Override
	public String toString() {    //파일에 어떻게 저장할 것인가를 고려해서 재정의 합니다.
		// TODO Auto-generated method stub
		return english + "*" + koreans;  //List의 toString() 출력형식 : [정적인, 실행중에 변화가 없는]
	}
	
	
	
	
	//getter,setter
	public String getEnglish() {
		return english;
	}
	public void setEnglish(String english) {
		this.english = english;
	}
	public List<String> getKoreans() {
		return koreans;
	}
	public void setKoreans(List<String> koreans) {
		this.koreans = koreans;
	}
	
}
