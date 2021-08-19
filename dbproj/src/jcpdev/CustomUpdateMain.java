package jcpdev;

import java.util.Scanner;

import dao.CustomDao;
import vo.CustomVo;

//고객ID 입력받아서 이메일(입력) 정보 수정하도록 합니다. -> (+)없는 고객ID 입력하면 고객등록하시겠습니까?
public class CustomUpdateMain {

	public static void main(String[] args) {
		CustomDao dao = CustomDao.getInstance();   //필요한 sql 실행 메소드 사용합니다.
		
		Scanner sc = new Scanner(System.in);
		String id,email;
		CustomVo vo;
		
		System.out.println("::: 고객 데이터 관리 :::");
		System.out.println("회원 정보 수정합니다.");
		System.out.print("아이디 입력 >>> ");
		id= sc.nextLine();
		
		if(dao.idcheck(id)) {
			System.out.println("저희 고객이 아니십니다.");
		
		}else {
			System.out.println("등록된 고객 정보를 수정합니다.");
			vo = dao.getCustom(id);         //id조회결과 행을 CustomVo 객체로 참조합니다.
			System.out.println(vo);
			
			System.out.print("\n새로운 이메일 입력 >>> ");
			email = sc.nextLine();
			vo.setEmail(email);            //vo 참조객체의 email을 변경
			
			dao.update(vo);
			System.out.println("수정된 결과 : " + dao.getCustom(id));
			
			
		}
	}

}






