package acorn;
import java.io.BufferedReader;
import java.io.IOException;
//문제점 : 
// 1) 반복되는 부분 : 함수로 구현하시오
// 2) 개별적으로 값을 수정하고 가지고 오는 함수를 작성하시오
     //set : 매개변수가 있음, void
     //get : 리턴값 있음, 매개변수 없음
// 3) 입력받는 것도 클래스에 함수로 구현하시오 (set/get)
import java.io.InputStreamReader;
//입력을 위한 패키지

//성적클래스 (이름, 국어, 영어, 수학, 총점, 평균)를 작성하시오
//생성자를 이용해서 초기화
//데이터를 문자열을 만들어서 출력하는 함수를 구현
//성적클래스 3개를 입력할 수 있는 배열을 생성한 다음 실시간으로 배열에 값을 입력
//입력된 값을 출력하시오

//Scanner 문자열 int // 버퍼로
public class t4_Sungjuk {
	public static void main(String[] args) throws IOException {		
//		//방법1)
//		 String name;
//		 int kor = 0;
//		 int eng = 0;
//		 int math = 0;		 
//		 BufferedReader typein = new BufferedReader(new InputStreamReader(System.in));
//	      System.out.println("이름 국어 영어 수학 순으로 3인분을 입력하시요.");
//	      Student20[] school = new Student20[3]; //주소값 저장하는 배열에 대한 주소
//	      for (int i = 0; i < 3; i++) {
//	         name = typein.readLine(); //문자열
//	         kor = Integer.parseInt(typein.readLine()); //숫자 입력
//	         eng = Integer.parseInt(typein.readLine());
//	         math = Integer.parseInt(typein.readLine());
//	         school[i] = new Student20(name,kor,eng,math);
//	      }
//	      System.out.println(school[0].printhead());
//	      for (int i = 0; i < 3; i++) {
//	         System.out.println(school[i].lasttoString());
//	     	}

		//방법2)...코드간결해짐
		Student20[] school = new Student20[3]; //배열의 주소
		for (int i = 0; i < 3; i++) {
			school[i] = new Student20(); //생성자에 있는 입력 내용
		}
		System.out.println(school[0].printhead());
		for (int i = 0; i < 3; i++) {
	         System.out.println(school[i].lasttoString());
	     	}	
			
		//메뉴화
		System.out.println("===========*성적관리 프로그램*===========");	
		menuOpen(school);
	}
	
	//배열을 매개변수로 하는 함수
	public static void menuOpen(Student20[] school) throws IOException{
		int inputNum = 0;
		boolean re = false;
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		while(!re){
			re = true;
			System.out.println("1.검색,  2.출력, 3.수정,  9.종료");
			System.out.println("메뉴 선택 : ");
			inputNum = Integer.parseInt(stdin.readLine());
			switch ((inputNum)) {
			case 1: System.out.println("1검색내용.");
					String inputName = stdin.readLine();
					for(int i =0;i<3;i++){
						if(school[i].name.equals(inputName)){
						System.out.println(school[i].lasttoString());
						}
					}
					menuOpen(school);
					break;
			case 2: System.out.println("2출력내용.");
					System.out.println(school[0].printhead());
					for(int i =0;i<3;i++){
						System.out.println(school[i].lasttoString());
					}
					menuOpen(school);
					break;
			// 수정 : 수정하고자 하는 이름 입력 => 이름을 검색 => 있으면 수정할 데이터를 입력 => 입력된 데이터로 기존의 데이터 수정
			case 3: System.out.println("3수정할내용.");
					String readName = stdin.readLine();
					for(int i =0;i<3;i++){
						if(school[i].name.equals(readName)){
							System.out.println(school[i].lasttoString());				
							String modifyname = stdin.readLine();
							school[i].setName(modifyname);
						}
					}		
					menuOpen(school);
					break;
			case 9: re = true; 
					break;	
			default:{System.out.println("다시 입력해주세요.");
					re = false; 
					break;}
			}
		}
	}
}

class Student20{
	  String name;
	  int kor;
	  int eng;
	  int math;
	  int sum;
	  float average;
	  	  
	  Student20()throws IOException{//디폴트 생성자
		  BufferedReader typein = new BufferedReader(new InputStreamReader(System.in));
		  this.name = typein.readLine(); //문자열
		  this.kor = Integer.parseInt(typein.readLine()); //숫자 입력
		  this.eng = Integer.parseInt(typein.readLine());
		  this.math = Integer.parseInt(typein.readLine());	         	  
	  }
	  	  
	  public void input() throws IOException{
		  BufferedReader typein = new BufferedReader(new InputStreamReader(System.in));
	  	  name = typein.readLine(); //문자열
          kor = Integer.parseInt(typein.readLine()); //숫자 입력
          eng = Integer.parseInt(typein.readLine());
          math = Integer.parseInt(typein.readLine());	
          //typein.close();
	  }
	  
	  public int total_fun() {
		  return this.kor + this.eng + this.math;
	  }
	  public float avr_fun() {
		  return average = Math.round((double)sum / 3);
	  }
	  	  	  
	  Student20(String name, int kor, int eng, int math) {		 	
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
			sum = total_fun();
			average = avr_fun();
	  }
	    
	  public String toString(){
		  return kor + "," + eng + "," + math;
	  }
	  
	  public String lasttoString(){
		  sum = kor + eng + math;
		  average = Math.round((double)sum / 3);
		  return name + "   " + kor + "   " + eng + "   " + math + "   " + sum + "   " + average; 
	  }
	  
	  public String printhead() {
		  return "이름" + "   " + "국어" + "   " + "영어" + "   " + "수학" + "   " + "합계" + "   " + "평균"; 
	  }
	  	  
	  public void setName(String name) {this.name= name;}
	  public void setKor(int kor) {this.kor= kor;}
	  public void setEng(int eng) {this.eng= eng;}
	  public void setMath(int math) {this.math= math;}
	  
	  public String getName() {return name;}
	  public int getKor() {return kor;}
	  public int getEng() {return eng;}
	  public int getMath() {return math;}
}

//출력결과:
//박보검
//1
//2
//3
//차은우
//4
//5
//6
//유승호
//7
//8
//9
//이름   국어   영어   수학   합계   평균
//박보검   1   2   3   6   2.0
//차은우   4   5   6   15   5.0
//유승호   7   8   9   24   8.0
//===========*성적관리 프로그램*===========
//1.검색,  2.출력, 3.수정,  9.종료
//메뉴 선택 : 
//3
//3수정할내용.
//박보검
//박보검   1   2   3   6   2.0
//여진구
//1.검색,  2.출력, 3.수정,  9.종료
//메뉴 선택 : 
//1
//1검색내용.
//여진구
//여진구   1   2   3   6   2.0
//1.검색,  2.출력, 3.수정,  9.종료
//메뉴 선택 : 
//2
//2출력내용.
//이름   국어   영어   수학   합계   평균
//여진구   1   2   3   6   2.0
//차은우   4   5   6   15   5.0
//유승호   7   8   9   24   8.0
//1.검색,  2.출력, 3.수정,  9.종료
//메뉴 선택 : 
//4
//다시 입력해주세요.
//1.검색,  2.출력, 3.수정,  9.종료
//메뉴 선택 : 
//9

