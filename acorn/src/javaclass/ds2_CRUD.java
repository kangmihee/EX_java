package javaclass;
import java.util.*;

// CRUD
// 데이터 저장 자료구조 : ArrayList
// 수정, 삭제, 조회는 이름만을 대상으로 함
// Comparator, Comparable을 implement한다.
// 출력은 toSting을 오버라이딩해서 간편하게 출력합니다.
// List의 하위객체들 : ArrayList, ListIterator, Vector, Stack
// ListIterator와 Iterator 차이점:
// list에서 삽입 수정등의 작업을 할 때는 ListIterator 가 더 편리...(캐스팅을안해줘도 되서?)
// ArrayList를 이용하여 삽입 삭제 수정 하는 방법에 대하여

public class ds2_CRUD {
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		System.out.println("추가:  ");
		al.add("C");
		al.add("A");
		al.add("E");
		al.add("B");
		al.add("D");
		al.add("F");
		System.out.print("출력:  ");
		
		Iterator<String> itr = al.iterator();
		while(itr.hasNext()) {
			Object element = itr.next();
			System.out.print(element + "  ");
		}
		System.out.println();
		
		// ListIterator는 리스트에서만 사용 가능
		// 삽입, 삭제가 용이하도록
		// Iterator -> Collections(Iterator) -> List(ListIterator) -> ArrayList
		
		ListIterator<String> litr = al.listIterator();
		String element = null;
		
		
		////// 수정
		while(litr.hasNext()) {
			element = litr.next();
			litr.set(element + "+");
		}		
		System.out.print("수정:  ");
		itr = al.iterator();
		while(itr.hasNext()) {
			element = itr.next(); // 요소값을 확인
			System.out.print(element + "  ");
		}
		System.out.println();
		
		
		////// 삭제
		litr = al.listIterator();
		while(litr.hasNext()) {
			element = litr.next();
			if(element.equals("E+")) { // 원하는 데이터 삭제
				litr.remove();
			}
		}			
		System.out.print("삭제:  ");
		itr = al.iterator();
		while(itr.hasNext()) {
			element = itr.next();
			System.out.print(element + "  ");
		}
		System.out.println();

		
		////// 삽입
		System.out.print("삽입:  ");
		litr = al.listIterator();
		int i = 0;
		while(litr.hasNext()) {
			element = litr.next();
			if(element.equals("B+")) {
				litr.add("TF");
				// al.add(litr.previousIndex(), "Z");
			}
			i++;
		}
		itr = al.iterator();

		
		////// 역으로
		while(itr.hasNext()) {
			element = itr.next();
			System.out.print(element + "  ");
		}
		System.out.println();
		System.out.print("역으로:  ");
		while(litr.hasPrevious()) {
			element = litr.previous();
			System.out.print(element + "  ");
		}
		System.out.println();
	}
}

//출력결과:
//추가:  
//출력:  C  A  E  B  D  F  
//수정:  C+  A+  E+  B+  D+  F+  
//삭제:  C+  A+  B+  D+  F+  
//삽입:  C+  A+  B+  TF  D+  F+  
//역으로:  F+  D+  TF  B+  A+  C+  

