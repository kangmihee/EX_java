package acorn;
public class t1_class {
	public static void main(String[] args) {
		byte b = 0;
		int i = 0;
		for(int x = 0 ; x <= 270 ; x++){  //11111111씩 증가하다가 부호비트로 인해 127(01111111)에서 -128(11111111)로 넘어감
			System.out.print(b++); // (byte:-128 ~ 127)범위인데 => -128
			System.out.print('\t'); // escape 문자열 => \n : newline, \t : tab
			System.out.println(i++);		
		}
		
		Car2 c1 = new Car2(); //데이터 타입 일치
		c1.color = "white"; //대입가능
		c1.gearType  = "auto";
		c1.door = 4;
		
		Car2 c2 = new Car2("white", "auto", 4);
		System.out.println("차량 color= " + c1.color + ", geatType=" + c1.gearType + "" + ", door=" + c1.door );
		System.out.println("차량 color= " + c2.color + ", geatType=" + c2.gearType + "" + ", door=" + c2.door );	
		
		add_num num = new add_num(); //객체배열을 만들때는  디폴트 생성자가 필요!
		System.out.println(num.getresult());
	}		
}

class add_num{ //생성자
	int a = 1000;
	int b = 2000;
	public int getresult() {
		return a+b;		
	}
	// add_num(){} 자동으로 디폴트 생성자 생성
}

//출력결과:
//0	0 
//  ~
//127 127
//-128 128
//  ~
//-1 255
//0	256
//  ~
//14	270
//차량 color= white, geatType=auto, door=4
//차량 color= white, geatType=auto, door=4
//3000
