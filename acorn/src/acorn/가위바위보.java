package acorn;

import javax.swing.JOptionPane;

//문제 가위(scissors) 바위(rock) 보(papper) 게임 만들기
//1. 경우의 수를 파악해서 승패 결정하기
//2. 계산에 의한 승패 결정하기
//3. 배열 인덱스를 이용한 승패 결정하기

public class 가위바위보 {
	//  가위:0, 바위:0, 보:0
	//  비김:0, 이김:1, 짐:2
	// 표 : 사용자  0  1  2
	// com   0  0  1  2
	//       1  2  0  1
	//       2  1  0  1
	
	//방법1)경우의 수를 파악해서 승패 결정하기
	public static int doif(int com, int person) {
		if(person==0){
			if(com==0) {return 0;}
			else if(com==1) {return 2;}
			else return 1;
		}
		else if(com==1) {
			if(com==0) {return 1;}
			else if(com==1) {return 0;}
			else return 2;
		}
		else  
			if(com==2) {return 2;}
			else if(com==1) {return 1;}
			else return 0;
	}			
	//방법3)배열 인덱스를 이용한 승패 결정하기 - 결과를 배열로 정의
		public static int doarray(int com, int person){
			int [][] judge = {{0,1,2}, {2,0,1}, {1,2,0}};
			return judge[com][person];
		}				
	//방법2)계산에 의한 승패 결정하기	(함수의 형태를 같게 해야 호환, 3가지 경우로 압축)
	public static int docalc(int com, int person){
		if( com == (person%3) ) { 
			return 0;} //비김	
		// 2 + 1 = 3
		// 0(가위) + 1 == 1(바위)
		// 1(바위) + 1 == 2(보)
		// 2(보)  + 1 == 0 (가위)
		else if( (com+1)%3 == (person%3) ) { 
			return 1;} 
		else {
			return 2;} 	
	}	

	public static void main(String[] args) {
		int input;
		String temp; //문자열
		int count = 0;
		int victory = 0;
		int lose = 0;
		int draw = 0;
	
		while(true){ //반복문 조건문,
			//입력 => 처리 => 출력
			temp = JOptionPane.showInputDialog("[ (가위)=0, (바위)=1, (보)=2, (종료)=3 ]:");
			input = Integer.parseInt(temp);
			int answer = (int)(Math.random() * 100) + 1;
			
			if(input == 3){ //게임을 종료
				System.out.println("\n===게임결과 :" + count + "전 " + victory + "승" + draw +"비김 " +lose + "패. ===");
				break;
			}
			count++;
			
			//not
			if(!(input == 0 || input == 1 || input == 2 || input == 3)){
				System.out.println("잘못 입력하셨습니다. ");
				input = Integer.parseInt(temp);
				count--;
			}			
			else{
				int result = doif(answer%3, input);
				if(result == 0){ draw++; }                                                       
				else if(result == 1){ victory++; }
				else lose++;
			}			
			System.out.println("게임결과: " + count + "전 " + victory + "승 " + draw + "비김" + lose + "패.\n");
		}
	}
}

//결과출력:
//(0입력)
//게임결과: 1전 1승 0비김0패.
//
//(1입력)
//게임결과: 2전 1승 1비김0패.
//
//(2입력)
//게임결과: 3전 1승 1비김1패.
//
////(3입력)
//===게임결과 :3전 1승1비김 1패. ===

