package test.servlet;

import java.io.PrintWriter;
import java.util.Random;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/todayselectServlet") //호출자
public class todayselectServlet extends HttpServlet { //이벤트에 대한 콜백
	private static final long serialVersionUID = 1L;
    
    public todayselectServlet() {
        super();
        
    }
    // servlet은 자동호출 service => doGet, doPost를 호출
    @Override //오버라이딩
	protected void service(HttpServletRequest requset, HttpServletResponse response) 
			throws ServletException, IOException {
		String[] list = {"즐거운 일주일의 시작이니 맘 잘먹으면 좋은일 있을거예요","로또사면 좋은 날","프로젝트 고민은 좋은 결과를 보게 될 겁니다"};
		int index = new Random().nextInt(3);
		String fortune = list[index];
		//출력
		response.setCharacterEncoding("UTF-8"); // webBrowser에서 해석을 인코딩 지정
		response.setContentType("text/html;charset=UTF-8"); // 전달되는 데이터타입 지정
		//out은 JSP에서 디폴트로 출력
		PrintWriter out = response.getWriter(); // 응답객체에서 출력 대상객체 얻기
		out.println("<!DOCTYPE html>"); // 출력할 HTML 파일 생성
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8' />");
		out.println("<title>오늘의 선택 페이지</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>" + fortune + "</p>");
		out.println("</body>");
		out.println("</html>");
	}
}
