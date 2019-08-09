package jdbc_test;
import java.sql.*;
import java.util.*;
import oracle.jdbc.OracleTypes;

public class employee_getcursor {
	public static void main(String[] args) {
		Connection con = new DBConnection().getConnection();
		CallableStatement stmt = null;
		ResultSet rs = null;
		Scanner input = new Scanner(System.in);
		System.out.println("Employee Role 입력: ");
		String role = input.nextLine();
		try {
			stmt = con.prepareCall("{call getEmployeeByRole(?,?)}");
			stmt.setString(1, role); // 직책은 문자열
			// OUT변수 : 커서문 => 내부적으로 테이블 그 자체
			stmt.registerOutParameter(2, OracleTypes.CURSOR);
			stmt.execute();
			
			rs = (ResultSet)stmt.getObject(2); 
			while (rs.next()) {
				System.out.println("Employee ID="+rs.getInt("empid")+", "
								 + "Name:"+rs.getString("name")+", "
								 + "Role:"+role+", "
								 + "City:"+rs.getString("city")+", "
								 + "Cuntry:"+rs.getString("country")); }
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			// stmt, re, con, input 닫으시오
			try {
				stmt.close();
				rs.close();
				con.close();
				input.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

//출력결과:
//Employee Role 입력: 
//대표
//Employee ID=1003, Name:발해인, Role:대표, City:서울, Country:대한민국
