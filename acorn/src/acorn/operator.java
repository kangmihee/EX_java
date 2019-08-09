package acorn;
//10진수 => 2진수 사운드, 문자, 숫자, 이미지, 텍스트 등을 처리
//증강연산자:(1순위로연산) ++, --
//산술연산자:(2순위로연산) *, /, +, -
//시프트연산자:(3순위로연산) <<, >>
//비교연산자: >, >=, ==, <, <=
//비트연산자:&, |, ^
//논리연산자: (조건)? : 참:거짓
//삼항연산자: =, +=, -=, *=, /=, %=(나머지연산자)

public class operator {
	public static void main(String[] args) { //전일연산자와 후위연산자
		int i=5;
		i++; //후위증가연산자  i=i+1
		System.out.println(i);  //6
		i=5;
		++i; //전위증가연산자
		System.out.println(i); //6
		System.out.println(i++); //6 i값에 함수(println)에 6을 넣어주고 값이 나갈때 +1 처리 => 7  
		System.out.println(++i); //8 함수(println)에 +1을 넣어줘서 7+1 => 8 	
		
		//128, 64, 32, 16, 8, 4, 2, 1
		//  0   1   1   0  0  0  0  1  =97 
		
		char c1= 'a'; //97이 2진수로 저장
		char c2 = c1;
		char c3 = ' '; //공백도 데이터이다.
		
		int j= c1 + 1; //변수에는 2진수로 저장되어 있다. 97+1
		
		c3= (char)(c1+1); //강제 캐스팅
		c2++;  //98
		c2++;  //99
		
		//char형은 문자 + 숫자로도 취급가능
		System.out.println("j=" + j); //98
		System.out.println("c2=" + c2);  //c  char형이라 문자로 출력 
		System.out.println("c3=" + c3);  //b  char형이라 문자로 출력
		
		//수학함수모음 : Math 클래스
		float pi = 3.141592f; //상수화
		float shortPi = Math.round(pi *1000) / 1000f; //round 반올림함수...소수점 3자리 올려줌 그리고나서 다시 나눠줌...
		//3141.592 => 3142 => 3.142...원하는 자리에서 반올림 할 때 사용하는 방법
		float shortPi_1 = (float)Math.ceil(pi * 1000) / 1000f; //올림
		//ceil 은 double을 리턴함
		float shortPi_2 = (float)Math.floor(pi * 1000) / 1000f; //내림
		// floor와 같은 효과가 있음
		// 3141 => 3.141
		float shortPi_3 = (int)(pi * 1000) / 1000f;
		
		System.out.println(shortPi); //3.142
		System.out.println(shortPi_1); //3.142
		System.out.println(shortPi_2); //3.141 
		System.out.println(shortPi_3); //3.141
				
		System.out.println(-8); //결과 : -8, 음수는 보수로 표헌		
		System.out.println(Integer.toBinaryString(-8));
		//음수는 보수로 표헌 0->1, 1->0
		//결과 : 11111111111111111111111111111000 #음수에서는 0을 숫자로 이해
		System.out.println(); 
			
		//Shift 왼쪽   -> *2
		//      오른쪽 -> /2
		int temp = -8 << 1; //-16
		System.out.println("-8 << 1 = " + temp);
		System.out.println(Integer.toBinaryString(temp));
		//결과 : 11111111111111111111111111110000
		System.out.println();
		
		temp = -8 << 2; //-32
		System.out.println("-8 << 2 = " + temp);
		System.out.println(Integer.toBinaryString(temp)); //메모리의 내용을 출력
		System.out.println();
			
		//문제.다음숫자를 바이너리로 출력하시오.
		//비트연산
		int x = 123; //1111011...메모리에 2진수 저장...앞의 자리수 0생략
		int y = 205; //11001101
		       //xor : 10110110...앞의 자리수 0붙여서(01111011)을 xor 해줌
	       	   //      128  32  16  4  2 => 182
		System.out.println(Integer.toBinaryString(x));
		System.out.println(Integer.toBinaryString(y));
		
		int z = x^y; //xor연산
		System.out.println(z); //10진수로 출력
		System.out.println(Integer.toBinaryString(z));
		//int x = 123; // 01111011 매모리에 2진수 저장
		//int y = 205; // 11001101
		               // 11111111
		
		System.out.println("x | y = " + (x|y)); //or...출력:255 => 256개지만 0부터  시작
		//int x = 123; // 01111011 매모리에 2진수 저장
		//int y = 205; // 11001101
				       // 01001001
                       //64 8 1 => 73
		
		System.out.println("x & y = " + (x&y)); //and...출력:73 
		//true(1) / false(0) 는 상수
		
		System.out.println("true | false = " + (true|false));  //true
		System.out.println("true & false = " + (true&false));  //false
		System.out.println("true ^ false = " + (true^false));  //true
			
		//삼항연산자 (if문을 줄여놓음)
		x = 10;
		y = -10;
		int absX = (x >= 0) ? x : -x;  //true이면 왼쪽, flase면 오른쪽 출력
		int absY = (y >= 0) ? y : -y;
		System.out.println("x= "+absX); //출력:10
		System.out.println("y= "+absY); //출력:10
			
		boolean power = false;
		power = !power; //false를 부정하면 true
		System.out.println(power); //출력:true
	}
}

//결과출력:
//10110110
//x | y = 255
//x & y = 73
//true | false = true
//true & false = false
//true ^ false = true
//x= 10
//y= 10
//true

