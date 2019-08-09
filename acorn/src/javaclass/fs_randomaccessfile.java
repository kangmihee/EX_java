package javaclass;
import java.io.*;

public class fs_randomaccessfile {
	
	static final String FILEPATH = "c:\\work\\myfile.TXT";
	
	public static void main(String[] args) {
		try {
			// 바이트 단위로 저장
			writerToFile(FILEPATH, "I love my country and my people", 0);
			System.out.println(new String(readFromFile(FILEPATH, 0, 18)));
			writerToFile(FILEPATH, "I love my country and my people", 31);
			System.out.println(new String(readFromFile(FILEPATH, 30, 40)));
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static byte[] readFromFile(String filePath, int position, int size) throws IOException{
		RandomAccessFile file = new RandomAccessFile(filePath, "r");
		file.seek(position);
		byte[] bytes = new byte[size];
		file.read(bytes);
		file.close();
		return bytes;
	}
	private static void writerToFile(String filePath, String data, int position) throws IOException{
		RandomAccessFile file = new RandomAccessFile(filePath, "rw");
		file.seek(position);
		file.write(data.getBytes()); // file에 저장
		file.close(); // file은 프로그램에서 open했지만 system 자원낭비 방지위해 close해준다.
	}
}

//결과출력:
//I love my country 
//eI love my country and my people