package javaclass;
import java.util.Vector;
// Enum : 범주형 변수 ( 변수 : 양정, 질적( 상, 중, 하, ) ) : 숫자로도 매핑
// Enumeration : 단방향 이터레이터
// LinkedHashSet( 입력순서를 보장 ) : TreeSet(정렬)
// unique elements만 저장가능
import java.util.Enumeration; //Enumeration은 단방향만 가능 //iterator 비교(양방향)
import java.util.Iterator;
import java.util.LinkedHashSet;
enum Season { SPRING, SUMMER, FALL, WINTER } // 숫자로도 사용가능, 문자로도 사용가능
public class ds_enumeration {

	public static void main(String[] args) {
		Enumeration days;
		Vector daynames = new Vector();
		daynames.add("Sunday");
		daynames.add("Monday");
		daynames.add("Tuesday");
		daynames.add("Wednesday");
		daynames.add("Thursday");
		daynames.add("Friday");
		daynames.add("Saturday");
		days = daynames.elements();
		while (days.hasMoreElements()) {
			System.out.println(days.nextElement());
		}
		Season currentSeason = Season.SPRING;
		if(currentSeason == Season.SPRING) {
			System.out.println("OOPS!");
		}
		
		// HashSet, TreeSet, LinkedHashSet 
		
		LinkedHashSet<String> set = new LinkedHashSet(); //입력순서대로 출력
		set.add("One");
		set.add("Two");
		set.add("Three");
		set.add("Four");
		set.add("Five");
		Iterator<String> i = set.iterator();
		while(i.hasNext())
		{
			System.out.println(i.next());
		}		
	}
}

//출력결과:
//Sunday
//Monday
//Tuesday
//Wednesday
//Thursday
//Friday
//Saturday
//OOPS!
//One
//Two
//Three
//Four
//Five