package javaclass;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ds2_ArrayList {

	public static void main(String[] args) {
		final int LIMIT = 10;
		String source = "0123456789abcdefghiABCDEFGHIJ!@#$%^&*()ZZZ";
		int length = source.length();
		List<String> list = new ArrayList<String>(length/LIMIT + 10); // 공간을 넉넉하게 확보하기위해(+10)
		
		// 상속구조
		for(int i=0; i<length; i+=LIMIT) {
			if(i+LIMIT < length)
			list.add(source.substring(i, i+LIMIT )); // 시작지저, 문자개수
			else // 마지막을 고려해서 
			list.add(source.substring(i)); // 매개변수가2개?...오버로딩
		}
		
		for(int i=0; i<list.size(); i++) { //순차접근시 iterator
			System.out.println(list.get(i)); // for문을 사용할 때는 인덱스를 사용, get 함수사용
		}
		
		Collections.shuffle(list); // 셔플링 : 랜덤하게 숫자를 섞을 때 사용
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}

//출력결과:
//0123456789
//abcdefghiA
//BCDEFGHIJ!
//@#$%^&*()Z
//ZZ
//@#$%^&*()Z
//BCDEFGHIJ!
//0123456789
//ZZ
//abcdefghiA
