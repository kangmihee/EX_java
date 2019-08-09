package javaclass;
//play (각 회사의 문자열 출력) 라는 공통인터페이스가 있고
//lg, samsung, sony회사에서 그 기능을 구현하도록 하고
//위의 제품의 play 함수를 호출할 수 있는 클래스를 작성하시오

interface PLAY{
	int a = 100; //public static final, 상수로 자동 변경
	public abstract void play(); 
}

class LG implements PLAY{ //모든  class는 기본으로 object 상속
	public void play() {
		System.out.println("play in B class");
	}
	public String toString() { //오버라이딩 : 문자열을 요구하는 함수에 들어가면 자동
		return "LG";
	}
}
class SAMSUNG implements PLAY{ 
	public void play() {
		System.out.println("play in C class");
	}
	public String toString() { 
		return "SAMSUNG";
	}
}
class SONY implements PLAY{ 
	public void play() {
		System.out.println("play in D class");
	}
	public String toString() { 
		return "SONY";
	}
}

class playauto {
	void autoplay(PLAY p) { //p는 문자열
		System.out.println("Connecting with " + p );
		p.play(); //(LG, SAMSUNG, SONY)클래스의 play 함수 호출
		//p.a = 100;
		System.out.println("p.a");
		System.out.println();
	}
}

public class in_play { //하나의 메소드를 이용해서 다양하게 기능하는 객체를 작동시킨다.
	public static void main(String[] args) {

		playauto pa = new playauto();
		LG lg = new LG();
		SAMSUNG samsung = new SAMSUNG();
		SONY sony = new SONY();
		//재정의 가능 : 다양한 기능을 구현하는 것이 가능
		//한번에 호출할 수 있는 것은 상속과 interface다
		//interface로 하는 이유는 강제적으로 오버라이딩해야 하기 때문
			
		pa.autoplay(new LG());  //결과는 아래와 같다
		pa.autoplay(lg);
		
		pa.autoplay(new SAMSUNG());
		pa.autoplay(samsung);
		
		pa.autoplay(new SONY());
		pa.autoplay(sony);
	}
}

//출력결과 :
//Connecting with LG
//play in B class
//p.a
//
//Connecting with LG
//play in B class
//p.a
//
//Connecting with SAMSUNG
//play in C class
//p.a
//
//Connecting with SAMSUNG
//play in C class
//p.a
//
//Connecting with SONY
//play in D class
//p.a
//
//Connecting with SONY
//play in D class
//p.a

