package javaclass;
class Unit { //사용자 정의 데이터 타입
	int currentTHP;  //유닛의 체력
	int x;           //유닛의 위치(x좌표)
	int y;           //유닛의 위치(y좌표)
}

//기능을 구현
//인터페이스 다중 상속
interface Flightable extends Movable, Attackable {}
//각기 다른 인터페이스를 분리해 놓은 것은 기능 조합을 하기 위함

interface  Movable { void move( int x, int y ); }
interface  Attackable { void attack( Unit u ); }
//상수하고 메소드
//매개변수

//조상 인터페이스(Movable,Attackable)을 상속받은 자손인터페이스 Flightable를 Fighter클래스에 구현 
class Fighter extends Unit implements Flightable{ 
	public void move( int x, int y ) {}
	public void attack( Unit u ) {}
}

public class in_flighter {
	public static void main(String[] args) {
		Fighter f = new Fighter(); //자바에서 클래스 인스턴스는 동적 메모리 할당
		
		//생성자가 호출
		if (f instanceof Unit) {
			System.out.println("f는 Unit 클래스의 자손입니다.");
		}
		if (f instanceof Flightable) {
			System.out.println("f는 Flightable 인터페이스를 구현했습니다.");
		}
		if (f instanceof Movable) {
			System.out.println("f는 Movable 인터페이스를 구현했습니다.");
		}
		if (f instanceof Attackable) {
			System.out.println("f는 Attackable 인터페이스를 구현했습니다.");
		}
		if (f instanceof Object) {
			System.out.println("f는 Object 클래스의 자손입니다.");
		}	
	}
}

//출력결과:
//f는 Unit 클래스의 자손입니다.
//f는 Flightable 인터페이스를 구현했습니다.
//f는 Movable 인터페이스를 구현했습니다.
//f는 Attackable 인터페이스를 구현했습니다.
//f는 Object 클래스의 자손입니다.

