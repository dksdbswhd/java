package vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//롬복테스트용 -> 롬복 라이브러리 추가 하고 롬복 설치(이클립스에게 알려줌)가 필요합니다.
//어노테이션 역할에 따라 위치가 정해져 있어요.
//@Getter
//@Setter
@Data      //getter+setter
@ToString
@NoArgsConstructor   //기본생성자
@AllArgsConstructor   //모든 필드 초기화하는 커스텀생성자
public class Product_ {
	private String pcode;
	private String pname;
	
	
	
	
}
