package javaclass;
//자료구조 : 데이터를 저장하는 구조
//저장형태에 따라 구분방법
	//stack : LIFO, FILO
	//Queue : FIFO 대기열 : memory, printer의 속도차

//데이터 저장방법 
	//배열/list/hash(hash함수: 키를 주소값 mapping하는 함수)

	//1)배열 : 연속적인 메모리 공간에 저장, 삽입삭제가 불량
	//2)list : 데이터의 앞이나 뒤에 다음데이터의 주소를 붙임
		//메모리 공간은 낭비하지만, 메모리를 효율적으로 사용가능
		//삽입, 삭제 용이
	
	//3)hash함수 : 검색속도가 가장 빠름(연관메모리)
		//저장형태 : 키이 + 데이터 형식, 키이를 주소값으로 변환

//프로그램 발전 형태
//구조적 프로그래밍 -> 객체 지향 프로그래밍 -> 일반화 프로그래밍 -> 함수화 프로그래밍
//순서적으로 실행   -> 데이터 + 함수
//  			    -> 오버로딩과 오버라이딩 -> 대표타입사용 (T타입...모든타입으로 사용가능하다)
//					-> 함수이름은 같은데  ( T -> int, T -> float )
//						T add(T a, T b){ 
//								return a + b; }

//Collection => oracle에서도 Collection
//자바의 자료구조 = 상속 + Generic 을 이용해서 작업
// Iterable (반복자) => COllection => List, Queue, Set



import java.util.*;
public class ds_linked {

	public static void main(String[] args) {
		Vector<String> v = new Vector<String>(); //문자열을 담는 백테로 정의
		
		//메모리 + 함수
		v.add("대한"); //iterator 주소만 배열식으로 저장
		v.add("민국");
		v.add("만세");
		
		Iterator<String> itr = v.iterator(); //Iterator(반복자)
		//reference 복사, 주소복사
		while(itr.hasNext()){ 
			System.out.println(itr.next()); //순서적으로 데이터를 처리하도록 인덱스
								//next()는 자신이 가리키는 데이터저장소에서 현재위치를 순차적으로 하나 증가해서 이동하는 것
		}
		ArrayList<String> list = new ArrayList<String>();
		v.add("대한"); 
		v.add("민국");
		v.add("만세");
		System.out.println(list);
		
		Iterator itr_list = list.iterator();
		while(itr_list.hasNext()){ 
			System.out.println(itr_list.next()); 
		}
		for(String obj:v){ //for in
			System.out.println(obj);
		}
		for(int i=0;i<v.size();i++){ //종료값은 size로
			System.out.println(v.get(i)); //get 함수를 이용한 요소 접근 
		}
		
		//람다함수 전, 자바에서 함수를 사용하려면 : 반드시 Class를 이용
		//foreach문 다음에는 함수
		//lambda함수 - python개념 : 무영함수
		//(int a, int b) -> {return a+b;}
		//javascript - web browser에서 작동하는 script : 웹에 동적 효과 부여
		System.out.println("foreach문 사용 :"); //함수화 프로그래밍
			v.forEach(a->{ 
				System.out.println(a);
				//문자열은 기본이 포인터 (1차원 배열, 배열은 기본포인터)
			});
		System.out.println(" foreachRemainimg() :");
		Iterator<String> itr_2 = v.iterator();
		itr_2.forEachRemaining(a->{
			System.out.println(a);
		});	
	}
}

//출력결과:
//대한
//민국
//만세
//[]
//대한
//민국
//만세
//대한
//민국
//만세
//대한
//민국
//만세
//대한
//민국
//만세
//foreach문 사용 :
//대한
//민국
//만세
//대한
//민국
//만세
// foreachRemainimg() :
//대한
//민국
//만세
//대한
//민국
//만세

