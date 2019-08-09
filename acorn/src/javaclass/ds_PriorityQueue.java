package javaclass;
// 비교가 가능
// class 비교는? 사용자정의 데이터 타입, 클래스 비교 : 
// 결정된 멤머변수를 기준으로 비교
// 클래스는 비교시(Comparable interface를 Implements한다.)
// Comparable : 순수추상클래스 -> 구성이 가상함수로 이루어짐 : 가상함수는 몸체부가 없음

import java.util.*;

class Books implements Comparable<Books>{  // 클래스 비교
	int id;
	String name;
	String author;
	String publisher;
	int quantity;
	Books(int id,String name,String author,String publisher,int quantity) {
		this.id=id;
		this.name=name;
		this.author=author;	
		this.publisher=publisher;
		this.quantity=quantity;
	}	
	public int compareTo(Books b) {
		if(id>b.id) { // 기준 데이터 컬럼
			return 1; 			// 앞의 데이터가 큰 경우
			}else if(id<b.id) { // 뒤의 데이터가 큰 경우
				return -1;
			}else {
				return 0;		// 같은 경우
			}
	}
}

public class ds_PriorityQueue { // 우선순위 큐
	public static void main(String[] args) {
		
		Queue<Books> queue = new PriorityQueue<Books>();
		Books b1 = new Books(201, "딥러닝의 이해", "김종호", "에이콘출판사", 1000000);
		Books b2 = new Books(202, "자바의 왕도", "김종호", "에이콘출판사", 2000000);
		Books b3 = new Books(203, "인생철학개론", "김종호", "에이콘출판사", 50000000);
		queue.add(b1);
		queue.add(b2);
		queue.add(b3);
		
		for(Books b:queue) {
			System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);
		}
		queue.remove(); // 우선순위 큐라서 head를 단수 제거
		
		for(Books b:queue) {
			System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);
		}
		System.out.println(queue.poll());    // 값을 가지고 오고 제거
		System.out.println(queue.element()); // 값만 가지고 옴 
	}
}

//결과출력: (정렬된 순서로 출력)
//201 딥러닝의 이해 김종호 에이콘출판사 1000000
//202 자바의 왕도 김종호 에이콘출판사 2000000
//203 인생철학개론 김종호 에이콘출판사 50000000
//202 자바의 왕도 김종호 에이콘출판사 2000000
//203 인생철학개론 김종호 에이콘출판사 50000000
//javaclass.Books@1a407d53
//javaclass.Books@3d8c7aca
