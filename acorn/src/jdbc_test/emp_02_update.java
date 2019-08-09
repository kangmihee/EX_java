package jdbc_test;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class emp_02_update {
	public static void main(String[] args) {
		Connection conn = new DBConnection().getConnection();
		/*
		 * try { Class.forName("oracle.jdbc.driver.OracleDriver"); String url =
		 * "jdbc:oracle:thin:@localhost:1521:xe"; conn =
		 * DriverManager.getConnection(url, "c##scott3", "owo0224662603");
		 * System.out.println("Oracle DB 접속 성공!"); }catch (Exception e) {
		 * e.printStackTrace(); }
		 */
		int num = 7499;
		String addr = "전산";
		String addr2 = "IT";
		// Statement -> PreparedStatement -> CallableStatement
		PreparedStatement pstmt = null;
		try{ // 데이터입력 부분은? : 여러개의 데이터에 반복 해서 사용하기 위해 ?
			String sql = "UPDATE emp SET job=? WHERE empno=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,  addr);
			pstmt.setInt(2,  num);
			pstmt.executeUpdate(); // insert into, update, delete 경우에 호출
			
			pstmt.setString(1,  addr2);
			pstmt.setInt(2,  num);
			pstmt.executeUpdate();
			
			System.out.println("회원정보를 수정했습니다.");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch (Exception e) {}
		}
	}
}

//출력결과:
//Oracle DB 접속 성공!
//회원정보를 수정했습니다.

//try문 주석처리하면
//회원정보를 수정했습니다.
