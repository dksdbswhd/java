package day11b;

public class SmartTV implements RemoteControl , WebSearch{
	private int volume;  //클래스의  필드
	
	@Override
	public void search(String url) {
		System.out.println("브로드밴드 서비스로 인터넷에 연결합니다. " );
		System.out.println(url +" 에 접속합니다.");
	}
	
	@Override
	public void turnOn() {
		System.out.println("스마트티비를 켭니다.");
		
	}
	
	@Override
	public void turnOff() {
		System.out.println("스마트티비를 끕니다.");
	}
	
	@Override
	public void setVolume(int volume) {   //인자 값이 23이라고 하면
		//정해진 볼륨의 범위에서만 set 하도록 정의합니다.
		if(volume > RemoteControl.MAX_VOLUME)   //조건식이 참
			this.volume = RemoteControl.MAX_VOLUME;  //volume은 최대값20
		else if(volume < RemoteControl.MIN_VOLUME)
			this.volume = RemoteControl.MIN_VOLUME;
		else  
			this.volume=volume;	  //0~20 사이의 값으로 인자 전달될 때 입니다.
		
		System.out.println("현재 당신의 스마트 티비 볼륨은 " + this.volume);
	}
}







