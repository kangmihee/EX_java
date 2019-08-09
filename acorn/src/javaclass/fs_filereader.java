package javaclass;
import java.io.*;

public class fs_filereader {
	public static void main(String[] args) throws Exception{
		FileReader reader = new FileReader("c:\\work\\filewriter_test.txt");
		while(true) {
			int data = reader.read(); // 한번에 한개씩
			if(data == -1) // 파일read는 끝은경우 -1을 return
				break;
			char ch = (char) data;
			System.out.print(ch + " ");
		}
		reader.close();

		try {
			FileReader reader2 = new FileReader("c:\\work\\filewriter_test.txt");
			while(true) {
				int data = reader2.read(); 
				if(data == -1)
					break;
				char ch = (char) data;
				System.out.print(ch);
			}
			reader.close();
		}
		catch (FileNotFoundException fnfe) {
			System.out.print("파일이 존재하지 않습니다.");
		}
		catch (IOException ioe) {
			System.out.print("파일을 읽을 수 없습니다.");
		}
	}
}

//출력결과:
//에 이 콘 아 카 데 미 에이콘아카데미 