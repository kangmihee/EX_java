package acorn;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//if else if else
//switch / case문

public class control2 {

	public static void main(String[] args) throws IOException { //throws IOException...예외처리해줘야 에러안남
		//class의 매개변수 클래스를 인스턴스해서 전달...new InputStreamReader(System.in)
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		//문자열 입출력은 무조건 문자열
		String imsi = in.readLine(); //문자열 String값으로 입력
		int score = Integer.parseInt(imsi); //숫자로 변환
		char grade = ' '; //공백도 문자임
		switch (score/10) { //if문 사용할 때는 비교연산자
		case 10:
		case 9:
			grade = 'A';
			break;
		case 8:
			grade = 'B';
			break;
		case 7:
			grade = 'C';					
		case 6:
			grade = 'D';			
		default: //나머지 예는 default로 처리
			grade = 'F';
		}
		System.out.println("등급= " + grade + "등급");	
			
		//문제. 작업시간을 입력받아서 5000시간이 넘어가면 100, 아닌경우는 시급80으로 계산하는 프로그램을 작성하시오.(if문 사용)
		String time1 = in.readLine(); 
		int time2 = Integer.parseInt(time1); 
		if(time2 > 5000){
			System.out.println("급여: " + time2*100 + "원");
			}
			else
				System.out.println("급여: " + time2*80 + "원");
		
		//다른방법.
		int pay;
		int hours;
		Scanner input = new Scanner(System.in);
		hours = input.nextInt();
				
		System.out.println("시간을 입력하시오 : ");
		
		if(hours>5000)
		{
			pay = hours * 100;
			//format문자열 d: digit, s:string
			//escape문자열 - 특별한 문자
			//newline = 엔터를입력한것과 같은 효과 
			//printf : format 문자열 
			System.out.printf("임금은%d입니다.\n", pay); //c와 호환하기위해		
		}
		else
		{
			pay = hours * 80;
			System.out.printf("임금은%d입니다.\n", pay);
		}
		
		//반복횟수, 값을 이용하는 방법
		//반복문 1부터 10까지의 합 : 증가변수와 누적변수
		int sum = 0; //누적변수  sum = sum + i 변수가옴
		int i = 0;  //증가변수 i = i + 1 상수가 옴
		int count = 0;  //실행홧수
		for(i=0;i<=10;i++){ //초기값, 한계값, 증가값
			sum += i; //누적
			// 1 2 3  4  5  6  7  8  9 10 
			// 1 3 6 10 15 21 28 36 45 55			
			count +=1;		
		}
		System.out.println("i값은= " + i ); //출력:11
		System.out.println(i-1 + " 까지의 합은= " + sum); //출력:55
		System.out.println("횟수= " + count); //출력:11
				
		//이중 for문 = 현실적데이터는 행렬이뤄짐
		for(i=2;i<=9;i++){ //2 3 4 5 6 7 8 9 => 8번
			for(int j=1;j<=9;j++){ //1 2 3 4 5 6 7 8 9 => 9번				
				//총 78번 돌아감				
				System.out.println(i +" * "+ j +" = "+ i*j);
			}
		}	
		//
		for(i=1;i<=3;i++)
			for(int j=1;j<=3;j++)	
				for(int k=1;k<=3;k++)	
					System.out.println(""+i+j+k);		
		//
		i=10;
		//while문은 횟수를 지정할 수 없을때, 종료조건만 알고 잇을 때 사용한다.
		while(i>=0) { //조건이 참일 때까지 반복, 주로 무한루프
			System.out.println(i--);
		}
		
		//문제. while문으로 구구단 만들기
		i=1;
		while(i<=9){
			int j=1;
			while(j<=9){			
				System.out.println(i +" * "+ j +" = "+ i*j);
				j++;
			}
			i++;							
		}				
	}
}

//결과출력:
//90(입력값)
//등급= A등급
//50(입력값)
//급여: 4000원
//10(입력값)
//시간을 입력하시오 : 
//임금은800입니다.
//i값은= 11
//10 까지의 합은= 55
//횟수= 11

// 구구단 2단 ~ 9단 출력
// 111 ~ 333 출력
// 10 ~ 0 출력
// 구구단 1단 ~ 9단 출력
