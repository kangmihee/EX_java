package acorn;

public class ThirUtil {
	public void MakeMessage(){ //static 없음
		System.out.println("타패키지의 정적함수의 호출");
	}
	
	public  void MakeMessage2(){
		System.out.println("타패키지의 정적함수의 호출2");
	}
}
