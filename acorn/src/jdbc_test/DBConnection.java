package jdbc_test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
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

//출력결과:
//7902 : FORD : ANALYST
//7934 : MILLER : CLERK
//7499 : ALLEN : 전산
//7521 : WARD : SALESMAN
//1245 : jung : SALESMAN
//1245 : jung : SALESMAN

//emp_02_update의 try문 주석처리하면 
//회원정보를 수정했습니다.
