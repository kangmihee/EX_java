package javaclass;
import java.io.*;

public class fs_randomaccess {
	public static void main(String[] args) {
	try {
		int b1 = 15;
		int b2 = 20;
		// 바이트기반, 문자기반은 입출력이 분리됨
		// RandomAccessFile 은 입출력 통함
		// r:read, w:write a:append
		// 포인터 이동 중심
		
		RandomAccessFile raf = new RandomAccessFile("c:\\work\\test.txt", "rw");
		
		raf.write(b1); // 포인터 이동
		raf.seek(0); // seek()는 포인터 이동 명령, raf.readByte(); 는 사용 불가
		System.out.println("" + raf.readByte()); //포인트 끝으로 이동
		
		raf.write(b2); // 포인터가 2번
		raf.seek(1);
		System.out.println("" + raf.readByte());
	}
	catch (IOException ex) {
		ex.printStackTrace();
		}
	}
}

//결과출력:
//15
//20

