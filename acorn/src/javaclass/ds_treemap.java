package javaclass;
import java.util.*;
public class ds_treemap {

	public static void main(String[] args) {
		TreeMap tm = new TreeMap();
		tm.put("강남", new Double(3434.34));
		tm.put("강북", new Double(123.22));
		tm.put("종로", new Double(1378.00));
		tm.put("서초", new Double(99.22));
		tm.put("고려", new Double(-19.08));
		
		Set set = tm.entrySet();
		Iterator i = set.iterator();
		while(i.hasNext()) { // 순서가 의미없음
			Map.Entry me = (Map.Entry)i.next();
			System.out.print(me.getKey() + ": ");
			System.out.println(me.getValue());		
		}
		System.out.println();
		// 검색의 문제점 => 찾는 데이터가 없으면 에러발생
		try {
			double balance = ((Double)tm.get("강남")).doubleValue();
			tm.put("강남", new Double(balance + 1000));
		}
		catch (Exception e) {
			System.out.println("찾는 데이터가 없습니다.");
		}
		System.out.println("강남: " + tm.get("강남"));		
	}
}

//결과출력:
//강남: 3434.34
//강북: 123.22
//고려: -19.08
//서초: 99.22
//종로: 1378.0
//종로: 1378.0
//
//강남: 4434.34
