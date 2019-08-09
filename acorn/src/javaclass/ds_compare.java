package javaclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// class 비교
// 사영자 정의 데이터 타입
class Dog implements Comparator<Dog>, Comparable<Dog>{
	private int age; // 단일변수
	private String name;
	Dog() { // default생성자
	}
	Dog(String n, int a){ //초기화 생성자
		name = n;
		age = a;
	}
	public String getDogName() {
		return name;
	}
	public int getDogAge() {
		return age;
	}
	@Override
	public int compareTo(Dog d) { // 오버라이딩 (매개변수 1개)
		return (this.name).compareTo(d.name);
	}
	@Override
	public int compare(Dog d, Dog d1) {
		return d.age - d1.age; // 리턴값 : 앞의 값 : 1보다 큰수, 0, 작으면 -값
	}
}
	
public class ds_compare {
	public static void main(String[] args) {
		List<Dog> list = new ArrayList<Dog>();
		list.add(new Dog("귀염",3));
		list.add(new Dog("반려",2));
		list.add(new Dog("동행",10));
		list.add(new Dog("짝짝",4));
		list.add(new Dog("타미",1));
		
		Collections.sort(list);
		for(Dog a : list)
			System.out.print(a.getDogName()+",  ");
		
		Collections.sort(list, new Dog());
		System.out.println();
		for(Dog a : list)
			System.out.print(a.getDogName()+"  :"+a.getDogAge() + ",  ");
	}
}

//출력결과:
//귀염,  동행,  반려,  짝짝,  타미,  
//타미  :1,  반려  :2,  귀염  :3,  짝짝  :4,  동행  :10,  
