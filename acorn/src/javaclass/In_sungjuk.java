package javaclass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

// 인터페이스 (Iterator) -> Collections
// List, Queue, Set
// Map
// ListIterator 는 List에만 삽입 삭제 등의 작업을 편리하게 하기 위하여 사용
// Iterator
// Class 정렬 : Comparable, Comparator implements

class Student50 implements Comparator<Student50>, Comparable<Student50>{
	String name;
	int ban;
	int no;
	int kor;
	int mat;
	int eng;
	int total;
	Student50() {}
	Student50(String name, int ban, int no, int kor, int mat, int eng){
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.mat = mat;
		this.eng = eng;
	}
	// 기본 : 함수베이스, 구조적 프로그램, 반복, stack
	// 접근지정자, 리턴타입, 함수명( 매개변수 )
	@Override
	public int compareTo(Student50 o) {		
		return this.name.compareTo(o.name);
	}
	@Override
	public int compare(Student50 o1, Student50 o2) {
		return o2.total - o1.total;
	}
	public String toString() {
		return name + "\t" + ban + "\t" + no + "\t" + kor + "\t" + 
			   mat + "\t" + eng + "\t" + total + "\t";
	}
}

// 1인분만 저장가능 => 자료구조, 자료구조(알고리즘, )
class Tables { 
	ArrayList<Student50> list;
	Iterator<Student50> itr;
	Scanner in;
	public Tables() { //초기화
		list = new ArrayList<Student50>();
		in = new Scanner(System.in);	
	}
	public int windowFor() throws IOException{
		System.out.println("========성적관리시스템========");
		System.out.println("--------------------");
		System.out.println("1.입력 2.삭제 3.편집 4.조회 5.정렬 6.출력 7.종료 ");
		System.out.println("--------------------");
		System.out.println("메뉴를 선택하세요:");
		int ch = 0;
		try {
			ch = Integer.parseInt(in.nextLine());
		}
		catch (NumberFormatException e) {			
		}
		switch (ch) {
		case 1:
			inputInfo();
			return 1;
		case 2:
			delete();
			return 1;
		case 3:
			edit();
			return 1;
		case 4:
			searchAndShow();
			return 1;
		case 5:
			sequencing();
			return 1;
		case 6:
			display();
			return 1;
		case 7:
			System.out.println("프로그램을 종료합니다.");
			in.close();
			return 0;
		default:
			System.out.println("잘못입력하셨습니다.");
			return 1;
		}
	}

	// 1.입력
	public void inputInfo() throws IOException{
		Student50 st1 = new Student50();
		System.out.print("이름을 입력하세요.");
		st1.name = in.nextLine();
		System.out.print("반을 입력하세요.");
		st1.ban = in.nextInt();
		System.out.print("번호을 입력하세요.");
		st1.no = in.nextInt();
		boolean re =false;
		while(!re) { // 데이터보호를 위해서 반복문과 try / catch 사용
			re = true; // 입장시true 로
			do {
				try {
					System.out.print("국어점수를 입력하세요.");
					st1.kor = in.nextInt();
				}catch (NumberFormatException e) {
					System.out.print("숫자로 입력해주세요.");
					re = false;
				}
			} while (st1.kor < 0 || st1.kor >100);
		}
		System.out.print("수학점수를 입력하세요.");
		st1.mat = in.nextInt();
		System.out.print("영어점수를 입력하세요.");
		st1.eng = in.nextInt();
		st1.total = (st1.kor+st1.mat+st1.eng);
		list.add(st1);
	}
	
	// 2.삭제
	public void delete()  { // 이터레이터, 비교함수 사용
		System.out.print("** 삭제하고자 하는 이름을 입력하세요.");
		String inputvalue = in.nextLine();
		itr = list.iterator();
		while (itr.hasNext()) {
			Student50 s = (Student50) itr.next();
			if(s.name.equals(inputvalue)) { // 입력 이름과 데이터가 같은가 비교
				itr.remove(); // 같으면 데이터 삭제
			}
		}
		System.out.println("** 삭제완료 **");
	}
	
	// 3.수정
	public void edit() throws IOException { //IOException 처리
		System.out.print("**수정하고자 하는 이름을 입력하세요.");
		String inputvalue = in.nextLine();
		itr = list.iterator();
		while (itr.hasNext()) {
			Student50 s = (Student50) itr.next();
			if(s.name.equals(inputvalue)) { 
				itr.remove(); 
			}
		}
		inputInfo();
		System.out.println("** 수정완료 **");
	}
	
	// 4.조회
	public void searchAndShow()  { 
		System.out.println("** 검색하고자 하는 이름을 입력하세요.");
		String inputvalue = in.nextLine();
		itr = list.iterator();
		while (itr.hasNext()) {
			Student50 s = (Student50) itr.next();
			if(s.name.equals(inputvalue)) {
				System.out.println("name: " + s.name);
				System.out.println("class_: " + s.ban + " no. " + s.no );
				System.out.println("Korean Score: " + s.kor);
				System.out.println("Math Score: " + s.mat);
				System.out.println("English Score: " + s.eng);
				System.out.println("Total Score: " + s.total);
			}
		}
	}
	
	// 5.정렬
	public void sequencing() throws IOException  { //IOException 처리
		int imsi =0;
		System.out.print("**총 합계점수 순으로 정렬하고 싶으면 1,"
								+ "이름 순으로 정렬하고 싶으면 2를 입력해주세요.");
		do {
			imsi = Integer.parseInt(in.nextLine());
		}while (!(imsi == 1 || imsi == 2));
		if(imsi == 1) {
			Collections.sort(list, new Student50()); // Collections를 상속
			// List, Queue, Set은 Collections 함수사용 (map제외)
			display();
		}else if(imsi == 2)	{
			Collections.sort(list);
			display();
		}
	}
	
	// 6.출력
	public void display() {
		System.out.println("**** 입력된 값들을 출력합니다. ****");
		System.out.println("-----------------------------------");
		// itr = list.iterator();
		// List, Queue, Set
		ListIterator<Student50> itr = list.listIterator();
		while (itr.hasNext()) { // 종료점 확인
		  // Student50 s = (Student50) itr.next(); // 이터레이터 사용시 캐스팅
			Student50 s = itr.next(); // 리스트이터레이터는 캐스팅 없이 사용가능 (단, 리스트형식 일때만 가능)
			System.out.println("이름 :" + s.name);
			System.out.println("반 :" + s.ban + "  번호 : " + s.no );
			System.out.println("국어 :" + s.kor);
			System.out.println("수학 :" + s.mat);
			System.out.println("영어 :" + s.eng);
			System.out.println("합계 : " + s.total);
			System.out.println("-----------------------------------");
		}
	}
}

public class In_sungjuk {
	public static void main(String[] args) throws IOException{
		Tables tb = new Tables() ;
		int i = 0;
		while (true) {
			i = tb.windowFor();
			if(i == 0) {			
			}			
		}
	}
}
