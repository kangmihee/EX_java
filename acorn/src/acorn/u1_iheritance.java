package acorn;

class Parent {
	int x = 100;
	void method() {
		System.out.println("parent Method");
	}
	public void setvalue(int x){
		this.x = x;
	}
}

class Child extends Parent{
	int x = 200; //데이터 재정의
	public Child() {
		x = 1000; 
	}
	public void setvalue(int x){
		this.x = x; //overriding 재정의
	}
	void method(){
		System.out.println("child method " + x );
	}
	void Method2(){ //자식특화, 자식이 임의로 추가
		System.out.println("child.method " + x );
	}
}

class Child2 extends Parent{
	int x=200;
	public Child2() {
		x = 2000;
	}
	public void setvalue(int x){
		this.x = x;
	}
	void method(){
		System.out.println("child method " + x );
	}
	void Method3(){
		System.out.println("child.method " + x );
	}
}

public class u1_iheritance {
	public static void main(String[] args) {
		Child c = new Child();
		Parent p = new Child();  //클래스 상이, 상속관계의 부모는 자식을 가리킬 수 있다.
			
		//오버라이딩 된 함수가 호출됨
		c.method();
		p.method(); 
		c.Method2();
		//p.method2(); //에러발생: 자식의 고유의(추가한 것은) 부모의 이름으로 호출불가 -> 다운캐스팅필요
		
		Child d = (Child) p; //다운캐스팅
		d.Method2();
		
		Child ch[] = new Child[3]; //객체 배열
		for(int i=0;i<3;i++){
			ch[i] = new Child(); //실제 heap에 메모리 공간확
		}
		ch[0].setvalue(100);
		ch[1].setvalue(20);
		ch[2].setvalue(10);
		
		for(int i=0;i<3;i++){
			ch[i].method();
		}
		//부모가 자식을 가리키도록 한다.
		Parent chp[] = new Parent[6];  // 3 : child,  3 : child2  
		for(int i=0;i<3;i++){
			chp[i] = new Child();
		}
		for(int i=3;i<6;i++){
			chp[i] = new Child2();
		}
		chp[0].setvalue(100);
		chp[1].setvalue(20);
		chp[2].setvalue(10);
		
		for(int i=0;i<3;i++){
			chp[i].method(); //부모의 이름으로 자식의 함수를 호출 가능
		}	
	}
}

//결과출력:
//child method 1000
//child method 1000
//child.method 1000
//child.method 1000
//child method 100
//child method 20
//child method 10
//child method 100
//child method 20
//child method 10
