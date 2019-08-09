package acorn;
import java.util.Scanner;

//point class 구현하시오 x,y좌표  set/get, move, display 함수 사용
//거리값을 구하는 함수(distance)는 가있는 class 작성
//Color Point Class 로 좌표값에 컬러값을 표현하도록 관리하는 클래스 작성
//Rectangle (좌표점 2개), Triangle (밑변 좌표점 2개), Circle (중심점과 반지름)

class Point{
	int x1;
	int y1;
	
	Point(int x1, int y1){
		this.x1 = x1;
		this.y1 = y1;
	}
	public Point(){
		x1 = 0;
		y1 = 0;
    }
	public double distance(Point p){
		double dis = Math.sqrt( (this.x1-p.x1)*(this.x1-p.x1)+(this.y1-p.y1)*(this.y1-p.y1) );
		return dis;
	}	
	public void setvalue1(int x1){ this.x1 = x1;}
	public void setvalue2(int y1){ this.y1 = y1;}
	
	public int getvalue1(int x1){ return x1;}
	public int getvalue2(int y1){ return y1;}		
}

class Color_Point extends Point{
	String color;
	public Color_Point(int x1, int y1, String color) {
		super(x1, y1);
		this.color = color;
	}
}

abstract class Shape_hw{
	public Point start, end;	
	public Shape_hw(Point p1, Point p2){
		this.start = p1;
		this.end = p2;
	}
	public abstract double display();
	public void move(Point p1, Point p2){
		start = p1;
		end = p2;
	}		
}

class Rectangle_hw extends Shape_hw{
	public int width,height;
	public Rectangle_hw(Point p1, Point p2){
		super(p1, p2);
	}
	public double display() {
		width = Math.abs(start.x1-end.x1);
		height = Math.abs(start.y1-end.y1);
		return width*height;
	}
}

class Triangle_hw extends Shape_hw{
	Point c;
	public Triangle_hw(Point a, Point b, Point c) {
		super(a, b);
		this.c=c;
	}
	public void move(Point a, Point b, Point c) {
		super.move(a, b);
		this.c = c;
	}
	public double display() {
		double value = 0.5*Math.abs(((start.x1*end.y1 + end.x1*c.y1 + c.x1*start.y1)
                                    -(end.x1*start.y1 + c.x1*end.y1 + start.x1*c.y1)));
		return value;
	}		
}

class Circle_hw extends Shape_hw{
	public double r;
	public Circle_hw(Point p1, Point p2) {
		super(p1,p2);
	}
	public double display() {
		r = start.distance(end);
		return Math.round((Math.PI*r*r)*100/100.0);
	}
}

public class Homework1 {
	public static void main(String[] args) {	
		Point p1 = new Point();
        Point p2 = new Point(0,5);
        System.out.println("두 좌표 간의 거리: "  + Math.round(p1.distance(p2))*100/100.0);
        
        Rectangle_hw r = new Rectangle_hw(new Point(), new Point(10,5));
        Triangle_hw t = new Triangle_hw(p1, new Point(5,0),new Point(5,5));
        Circle_hw c = new Circle_hw(p1, new Point(0,5));
        Color_Point cp = new Color_Point(0, 5,"red");
        System.out.println("(" + cp.x1 + "," + cp.y1 + ")좌표의 color값:" + cp.color );
               
        System.out.println("좌표 이동 전의 도형의 넓이: ");
        System.out.print("사각형:" + r.display() + " 삼각형:"  +  t.display() + " 원:" +  c.display() + "\n");    
        
        System.out.println("좌표 이동 후의 도형의 넓이: ");
        r.move(new Point(8,8),new Point(3,3));
        c.move(new Point(), new Point(0,2));
        t.move(new Point(), new Point(4,0), new Point(0,4));		
        System.out.print("사각형:" + r.display() + " 삼각형:"  +  t.display() + " 원:" +  c.display() + "\n");    		
	}
}

//출력결과:
//두 좌표 간의 거리: 5.0
//(0,5)좌표의 color값:red
//좌표 이동 전의 도형의 넓이: 
//사각형:50.0 삼각형:12.5 원:79.0
//좌표 이동 후의 도형의 넓이: 
//사각형:25.0 삼각형:8.0 원:13.0

