package acorn;
public class t2_Circle {

	public static void main(String[] args) {
		Circle1 c1 = new Circle1();
		//c1.radius = 100; //private변수에 값 대입
		c1.setRadius(100);
		c1.display();		
	}
}

// 원을 표현하는 class : 속성 - 반지름, 중심점
class Circle1 {
	private double radius = 0; //접근 지정자
	
	public void setRadius(double r) {
		radius = r;
	}
	public double getRadius() {
		return radius;
	}
	public double getArea() {
		return Math.PI * radius * radius;
	}
	public void display() {
		System.out.println("원의 면적은" + getArea());
	}
}

//출력결과:
//원의 면적은31415.926535897932
