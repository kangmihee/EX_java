package javaclass;
import java.util.Iterator;
import java.util.LinkedList;
// linked list => 데이터의 앞뒤에 다음, 잊ㄴ 데이터의 주소값으로 붙음
// 주소를 저장하는 포인터의 사이즈만큼 기억공간은 낭비
// 반복자 사용, Collection 함수를 동일이름으로 사용가능
// 저장구조는 포인터가 앞귀에 붙음
// 순서적으로 접근하는데 필요한 interface가 있음
// Iterable -> Collection -> List -> AbstractList sequentiaiList 구현
// -> LinkedList

public class ds_linkedlist {

	public static void main(String[] args) {
		Dept d1 = new Dept(10, "ACCOUNTNG", "NEWYORK");
		Dept d2 = new Dept(20, "RESEARCH", "DALLAS");
		Dept d3 = new Dept(30, "SALES", "CHICAGO");
		Dept d4 = new Dept(40, "OPERATIONS", "BOSTION");
		
		LinkedList<Dept> al = new LinkedList<Dept>();
		al.add(d1);
		al.add(d2);
		al.add(d3);
		al.add(d4); //저장하는 방법만 다름
		Iterator<Dept> itr = al.iterator();
		while(itr.hasNext()){ 
			System.out.println(itr.next()); 
		}
		
		LinkedList<Dept> al2 = new LinkedList<Dept>();
		al2.add(d1);
		al2.add(d2);
		al2.addAll(al2);
		// 삽입삭제가 잘됨
		al.addFirst(d1);
		al.addLast(d2);
		al.removeFirst();
		al.removeLast();
		al.removeFirstOccurrence(d1);
		al.removeLastOccurrence(d2);
		
		al.clear();
		//거꾸로 순회하고 싶을 경우
		Iterator reverse_itr = al.descendingIterator();
		while(reverse_itr.hasNext()){
			System.out.println(reverse_itr.next()); 
		}
	}
}

//출력결과:
//javaclass.Dept@6aaa5eb0
//javaclass.Dept@3498ed
//javaclass.Dept@1a407d53
//javaclass.Dept@3d8c7aca

