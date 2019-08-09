package acorn;

public class Car2 {
	String color; //컬러
	String gearType; //기어타입
	int door; //도어수
	
	Car2() {} //디폴트 생성자...주석처리하면 에러남...명시적으로 만들어줘야함
	Car2(String c, String g, int d) { //생성자 오버로딩
		color = c;
		gearType = g;
		door = d;
	}
}
