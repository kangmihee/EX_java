package acorn;

class Card{
	String kind;
	int number;
		
	//상속에서 중요해짐 : 자식이 부모의 생성자를 호출해야 될 경우가 있고
	//생성자 오버로딩
	Card() { //생성자 : 생성자가 생성자를 호출하는 것은 가능...Card cd = new Card()로 호출당했을때 디폴트 값이 변한다.
		this("SPADE", 1); //디폴트값
	}
	Card(String kind, int number) { //생성자: 강제호출 불가능
		this.kind = kind;
		this.number = number;
	}
	void display(){
		System.out.println(kind + "   " + number);
	}
}

public class String_test {
	public static void main(String[] args) {
		String one = "Foo"; //문자열 클래스
		char [] c = {'F', 'o', 'o'}; //문자 배열
		String two = new String( c );
		
		System.out.println(one.equals(two)); //출력:true ...equals는 대소문자 동일해야한다...
		System.out.println(one.equals(c)); //출력:false
		System.out.println(one.equalsIgnoreCase(two)); //출력:true	
		
		//문자열 배열 생성
		String[] words = {new String("aaa"), new String("bbb"), new String("ccc")};
		
		//자바에서 문자열을 비교할 때 equals로 사용해야한다...==는 사용불가!
		for(int i=0; i<words.length;i++){
			if(words[i].equals("ccc")){ //값으로 비교한다
				System.out.println("words에서 equals 메서드로 찾았습니다.");
			}
			if(words[i]=="ccc"){ //비교연산자...==는 주소값으로 비교한다
				System.out.println("words에서 ==연산자로 찾았습니다.");
			}
		}		
		Card c1 = new Card();
		Card c2 = new Card();
		c1.display();
		c2.display(); //같은 값이 출력
		System.out.println(c1); // 클래스출력. 객체가 가지고 있는 값 출력
		System.out.println(c2.toString());	
	}
}

//결과출력:
//true
//false
//true
//words에서 equals 메서드로 찾았습니다.
//SPADE   1
//SPADE   1
//acorn.Card@6bf256fa
//acorn.Card@6cd8737

