package javaclass;

// generic class
class Box<T> {
	private T t;
	public void add(T t) {
		this.t = t;
	}
	public T get() {
		return t;
	}
}

//generic 함수
public class ds_generic {
	public static <E> void printArray( E[] inputArray ) {
		for(E element : inputArray) {
			System.out.printf("%s ", element);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Integer[] intArray = {1, 2, 3, 4, 5};
		Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
		Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };
		printArray(intArray); //오버로딩으로 처리하기 위해 3개의 함수  
		printArray(doubleArray);
		printArray(charArray);
		
		//데이터 타입구분없이 사용가능
		Box<Integer> integerBox = new Box<Integer>();
		Box<String> stringBox = new Box<String>();
		integerBox.add(new Integer(10));
		stringBox.add(new String("안녕 일반화 프로그램"));
		System.out.printf("정수형 :%d\n\n", integerBox.get());
		System.out.printf("문자형 :%s\n", stringBox.get());
	}
}

//출력결과:
//1 2 3 4 5 
//1.1 2.2 3.3 4.4 
//H E L L O 
//정수형 :10
//
//문자형 :안녕 일반화 프로그램	

