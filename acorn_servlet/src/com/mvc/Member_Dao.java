package com.mvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.borad.DbcpBean;
 
public class Member_Dao {
	private static Member_Dao dao;
	private Member_Dao() {} 
	public static Member_Dao getInstance() {
		if(dao == null) {
			dao = new Member_Dao();
		}
		return dao;
	}
	public List<Member_Dto> get_List() {
	      Connection conn =null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      List<Member_Dto> list = new ArrayList<Member_Dto>();
	      try {
	         conn = new DbcpBean().getConn();
	         String query = "SELECT num, name, addr FROM member ORDER BY num DESC";
	         pstmt = conn.prepareStatement(query);
	         rs = pstmt.executeQuery();
	         while (rs.next()) {
	            int num = rs.getInt("num");
	            String name = rs.getString("name");
	            String addr = rs.getString("addr");
	            Member_Dto dto = new Member_Dto(num,name,addr);
	            list.add(dto);
	         }
	         pstmt.close();
	         conn.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         try {
	            if(rs!=null) rs.close();
	         } catch (Exception e) {}
	      }
	      return list;
	   }
}
