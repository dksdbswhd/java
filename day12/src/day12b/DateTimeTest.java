package day12b;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

//날짜와 시간형식 클래스를 연습합니다.
//  java.util.Date 클래스  -> java.util.Calendar 클래스 
//   -> Java 8버전 LocalDate(날짜),LocalTime(시간),LocalDateTime(날짜와시간) 클래스
public class DateTimeTest {

	public static void main(String[] args) {

		LocalDate currentDate = LocalDate.now();    //현재 날짜를 가져옵니다.
		System.out.println("날짜 확인 : " + currentDate);
		
		LocalTime currentTime = LocalTime.now();
		System.out.println("시간 확인 : " + currentTime);
		
		LocalDateTime current = LocalDateTime.now();
		System.out.println("날짜 와 시간 확인 : " + current);
		
		//특정 날짜,시간을 참조한다.
		LocalDate wdate = LocalDate.of(2021, 1, 12);
		System.out.println("날짜 확인 : " + wdate);
		
		LocalTime wtime = LocalTime.of(23, 11);
		System.out.println("시간 확인 :" + wtime);
		
		//현재 날짜로부터 10일 후를 계산
		System.out.println("오늘날짜 + 10일 : " + currentDate.plusDays(10));
		//현재 날짜 10일 전을 계산
		System.out.println("오늘날짜 - 10일 : " + currentDate.minusDays(10));
	}

}






