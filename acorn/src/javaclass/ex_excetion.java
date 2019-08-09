package javaclass;

public class ex_excetion {
	public static void main(String[] args) {
		//내포된 try문을 사용하는 것도 가능
		try { //crawling : naver
			//int data = 100 / 0;
			int a[] = new int[5];
			//a[5] = 30/0; //작동x
			  a[4] = 30/0; //작동o
		}	
		// 상속구조로 이루어져 있음
		// throwable 최상위 오브젝트
		// Exception / Error
		// RuntimeException		
		catch(ArithmeticException e) { System.out.println(e); }
		catch (ArrayIndexOutOfBoundsException e) 
		{
			System.out.println("ArrayIndexOutOfBounds Exception occurs");
		}			
		catch(Exception e) { System.out.println(e); }
		
		// 시스템 자원을 요구하는 명령을 해제하기 위해 사용
		// 파일오픈은 반드시 colse해줘야 함 == os에 부담주고
		// 자바에서 데이터베이스에 접속(20개 접속)
		finally {System.out.println("finally block os always executed");}
				
		// 예외처리는
		// 1)계속되어야 한다
		// 2)범위가 구체적인 것부터 지정해야한다.
		// 3)Exception은 ArithmeticException 보다 뒤에 와야한다
		// 4)ArithmeticException 는 사용자가 강제로 예외를 발생시킨다.
	}
}

//출력결과:
//java.lang.ArithmeticException: / by zero
//finally block os always executed

