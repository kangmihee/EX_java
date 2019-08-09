package acorn;
// 자바에서의 클래스는
//1. 진입점함수를 가진 클래스 : 실행이 가능
//2. static만 가진 클래스 : 인스턴스 없이 호출이 가능
//3. 일반클래스 : 인스턴스 후 호출가능
public class callby_reference {	
	public static void m() { }
	public static void m(int i) { i = 99; }
	public static void m(int []arr) { arr[0] = 99; }
	//배열은 기본적으로 포인터 : 여러개의 데이터를 저장 => heap에 생성이 되고 주소값저장
	
	public static void main(String[] args) {
		m();
		int i =10; //callby_value
		m(i);
		System.out.println(i); //출력:10
		// val이라는 기억공간에 주소값을 가지고 있고 그 주소를 찾아 가면 10
		
		Integer val = new Integer(10); //heap에 생성(heap에공간만들고 주소값저장)
		m(val);
		System.out.println(val); //출력:10...주소가 아니라 값으로 받아서 10으로 출력됨
		
		int[]arr = {10, 20, 30}; //배열정의 heap에 값저장
		m(arr); //arr에는 heap의 주소값가짐
		System.out.println(arr[0]); //출력:99...주소값으로 받아 99로 출력됨(함수에의해 값이변경됨:callby_reference)
		System.out.println(arr.length); //출력:3
		
		SecondUtil.MakeMessage(); //다른class의 함수 호출...클래스호출은 인스턴스 필요로함 but static 사용으로 필요없어짐
		ThirUtil th = new ThirUtil(); // ThirUtil 클래스에는 static 없기때문에...instance => heap 메모리를 확보하고 실행가능
		th.MakeMessage();
			
		//문제. 별도의 클래스를 생성할 것 : 일반 클래스로 생성할 것
		//문제. add함수와 volume함수를 가진 클래스를 생성한 다음 이를 호출하여
		//10과 20의 합을 출력하고 가로: 10, 세로: 20, 높이: 100의 부피를 출력하는 클래스를 작성하시오.		
		Volume re = new Volume();
		re.add(10,20);
		re.volume(10,20,100);
		re.factorial(10);		
	}
}

//결과호출:
//10
//10
//99
//3
//타패키지의 정적함수의 호출
//타패키지의 정적함수의 호출
//30
//20000

