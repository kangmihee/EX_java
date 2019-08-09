package javaclass;
import java.io.*;
import java.util.*;

// 문제 : 입력되는 문자열을 stack을 이용해서 거꾸로 출력하시오

public class ds2_stack_reverse {
	static Stack<String> input(String s){
		Stack<String> st = new Stack<String>();
		for(int i=0; i<s.length();i++) {
			st.push((String.valueOf(s.charAt(i)))); // 문자열함수 : 위치문자 출력, 문자
		}
		return st;
	}
	static void output(Stack<String> st){
		Iterator it = st.iterator();
		while(it.hasNext()){
			System.out.println(st.pop()); 
		}
	}
	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("역순으로 출력할 문자열을 입력하세요.");
		System.out.println("==>   ");
		String temp = "";
		try {
			temp = in.readLine();
		}catch(Exception e) {
			System.out.println("에러발생");
		}
		output(input(temp)); // 출력 input(입력)
	}
}

//출력결과:
//역순으로 출력할 문자열을 입력하세요.
//==>   
//차은우
//우
//은
//차