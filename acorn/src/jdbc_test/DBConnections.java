package jdbc_test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// DBConnection con = new DBConnection();
// Singleton
// 생성자는 private로 막음
// 함수를 이요해서 인스턴스를 한번만 하도록 한다.
// 인스턴스 한번 만들어 지고 공용으로 사용됨
// Singleton은 (logging, cashing, thread pools, configurations : 한 프로그램에서 하나의 값만 필요 = 한번만 생성해야 되는 경우 ) 에서 사용

public class DBConnections {
	private static final String DB_DRIVER_CLASS = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String DB_USERNAME = "c##scott3";
	private static final String DB_PASSWORD = "owo0224662603";
	
	private DBConnections() {} // 생성자를 private으로 변경...DBConnection은 instance불가능 상태 
	static Connection con = null;
	// Singleton design pattern 의 적용(자원활용의 효율성)
	
	public static Connection getConnection() {
		if (con == null) { // null인 경우만 instance (1번만 instance됨)
			try {
				Class.forName(DB_DRIVER_CLASS);
				con = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return con; // 동알헌 주소의 주소값만 넘어감
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
