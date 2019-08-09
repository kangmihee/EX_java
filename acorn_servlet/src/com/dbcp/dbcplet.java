package com.dbcp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.borad.DbcpBean;

@WebServlet("/dbcplet")
public class dbcplet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public dbcplet() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body><center><h3>");
		
		Connection conn = null;
		PreparedStatement ptmt = null;
		String query = "INSERT INTO test_table VALUES(?,?)";
		
		conn = new DbcpBean().getConn(); //Connection pool에서 접속 포인트 정보
		try {
			ptmt = conn.prepareStatement(query);
			ptmt.setString(1, name);
			ptmt.setString(2, age);
			int res = ptmt.executeUpdate();
			if (res>0) {
				out.println("저장성공");
			}
			ptmt.close();
			conn.close();
		} catch (Exception e) {
			out.println("SQL Process Error:" + e.getMessage());
		}
		out.println("</h3></center></body></html>");
	}
}
