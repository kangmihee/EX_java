package javaclass;
import java.io.*;
import java.util.*;

//성적프로그램 : 메뉴방식으로 입력, 수정, 삭제, 조회, 정렬, 종료
//데이터 저장 자료구조 : ArrayList
//수정, 삭제, 조회는 이름만을 대상으로 함
//Comparator, Comparable을 implement한다.
//출력은 toSting을 오버라이딩해서 간편하게 출력합니다.

class Student40 implements Comparator<Student40>, Comparable<Student40>{ 
	String name;
	int kor;
	int mat;
	int eng; 	
	
	public Student40() {}
	Student40(String name,int kor,int mat,int eng){
		this.name=name;
		this.kor=kor;
		this.mat=mat;
		this.eng=eng;
	}	
	public int compareTo(Student40 s) {
		return name.compareTo(s.name);
	}
	public int compare(Student40 s, Student40 s2) {
		return s.kor - s2.kor;
	}
	public String getName() {
		return name;
	}
	public String toString() {
		return "이름:"+ name + "  국어성적:" + kor + "  영어성적:" + eng + "  수학성적:" + mat ; 
	}
}

public class ds2_CRUD_ex {
	public static void main(String[] args) {
		Properties prop = new Properties();
		ArrayList<Student40> student = new ArrayList<Student40>();	
		Scanner scan = new Scanner(System.in);
		String name;
		int kor=0;
		int mat=0;
		int eng=0;
		
		System.out.println("이름, 국어, 영어, 수학 점수를 입력하시오.");
		for(int i=0;i<3;i++) {
			System.out.print("이름: ");
			name=scan.nextLine();
			System.out.print("국어 점수: "); 
			kor=scan.nextInt();
			System.out.print("수학 점수: ");
			mat=scan.nextInt();
			System.out.print("영어 점수: ");
			eng=scan.nextInt();
			scan.nextLine();	
			Student40 st = new Student40();
			st.name=name;
			st.kor=kor;
			st.mat=mat;
			st.eng=eng;
			student.add(st);
		}
							
		Iterator<Student40> itr = student.iterator();
		System.out.println();
		System.out.println("학생 성적데이터: ");
		while(itr.hasNext()) {
			Student40 s = (Student40)itr.next();
			System.out.println(s.toString());
			prop.setProperty(s.name, s.toString());
		}
		System.out.println();
		
		ListIterator<Student40> litr = student.listIterator();
		Student40 element = null;
		int scannum;
		while(true){
			System.out.println();
			System.out.println("숫자를 입력하세요. 추가:1  삭제:2  수정:3  조회:4  정렬:5  종료:6");
			scannum = scan.nextInt();
			if(scannum==1) {
				//입력
				while(litr.hasNext()) {
					element = litr.next();
					
					if(element.name.equals("차은우")) {
						litr.add(new Student40("강미희", 95, 85, 75));
					}
				}
				System.out.println("강미희 학생이 새로 추가되었습니다.");
			}
			
			else if(scannum==2) {
				//삭제
				litr = student.listIterator();
				while(litr.hasNext()) {			
					element = litr.next();
					if(element.name.equals("차은우")) {
						litr.remove();
					}
				}			
				System.out.println("차은우 학생이 삭제 되었습니다.");
			}
			
			else if(scannum==3) {
				//수정
				litr = student.listIterator();
				while(litr.hasNext()) {
					element = litr.next();
					if(element.name.equals("박보검")) {
						litr.set(new Student40("박보검", 100, 100, 100));
					}	
				}		
				System.out.println("박보검 학생의 성적이 수정되었습니다.");
			}
			
			else if(scannum==4) {
				//조회
				System.out.println("학생 성적데이터 확인:");
				itr = student.iterator();
				while(itr.hasNext()) {
					element = itr.next();
					System.out.println(element.toString());
				}
			}
			
			else if(scannum==5) {
				//정렬
				Collections.sort(student);
				System.out.println("이름순 정렬: ");
				for(Student40 a : student) {
					System.out.println(a.getName()+ "   ");
				}
			}
			else if(scannum==6) {
				break;		
			}
			else
				System.out.println("다시 입력해 주세요.");		
		}
		System.out.print("종료되었습니다.");				
	}
}
