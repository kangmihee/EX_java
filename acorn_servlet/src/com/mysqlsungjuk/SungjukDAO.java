package com.mysqlsungjuk;

import java.sql.*;
import java.util.*;
import javax.servlet.*;

import com.borad.DbcpBean;

public class SungjukDAO {
   private static SungjukDAO dao;
   private SungjukDAO() {}
   public static SungjukDAO getInstance() {
      if (dao==null) {//싱글톤
         dao=new SungjukDAO();
      }
      return dao;
   }
   public boolean addSungjuk(SungjukDTO dto) throws ServletException{
	      String query="insert into grade_table values(NULL,?,?,?,?,NULL,NULL)";
	      //NULL:autoINCREMENT  SEQUECE
	      //날짜 처리 DATA NOW() SYSDATE
	      Connection conn=null;
	      PreparedStatement pstmt=null;
	      boolean isSuccess=false;
	      try {
	         conn=new DbcpMyBean().getConn();
	         pstmt=conn.prepareStatement(query);
	         pstmt.setString(1,dto.getName());
	         pstmt.setInt(2,dto.getKor());
	         pstmt.setInt(3,dto.getMat());
	         pstmt.setInt(4,dto.getEng());

	         pstmt.executeUpdate();
	         pstmt.close();
	      }catch(SQLException ex) {
	         throw new ServletException("insert FAIL");
	      }finally {
	         //this.close();
	      }
	      return true;
	   }
}


