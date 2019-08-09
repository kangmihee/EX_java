package javaclass;
import java.util.*;
import java.io.*;

// 문제
// 1)성적 클래스에 배열을 만들고 3개의 데이터를 입력한다.
// 2)입력된 데이터를 ArrayList에 모읍니다.
// 3)Properties에 3개의 데이터를 정의하고 저장합니다.
// (이름, 점수=("국어,영어,수학"))
// 4)저장된 Properties를 로딩해서 합계, 평균, 최고점수과목, 최고점, 최저점을 계산합니다.
// 5)계산된 값을 출력합니다.
// (ds_properties4)에 풀이

class Student20{
	String name;
	int kor;
	int mat;
	int eng; // 저장은 여기까지만
	int total; 
	int average;
	String subject; // 국어 영어 수학 중 최고점수과목
	int highpoint; // 최고점
	int lowpoint; // 최소점
	
	public Student20() {}
	Student20(String name,int kor,int mat,int eng){
		this.name=name;
		this.kor=kor;
		this.mat=mat;
		this.eng=eng;
	}
	public String toString() {
		total = kor + mat + eng;
		average = total/3;
		System.out.println(total+average);
		return kor + "," + mat + "," + eng ; 
	}
	public String lasttoString() {
		return name + "   " + kor + "   " + mat + "   " + eng + "   " + 
			   total + "   " + average + "   " + subject + "   " + highpoint; 
	}
}

public class ds_properties3 {
	public static void main(String[] args) {
		//1)
		Student20 s1 = new Student20("차은우",90,80,70);
		
		//2)
		ArrayList<Student20> list = new ArrayList<Student20>();
		list.add(s1);
		Iterator itr = list.iterator();
		while(itr.hasNext()) {
			Student20 st = (Student20)itr.next();
			System.out.println(st.name+"  "+st.kor+"  "+st.mat+"  "+st.eng);
		}

		//3)
		Properties prop = new Properties();
		prop.setProperty("차은우","90,80,70");
		
		Enumeration e = prop.propertyNames();
		while(e.hasMoreElements()) {
			String element = (String)e.nextElement();
			System.out.println(element + "의 점수는" + prop.getProperty(element));
		}
		
		//4)
		String[] data = prop.getProperty("차은우").split(",");	
		data.toString();
		//data.lasttoString();
		int total = 0; 
		int average = 0;
		String subject; 
		int highpoint = 0; 
		int lowpoint = 0; 
		for(int i=0;i<data.length;i++) { // 화일로 저장시 문자로 저장 => 변환
			int intValue = Integer.parseInt(data[i]); // 정수화
			if(i==0) highpoint = lowpoint = intValue; // 최대, 최소값
			
			if(highpoint < intValue) {
				highpoint = intValue;
			}else if (lowpoint > intValue) {
				lowpoint = intValue;
			}
			total += intValue; // 합계
			average = total/3;
		}	
		System.out.println("합계:" + total + " 평균:" + average + 
						   " 최고점:" + highpoint + " 최저점:" + lowpoint );	
	}
}
