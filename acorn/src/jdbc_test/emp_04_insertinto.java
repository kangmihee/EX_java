package jdbc_test;
import java.sql.*;

public class emp_04_insertinto {
	public static void main(String[] args) {
		Connection conn = new DBConnection().getConnection();
		int no = 1400;
		String name = "에이콘";
		String job = "전산실";
		int mgr = 7698;
		Double sal = 2500.0;	
		
		PreparedStatement pstmt = null;
		try {
			String sql = "INSERT INTO emp (empno,ename,job,mgr,sal)" + "VALUES(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setString(2, name);
			pstmt.setString(3, job);
			pstmt.setInt(4, mgr);
			pstmt.setDouble(5, sal);
			pstmt.executeUpdate();
			System.out.println("회원정보를 저장했습니다.");
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
//회원정보를 저장했습니다.
	