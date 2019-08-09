package test.servlet;

import java.io.PrintWriter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public InsertServlet() {
        super();
    }
    //service => doGet/doPost로 분리해서 작업됨
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		System.out.println("name: " + name);
		System.out.println("addr: " + addr);

		PrintWriter pw = response.getWriter();
		pw.println("입력성공!");
	}
}
// html 요철 => jsp(호출 : script), servlet(이벤트로 받음)