package test.servlet;

import java.io.PrintWriter;
import java.util.Date;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/time/showtime")
public class ShowTimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowTimeServlet() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<meta charset='UTF-8' />");
		pw.println("<title>현재시간 페이지</title>");
		pw.println("</head>");
		pw.println("<body>");
		
		Date date = new Date();
		pw.println("<p>" + date.toString() + "</p>");
		pw.println("</body>");
		pw.println("</html>");
	}
}
