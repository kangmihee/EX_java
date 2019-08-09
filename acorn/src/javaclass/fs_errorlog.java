package javaclass;
import java.io.*;
import java.util.Date;

public class fs_errorlog {
	public static void main(String[] args) throws Exception{
		PrintStream ps = null; // 에러의 발향 전환
		FileOutputStream fos = null; // 파일저장
		try {  // FileOutputStream : 파일끝에 내용을 추가한다.		
			fos = new FileOutputStream("c:\\work\\error.log", true);
			ps = new PrintStream(fos);
			System.setErr(ps); // 에러는 원래 표준 err장치로 출력 (모니터)
			
			System.out.println(1);
			System.out.println(2);
			System.out.println(3);
			System.out.println(0/0); // 예외발생 : 프로그램은 계속진행해야한다.
			System.out.println(4); // 실행되지 않는다.
		}catch (Exception ae) { // 에러는 예외처리로 넘어가고 예외처리가 끝나면 블럭 out
			System.err.println("------------------------------");
			System.err.println("예외발생시간 : " + new Date());
			ae.printStackTrace(System.err);
			System.err.println("예외메시지 : " + ae.getMessage());
			System.err.println("------------------------------");
		}
		System.out.println(6); // 예외발생시 catch로 넘어가 예외처리 후 6호출
		method1();
	}
	
	static void method1() throws Exception{
		method2(); // 예외발생시 일단 블록은 탈출함
		System.out.println("1번 메소드");
	}
	static void method2() throws Exception{
		System.out.println("2번 메소드");
		throw new Exception();
	}
}

//출력결과:
//1
//2
//3
//6
//2번 메소드
