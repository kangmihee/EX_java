package acorn;
//문제
//국어 영어 수학 점수이다. 
//국어 영어 수학의 합계와 평균을 구하시오
//개인별 합계와 평균을 구하시오
//평균에 따라 grade를 구하시오
//평균은 소수점 2째자리에서 반올림하시오
//배열, 반복문
//90, 90, 90 //개인합계
//20, 20, 20
//30, 30, 30
//40, 40, 40
//50, 50, 50
//과목합계

class Data2 { //1차원 배열로 처리 가능
	int korea;
	int english;
	int math;
	int sum;
	float avr;
	public Data2(int korea, int english, int math) {
		this.korea = korea; this.english = english; this.math = math;
		this.sum = korea + english + math;
		this.avr = this.sum / 3.0f;		
	}
	
	public void run() { 
		System.out.println("합계는:"+ this.sum + " 평균은:" + this.avr);
	}
}

public class Sunjuk1 {
	public static void main(String[] args) {
		int kor=0, eng=0, math=0;	
		int[][] sunjuk = {{99, 91, 89},{88, 70, 71},{40, 65, 17},{80, 62, 65},{95, 68, 93}};
		
		for(int i=0;i<sunjuk.length;i++){  //행의개수
			int sum=0;
			char grade;
			kor=kor+sunjuk[i][0];
			eng=eng+sunjuk[i][1];
			math=math+sunjuk[i][2];	
			
			System.out.print(" " + (i + 1 )+ " ");
			
			for(int j=0;j<sunjuk[i].length;j++){ //열의개수
				sum = sum + sunjuk[i][j];
			}			
			if(sum/sunjuk[i].length >=90)
				grade = 'A';
			else if(sum/sunjuk[i].length>=80)
				grade = 'B';
			else if(sum/sunjuk[i].length>=70)
				grade = 'C';
			else if(sum/sunjuk[i].length>=60)
				grade = 'D';
			else 
				grade = 'F';
			
		System.out.println("개인별 합계는: " + sum + "  평균은: " + (Math.round(sum*10 /(float)sunjuk[i].length)/10f) + "  석차는: " + grade);			
		}System.out.println("과목별 합계= " + "국어:"+ kor + " 영어:" + eng+" 수학:" +math );
		System.out.println("과목별 평균= "  + "국어:"+ Math.round(kor*10/(float)sunjuk.length)/10f + 
				                            " 영어:" + Math.round(eng*10/(float)sunjuk.length)/10f + 
				                            " 수학:" +Math.round(math*10/(float)sunjuk.length)/10f );

		 //클래스를 이용한 성적합계와 평균출력에 대해서 구현하시오.
		 //클래스는 1차원 배열과 동일한 효과가 있음
		 //string은 한번만 하면 자동 string자체가 1차원 배열
		 Data2 [] score = new Data2[3]; //객체가 저장된 주소 배열이 heap에 생성
		 score[0]= new Data2(15,25,30);
		 score[0].run();
		 
		 Data2 [] data1 = new Data2[5]; //객체가 저장될 주소 배열이 heap에 생성
		 data1[0] = new Data2(90,  90,  90); //실제 데이터를 저장. 그 주소를 주소 배열에 저장
		 data1[1] = new Data2(20,  20,  20);
		 data1[2] = new Data2(30,  30,  30);
		 data1[3] = new Data2(40,  40,  40);
		 data1[4] = new Data2(50,  50,  50);
		 
		 Data2 [] data = {new Data2(90,  90,  90), new Data2(20,  20,  20),new Data2(30,  30,  30), 
				          new Data2(40,  40,  40), new Data2(50,  50,  50) }; 
			for(int i=0; i< data.length;i++){ //사용자 정의 데이터타입인 class
				System.out.print(data[i].korea+ " " + data[i].english + " " + data[i].math + " " 
				                + data[i].sum + " " + data[i].avr + "\n");
			}
			kor = 0;
			eng = 0;
			math = 0;
			for(int i=0; i<data.length;i++){
				kor += data[i].korea;
				eng += data[i].english;
				math += data[i].math;	
			}
			System.out.println("과목별 합계= " + "국어:"+ kor + " 영어:" + eng+" 수학:" +math );
			 System.out.println("과목별 평균= " + "국어:"+ Math.round(kor*10/(float)sunjuk.length)/10f + 
					                            " 영어:" + Math.round(eng*10/(float)sunjuk.length)/10f + 
					                            " 수학:" +Math.round(math*10/(float)sunjuk.length)/10f );		 
		}
	}

//결과출력:
//과목별 평균= 국어:80.4 영어:71.2 수학:67.0
//합계는:70 평균은:23.333334
//90 90 90 270 90.0
//20 20 20 60 20.0
//30 30 30 90 30.0
//40 40 40 120 40.0
//50 50 50 150 50.0
//과목별 합계= 국어:230 영어:230 수학:230
//과목별 평균= 국어:46.0 영어:46.0 수학:46.0
