package javaclass;
// 자바 시스템에서 옵션을 저장할 때 사용
import java.util.*;
import java.io.*;

public class ds_properties {
	public static void main(String[] args) throws Exception{ //throws Exception : 예외처리 해줘야 prop.store 가능 
		Properties prop = new Properties(); // 화일 : 문자열로 저장
		prop.setProperty("timeout", "30");
		prop.setProperty("language", "kr");
		prop.setProperty("size", "10");
		prop.setProperty("capacity", "10");
		Enumeration e = prop.propertyNames();
		while(e.hasMoreElements()) {
			String element = (String)e.nextElement();
			System.out.println(element + "=" + prop.getProperty(element));
		}
		prop.setProperty("size", "20");
		System.out.println("size= " + "=" + prop.getProperty("size"));
		
		// 실제 자바에서...System.getProperty() : 자바 시스템이 지원하는 속성값 획득
		// 파일로 저장시 저장 함수를 호출하는 함수에서 예외처리를 해야 함
		prop.store(new FileWriter("info.properties"), "이건테스트로 저장");
		Properties sysProp = System.getProperties();
		System.out.println("java.version :" + sysProp.getProperty("java.verion"));
		System.out.println("user.langue :" + sysProp.getProperty("user.langue"));
		sysProp.list(System.out); // 전체속성출력
			// System.out : 표준출력장치
		 	// System.in  : 표준입력장치		
	}
}

//결과출력:
//capacity=10
//size=10
//timeout=30
//language=kr
//size= =20
//java.version :null
//user.langue :null

//System.out에 관한 전체속성출력
