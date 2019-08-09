package javaclass;
// Book(id, name, author, publisher, quantity) 클래스를 만들고
// 101, 딥러닝의 이해, 김종호, 에이콘출판사, 1000000
// 102, 자바의 왕도, 김종호, 에이콘출판사, 2000000
// 103, 인생철학개론, 김종호, 에이콘출판사, 50000000
// 1) TreeSet에서 초기화 하시오
// 2) 이터레이터를 이용해서 HashSet의 데이터를 출력하시오
// 3) HashSet의 데이터를 모두 제거하시오
// 4) Arraylist에 문자열 "대한", "민국", "만세"를 입력하고 HashSet으로 초기화 하시오

import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Iterator;

class Book{ 
	int id;
	String name;
	String author;
	String publisher;
	int quantity;
	public Book(int id,String name,String author,String publisher,int quantity) {
		this.id=id;
		this.name=name;
		this.author=author;	
		this.publisher=publisher;
		this.quantity=quantity;
	}
}

// HashSet, TreeSet의 차이
public class ds_set {

	public static void main(String[] args) {
		int count[] = {34, 22, 10, 60, 30, 22 };
		Set<Integer> set = new HashSet<Integer>();
		HashSet<Integer> set1 = new HashSet<Integer>();
		try {
			for(int i=0;i<6;i++) {
				set.add(count[i]);
			}
			System.out.println(set); //출력개수 : 5개 (중복불허되기때문)
			TreeSet sortedSet = new TreeSet<Integer>(set); //타 데이터구조로부터 초기화 시킬수 있음
			System.out.println("정렬유지:");
			System.out.println(sortedSet);
			System.out.println("셀의 첫요소: " +(Integer)sortedSet.first());
			System.out.println("셀의 마지막 요소: " +(Integer)sortedSet.last());
			
			// 1)TreeSet에서 초기화 하시오
			Book b1 = new Book(101, "딥러닝의 이해", "김종호", "에이콘출판사", 1000000);
			Book b2 = new Book(102, "자바의 왕도", "김종호", "에이콘출판사", 2000000);
			Book b3 = new Book(103, "인생철학개론", "김종호", "에이콘출판사", 50000000);
			HashSet<Book> ts = new HashSet<Book>();
			// HashSet의 제약사항 : 트리셋은 unique element만 가능(class때문에 트리셋이 사용불가)
			// null elemant 입력 불가, HashSetdms null이 가능
			// 동기화 지원을 안함
			// 오름 차순이 기본임
			ts.add(b1);
			ts.add(b2);
			ts.add(b3);
			for(Book b:ts) {
				System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);
			}
			
			// 2) 이터레이터를 이용해서 HashSet의 데이터를 출력하시오
			Iterator<Integer> iter = set.iterator();
			while(iter.hasNext()) 
			{
				System.out.println(iter.next());
			}
			// 3) HashSet의 데이터를 모두 제거하시오
			set.clear();
			
			// 4) Arraylist에 문자열 "대한", "민국", "만세"를 입력하고 HashSet으로 초기화 하시오
			ArrayList<String> a2 = new ArrayList<String>();
			a2.add("대한");
			a2.add("민국");
			a2.add("만세");
			HashSet<String> hs = new HashSet<String>(a2);
		}
		catch(Exception e) {}	
	}
}

//출력결과:
//[34, 22, 10, 60, 30]
//정렬유지:
//[10, 22, 30, 34, 60]
//셀의 첫요소: 10
//셀의 마지막 요소: 60
//101 딥러닝의 이해 김종호 에이콘출판사 1000000
//102 자바의 왕도 김종호 에이콘출판사 2000000
//103 인생철학개론 김종호 에이콘출판사 50000000
//34
//22
//10
//60
//30
