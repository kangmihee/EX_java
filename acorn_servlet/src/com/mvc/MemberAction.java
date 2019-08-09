package com.mvc;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;

import com.borad.DbcpBean;
import com.mvc.Member_Dto;
import com.mvc.Member_Dao;
 
public class MemberAction extends Action{
	@Override 
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		List<Member_Dto> list = Member_Dao.getInstance().get_List();
		Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
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
            
         }catch(Exception e) {
            e.printStackTrace();
         }finally {
            try {
               if(rs != null) rs.close();
            }catch(Exception e) {}
         }request.setAttribute("name", list);
 		  ActionForward actionf=new ActionForward("/views/member.jsp");
		return actionf;
	}
}
 