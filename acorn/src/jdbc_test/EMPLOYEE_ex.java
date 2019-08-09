package jdbc_test;
import java.sql.*;
import java.util.*;
//문제 : EMPLOYEE 테이블을 생성한 다음 preparedStatement를 이용하여
//데이터입력, 데이터수정, 데이터삭제, 데이터검색을 할 수 있도록
//클래스를 생성해 보시오

class Menu {
	Connection conn = new DBConnection().getConnection();
	Scanner in;
	public Menu() {
		in = new Scanner(System.in);
	}
	public int PushMenu(){
		
		System.out.println();
		System.out.println("1.insert_into 2.update 3.delete 4.select 5.종료");
		int num = 0;
		num = Integer.parseInt(in.nextLine());
		switch (num) {
		case 1:
			insert_into();
			return 1;
		case 2:
			update();
			return 1;
		case 3:
			delete();
			return 1;
		case 4:
			select();
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
	
	public void addpstmt(PreparedStatement pstmt, int no, String name, 
			String role, String city, String country) throws Exception {
		pstmt.setInt(1, no);
		pstmt.setString(2, name);
		pstmt.setString(3, role);
		pstmt.setString(4, city);
		pstmt.setString(5, country);
		pstmt.addBatch(); // 여러개 입력시
		pstmt.clearParameters();
	}
	
	// 입력
	public void insert_into() {
		PreparedStatement pstmt = null;
		try {
			String sql = "INSERT INTO employee (empid,name,role,city,country)" + "VALUES(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
//			for(int i=0;i<3;i++) {
//				System.out.println("번호를 입력하세요.");
//				int no = Integer.parseInt(in.nextLine());
//				pstmt.setInt(1, no);
//				
//				System.out.println("이름을 입력하세요.");
//				String name = in.nextLine();
//				pstmt.setString(2, name);
//				
//				System.out.println("직책을 입력하세요.");
//				String role = in.nextLine();
//				pstmt.setString(3, role);
//				
//				System.out.println("위치를 입력하세요.");
//				String city = in.nextLine();
//				pstmt.setString(4, city);
//				
//				System.out.println("국적을 입력하세요.");
//				String country = in.nextLine();
//				pstmt.setString(5, country);
//				
//				pstmt.addBatch(); // 여러개 입력시
//				pstmt.clearParameters();
//			}
			addpstmt(pstmt, 1001, "조선인", "과장", "서울", "대한민국");
			addpstmt(pstmt, 1002, "성공해", "부장", "서울", "대한민국");
			addpstmt(pstmt, 1003, "발해인", "대표", "서울", "대한민국");
			//pstmt.executeUpdate(); // 한꺼번에 데이터 실행
			System.out.println("회원정보를 저장했습니다.");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 수정
	public void update() {
		PreparedStatement pstmt = null;
		String name1 = "성공인";
		String name2 = "성공해";
		try{ 
			String sql = "UPDATE employee SET name=? where name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  name1);
			pstmt.setString(2,  name2);
			pstmt.executeUpdate(); 
			System.out.println("회원정보를 수정했습니다.");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 삭제
	public void delete() {
		PreparedStatement pstmt = null;
		int num =1002;
		try {
			String sql = "DELETE FROM employee WHERE empid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  num);
			pstmt.executeUpdate();
			System.out.println("회원정보를 삭제했습니다.");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 검색
	public void select() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT empid,name,role,city,country FROM employee";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); 
			while(rs.next()) { 
				int empid = rs.getInt("empid"); 
				String name = rs.getString("name");
				String role = rs.getString("role");
				String city = rs.getString("city");
				String country = rs.getString("country");
				
				System.out.println(empid + " : " + name + " : " + role + " : " + city + " : " + country);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

public class EMPLOYEE_ex {
	public static void main(String[] args){
		Menu menu = new Menu();
		int i = 0;
		while(true) {
			i = menu.PushMenu();
			if(i == 0) {				
			}
		}
	}
}
