package acorn;

//클래스 base로 작업하면...
//객체화 : user(사용자), com(입력), judge(심판)
//문제 : 클래스 베이스로 가위바위보게임을 구현하시오.

import javax.swing.JOptionPane;

class User{ //숫자입력 선택 //멤버변수 + 멤버함수
	int input = 0;
	String temp ="";

	User(){}
	User(int input){		
		this.input =input;	
	}
	public int getUser(){
		temp = JOptionPane.showInputDialog("[ (가위)=0, (바위)=1, (보)=2, (종료)=3 ]:");
		if(temp == null || temp.equals("3"))
			return 3;	
		System.out.println("입력한 값: " + temp);
		input = Integer.parseInt(temp);
		return input;
	}
}

class Com{	
	private int answer;
	Com() {
		answer =0;
	}
	Com(int answer){
		this.answer = answer;
	}
	public int getComputer(){
		answer = ((int)(Math.random() * 100 )) % 3;
		return answer;
	}
}

class Judge{ //승패를 결정, 결과를 가지고 있어야함(저장), 게임결과 출력
	int victory;
	int lose;
	int draw;
	int count;
	
	Judge() {
		victory = 0;
		lose = 0;
		draw = 0;
		count = 0;
		System.out.println("게임이 초기화 되었습니다.");
	}
	
	public static int doarray(int com, int user){
		int [][] judge = {{0,1,2}, {2,0,1}, {1,2,0}};
		return judge[com][user];
	}	
		
	//함수나 클래스 : 어떤 데이터를 처리할 것인지, 처리한 다음 어떤 데이터를 리턴할 것인지
	public void gamdicidion(int com, int user){
		
		int result = doarray(com, user);
		count++;
		if(result==0){
			System.out.println("비김");
			draw++;
		}else if(result==1){
			System.out.println("이김");
			lose++;
		}else{
			System.out.println("짐");
			victory++;
		}
		print();
	}
	public void print(){
		System.out.println("게임결과: " + count + "전 " + victory + "승 " + draw + "비김 " + lose + "패.\n");
	}
}


public class 가위바위보클래스 {
	public static void main(String[] args) {
		
		Com com = new Com();
		User user = new User();
		Judge jud = new Judge();
		
		while(true){
		int sel = user.getUser();
		if(sel == 3){
			jud.print();
			System.out.println("게임이 종료되었습니다.");
			break;
		}
		jud.gamdicidion(com.getComputer(), sel);
		}
	}
}

//결과출력:
//게임이 초기화 되었습니다.
//입력한 값: 0
//비김
//게임결과: 1전 0승 1비김 0패.
//
//입력한 값: 2
//이김
//게임결과: 2전 0승 1비김 1패.
//
//게임결과: 2전 0승 1비김 1패.
//
//게임이 종료되었습니다.

