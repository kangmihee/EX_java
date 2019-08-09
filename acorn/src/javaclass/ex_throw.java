package javaclass;

public class ex_throw {
	static void validate(int age){
		if(age<18)
			throw new ArithmeticException("정당하지 않습니다.");
		else
			System.out.println("투표권한있음");
	}
	public static void main(String[] args) {
		try {
			validate(13); //18부터 큰수 입력하면 예외처리x
		}
		catch(Exception m) {System.out.println("Exception 발생");}
	}
}

//출력결과:
//Exception 발생

