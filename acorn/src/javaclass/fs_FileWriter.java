package javaclass;
import java.io.*;

public class fs_FileWriter {
	public static void main(String[] args) {
		// 파일 입출력은 에외처리
		// FileWriter는 문자를기반으로 출력
		FileWriter writer = null;
		try {
			writer = new FileWriter("c:\\work\\filewriter_test.txt");
			char arr[] = {'에','이','콘','아','카','데','미'};
			for(int cnt=0; cnt<arr.length;cnt++) {
				writer.write(arr[cnt]);
			}
		}catch (IOException e) {
			System.out.println("1 파일로 출력할 수 없습니다.");
		}
		finally {
			try{
				writer.close();
				System.out.println("파일을 출력했습니다.");
			}catch (Exception e) {	
			}
		}
	}
}

//결과출력:
//파일을 출력했습니다.
