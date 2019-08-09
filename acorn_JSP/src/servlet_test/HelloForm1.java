package servlet_test;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
// JSP에서 외부 클래스 방법(호출)
//		0) <% %> 안에서 코딩하는 방법
// 		1) useBean : 액션태그 (정해진 포멧으로 데이터를 입출력하고 싶을 떄)
// 		2) JSP <% 태그에서 클래스를 인스턴스해서 사용하는 방법  (java코딩하듯이 사용)
// 		3) servlet을 사용하는 방법 MVC( model, view, controller)
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/HelloForm1")
public class HelloForm1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public HelloForm1() {
        super();
    }

    // get 방식으로 통신할 때 사용
    // JSP 에서는 request, response 가 implicit Object임
    // Servlet으로 프로그램시는 request, response 매개변수로 자동으로 입력됨
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8"); // 자리 fix
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out = response.getWriter();
		String title = "form 데이터를 get으로 받기";
		String docType = "<!docType html>";
		// String docType = "<!docType html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		String first_name = (String)request.getParameter("first_name");
		// first_name = new String(first_name.getBytes("ISO8859_1"), "UTF-8");
		String address = (String)request.getParameter("address");
		// address = new String(address.getBytes("ISO8859_1"), "UTF-8");
		out.println(docType +
				"<html>\n" +
				"<head><title>" + title + "</title></head>\n" + 
				"<body bgcolor=\"#f0f0f0\">\n" + 
				"<h1 align=\"center\">" + title + "</h1>\n" + 
				"<ul>\n" + 
				"  <li><b>name</b>: " + first_name + "\n" + "</li>" +
				"   <li><b>address</b>: " + address + "\n" + "</li>" +
				"</ul>\n" +
				"</body></html>");			
	}

	// post 방식으로 통신할 때 사용
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}





















