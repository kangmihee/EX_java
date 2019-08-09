package Model_view_con_ex;
import java.sql.*;
import java.util.Scanner;

class DB_Connection {
	private static final String DB_DRIVER_CLASS = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String DB_USERNAME = "c##scott3";
	private static final String DB_PASSWORD = "owo0224662603";
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(DB_DRIVER_CLASS);
			con = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}

class SungjukView {
	EX_Model model = new EX_Model();
	Scanner in;
	Connection coninsert;
	public SungjukView() {
		in = new Scanner(System.in);
	}
	public int PushMenu(){
		System.out.println("------------------------------");
		System.out.println("1.insert_into  2.update  3.delete  4.select  5.종료");
		System.out.println("메뉴를 고르세요: ");
		int num = 0;
		num = Integer.parseInt(in.nextLine());
		switch (num) {
		case 1:
			new EX_Control().insertinto();
			return 1;
		case 2:
			new EX_Control().update();
			return 1;
		case 3:
			new EX_Control().delete();
			return 1;
		case 4:
			new EX_Control().select();
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
	
	public void print(int no, String name, int kor, int eng, int mat, int total, float avr) {
		System.out.println("No=:"+no+",  "
						 + "Name:"+name+",  "
						 + "Kor:"+kor+",  "
						 + "Eng:"+eng+",  "
						 + "Mat:"+mat+",  "
						 + "Total:"+total+",  "
						 + "Avr:"+avr);
	}
}

public class EX_View {
	public static void main(String[] args) {
		SungjukView menu = new SungjukView();
		int i = 0;
		while(true) {
			i = menu.PushMenu();
			if(i == 0) {		
				break;
			}
		}
	}	
}
