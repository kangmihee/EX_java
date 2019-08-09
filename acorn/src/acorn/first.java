package acorn;
//예약어
//모든 프로그램은 함수로 작성
//순차적으로 실행
//순서를 변경 : 조건문, 반복문, 함수
//함수는 리턴값과 매개면수로 구성
// void : 리턴값이 없음
// static : 정적함수 , static 쓰면 instance 하지않고도 사용가능
// instance : 클래스를 실행시키기 위해 메모리를 만드는 것

public class first {
	public static void main(String[] args) { //프로그램 진입점 //함수선언 
		
		System.out.println("대한민국"); //문장종료점
		System.out.println("서울시");
		
		//변수선언
		byte iByte = 10;
		short iShort = 10;
		int iInt = 10;
		long iLong = 10;
		int tmp = iByte;
		
		//형변환 : casting...공간유지위해 데이터타입 변환
		byte tmp2 = (byte)iInt;
		
		//부동소수점 표현
		float  num1 = 10.1f;
		double num2 = 10.1d;
		double num3 = 10.1;
		
		//국어 영어 점수를 90점 100점으로 입력하는 변수를 생성하고 두수를 더해서 result 변수에 입력
		//평균은 average에 입력
		//평균을 출력하시오
		
		int kor = 90;
		int eng = 100;		
		int result = kor + eng;
		float average = result/2.0f;		
		System.out.println("평균 :"+average);
				
		char ch1 ='a';
		char ch2 ='1'; //숫자와 문자를 구분 mapping 숫자1은 49 숫자0은 48
		System.out.println(ch1);
		System.out.println(ch2);
		
		int code1 =ch1;
		int code2 =ch2;
		System.out.println(code1); // 97:a, 98:b ... 오름차순으로 정렬
		System.out.println(code2); // 49:1 ... 숫자1은 49코드값으로
		
		String name = "에이콘아카데미"; //문자열
		System.out.println(name);
	}
}

//출력결과:
//대한민국
//서울시
//평균 :95.0
//a
//1
//97
//49
//에이콘아카데미

