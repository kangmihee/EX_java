package jdbc_test;
import java.sql.*;
import java.util.*;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

import java.lang.reflect.Executable;

//정리문제: callableStatement를 사용하는 예
//삭제 프로시져(이름으로)와 수정 프로시져(이름을 수정)를 작성하시오
//employee 데이터를 삽입, 삭제, 수정, 검색 하는 객체를 구현하시오
//class base로 작성하고 각 기능함수를 구현한 다음
//main에서 class를 호출해서 작동하도록 구현하시오
class Menu02 {
	Connection con = new DBConnection().getConnection();
	CallableStatement stmt = null;
	ResultSet rs = null;
	Scanner in;
	public Menu02() {
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
	
	
	// 입력
	public void insert_into() {
		OracleCallableStatement stmt = null;
		Object[] empObjArray = new Object[5];
		System.out.println("ID:");
		empObjArray[0] = Integer.parseInt(in.nextLine());
		System.out.println("Name:");
		empObjArray[1] = in.nextLine();
		System.out.println("Role:");
		empObjArray[2] = in.nextLine();
		System.out.println("City:");
		empObjArray[3] = in.nextLine();
		System.out.println("Country:");
		empObjArray[4] = in.nextLine();
		try {
			StructDescriptor empStructDesc = StructDescriptor.createDescriptor("EMPLOYEE_OBJ", con);
			STRUCT empStruct = new STRUCT(empStructDesc, con, empObjArray);
			
			stmt = (OracleCallableStatement)con.prepareCall(
					"{call insertEmployeeObject(?,?)}"); 
			stmt.setSTRUCT(1, empStruct); 
			stmt.registerOutParameter(2, java.sql.Types.VARCHAR); 
			stmt.executeUpdate();
			System.out.println("데이터를 추가 하였습니다.");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	// 수정
	public void update() {
		System.out.println("수정할 데이터의 이름을 입력하세요.");
		String name1 = in.nextLine();
		System.out.println("새로 바꿀 이름을 입력하세요.");
		String name2 = in.nextLine();
		try {
			stmt = con.prepareCall("{call updateEmployee(?,?)}");
			stmt.setString(1, name1); 
			stmt.setString(2, name2); 

			stmt.execute();
			System.out.println("'"+name1+"' 의이름을 '"+name2+"' 로 바꾸었습니다.");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 삭제
	public void delete() {
		System.out.println("삭제할 데이터의 이름을 입력하세요.");
		String name = in.nextLine();
		try {
			stmt = con.prepareCall("{call deleteEmployee(?,?)}");
			stmt.setString(1, name); 
			//stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
			stmt.execute();
			System.out.println(name+"의 데이터를 삭제했습니다.");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 검색
	public void select() {
		System.out.println("검색할 데이터의 직책을 입력하세요: ");
		String role = in.nextLine();
		try {
			stmt = con.prepareCall("{call getEmployeeByRole(?,?)}");
			stmt.setString(1, role); 
			stmt.registerOutParameter(2, OracleTypes.CURSOR);
			stmt.execute();
			
			rs = (ResultSet)stmt.getObject(2); 
			while (rs.next()) {
				System.out.println("Employee_ID=:"+rs.getInt("empid")+",  "
								 + "Name:"+rs.getString("name")+",  "
								 + "Role:"+role+",  "
								 + "City:"+rs.getString("city")+",  "
								 + "Cuntry:"+rs.getString("country")); }
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

public class EMPLOYEE_ex2 {
	public static void main(String[] args) {
		Menu02 menu = new Menu02();
		int i = 0;
		while(true) {
			i = menu.PushMenu();
			if(i == 0) {		
				break;
			}
		}
	}
}