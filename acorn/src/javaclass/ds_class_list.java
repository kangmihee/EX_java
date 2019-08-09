package javaclass;

import java.util.ArrayList;
import java.util.Iterator;

//다음 데이터를 array리스트에 저장
// 101,"고구려",12 =>사용자정의 데이터타입 => class
// 102,"대발해",21
// 103,"왕대한",25
// => ArrayList

class Student{
	int rollno;
	String name;
	int age;
	public Student(int rollno, String name, int age) {
		this.rollno=rollno;
		this.name=name;
		this.age=age;		
	}
}

// 처음에 10개 정도의 메모리를 자동으로 생성해줌
// add함수 사용시
public class ds_class_list {
	// ArrayList는 배열이 작동하는 방식과 같이 작동한다. (삽입,삭제)
	// 동적배열( 사이즈 유동적 )
	public static void main(String[] args) {
		Student s1 = new Student(101,"고구려",12);
		Student s2 = new Student(102,"대발해",21);
		Student s3 = new Student(103,"왕대한",25);
		ArrayList<Student> a1 = new ArrayList<Student>();
		a1.add(s1); // s1 -> 주소값 -> heap 데이터 저장
		a1.add(s2);
		a1.add(s3);
		
		Iterator itr = a1.iterator();
		//while문으로 출력하기
		while(itr.hasNext()) {
			Student st = (Student)itr.next();
			System.out.println(st.rollno+"  "+st.name+"  "+st.age);
		}
		//forEach로 출력하기
		a1.forEach(a->{ //주소값
			System.out.println(a.rollno+"  "+a.name+"  "+a.age);
		});			
	}
}

//출력결과:
//101  고구려  12
//102  대발해  21
//103  왕대한  25
//101  고구려  12
//102  대발해  21
//103  왕대한  25

