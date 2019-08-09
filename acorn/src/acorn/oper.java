package acorn;
//하나의 화일에 사칙연산을 하는 하는 클래스를 생성하고 그 클래스를 이용해서 5L, 3L에 대한 +,-,*,/를 실행한 후 그 값을 출력하시오
public class oper {
	long add(long x, long y){
		long addresult=0;
		addresult = x+y;
		return addresult;
	}
	long subtrat(long x, long y){
		return x-y;
	}
	long multiply(long x, long y){
		return x*y;
	}
	long divide(long x, long y){
		return x/y;
	}

	public static void main(String[] args) {
		oper op = new oper();
		long result1 = op.add(5L, 3L);
		long result2 = op.subtrat(5L, 3L);
		long result3 = op.multiply(5L, 3L);
		double result4 = op.divide(5L, 3L);
		
		//다른연산에 활용하고자 할 경우 결과를 변수에 받아서 사용
		System.out.println("add(5L, 3L): " + result1); //결과:
		System.out.println("subtrat(5L, 3L): " + result2); //결과:2
		System.out.println("multiply(5L, 3L): " + result3); //결과:15
		System.out.println("divide(5L, 3L): " + result4); //결과:1.0
		
		//값의 출력만 필요할 경우
		System.out.println("add(5L, 3L): " + op.add(5L, 3L)); //결과:8
		System.out.println("subtrat(5L, 3L): " + op.subtrat(5L, 3L)); //결과:2
		System.out.println("multiply(5L, 3L): " + op.multiply(5L, 3L)); //결과:15
		System.out.println("divide(5L, 3L): " + op.divide(5L, 3L)); //결과:1
	}
}

//출력결과:
//add(5L, 3L): 8
//subtrat(5L, 3L): 2
//multiply(5L, 3L): 15
//divide(5L, 3L): 1.0
//add(5L, 3L): 8
//subtrat(5L, 3L): 2
//multiply(5L, 3L): 15
//divide(5L, 3L): 1

