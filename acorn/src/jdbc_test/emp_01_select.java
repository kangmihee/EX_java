package jdbc_test;
//import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
// Collection -> Statement -> ResultSet
// Statement, PreparedStatement -> CallableStatement

public class emp_01_select {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			// 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 장치 id까지
			String url ="jdbc:oracle:thin:@localhost:1521:xe"; // @localhost를 ip주소로 주면 다른 ip 접속 가능
			// 실제연결명령
			conn = DriverManager.getConnection(url, "c##scott3", "owo0224662603"); // scott은 DB, 비밀번호는tiger 에 접속
			System.out.println("Oracle DB 접속 성공!");
		}catch (Exception e) {
			e.printStackTrace();
		}
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 실제 서버에 전달된 쿼리문(문자열을 준비)
			String sql = "SELECT empno, ename, job FROM emp";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); // DQL을 사용할 때 적용, executeQuery()함수가 서버로 전달..?
			while(rs.next()) { // 테이블, 자료구조
				int empno = rs.getInt("empno"); // 컬럼타임과 일치하게 함수 적용
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				System.out.println(empno + " : " + ename + " : " + job);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally { // 예외가 없이도 실행
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();			
			}catch (Exception e) {}
		}// try
	}
}

//출력결과:
//Oracle DB 접속 성공!
//7902 : FORD : null
//7566 : JONES : MANAGER
//7698 : BLAKE : MANAGER
//7782 : CLARK : MANAGER
//7839 : KING : PRESIDENT
//7844 : TURNER : SALESMAN
//7876 : ADAMS : CLERK
//7900 : JAMES : CLERK
//7902 : FORD : ANALYST
//7934 : MILLER : CLERK
//7499 : ALLEN : 전산
//7521 : WARD : SALESMAN
//1245 : jung : SALESMAN
//1245 : jung : SALESMAN
