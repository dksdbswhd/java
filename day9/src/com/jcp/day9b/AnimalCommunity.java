package com.jcp.day9b;

public class AnimalCommunity {

	public static void main(String[] args) {
//			Animal[] animals = new Animal[3];
			Animal[] animals = new Animal[10];
			animals[0] = new Puppy("브라운");
			animals[1] = new Cat();
			animals[2] = new Rabbit();
			//animals[0].setColor("브라운");
			animals[1].setColor("그레이");
			animals[2].setColor("화이트");
			
			System.out.println("[[반려동물 목록을 보여드리겠습니다.]] \n");
			for(int i=0;i<animals.length;i++) {
	//현재 animals 배열에 3번 인덱스부터는 null객체입니다. -> sound()오류
	//그렇다고 배열의 크기를 줄이거나 배열의 크기에 맞춰 반복하도록 하면 프로그램이 아닙니다.
	//그래서 null 아닐때만 sound()를 실행합니다.			
				if(animals[i]!= null)
					animals[i].sound(); 		//sound() 메소드로 다형성 구현합니다.
			}	
			
	//	모모회원이 동물 분양 받을 수 있는지 셀프 체크
	//	강아지는 15세이상, 고양이는 18세이상, 토끼는 13세 이상 분양받을 수 있습니다.			
		Member momo = new Member("모모", 17);	
		
		boolean result =momo.isAdopt(animals[1]);
		String message=momo.getName() + " 회원님은 ";	
	
//강아지,고양이,토끼 출력방법은 여러가지 가능합니다.		
		if(animals[1] instanceof Puppy)	
			message +="강아지";
		else if(animals[1] instanceof Cat)	
			message +="고양이";
		else if(animals[1] instanceof Rabbit)	
			message +="토끼";
		
		print(result,message);
		
		//다른 멤버 추가해서 다른 animal 도 테스트. -> TYPE 상수 활용.
		Member sana = new Member("사나",16);
		
		message=momo.getName() + " 회원님은 " + animals[0].getType();	
		print(result,message);
		
		
		
		
		}//main end
	
	
		static void print(boolean result , String message) {
			if(result) {
				System.out.print(message + " 분양 가능합니다.");
				System.out.println("😃");
			} else {
				System.out.print(message + " 분양 자격이 안됩니다.");
				System.out.println("😓");
			}
		}

}







