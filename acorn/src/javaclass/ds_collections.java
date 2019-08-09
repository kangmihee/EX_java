package javaclass;

import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ds_collections {

	public static void main(String[] args) {
		ArrayList<String> arraylist = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		arraylist.add(scan.nextLine());
		
		arraylist.add("나무");
		arraylist.add("나무");
		arraylist.add("오리");
		arraylist.add("가방");
		
		System.out.println(arraylist.get(0)); //get, set
		Collections.sort(arraylist); //정렬함수
		System.out.println(arraylist.get(0));
		System.out.println(arraylist.get(1));
		// frequency 도수 주파수
		System.out.println(Collections.frequency(arraylist, "나무"));
		// 이진검색 : 정렬후 사용
		System.out.println(Collections.binarySearch(arraylist, "오리"));
		System.out.println(arraylist.get(0));
		System.out.println(arraylist); // to_String 함수 작동(Object)
	}

}

//출력결과:
//(입력):박보검
//박보검
//가방
//나무
//2
//4
//가방
//[가방, 나무, 나무, 박보검, 오리]