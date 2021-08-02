package day11b;
public interface RemoteControl {
	int MAX_VOLUME =20;   //public static final 생략됨.
	int MIN_VOLUME =0;
	
	void turnOn();    //public abstract void turnOn();
	void turnOff();
	void setVolume(int volume);
	
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음 처리합니다..");
		}else {
			System.out.println("무음 해제합니다..");
		}
	}
	
	static void changeBattery( ) {
		System.out.println("건전지를 교환합니다.");
	}
}
