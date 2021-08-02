package day11b;

public class Audio implements RemoteControl {
	private int volume;

	@Override
	public void turnOn() {
		System.out.println("Audio를 켭니다.");

	}

	@Override
	public void turnOff() {
		System.out.println("Audio를 끕니다.");

	}

	@Override
	public void setVolume(int volume) {
		// 정해진 볼륨의 범위에서만 set 하도록 정의합니다.
		if (volume > RemoteControl.MAX_VOLUME+10) // 조건식이 참
			this.volume = RemoteControl.MAX_VOLUME+10; // volume은 최대값20
		else if (volume < RemoteControl.MIN_VOLUME+5)
			this.volume = RemoteControl.MIN_VOLUME+5;
		else
			this.volume = volume; // 5~30 사이의 값으로 인자 전달될 때 입니다.

		System.out.println("현재 당신의 Audio 볼륨은 " + this.volume);

	}

}
