package acorn;
public class static_nonstatic { //사용자 정의 데이터타입
	int a; //메모리 공간을 확보 : 멤버변수용량, 함수는 한번만 확보
	int b;
	String name;

	public static void main(String[] args) { // 진입점 함수
		static_nonstatic fun = new static_nonstatic();  // 함수1개씩 메모리 확보(변수 a,b,name) 함수끼리공간이 서로 다름(중복x)
		static_nonstatic fun2 = new static_nonstatic(); // 메모리확보
		static_nonstatic fun3 = new static_nonstatic(); // 메모리확보
		System.out.println("프로그램 시작 펏 함수 호출");
		fun.staticMethod1(); //저장된 데이터는 다르나 호출되는 함수는 같다.
		fun2.staticMethod1();
		System.out.println("메인으로 복귀");
		System.out.println("10팩토리얼의 출력 =" + fact(10));
		System.out.println("10팩토리얼의 출력 =" + fun.fact(10));
	}
	
	void staticMethod1() { //일반함수 : 인스턴스
		System.out.println("첫 함수 진입 ");
		staticMethod2(); //두번째 일반함수 호출
		System.out.println("두번째 함수 호출 종료");
	}
	
	void staticMethod2() {
		System.out.println("두번째 함수 진입 ");
		System.out.println("두번째 함수 호출");
		System.out.println("두번째 함수 종료 ");
	}
	
	public static int fact(int number){ //정적함수
		if(number == 0)
			return (1);
		return (number * fact(number-1) );
	}
}

//함수호출:
//프로그램 시작 펏 함수 호출
//첫 함수 진입 
//두번째 함수 진입 
//두번째 함수 호출
//두번째 함수 종료 
//두번째 함수 호출 종료
//첫 함수 진입 
//두번째 함수 진입 
//두번째 함수 호출
//두번째 함수 종료 
//두번째 함수 호출 종료
//메인으로 복귀
//10팩토리얼의 출력 =3628800
//10팩토리얼의 출력 =3628800

