package Model_view_con_ex;
import java.sql.*;
import java.util.*;
import oracle.jdbc.*;

class EX_Control {
	EX_Control() {}
	Connection con = new DB_Connection().getConnection();
	CallableStatement stmt = null;
	ResultSet rs = null;
	Scanner in = new Scanner(System.in);
	
	// 검색
	public Connection insertinto() {
		Connection coninsert = null;
		EX_Model model = new EX_Model();
		SungjukView view = new SungjukView();
		System.out.println("No:");
		int no = Integer.parseInt(in.nextLine());
		System.out.println("Name:");
		String name = in.nextLine();
		System.out.println("Kor:");
		int kor = Integer.parseInt(in.nextLine());
		System.out.println("Eng:");
		int eng = Integer.parseInt(in.nextLine());
		System.out.println("Mat:");
		int mat = Integer.parseInt(in.nextLine());
		int total = kor + eng + mat;
		float avr =(total/3);
		try {
			stmt = con.prepareCall("{call insertsungjuk(?,?,?,?,?,?,?)}");
			stmt.setInt(1, no); 
			stmt.setString(2, name); 
			stmt.setInt(3, kor); 
			stmt.setInt(4, eng); 
			stmt.setInt(5, mat); 
			stmt.setInt(6, total); 
			stmt.setFloat(7, avr); 
			stmt.executeUpdate();
			model.setNo(no);
			model.setName(name);
			model.setKor(kor);
			model.setEng(eng);
			model.setMat(mat);
			model.setTotal(total);
			model.setAvr(avr);
			System.out.println("데이터를 추가 하였습니다.");
			view.print(model.getNo(), model.getName(), model.getKor(), 
					   model.getEng(), model.getMat(), model.getTotal(), model.getAvr());
		}catch (Exception e) {
			e.printStackTrace();
		}
		return coninsert;
	}
	
	// 수정
	public Connection update() {
		EX_Model model = new EX_Model();
		SungjukView view = new SungjukView();
		Connection conupdate = null;
		System.out.println("수정할 데이터의 이름을 입력하세요.");
		String name1 = in.nextLine();
		System.out.println("새로 바꿀 이름을 입력하세요.");
		String name2 = in.nextLine();
		try {
			stmt = con.prepareCall("{call updatesungjuk(?,?)}");
			stmt.setString(1, name1); 
			stmt.setString(2, name2); 

			stmt.execute();
			System.out.println("'"+name1+"' 의이름을 '"+name2+"' 로 바꾸었습니다.");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return conupdate;
	}
	
	
	// 삭제
	public Connection delete() {
		Connection condelete = null;
		System.out.println("삭제할 데이터의 이름을 입력하세요.");
		String name = in.nextLine();
		try {
			stmt = con.prepareCall("{call deletesungjuk(?)}");
			stmt.setString(1, name); 
			stmt.execute();
			System.out.println(name+"의 데이터를 삭제했습니다.");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return condelete;
	}
	
	
	// 검색
	public Connection select() {
		EX_Model model = new EX_Model();
		SungjukView view = new SungjukView();
		Connection conselect = null;
		System.out.println("검색할 사람을 입력하세요: ");
		String selectname = in.nextLine();
		try {
			stmt = con.prepareCall("{call selectsungjuk(?,?)}");
			stmt.setString(1, selectname); 
			stmt.registerOutParameter(2, OracleTypes.CURSOR);
			stmt.execute();
			
			rs = (ResultSet)stmt.getObject(2); 
			while (rs.next()) {
				int number = rs.getInt("no");
				model.setNo(number);
				model.setNo(rs.getInt("no"));
				model.setName(rs.getString("name"));
				model.setKor(rs.getInt("kor"));
				model.setEng(rs.getInt("mat"));
				model.setMat(rs.getInt("mat"));
				model.setTotal(rs.getInt("total"));
				model.setAvr(rs.getFloat("avr"));
				view.print(model.getNo(), model.getName(), model.getKor(), 
						   model.getEng(), model.getMat(), model.getTotal(), model.getAvr());
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return conselect;
	}
}
