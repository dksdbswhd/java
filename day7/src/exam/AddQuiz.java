package exam;

public class AddQuiz {
//필드	
		int data1;		//문제 데이터 1
		int data2;		//문제 데이터 2  , 문제는 data1 + data2
		int userAns;   //사용자 입력한 답

//기본생성자
		
//메소드		
		boolean makeResult() {     //사용자 입력한 답이 정답이면 true, 아니면 false
			if(data1+data2==userAns) 
				return true;  //정답
			else 
				return false;
		}
		
		
		String resultPrint() {		//사용자답 문제 각각 채점결과 o 또는 x 표시
			if(makeResult()) return "O";   //data1+data2==userAns 조건검사 대신 메소드 호출
			else return "X";
		}

}
