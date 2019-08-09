package acorn;
//Shape => Triangle(밑변,높이), Rectangle(밑변,높이), Circle
//문제. Rectangle class, Triangle class를 구현해 보시오
//면적계산
public class u3_shape {
	//값을 변경하는 함수를 공통으로 하도록 구현
	//값을 변경한 다음 출력하도록 하는 공통 함수 생성
	//매개변수로 객체를 전달한 다음 다운 캐스팅을 자동으로 하는 함수를 작성
	public static void shaperPrint(Shape sh, double base, double height){ // sh:객체변수
		if(sh instanceof Circle ) { //인스턴스 된 클래스 확인
			Circle ci = (Circle)sh; //고려해서 사용할 것
			ci.setRadius(base);
			ci.makeArea();
			ci.display();
		}
		else if (sh instanceof Rectangle) {
			Rectangle rec = (Rectangle)sh;
			rec.setbase(base);
			rec.setheight(height);
			rec.makeArea();
			rec.display();
		}
		else if(sh instanceof Triangle){
			Triangle tri = (Triangle)sh;
			tri.setbase(base);
			tri.setheight(height);
			tri.makeArea();
			tri.display();
		}
	}
	
	public static void main(String[] args) {
		Shape sh = new Circle(10);
		sh.makeArea();
		System.out.println(sh.getArea());
		
		//sh.setRadius(1000); //추가된 함수는 호출불가
		Circle ci = (Circle)sh; //형변환
		ci.setRadius(1000);
		
		Shape sh2 = new Rectangle(10, 20);
		sh2.makeArea();
		sh2.display();
		Rectangle rec = (Rectangle)sh2;
		
		Shape sh3 = new Triangle(10, 20);
		sh2.makeArea();
		sh2.display();
		Triangle tri = (Triangle)sh3;			
		
		shaperPrint(rec, 5, 4);
		shaperPrint(tri, 6, 4);
		shaperPrint(ci, 100, 0); //원인 경우는 가짜 매개변수 0을 전달해야 함
	}
}

class Shape {
	protected double area;
	public void display() {
		System.out.println("면적은 " + this.area + "입니다.");
	}
	public void makeArea() {}
	public double getArea() {
		return area;
	}
}

class Circle extends Shape{
	private double radius; //자식 추가
	public Circle(int radius){
		this.radius = radius;
	}
	public void makeArea() { //재정의
		area = Math.PI*Math.pow(radius, 2);
	}
	public double getRadius() { //자식추가
		return radius;
	}
	public void setRadius(double radius){ //자식추가
		this.radius = radius;
	}	
}

class Rectangle extends Shape{
	private double base;
	private double height;
	
	public Rectangle(double base, double height){
		this.base = base;
		this.height = height;
	}
	public void makeArea() { 
		area = base*height;
	}
	public double getbase(double base) { 
		return base;
	}
	public void setbase(double base){ 
		this.base = base;
	}	
	public double getheight(double height) { 
		return base;
	}
	public void setheight(double height){ 
		this.height = height;
	}	
}

class Triangle extends Shape{
	private double base;
	private double height;
	
	public Triangle(double base, double height){
		this.base = base;
		this.height = height;
	}
	public void makeArea() { //재정의
		area = (float)(base*height)/2;
	}
	public double getbase(double base) { //자식추가
		return base;
	}
	public void setbase(double base){ //자식추가
		this.base = base;
	}	
	public double getheight(double height) { //자식추가
		return base;
	}
	public void setheight(double height){ //자식추가
		this.height = height;
	}	
}

//결과출력:
//314.1592653589793
//면적은 200.0입니다.
//면적은 200.0입니다.
//면적은 20.0입니다.
//면적은 12.0입니다.
//면적은 31415.926535897932입니다.

