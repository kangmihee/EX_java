package javaclass;
import java.io.IOException;
import java.io.*;
import java.util.*;
// Person의 wrapper 클래스 생성하시오
// ArrayList 자료구조 -> Iterator 사용
// 입출력 -> Scanner 사용
// 코딩순서: 메뉴 -> 입력 / 출력
class Person implements java.io.Serializable{
	 String name;  // 클래스 외부에서 진입
	 String gender;
	 String phone;
	 int age;
	 String addr;
	 String etc;	
	 
	public Person(String name, String gender, String phone, int age, String addr, String etc) {
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.age = age;
		this.addr = addr;
		this.etc = etc;
	}
	
	public Person() {}
	public String getName() {return name;} //메시지를 통한 정보교환
	public void setName(String name) {this.name = name;}

	public String isGender() {return gender;}
	public void setGender(String gender) {this.gender = gender;}

	public String getPhone() {return phone;}
	public void setPhone(String phone) {this.phone = phone;}

	public int getAge() {return age;}
	public void setAge(int age) {this.age = age;}

	public String getAddr() {return addr;}
	public void setAddr(String addr) {this.addr = addr;}

	public String getEtc() {return etc;}
	public void setEtc(String etc) {this.etc = etc;}
	
}

class Menu {
	ArrayList<Person> list;
	Iterator<Person> itr;
	Scanner in;
	
	public Menu() {
		list = new ArrayList<Person>();
		in = new Scanner(System.in);
	}
	
	public int PushMenu(){
		System.out.println("========주소록 관리========");
		System.out.println("--------------------");
		System.out.println("1.입력 2.출력 3.파일저장 4.로딩 5.종료");
		System.out.println("--------------------");
		System.out.print("메뉴를 선택하세요:");
		int ch = 0;
		ch = Integer.parseInt(in.nextLine());
		switch (ch) {
		case 1:
			input();
			return 1;
		case 2:
			display();
			return 1;
		case 3:
			save();
			return 1;
		case 4:
			loadFile();
			return 1;
		case 5:
			System.out.println("프로그램을 종료합니다.");
            in.close();			
            return 0;
		default:
			System.out.println("잘못입력하셨습니다.");
			return 1;
		}
	}
	
	// 1.입력
	public void input(){
		Person per = new Person();
		System.out.print("이름을 입력하세요.");
		per.name = in.nextLine();
		System.out.print("성별을 입력하세요.");
		per.gender = in.nextLine();
		System.out.print("핸드폰 번호를 입력하세요.");
		per.phone = in.nextLine();
		System.out.print("나이를 입력하세요.");
		per.age = Integer.parseInt(in.nextLine());
		System.out.print("주소를 입력하세요.");
		per.addr = in.nextLine();
		System.out.print("기타정보를 입력하세요.");
		per.etc = in.nextLine();
		list.add(per);
		
	}
	
	// 2.출력
	public void display() {
		System.out.println("**** 입력된 값들을 출력합니다. ****");
		System.out.println("-----------------------------------");
		ListIterator<Person> itr = list.listIterator();
		while (itr.hasNext()) { 
			Person s = itr.next(); 
			System.out.print("이름:" + s.getName());
			System.out.print(" 성별:" + s.isGender());
			System.out.print(" 핸드폰번호:" + s.getPhone());
			System.out.print(" 나이:" + s.getAge());
			System.out.print(" 주소:" + s.getAddr());
			System.out.println(" 기타정보:" + s.getEtc());
		}
	}
	
	// 3.파일저장
	public void save() {
		ListIterator<Person> itr = list.listIterator();
		while (itr.hasNext()) { 
			Person s = itr.next(); 
			try {
				FileOutputStream fileOut = new FileOutputStream("c:\\work\\AddressBook.txt");
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject(s);
				out.close();
				fileOut.close();
				System.out.println("Searialized data is saved in c:\\work\\AddressBook.txt");
			}
			catch (IOException i) {
				i.printStackTrace();
			}
		}
	}

	// 4. 파일로드
	public void loadFile() {
      Person e=null;
      try { // 상대경로 는(현재 프로그램이 실행되는 위치)이고 절대경로는(c:드라이버) 저장이다
         FileInputStream fileIn=new FileInputStream("c:\\work\\AddressBook.txt");
         ObjectInputStream in=new ObjectInputStream(fileIn);
         e=(Person)in.readObject();
         in.close();
         fileIn.close();
      }catch(IOException i) {
         i.printStackTrace();
         return ;
      }catch(ClassNotFoundException c) {
         System.out.println("AddressBook class 데이터가 없음");
         c.printStackTrace();
         return;
      }

      System.out.println("직렬화 데이터 로딩");
      System.out.print("이름:"+e.getName());
      System.out.print(" 성별:"+e.isGender());
      System.out.print(" 전화번호:"+e.getPhone());
      System.out.print(" 나이:"+e.getAge());
      System.out.print(" 주소:"+e.getAddr());
      System.out.println(" 기타정보:"+e.getEtc());
      
   }
}

public class ds3_AddressBook {
	public static void main(String[] args){
		Menu menu = new Menu();
		int i = 0;
		while(true) {
			i = menu.PushMenu();
			if(i == 0) {
				break;
			}
		}
	}
}

//출력결과:
//========주소록 관리========
//--------------------
//1.입력 2.출력 3.파일저장 4.로딩 5. 종료
//--------------------
//메뉴를 선택하세요:1
//이름을 입력하세요.박보검
//성별을 입력하세요.남자
//핸드폰 번호를 입력하세요.010-1234-5678
//나이를 입력하세요.25
//주소를 입력하세요.부천시
//기타정보를 입력하세요.ㅎㅅㅎ
//========주소록 관리========
//--------------------
//1.입력 2.출력 3.파일저장 4.로딩 5. 종료
//--------------------
//메뉴를 선택하세요:2
//**** 입력된 값들을 출력합니다. ****
//-----------------------------------
//이름:박보검 성별:남자 핸드폰번호:010-1234-5678 나이:25 주소:부천시 기타정보:ㅎㅅㅎ
//========주소록 관리========
//--------------------
//1.입력 2.출력 3.파일저장 4.로딩 5. 종료
//--------------------
//메뉴를 선택하세요:3
//Searialized data is saved in c:\work\AddressBook.txt
//========주소록 관리========
//--------------------
//1.입력 2.출력 3.파일저장 4.로딩 5. 종료
//--------------------
//메뉴를 선택하세요:4
//직렬화 데이터 로딩
//이름:박보검 성별:남자 전화번호:010-1234-5678 나이:25 주소:부천시 기타정보:ㅎㅅㅎ
//========주소록 관리========
//--------------------
//1.입력 2.출력 3.파일저장 4.로딩 5. 종료
//--------------------
//메뉴를 선택하세요: