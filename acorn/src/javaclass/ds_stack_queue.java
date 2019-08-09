package javaclass;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ds_stack_queue {
	public static void main(String[] args) {
		Stack st = new Stack();
		
		//부모이기 때문에 Queue에 있는 함수만 적용해서 운용하면 됨
		Queue q = new LinkedList();
		// upcasting 일 때 암묵적으로 캐스팅 작동
		// downcasting은 명시적으로 캐스팅한다.
		LinkedList lt =(LinkedList)q;
		
		st.push("0");
		st.push("1");
		st.push("2"); // push(입력) / pop(출력, 데이터삭제)
		st.push("4"); // 입력성공시 return
		// ArrayList => Vector(벡터는 구현이나 사용하지 마라)
		// Iterable => Collections => Vector => Stack
		System.out.println(st.elementAt(2)); // 수서대로 데이터를 접근
		Enumeration en = st.elements(); // Enumeration
		while(en.hasMoreElements()) {
			System.out.println(en.nextElement());
		}
		q.offer("0"); // return하지 않음
		q.offer("1");
		q.offer("2");
		q.add("100");
		q.offer("3");
		
		System.out.println("= Stack =");	
		while(st.empty()) {
			System.out.println(st.pop());
		}
		
		System.out.println("= Queue =");	
		while(st.empty()) {
			System.out.println(q.poll()); // 삭제, 데이터획득, peek는 삭제안함
		}
	}
}

//결과출력:
//2
//0
//1
//2
//4
//= Stack =
//= Queue =
