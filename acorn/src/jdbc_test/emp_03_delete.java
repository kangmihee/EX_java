package jdbc_test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class emp_03_delete {
	public static void main(String[] args) {
		Connection conn = new DBConnection().getConnection();
		int num =7499;
		PreparedStatement pstmt = null; // 한개의 데이터를 다룰때도 ? 를 사용
		try {
			String sql = "DELETE FROM emp WHERE empno=?";
			pstmt = conn.prepareStatement(sql);
			// 데이터 타입 불일치 할때 에러가 많이 발생
			pstmt.setInt(1,  num);
			pstmt.executeUpdate();
			System.out.println("회원정보를 삭제했습니다.");
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
//회원정보를 삭제했습니다.
