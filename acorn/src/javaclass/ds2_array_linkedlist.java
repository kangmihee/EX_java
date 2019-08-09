package javaclass;
import java.util.*;

public class ds2_array_linkedlist {
	public static void main(String[] args) {
		// 함수의 매개변수가 부모이면 - 상속된 자식을 모두 가리킬 수 있다.
		// 함수의 생성시 부모타입으로 중복을 제거
		ArrayList al = new ArrayList(1000000); // 배열
		LinkedList ll = new LinkedList(); // 삽입삭제 링크드
		System.out.println("= 순차적으로 추가하기 =");
		System.out.println("ArrayList :"+add1(al));
		System.out.println("LinkedList :"+add1(ll));
		System.out.println();
		System.out.println("= 중간에 추가하기 =");
		System.out.println("ArrayList :"+add2(al));
		System.out.println("LinkedList :"+add2(ll));
		System.out.println();
		System.out.println("= 중간에서 삭제하기 =");
		System.out.println("ArrayList :"+remove2(al));
		System.out.println("LinkedList :"+remove2(ll));
		System.out.println();
		System.out.println("= 순차적으로 삭제하기 =");
		System.out.println("ArrayList :"+remove1(al));
		System.out.println("LinkedList :"+remove1(ll));
		System.out.println();

	}
	public static long add1(List list) { 
		// 1c초 : 1000ms
        long start = System.currentTimeMillis(); // 190냔 1월 1일 부터 현재까지 ms
        for(int i=0; i<100000;i++) list.add(i+""); 
        long end = System.currentTimeMillis(); 
        return end - start; // 경과시간
	}

	public static long add2(List list) { 
		long start = System.currentTimeMillis(); 
		for(int i=0; i<1000;i++) list.add(500, "X"); 
		long end = System.currentTimeMillis(); 
	      return end - start; 
	}
	
	public static long remove1(List list) { 
		long start = System.currentTimeMillis(); 
		for(int i=list.size()-1; i > 0;i--) list.remove(i); 
		long end = System.currentTimeMillis(); 
		return end - start; 
	}
	
	public static long remove2(List list) { 
		long start = System.currentTimeMillis(); 
		for(int i=0; i<1000;i++) list.remove(i); 
		long end = System.currentTimeMillis(); 
		return end - start; 
	} 
}

//출력결과:
//= 순차적으로 추가하기 =
//ArrayList :24
//LinkedList :20
//
//= 중간에 추가하기 =
//ArrayList :34
//LinkedList :2
//
//= 중간에서 삭제하기 =
//ArrayList :33
//LinkedList :2
//
//= 순차적으로 삭제하기 =
//ArrayList :3
//LinkedList :5
