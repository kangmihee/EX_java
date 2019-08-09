package javaclass;
import java.util.*;
// HashMap : key + data
// 반복자가 없음 : set을 사용
// set => iterator => colloection => set
// HashMap, treeSet, Linkedhashset
// 키를 이용해서 검색
// 동기화를 지원하지 않음
// HashMap(1.2버전) : Hashtable -> HashMap
// 빠르다,, null 데이터를 허용, iterator 사용

public class ds_hashmap {
	public static void main(String[] args) {
		HashMap hm = new HashMap(); // 검색속도가 빠름, 처리불편(set 이용)
		
		hm.put("소득", new Double(3434.34)); // hash 함수 => 주소
		hm.put("체중", new Double(123.22));
		hm.put("저축", new Double(1345.00));
		hm.put("나이", new Double(39.22));
		hm.put("대출", new Double(-19.08));
		// 중복을 불허하는 키 => set, map 하고 동지
		
		Set set = hm.entrySet(); // 키이 값만 별도로 가지고 옴
		Iterator i = set.iterator(); // set은 Iterator을 상속받음
		while(i.hasNext()) {
			//casting이 필요
			Map.Entry me = (Map.Entry)i.next(); // 셀이 가리키는 구조를 모름
			System.out.print(me.getKey()+": "); //  키값 획득
			System.out.println(me.getValue()); // 데이터 획득
		}
		
		//키이데이터 타입을 가진
		Iterator<String> keys = hm.keySet().iterator();
		while(keys.hasNext()) {
			String key = keys.next();
			System.out.println(String.format("키 : %s, 값 : %s", key, hm.get(key)));
		}
//		for(Map.Entry<String, Double> elem : hm.entrySet()) {
//			System.out.println(String.format("키 : %s, 값 : %s", elem.getKey(),elem.getValue()));
//		}
		
		// 데이터 검색
		// map은 키가 중복불허
		double balance = (Double)hm.get("소득"); // 3434.34
		hm.put("소득", 2000); // 값입력 //키중복불허, 값을변경
		hm.put("소득", new Double(balance + 1000)); // 3434.34 + 1000 = 4434.33
		System.out.println("소득 new balance: " + hm.get("소득"));
		System.out.println(set); // []대괄호로 출력, to_String을 오버라이딩
		System.out.println(hm); // {}중괄호로 출력
	}
}

//결과출력:
//체중: 123.22
//소득: 3434.34
//나이: 39.22
//대출: -19.08
//저축: 1345.0

//키 : 체중, 값 : 123.22
//키 : 소득, 값 : 3434.34
//키 : 나이, 값 : 39.22
//키 : 대출, 값 : -19.08
//키 : 저축, 값 : 1345.0

//소득 new balance: 4434.34
//[체중=123.22, 소득=4434.34, 나이=39.22, 대출=-19.08, 저축=1345.0]
//{체중=123.22, 소득=4434.34, 나이=39.22, 대출=-19.08, 저축=1345.0}

