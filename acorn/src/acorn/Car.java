//숫자형 데이터, 문제형 데이터, 객체형 데이터
package acorn;

public class Car { //클래스 : 멤버변수 + 멤버 매소드
	public String name;
	//생성자 : 멤버변수를 초기화 할대 사용
	//     : 강제로 호출할 수 없고 클래스 인스턴스 될 때 처음 한 번만 실행
	
	public Car(String name){ //리턴값이 없음
		this.name=name; //this는 인스턴스 된 클래스 자체를 this
	}
	public void drive() { //함수이름은 drive로 같은데 값을 다르게 줘서 호출내용이 다름
		System.out.println(this.name+ "이(가) 달라요.");
	}
}
