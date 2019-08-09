package javaclass;
import java.io.*;
// 직렬화
// 방법 -> java.io.Serializable;

class Employee implements java.io.Serializable {
	public String name;
	public String address;
	public transient int SSN;
	public int number;
	
	public void mailCheck() {
		System.out.println("Mail ");
	}
}
public class fs_Objectfilesystem {
	public static void main(String[] args) {
		Employee e = new Employee();
		e.name = "대한민국";
		e.address = "서울시 종로구";
		e.SSN = 11122333;
		e.number = 101;
		
		try {
			FileOutputStream fileOut = new FileOutputStream("c:\\work\\test.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(e);
			out.close();
			fileOut.close();
			System.out.println("Searialized data is saved in c:\\work\\test.txt");
		}
		catch (IOException i) {
			i.printStackTrace();
		}
	}
}

//출력결과:
//Searialized data is saved in c:\work\test.txt
