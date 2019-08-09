package javaclass;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
//문제
//성적 : 번호 이름 국어 영어 수학 총점 평균을 가지는 데이터
//ArrayList에 저장하고 
//위의 데이터에 데이터 입력 출력하는 메뉴방식으로 구현하시오
//데이터는 입력 받아서 저장
//전체출력, 이름을 입력받아서 검색한 후에 출력

class Sungjik{
	int no;
	String name;
	int kor;
	int eng;
	int mat;
	int total;
	int avr;
	public Sungjik(int no,String name,int kor,int eng,int mat,int total,int avr) {
		this.no=no;
		this.name=name;
		this.kor=kor;	
		this.eng=eng;
		this.mat=mat;
		this.total=total;
		this.avr=avr;
	}
}

public class ex_ArrayList {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
		while(scan.hasNextLine()){
         list.add(scan.nextLine());
      }
      Iterator itr_list = list.iterator();
      while(itr_list.hasNext()){ 
      	Sungjik sj = (Sungjik)itr_list.next();
	      for(int i=0;i<3;i++){
	      	System.out.println(list.get(i));
	      }
	  }
		
		/*Iterator itr_list = ad1.iterator();
		while(itr_list.hasNext()){ 
			Sungjik sj = (Sungjik)itr_list.next();
			System.out.println(sj.no+"  "+sj.name+"  "+sj.kor+"  "+
					sj.eng+"  "+sj.mat+"  "+sj.total+"  "+sj.avr);
		}

		ad1.forEach(a->{ //dept 테이블 출력
			System.out.println(a.no+"  "+a.name+"  "+a.kor+"  "+
							   a.eng+"  "+a.mat+"  "+a.total+"  "+a.avr);
		});*/
		
	}	
}
