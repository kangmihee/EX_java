package acorn;
import java.util.Random;
import java.util.Scanner; 
//문제 가위(scissors) 바위(rock) 보(papper) 게임 만들기
//1. 경우의 수를 파악해서 승패 결정하기
//2. 계산에 의한 승패 결정하기
//3. 배열 인덱스를 이용한 승패 결정하기

public class Game {
	public static void main(String[] args) {
		int scannum;
		int rannum = (int)(Math.random()*3%3);
		
		Scanner input = new Scanner(System.in);
		System.out.println("숫자를 입력하세요. 가위:0  바위:1  보:2");
		scannum = input.nextInt();
				
		//방법1)
		switch (scannum) {
		case 0:
			if(rannum==0){
				System.out.println("비겼습니다.");
			}else if(rannum==1){
				System.out.println("졌습니다.");
			}else if(rannum==2){
				System.out.println("이겼습니다.");
			}break;	
			
		case 1:
			if(rannum==0){
				System.out.println("이겼습니다.");
			}else if(rannum==1){
				System.out.println("비겼습니다.");
			}else if(rannum==2){
				System.out.println("졌습니다.");
			}break;	
			
		case 2:
			if(rannum==0){
				System.out.println("졌습니다.");
			}else if(rannum==1){
				System.out.println("이겼습니다.");
			}else if(rannum==2){
				System.out.println("비겼습니다.");
			}break;	
		default:
			break;
		}
	}
	
	//방법2)계산에 의한 승패 결정하기
	//    가위:0, 바위:0, 보:0
	//    비김:0, 이김:1, 짐:2
	//    함수의 형태를 같게 해야 호환
	public static int docalc(int com, int person){
		if(com == (person %3)) {
			return 0; //비김
		}
		else if((com+1) == (person %3)) {
			return 2; //짐
		}
		else
			return 1; //이김		
	}
	
	//방법3)배열 인덱스를 이용한 승패 결정하기
	public static int doarray(int com, int person){
		int [][] judge = {{0,1,2}, {2,0,1}, {1,2,0}};
		return judge[com][person];
	}	
}

//출력결과:
//숫자를 입력하세요. 가위:0  바위:1  보:2
//0(입력값)
//이겼습니다.

