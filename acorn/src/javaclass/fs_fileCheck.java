package javaclass;
import java.io.*;

public class fs_fileCheck {
	public static void main(String[] args) throws Exception{
		File f = new File("c:\\work\\filewriter_test.txt");
		if(f.exists()) {
			System.out.println("파일명:" + f.getName());
			System.out.println("파일경로:" + f.getPath());
			System.out.println("파일경로:" + f.getParent());
			System.out.println("파일크기:" + f.length() + "kb");
			System.out.println("최종수정일:" + new java.util.Date(f.lastModified()));
		}
		else {
			System.out.println(f.getName() + "라는 파일이 없습니다.");
			f.mkdir(); // 디렉토리만들수 있다
			f.createNewFile();
		}
	}
}

//출력결과:
//파일명:filewriter_test.txt
//파일경로:c:\work\filewriter_test.txt
//파일경로:c:\work
//파일크기:21kb
//최종수정일:Mon Mar 25 16:23:53 KST 2019