package acorn;
public class arrary_test {
	public static void main(String[] args) {
		int sum = 0;
		float average = 0f; 
		              // 0,  1,  2,   3,  4  인덱스
		int[] score = {100, 88, 100, 100, 90}; //배열초기화시는 중괄호 사용
		
		for (int i=0;i<score.length;i++){ //횟수와 값 => 배열 인덱스
			sum += score[i]; //인덱싱 에러가 많이 발생
		}		
		//for in 문
		//인덱싱 에러가 발생하지 않음, x데이터 자체가 된다
		for (int x : score){ //데이터 요소를 하나 변수에 대입하면서 처리
			sum += x;
		}	
		average = sum/score.length;
		System.out.println("합계는: " + sum);
		System.out.println("평균은: " + average);
			
		int ave = (int)average/10;
		char grade = 'F';
		switch (ave) {
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
		default:
			grade = 'F';	
		}
		
		System.out.println("등급은 = " + grade + "입니다.");
		switch (grade) {
		case 'A' : //문자를 이용한 판단
			System.out.println("Excellent!");
			break;
		case 'B' :
		case 'C' :
			System.out.println("Well done");
			break;
		case 'D' :
			System.out.println("you passed");
			break;
		case 'F' :
			System.out.println("Better try again");
			break;
			
		default: 
			System.out.println("Invalid grade");
			break;
		}		
	}
}

//출력결과:
//합계는: 956
//평균은: 191.0
//등급은 = F입니다.
//Better try again

