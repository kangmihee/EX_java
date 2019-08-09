package javaclass;
import java.util.*;
import java.io.*;

public class ds_properties2 {
	public static void main(String[] args) {
		Properties prop = new Properties();

		prop.setProperty("timeout", "30");
		prop.setProperty("language", "한글");
		prop.setProperty("size", "10");
		prop.setProperty("capacity", "10");
		prop.setProperty("data", "100,200,300"); // 여러개의 data 입력가능(배열)
		prop.setProperty("name", "이상구");  // key, data 형식...
		
		try {
			prop.store(new FileOutputStream("c:\\work\\test3.txt"), // 파일로 저장 FileOutputStream, 파일명 지정
					 						"Properties Example");
		}catch (IOException e) {
			e.printStackTrace();
		}
		try {
			prop.load(new FileInputStream("c:\\work\\test3.txt")); // 파일 로딩
		}catch (IOException e) {
			System.out.println("지정된 파일을 찾을 수 없습니다.");
			System.exit(0);
		}
		
		String name = prop.getProperty("name"); // 로딩된 파일이름 가져옴
		String[] data = prop.getProperty("data").split(","); // 분리문자열 , 배열로 값 가져옴 (100,200,300)
		int max = 0;
		int min = 0;
		int sum = 0;
		for(int i=0;i<data.length;i++) { // 화일로 저장시 문자로 저장 => 변환
			int intValue = Integer.parseInt(data[i]); // 정수화
			if(i==0) max = min = intValue; // 최대, 최소값
			
			if(max < intValue) {
				max = intValue;
			}else if (min > intValue) {
				min = intValue;
			}
			sum += intValue; // 합계
		}
		System.out.println("이름: " + name);
		System.out.println("최댓값: " + max);
		System.out.println("합계: " + sum);
	}
}
