package javaclass;
import java.io.*;

public class fs_filelist {
	public static void main(String[] args) {
		File f = new File("c:\\work");
		File[] files = f.listFiles(); // 디렉터리의 파일 리스트
		System.out.println("파일로딩");
		for(int i=0,j=1;i<files.length;i++) {
			if(files[i].getName().endsWith(".java")) {
				System.out.println(j++ + " : " + files[i].getName()); // getName()은 문자열 출력
			}
		}
	}
}

//출력결과:

//endsWith(".txt")일때는
//파일로딩
//1 : filewriter_test.txt
//2 : sungjuk3.txt
//3 : test3.txt

//endsWith(".java")일때는
//파일로딩
//1 : fs_filelist.java
