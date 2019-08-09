package acorn;
import java.util.Scanner; //입력을 위한 패키지
public class control {
	public static void main(String[] args) {
		// 조건문
		int visitCount = 0;
		if (visitCount < 1) {
			System.out.println("조건일치");
		}
		System.out.println("다음 순서로 진행 ");
		
		//점수를 등급으로 나타내기
		int grade;
		Scanner input = new Scanner(System.in);	//클래스로 만들기위해서 import 시켜준다	
		System.out.println("점수를 입력하시오.");
		grade = input.nextInt();
		if(grade>=90)
			System.out.println("A");
		else if(grade>=80)
			System.out.println("B");
		else if(grade>=70)
			System.out.println("C");
		else if(grade>=60)
			System.out.println("D");
		else 
			System.out.println("F");
						
		//문제. 2수를 입력받고 큰 수를 출력하시오.	
		int num1;
		int num2;		
		System.out.print("첫번째 수:");
		num1 = input.nextInt();
		System.out.print("두번째 수:");
		num2 = input.nextInt();
			if(num1>num2)
				System.out.println("큰 수:"+num1);
			else 
				System.out.println("큰 수:"+num2);
			
		//문제. 국어 영어 점수를 입력받고 두 수를 더한 다음 평균을 출력하시오.		
		int kor;
		int eng;
		float result;
		System.out.print("국어 점수:");
		kor = input.nextInt();
		System.out.print("영어 점수:");
		eng = input.nextInt();
		result = kor+eng;
		System.out.println("평균 값:" + result/2.0f);
		
		//대입 연산자
		int num =10;
		num +=2; // num = num + 2 // 증가연산자 => 연산의 결과값은 누산기
		num -=2; // num = num - 2
		num *=4; // num = num * 4
		num /=2; //나누기
		num %=6; //나머지 연산자 , 경우의 수를 만들기 위해서 사용
		// 어떤 수가 들어오더라도 3가지 경우로 만들 경우
		
		//문제. 점수를 입력받고 홀수 인지 짝수인지를 출력하시오.
		//for(초기값; 한계값; 증가값)
		for(int i=0; i<10; i++){ //횟수를 카운트하거나 숫자를 이용하거나			
			num = input.nextInt(); // i = i+1
			if(num % 2 == 0)
				System.out.println("짝수 입니다.");
			else 
				System.out.println("홀수 입니다.");
			}

		//문제.
		//홀짝게임 
		//turn around 게임
		//상대를 결정, 사람: 입력, 컴퓨터 : random
	}	
}	

//출력결과:
//조건일치
//다음 순서로 진행 
//점수를 입력하시오.
//
//100
//A
//첫번째 수:50
//두번째 수:30
//큰 수:50
//국어 점수:90
//영어 점수:80
//평균 값:85.0
//5
//홀수 입니다.
//2
//짝수 입니다.

