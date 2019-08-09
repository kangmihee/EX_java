package javaclass;
// ArrayList의 상속계층도
// List는 저장방식
// AbstractList 는 interface 리스트형 데이터로 사용할 때 공통부분 정의
// ArrayList : 배열방식으로 데이터를 저장할 때 사용
// ArrayList ->  배열 -> : 많은 양의 데이터를 순서적으로 처리할 때 적합
// Iterable -> Collection -> List -> AbstractList -> ArrayList

import java.util.ArrayList;
import java.util.Iterator;

class Dept{
	int deptno;
	String dname;
	String loc;
	public Dept(int deptno, String dname, String loc) {
		this.deptno=deptno;
		this.dname=dname;
		this.loc=loc;		
	}
}

public class ds_dept {
	public static void main(String[] args) {
	
		Dept d1 = new Dept(10, "ACCOUNTNG", "NEWYORK");
		Dept d2 = new Dept(20, "RESEARCH", "DALLAS");
		Dept d3 = new Dept(30, "SALES", "CHICAGO");
		Dept d4 = new Dept(40, "OPERATIONS", "BOSTION");
		ArrayList<Dept> ad1 = new ArrayList<Dept>();
		ad1.add(d1);
		ad1.add(d2);
		ad1.add(d3);
		ad1.add(d4);

		ad1.forEach(a->{ //dept 테이블 출력
			System.out.println(a.deptno+"  "+a.dname+"  "+a.loc);
		});	
		
		//Iterator itr = ad1.iterator(); 필요없어도된다
		
		ArrayList<Dept> ad2 = new ArrayList<Dept>();
		ad2.add(d1);
		ad2.add(d2);
		ad2.add(d3);
		ad2.add(d4);
		ad2.add(1,d1); //배열은 중복을 허용한다. but! set, map은 중복불가
		ad2.addAll(ad2); //한번에 여러값을 입력
		ad2.add(d3);
		ad2.remove(0);
		ad2.removeAll(ad2);
		ad2.clear();
		System.out.println("Is ArrayList Empty: " + ad2.isEmpty());
		ad2.set(1,d2); //update수정
		System.out.println("수정 후: " + ad2.get(1));
	}
}

//출력결과:
//10  ACCOUNTNG  NEWYORK
//20  RESEARCH  DALLAS
//30  SALES  CHICAGO
//40  OPERATIONS  BOSTION
//Is ArrayList Empty: true
