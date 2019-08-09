package jdbc_test;
import java.sql.Connection;
import java.sql.SQLException;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;
import java.util.Scanner;
import oracle.jdbc.OracleCallableStatement;
import oracle.net.aso.s;

public class employee_call_insertEmployee {
	public static void main(String[] args) {
		Connection con = new DBConnection().getConnection();
		OracleCallableStatement stmt = null;
		// 배열에 입력데이터를 모두 받음
		// 최상위 Object - 객체는 Object 부모는 자식을 가리킬 수 있음
		Object[] empObjArray = new Object[5]; // Object 배열 : 숫자,문자 모두 들어갈 수 있음
		Scanner input = new Scanner(System.in);
		
		System.out.println("  ID (int)  ");
		empObjArray[0] = Integer.parseInt(input.nextLine());
		System.out.println("Name:");
		empObjArray[1] = input.nextLine();
		System.out.println("Role:");
		empObjArray[2] = input.nextLine();
		System.out.println("City:");
		empObjArray[3] = input.nextLine();
		System.out.println("Country:");
		empObjArray[4] = input.nextLine();
		// 입력된 데이터의 데이터 타입을 확인할 수 없음
		// 서버측에 디스크립터를 만들어서 보내면 서버에서 자동으로 파싱함
		try {
			StructDescriptor empStructDesc = StructDescriptor.createDescriptor("EMPLOYEE_OBJ", con);
			STRUCT empStruct = new STRUCT(empStructDesc, con, empObjArray);
			
			stmt = (OracleCallableStatement)con.prepareCall(
					"{call insertEmployeeObject(?,?)}"); // 매개변수 (in변수)
			stmt.setSTRUCT(1, empStruct); // 한꺼번에 5개의 데이터 입력
			stmt.registerOutParameter(2, java.sql.Types.VARCHAR); // 2번째의 데이터를 가져온다?
			stmt.executeUpdate();
			String result = stmt.getString(2);
			System.out.println("입력성공::" + result );
		}catch (Exception e) {
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
//ID (int)  
//1004
//Name:
//차은우
//Role:
//사장
//City:
//서울
//Country:
//대한민국
//
//입력성공::TRUE

