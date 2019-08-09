package jdbc_test;
import java.util.*;
import java.lang.reflect.Executable;
import java.sql.*;

public class employee_select {
	public static void main(String[] args) {
		Connection con = new DBConnection().getConnection();
		CallableStatement stmt = null;
		Scanner input = new Scanner(System.in);
		System.out.println("Entry Employeee ID (int)");
		int id = Integer.parseInt(input.nextLine());
		
		try { //getEmployee 프로시저 이름
			stmt = con.prepareCall("{call getEmployee(?,?,?,?,?)}");
			stmt.setInt(1, id);
			
			stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
			stmt.registerOutParameter(3, java.sql.Types.VARCHAR);
			stmt.registerOutParameter(4, java.sql.Types.VARCHAR);
			stmt.registerOutParameter(5, java.sql.Types.VARCHAR);
			
			stmt.execute();
			
			String name = stmt.getString(2);
			String role = stmt.getString(3);
			String city = stmt.getString(4);
			String country = stmt.getString(5);
			
			// 받아 온 결과를 보는 것(리턴한 데이터가 있는가 확인하고 찍음)
			if(name != null) {
				System.out.println("Employeee Name : "+name+",Role : "+role+
						",City : "+city+",Country : "+country);
			}else {
				System.out.println("Employeee Not Found with ID" + id);
			}
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				con.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}

//출력결과:
//Entry Employeee ID (int)
//1001
//Employeee Name : 조선인,Role : 과장,City : 서울,Country : 대한민국
