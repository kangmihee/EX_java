package acorn;
import javax.swing.JOptionPane;  //Java GUI 패키지
public class Hitnum {

	public static void main(String[] args) {
		int answer = (int)(Math.random() * 100) +1;
		int input = 0;
		// char 한문자 char [] ch 문자열을 처리가능
		String temp = ""; //문자열 class
		int count = 0;
		do{ // GUI 방식의 interface가 출력 => text 입력(입력기본값이 string형)
			count++;
			temp = JOptionPane.showInputDialog("1~100사이의 값 입력 " + "종료는 -1");
			if(temp.isEmpty() || temp.equals("-1")) {
				break;
			}
			System.out.println("입력한 값: " + temp );
			input = Integer.parseInt(temp);
			if(answer > input) {
				System.out.println("숫자가 너무 작습니다. ");
			}else if(answer < input) {
				System.out.println("숫자가 너무 큽니다. ");
			}else {
				System.out.println("정답입니다. ");
				System.out.println("입력하신 횟수는 " +count+"회 입니다." );
				break;
			}
		}while(true); //while과 같은 방법으로 사용
		//1번은 반드시 실행			
	}
}

//출력결과:
//입력한 값: 45
//숫자가 너무 큽니다. 
//입력한 값: 30
//숫자가 너무 큽니다. 
//입력한 값: 20
//숫자가 너무 큽니다. 
//입력한 값: 10
//숫자가 너무 작습니다. 
//입력한 값: 15
//숫자가 너무 큽니다. 
//입력한 값: 12
//숫자가 너무 작습니다. 
//입력한 값: 13
//정답입니다. 
//입력하신 횟수는 7회 입니다.

