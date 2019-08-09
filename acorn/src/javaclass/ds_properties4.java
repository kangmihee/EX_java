package javaclass;
import java.util.*; // 자료구조
import java.io.*; //데이터 입출력
// 자바에서 데이터를 저장하거나 함수, 변수
// package 분리하면 동일한 클래스 가능

//문제
//1)성적 클래스에 배열을 만들고 3개의 데이터를 입력한다.
//2)입력된 데이터를 ArrayList에 모읍니다.
//3)Properties에 3개의 데이터를 정의하고 저장합니다.
//(이름, 점수=("국어,영어,수학"))
//4)저장된 Properties를 로딩해서 합계, 평균, 최고점수과목, 최고점, 최저점을 계산합니다.
//5)계산된 값을 출력합니다.
//(ds_properties4)에 풀이
// class를 비교 가능하도록 수정하기
// 성적순, 이름순

class Student30 implements Comparator<Student30>, Comparable<Student30>{ // 동일한 패키지에서는 동일한 클래스명 사용불가
	String name;
	int kor;
	int mat;
	int eng; 	
	int total; // 키
	int average; // 데이터
	String subject; 
	int highpoint;
	int lowpoint;
	
	public Student30() {}
	Student30(String name,int kor,int mat,int eng){
		this.name=name;
		this.kor=kor;
		this.mat=mat;
		this.eng=eng;
	}
	
	// propertied 는 문자열로 데이터를 저장
	// Object를 상속 toString함수는 문자열을 요구하는 함수 안에서 문자열 리턴
	public String toString() {
		total = kor + mat + eng;
		average = total/3;
		return kor + "," + mat + "," + eng ; 
	}
	public String lasttoString() {
		return name + "  " + kor + "    " + mat + "    " + eng + "    " + 
			   total + "    " + average + "      " + subject + "       " + highpoint; 
	}
	@Override
	public int compareTo(Student30 student1) {
		return name.compareTo(student1.name);
	}
	@Override
	public int compare(Student30 student1, Student30 student2) {
		return student1.total - student2.total;
	}
}

public class ds_properties4 {
	public static void main(String[] args) {
		Properties prop = new Properties();
		ArrayList<Student30> student= new ArrayList<Student30>();
		Scanner sc = new Scanner(System.in);
		String name;
		int kor=0;
		int mat=0;
		int eng=0;
		System.out.println("이름, 국어, 영어, 수학 점수를 3개 입력하시오.");
		for(int i=0;i<3;i++) { // 1번에서 입력해서 처리하는 것을 구현
			name=sc.nextLine(); // 단일변수에 데이터 입력
			kor=sc.nextInt();
			mat=sc.nextInt();
			eng=sc.nextInt();
			sc.nextLine(); // buffer 정리용(한 번 끊어준다)
			Student30 st = new Student30(); // 클래스 데이터를 취함
			st.name=name;
			st.kor=kor;
			st.mat=mat;
			st.eng=eng;
			student.add(st);					
		}
		Iterator<Student30> itr = student.iterator();
		while(itr.hasNext()) {
			Student30 s = (Student30)itr.next();
			System.out.println(s);
			prop.setProperty(s.name, s.toString());
		}
		try { // Stream 함수 제공 : Byte형 데이터 저장 // Stream은 저장일렬로 저장
			prop.store(new FileOutputStream("c:\\work\\sungjuk3.txt"),  "성적파일");
		}catch (IOException e) {
			e.printStackTrace();
		}
		try {
			prop.load(new FileInputStream("c:\\work\\sungjuk3.txt"));
		}catch (IOException e) {
			System.out.println("파일을 찾을 수 없습니다.");
			System.exit(0); // 프로그램 종료
		}
		student.clear(); // ArratList데이터 점수 다 날림 
		
		Enumeration e = prop.propertyNames(); // 단방향 이터레이터
		int ban_total = 0;
		float ban_average = 0;
		while(e.hasMoreElements()) {
			// propertied는 key + data 형식으로 데이터 저장
			String element = (String)e.nextElement(); // 키값
			// 문자열 함수 : split
			String [] data = prop.getProperty(element).split(","); // 데이터
			Student30 st = new Student30();
			st.name = element;
			double perdonal_sum = 0;
			
			for(int i=0;i<data.length;i++) { // 화일로 저장시 문자로 저장 => 변환
				int intValue = Integer.parseInt(data[i]); // 정수화
				if(i==0) st.kor = intValue;
				else if(i==1)st.mat = intValue;
				else st.eng= intValue;	
				perdonal_sum += intValue; // 개인합계
				
				// 최고과목과 최고점수를 확인하는 부분
				if(i==0) {
					st.highpoint = st.lowpoint = intValue;
					st.subject = "국어"; // 변수 초기화하는 부분
				}
				
				// 최고점수 과목선정
				if(st.highpoint < intValue) { 
					st.highpoint = intValue;
					if(i==0) 
						st.subject = "국어";
					else if(i==1) 
						st.subject = "영어";
					else st.subject = "수학";
				}
				
				// 최소점수 과목선정
//				if (st.lowpoint > intValue) { 
//					st.lowpoint = intValue;
//					st.highpoint = intValue;
//					if(i==0) 
//						st.subject = "국어";
//					else if(i==1) 
//						st.subject = "영어";
//					else st.subject = "지향";
//				}
			}// for문 종료.
			 // for문 종료 후 과목결정, 과목들의 총점 구하기
			 // 개인점수 합계와 평균계산
			
			st.total += (int)perdonal_sum; // 합계
			st.average = (int)Math.round(perdonal_sum/3);
			student.add(st);
			ban_total += perdonal_sum;
		}// 3명분의 성적계산
		 // 반복문 종료 후 결과 출력
		itr = student.iterator();
		System.out.println("계산결과 출력");
		System.out.println("이름  국어  영어  수학  총점  평균  최고점수과목  최고점수");
		while(itr.hasNext()) {
			Student30 s = (Student30)itr.next();
			System.out.println(s.lasttoString());
		}
		ban_average = (float)((int)(ban_total/3 *100)) /100 ; // 소수점2째자리까지 표현(*100 해주고 /100)
		System.out.println( "반총점:" + ban_total + " 반평균:" +ban_average );
	}
}

// 문제
// 1)반 : 반점수합계(ban_sum)와 평균(ban_average)로 구해서 출력해보시오
// 2)반점수합계와 평균을 출력

//출력결과:
//99,88,77
//66,55,44
//33,22,11
//계산결과 출력
//이름  국어  영어  수학   총점   평균  최고점수과목  최고점수
//차은우  99    88    77    264    88      국어       99
//유승호  33    22    11    66     22      국어       33
//박보검  66    55    44    165    55      국어       66
//반총점:495 반평균:165.0
