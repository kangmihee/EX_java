package javaclass;

// 일반화 프로그램
// 비교사는 Comparable 상속
// compareTo 함수는 같으면0, 크면1, 작으면 -1를 리턴

public class ds_generic_comparable {
	public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
		T max = x;
		if(y.compareTo(max) > 0) {
			max = y;
		}
		if(z.compareTo(max) > 0) {
			max = z;
		}
		return max;
	}
	public static void main(String[] args) {
//		 String[] str = {"10", "20", "30"};
//		 String ret = maximum(str);
//		 System.out.println("가장 작은 수 : " + ret );
		System.out.printf("Max of %d, %d and %d is %d\n\n", 3, 4, 5, maximum(3, 4, 5));
		System.out.printf("Max of %.1f, %.1f and %.1f is %.1f\n\n", 6.6, 7.7, 8.8, maximum(6.6, 7.7, 8.8));
		System.out.printf("Max of %s, %s and %s is %s\n\n", "pear", "apple", "orange", maximum("pear", "apple", "orange"));
	}
}

//출력결과:
//Max of 3, 4 and 5 is 5
//
//Max of 6.6, 7.7 and 8.8 is 8.8
//
//Max of pear, apple and orange is pear
