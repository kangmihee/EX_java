package acorn;
import java.util.Scanner;

public class Array2 {
	public static void main(String[] args) {		
		for(int i=0; i<args.length;i++)
			System.out.println("args[ " + i + " ] = " + args[i] );
		
		System.out.println("메인메소드가 시작되었습니다.");
		
		int[] nums = new int[3]; //stack = heap 의 주소값 저장, heap
		nums[0] = 10; //초기화방법
		nums[1] = 20;
		nums[2] = 30;
		int[] nums2 ={10, 20, 30}; //초기화방법2
		for(int i=0; i<nums2.length;i++){
			System.out.println(nums2[i] + "\n");
		}
		
		//문자열 배열...int 와 구조가 달라 stack -> main변수저장, heap -> 주소저장
		//heap 문자열 주소 배열
		//문자열에 대한 공간확보하고 데이터 입력후 그 주소를 문자열 주소 배열에 저장
 		String[] names = new String[3];
		names[0] = "서울시";
		names[1] = "충주시";
		names[2] = "대전";
		String[] names2 = {"서울시", "충주시", "대전"};
		for(int i =0; i< names2.length;i++){
			System.out.println(names2[i] + "\n");
		}
		
		Car[] cars = new Car[3]; //공간만 만든상황..초기화필요!
		//방법1
		cars[0] = new Car("소나타"); //객체를 전제조건을 하기 때문에 new를 사용해서 데이터를 직접 넣어준다...문자열은 초기화 필요
		cars[1] = new Car("아반떼");
		cars[2] = new Car("아우디");
		cars[0].drive();
		cars[1].drive();
		cars[2].drive();
		
		//방법2
		Car[] cars2 = {new Car("A"), new Car("B"), new Car("C")};
		cars2[0].drive();
		cars2[1].drive();
		cars2[2].drive();
		
		//Person (이름과 나이) 클래스를 생성한 다음 출력하는 함수를 만드시오
		//Person 클래스의 배열3개를 만들고 초기화 한 다음 함수를 이용해서 정보를 출력하시오
		Person[] pe = new Person[3];
		pe[0] = new Person ("강동원", 30);
		pe[1] = new Person ("박보검", 25);
		pe[2] = new Person ("차은우", 20);
		pe[0].print();
		pe[1].print();
		pe[2].print();	
			
		//int[] score = {79, 88, 91, 33, 100, 55, 95};
		//최대값과 최소값을 찾아서 출력하시오.
					
		int[] score = {79, 88, 91, 33, 100, 55, 95};		
		int min = score[0];  //79
		int max = score[0];  //79		
		for(int i=0;i<score.length;i++){
			if(score[i]>max){
				max = score[i];
			}if(score[i]<min){
				min = score[i];
			}
		}
		System.out.println("최소값은:" + min + " 최대값은:" + max );
			
		int[] number = new int[10];
		for(int i=0; i<number.length;i++){
			number[i] = i;
			System.out.print(number[i] + " ");
		}		
		for(int i=0; i<100;i++){
			int n =(int)(Math.random() * 10); //0~9랜덤
			int temp = number[0];
			number[0] = number[n];
			number[n] = temp;	
		}
		//문제. shuffling된 데이터를 오름(내림) 차순으로 정렬하시오(버블정렬)
		for(int i=0; i <number.length;i++){
			boolean changed = false;
			for(int j=0; j < number.length-i-1 ;j++){//-1을 해주지 않으면 숫자가 오버되어 결과 안나옴
				if(number[j] < number[j+1]){
					int temp = number[j]; //임시변수에 데이터를 백업
					number[j] = number[j+1];
					number[j+1] = temp;
					changed =true; //변화가 있음
				}	
			 // ! 부정not
			}if(!changed) break; // 참일 때 종료
		}
				
		//문제. 반복문사용
		//     0.000 ~ 0.9999 : 0, 99   
		//     com : 1~100 까지의 수를 선택 Math.random *100 + 1
		//     사용자는 수를 입력해서 정답을 맞춤 (비교)
		//     틀리면 메시지를 출력정답이 입력한 숫자보다 크거나 작다는 것을 출력
		//     최종적으로 정답을 맞추면 event출력
		//     Hitnum class에 쓰앵님 풀이
		
		int com = (int)(Math.random() * 100) +1;
		for(int i=0; i<100;i++){			
			Scanner input = new Scanner(System.in);
			int a = input.nextInt();
			if(a > com){
				System.out.println("입력값 " + a + " 보다 작습니다.");
			}else if(a < com){
				System.out.println("입력값 " + a + " 보다 큽니다.");
			}else 
				System.out.println("입력값 " + a + " 와 같습니다.");	
		}			
	}
}

//출력결괴:
//메인메소드가 시작되었습니다.
//10
//
//20
//
//30
//
//서울시
//
//충주시
//
//대전
//
//소나타이(가) 달라요.
//아반떼이(가) 달라요.
//아우디이(가) 달라요.
//A이(가) 달라요.
//B이(가) 달라요.
//C이(가) 달라요.
//강동원은30 살이다.
//박보검은25 살이다.
//차은우은20 살이다.
//최소값은:33 최대값은:100
//0 1 2 3 4 5 6 7 8 9 






