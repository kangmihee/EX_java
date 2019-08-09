package test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test2")
public class TestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public TestServlet2() {
        super();
    }
    protected void service(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
    	String num = request.getParameter("num");
    	String name = request.getParameter("name");
    	System.out.println("num:" + num);
    	System.out.println("name:" + name);
    	PrintWriter pw = response.getWriter();
    	pw.println("성공입니다.");
    }
}
