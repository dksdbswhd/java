package vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//buy# 테이블과 매핑되는 클래스
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BuyVo {
	private int buy_no;
	private String custom_id;
	private String pcode;
	private int quantity;
	private Date buy_date;
	

}
