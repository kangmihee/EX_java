package javaclass;
// Collections 함수 : List, Queue, Set
// Map
import java.util.*;
public class ds_Collection_Map {

	   public static void main(String[] args) {
	      List a1 = new ArrayList(); // 배열 -> 데이터를 일괄처리
	      a1.add("자라");
	      a1.add("고래");
	      a1.add("피래미");
	      System.out.println(" ArrayList elements ");
	      System.out.println("\t" + a1);
	      
	      //LinkedList
	      List l1 = new LinkedList(); // 리스트 : 삽입 삭제 처리시 양호
	      l1.add("자라");
	      l1.add("고래");
	      l1.add("피래미");
	      System.out.println();
	      System.out.println(" LinkedList elements ");
	      System.out.println("\t" + l1);
	      
	      //HashSet
	      Set s1 = new HashSet(); // 데이터를 중복시키지 않을 때 좋음
	      s1.add("자라");
	      s1.add("고래");
	      s1.add("피래미");
	      System.out.println();
	      System.out.println(" Set Elements ");
	      System.out.println("\t" + s1);
	      
	      //HashMap
	      Map m1 = new HashMap(); // 검색할 때 암호
	      m1.put("자라", "8"); // 입력이 put
	      m1.put("고래", "31");
	      m1.put("피래미", "12");
	      m1.put("홍어", "14");
	      System.out.println();
	      System.out.println(" Map Elements ");
	      System.out.println("\t" + m1);
	   }
	}

//출력결과:
//ArrayList elements 
//	[자라, 고래, 피래미]
//
//LinkedList elements 
//	[자라, 고래, 피래미]
//
//Set Elements 
//	[자라, 피래미, 고래]
//
//Map Elements 
//	{자라=8, 피래미=12, 고래=31, 홍어=14}
