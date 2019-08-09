package com.borad;

import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource; //sql을 실행할 때 DB point 정보를 갖고 있는 객체

/*
 * Data Base Connection Pool Bean
 * 
 * - DataBase에 access 해서 작업하려면 Connection 객체가 필요하다.
 * - Connection 객체를 connection pool에 미리 만들어 놓고 필요할 때 마다
 * 	 사용하고 반납하는 구조로 사용해야한다.
 * - DbcpBean객체에서 리턴해주는 Connection 객체를 사용하고 .close()
 * 	 메소드를 호출하면 자동으로 반납된다.
 */

public class DbcpBean {
	//멤버필드
	private Connection conn;
	//생성자
	public DbcpBean() {
		try {
			//JNDI(Java naming and Directory Interface)
			//원격으로 클래스를 접속해서 사용하는 객체
			Context initContext = new InitialContext();
			//톰캣에서 제공하는 컴포넌트 환경
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/oraconn");
			conn = ds.getConnection();
			System.out.println("DbcpBean 작업성공!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//Connection 객체를 리턴해주는 메소드
	public Connection getConn() {
		return conn;
	}
	@Override
	protected void finalize() throws Throwable {
		conn.close();
	}
}
