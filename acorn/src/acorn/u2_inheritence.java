package acorn;

class A { //public
	int f;
	A(){
		f = 10;
	}
	void m(){
		System.out.println("f = " + f);
	}
}

public class u2_inheritence extends A{
	int f;
	int f2;
	
	u2_inheritence(){
		f = 100;
		f2 = 200;
	}
	void m2() {
		System.out.println("f2 = " + f);
	}

	public static void main(String[] args) {
		A a = new A();
		a.f++;
		a.m();
//		a.f2++; //상속(자식호출)불가능
//		a.m2(); //상속(자식호출)불가능
		u2_inheritence b = new u2_inheritence();
		b.f++; //변수 재정의 - 거의사용하지 않음
		b.m();
		b.f2++; //자식추가
		b.m2();
	}
}

//결과출력:
//f = 11
//f = 10
//f2 = 101
