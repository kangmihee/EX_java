package javaclass;

interface Printable1{
	void print(); //추상메서드
}
/*interface Showable1 extends Printable1{  //인터페이스 상속
	void show(); //메서드
}*/

interface Showable1{ //...다중인터페이스 상속위해서 위 인터페이스 주석처리하고 만들어줌
	void show();
}

//인터페이스 상속시 그 결과도 인터페이스
public class in_abstract implements Showable1,Printable1{
	
	public void print(){System.out.println("안녕");}
	public void show(){System.out.println("최대한 능력발휘");}
	
	public static void main(String[] args) { //static //main
		
		in_abstract obj = new in_abstract();
		//배열 처리하거나 함수의 매개변수로 받기위해(자식)
		obj.print(); 
		obj.show(); 
		
		//인터페이스 변수
		Printable1 insp = new in_abstract();
		insp.print(); 
		//insp.show(); //호출불가능..다운캐스팅 해주어야함
		//강제로 다운캐스팅
		obj = (in_abstract) insp;
		obj.print(); 
		obj.show(); 
	}
}

//출력결과:
//안녕
//최대한 능력발휘
//안녕
//안녕
//최대한 능력발휘

