package acorn;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class odd_even {
	public static void main(String[] args) { // static : 인스턴스 없이 실행
		//문제. 홀짝게임 = turn around 게임, 상대를 결정, 사람: 입력, 컴퓨터 : random		
		int count =0;  int win = 0;  int loss = 0;
		Scanner scan = new Scanner(System.in);
		for(;;){ // 무한루프...종료점이 없어서 break입력으로 종료시켜준다.
			System.out.println("0(짝)"
					+ ", 1(홀)을 입력하세요.");
			// Integer.parseInt : 형변환
			int person = Integer.parseInt(scan.nextLine()); //문자로 입력
			if( person == 9 ) break; // break : for문을 강제로 종료시킴
			int com = (int)(Math.random() *2); // Math : static method 들의 모임
			if( person%2 == com ){
				win+=1;
				System.out.println("맞추었습니다. ");
			}else{
				loss+=1;
				System.out.println("틀렸습니다. (오백원) ");
			}
			count +=1;
		}
		System.out.println("총게임횟수는 = " + count + "전 : " + win +"승 : "+ loss +"패 입니다. ");
	}
}

//결과출력:
//0(짝), 1(홀)을 입력하세요.
//0(입력값)
//맞추었습니다. 
//0(짝), 1(홀)을 입력하세요.
//1(입력값)
//틀렸습니다. (오백원) 
//0(짝), 1(홀)을 입력하세요.
//1(입력값)
