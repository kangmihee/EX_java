package acorn;
// 클래스 = 멤버변수 + 멤버변수 
public class SecondUtil { //진입점 함수(main)가 없는 일반 클래스
	int a;
	public static void MakeMessage(){
		System.out.println("타패키지의 정적함수의 호출");
	}
	public static void MakeMessage2(){
		System.out.println("타패키지의 정적함수의 호출2");
	}
}
