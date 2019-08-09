package javaclass;
import java.util.*;

// Product를 상속받는 Tv와 Audio를 생성하고 Object의 toString함수를 오버라이딩 하시오
// ArrayList에 Tv와 Audio를 2개씩 저장
// ArrayList에 저장된 데이터를 출력할 수 있는 함수를 작성하시오
// 상속구조에서 일반적으로 작동하는 함수를 생성하려면 매개변수 부모타입

class Product{
	public String toString() {
		return "나는 product";
	}
}
class Tv extends Product{
	public String toString() {
		return "나는 Tv";
	}
}
class Audio extends Product{
	public String toString() {
		return "나는 Audio";
	}
}

public class ds2_generic {
	public static void main(String[] args) {
		ArrayList<Product> productList = new ArrayList<Product>();
		ArrayList<Tv> tvList = new ArrayList<Tv>();
		//ArrayList<Audio> audioList = new ArrayList<Audio>();
		
		productList.add(new Tv());
		productList.add(new Audio());
		
		tvList.add(new Tv());
		tvList.add(new Tv());
		
		// 상속계통의 모든 데이터를 출력하려면 어떻게 해야하는가
		printAll(productList);
		//printAll(tvList);
		
		printAll2(productList);
		printAll2(tvList);
	
	}	
	public static void printAll(ArrayList<Product> list) {
		for(Product p : list) {
			System.out.println(p);
		}
	}
	public static <T extends Product> void printAll2(ArrayList<T> list) {
		for(Product p : list) {
			System.out.println(p);
		}
	}
}

//결과출력:
//나는 Tv
//나는 Audio
//나는 Tv
//나는 Audio
//나는 Tv
//나는 Tv
