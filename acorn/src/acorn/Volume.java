package acorn;
public class Volume { //일반클래스라 인스턴스 필요
	
	//add 함수
	public void add(int a, int b){
		int sum;
		sum = a+b;
		System.out.println(sum);		
	}
	
	//volume 함수
	public void volume(int x, int y, int z){
		int result;
		result = x*y*z;
		System.out.println(result);		
	}
	
	//factorial 함수
	public long factorial(int n) { //재귀함수를 이용한 팩토리얼 함수
		long result = 0;
		if( n == 1 ){ //종료조건을 지정하지 않으면 무한루프로 빠져서 에러발생 
			result = 1;
		}else {
			result = n*factorial(n-1);
		}
		return result;
	}			
}

//출력결과:
//0123456789
//abcdefghiA
//BCDEFGHIJ!
//@#$%^&*()Z
//ZZ
//@#$%^&*()Z
//0123456789
//BCDEFGHIJ!
//abcdefghiA
//ZZ
