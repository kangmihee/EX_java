package acorn;
import java.util.Scanner;

public class method {
	int a = 100; //함수밖에 선언된 변수:멤버변수

	public static void main(String[] args) { //main은 진입점함수...처음으로실행됨
		int a = 10;
		int b = 20;
		int result = add(a,b);
		System.out.println("결과는: " + result );	
		
	    int x; int y; int z;	      	
		Scanner input = new Scanner(System.in);
		x = input.nextInt();
		y = input.nextInt();
		z = input.nextInt();
		System.out.println("부피는: " + volume(x,y,z));
		
		f('c'); //출력:f(char)
		byte i = 2;
		f(i);//출력:f(int)
		short j =2;
		f(j);//출력:f(int)
		f(2);//출력:f(int)
		f(2L);//출력:f(long)	
	}
	
	//overloading
	static void f(char c) {System.out.println("f(char)");}
	static void f(int i) {System.out.println("f(int)");}
	static void f(long c) {System.out.println("f(long)");}
	
	//문제. 밑변, 넓이, 높이를 입력받아서 부피을 계산하는 함수를 작성하고
	//밑변:10, 넓이:20, 높이:30 의 부피을 계산하시오.
	public static int volume(int x, int y, int z){
		int result;		
		result = x * y * z;		
		return result;		
	}
	
	//문제. 두수를 입력받아서 변수간의 값을 교환하는 함수를 작성하시오.
	public static void change(int x, int y){
		//i=i+1 => 누산기에 일차 저장
		int temp; //임시변수		
		temp = x;
		x = y;
		y = temp;		
	}
	
	public static int add(int a, int b){ // static : 인스턴스 하지않고 사용
		int result;		
		result = a + b;
		f('c'); //static함수는 서로 호출이 가능하다
		return result;		
	}
}

//출력결과:
//f(char)
//결과는: 30

