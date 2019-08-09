package javaclass;
import java.util.*;

// 문제: 이름 반 번을 관리하는 클래스를 만들고
// ArrayList에 3개의 데이터를 입력하고 출력(Iterator사용) 하시오

class Class{
	String name;
	int ban;
	int no;
	public Class() {}
	Class(String name,int ban,int no){
		this.name=name;
		this.ban=ban;
		this.no=no;
	}
	public String toString() {
		return "이름:"+name + "  반:" + ban + "  번호:" + no ; 
	}
}

public class ds_total {
	public static void main(String[] args) {
		Properties prop = new Properties();
		ArrayList<Class> cl= new ArrayList<Class>();
		Scanner scan = new Scanner(System.in);
		String name;
		int ban=0;
		int no=0;
		System.out.println("이름, 반, 번호를 입력하시오.");
		for(int i=0;i<3;i++) { 
			name=scan.nextLine(); 
			ban=scan.nextInt();
			no=scan.nextInt();
			scan.nextLine();
			Class cla = new Class(); 
			cla.name=name;
			cla.ban=ban;
			cla.no=no;
			cl.add(cla);
		}
		Iterator<Class> itr = cl.iterator();
		while(itr.hasNext()) {
			Class s = (Class)itr.next();
			System.out.println(s);
			prop.setProperty(s.name, s.toString());
		}
	}
}

//결과출력:
//이름:차은우  반:1  번호:10
//이름:박보검  반:2  번호:20
//이름:유승호  반:3  번호:30