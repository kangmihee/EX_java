package javaclass;
import java.util.*;

// nextInt : int 형 숫자 범위 내에서
// nextFloat : 0.0 ~ 1.2 (1.0은 불포함)
public class ds2_Random {
	public static void main(String[] args) {
		Random rand = new Random(1); // 의사난수 (규칙젇,시작으로 랜덤화)
		Random rand2 = new Random(1);
		
		// int범위
		System.out.println("= rand =");
		rand.nextInt();
		for(int i=0;i<5;i++) 
			System.out.println(i+":"+rand.nextInt());
		System.out.println();
		System.out.println("= rand(함수 매개변수 범위) =");
		rand.nextInt();
		for(int i=0;i<5;i++)
			System.out.println(i+":"+rand.nextInt(10)); // 일정한 숫자내에서
		System.out.println();
		System.out.println("= rand2(0.0 ~ 1.0 (불포함)) =");
		rand2.nextFloat();
		for(int i=0;i<5;i++)
			System.out.println(i+":"+rand2.nextFloat()); 
	}
}

//결과출력:
//= rand =
//0:431529176
//1:1761283695
//2:1749940626
//3:892128508
//4:155629808
//
//= rand(함수 매개변수 범위) =
//0:6
//1:8
//2:8
//3:9
//4:3
//
//= rand2(0.0 ~ 1.0 (불포함)) =
//0:0.100473166
//1:0.4100808
//2:0.40743977
//3:0.2077148
//4:0.036235332
