package javaclass;
import java.io.*;

public class fs_objectRead {
	public static void main(String[] args) {
		Employee e = null;
		try {
			FileInputStream fileIn = new FileInputStream("c:\\work\\test.txt");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			e = (Employee) in.readObject();
			in.close();
			fileIn.close();
		}
		catch (IOException i) {
			i.printStackTrace();
			return;
		}
		catch (ClassNotFoundException c) {
			System.out.println("Employee class 데이터가 없음");
			c.printStackTrace();
			return;
		}
		System.out.println("직렬화 데이터 로딩");
		System.out.println("Name: " + e.name);
		System.out.println("Address: " + e.address);
		System.out.println("SSN: " + e.SSN);
		System.out.println("Number: " + e.number);	
	}
}

//출력결과:
//직렬화 데이터 로딩
//Name: 대한민국
//Address: 서울시 종로구
//SSN: 0
//Number: 101


// 객체 직렬화를 이용해서 주소록 프로그램에 파일 저장 메뉴를 추가하시오