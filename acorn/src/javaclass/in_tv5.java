package javaclass;

//공통기능을 정의 on/off
interface TVaction {
	void on();
	void off();
}

//리모컨 -인터페이스를 상속받은 모든 객체의 동작을 제어하는 기능
class TV5 {
	void autoOn(TVaction i) { //인터페이스를 클래스 안에사용??...인터페이스는 마치 부모처럼 자식을 가져다가 쓸수 있음
		i.on();
	}
	void autoOff(TVaction i) {
		i.off();
	}
}

//공통기능을 구현함
class LgTV implements TVaction{
	public void on() {
		System.out.println("Lg ON");
	}
	public void off() {
		System.out.println("Lg Off");
	}
}
class SamsungTV implements TVaction{
	public void on() {
		System.out.println("Samsung ON");
	}
	public void off() {
		System.out.println("Samsung Off");
	}
}
class LotteTV implements TVaction{
	public void on() {
		System.out.println("Lotte ON");
	}
	public void off() {
		System.out.println("Lotte Off");
	}
}

public class in_tv5 {
	public static void main(String[] args) {
		TV5 tv = new TV5(); //리모콘
		
		tv.autoOn(new LgTV());
		tv.autoOn(new LotteTV());
		tv.autoOn(new SamsungTV());
		
		tv.autoOff(new LgTV());
		tv.autoOff(new LotteTV());
		tv.autoOff(new SamsungTV());			
	}
}

//출력결과:
//Lg ON
//Lotte ON
//Samsung ON
//Lg Off
//Lotte Off
//Samsung Off

