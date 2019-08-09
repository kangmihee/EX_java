package acorn;
//class : 진입함수, 일반클래스, static함수가 있는 클래스
// 하나의 화일에 여러개의 class가 있을경우
class Data {int x;} //클래스는 하나의 화일...private class라서 다른 class에서 접근 불가능
//자바에서 접근 지정자를 지정하지 않으면 private - class
//private 변수는 외부직접 접근이 불가능 - 함수를 통해서 접근가능
//변수인 경우 접근 지정자를 붙이지 않으면 public

public class Onefileclass {
	//overloading
	static void change(int x){ //함수의 이름이 동일, 매개변수의 데이터 타입과 갯수
		x = 100;
		System.out.println("change() : x = " + x ); //출력:10
	}
	static void change(Data d){
		d.x = 100;
		System.out.println("change() : x = " + d.x ); //출력:100
	}
	
	//배열변수는 stack에 생성-주소값저장, 저장되는 데이터는 heap
	static void change(int[] x){ //매개변수전달방식 callby_reference, callby_value
		x[0] = 1000;
		System.out.println("change() : x = " + x[0] ); //출력:1000
	}

	public static void main(String[] args) {
		Data d = new Data();
		d.x = 10;
		System.out.println("main() : x = " + d.x );
		int[] x = {10};
		change(d);
		change(x);
		System.out.println("After change(d.x)" );
		System.out.println("main() : x = " + d.x ); //출력:100				
	}
}

//출력결과:
//main() : x = 10
//change() : x = 100
//change() : x = 1000
//After change(d.x)
//main() : x = 100
