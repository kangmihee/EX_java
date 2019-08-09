package com.mvc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

//Controller

@WebServlet("*.do")
public class CommandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final int INCLUDE_EXTENSION_LENGTH = 3;
    public CommandServlet() { super(); }
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//전송정보 추출 REST방식
    	//fortune.do => 서버에 있는 파일명을 알게 됨
    	//앞 단어에 따라 mapping
    	String uri = request.getRequestURI(); //전체 주소
    	String contextName = request.getContextPath(); //파일명을 제외한 정보
    	String command = uri.substring(contextName.length(), uri.length() - INCLUDE_EXTENSION_LENGTH);
    	//
    	//if command = "fortune"  ..;
    	//else command = "abc";
    	//공장에서 command에 따른 객체를 생성한 다음
    	//Action을 상속받은 자식 객체를 인스턴스
    	//상속 : 부모는 자식을 가리킬 수 있음.
    	
    	//실행할 객체가 만들어져서 리턴
    	//factory pattern : 객체를 상황에 맞게 생성해주는 것을 말한다.
    	Action action = UserActionFactory.getInstance().action(command);
    	if (action != null) {
    		//데이터를 다음으로 넘겨주는 것이 View
			ActionForward af = null;
			try {
				//어디로 갈 것인지 즉 보여줄 것이 무엇인지 view
				//command pattern
				af = action.execute(request, response); //한번에 실행된다.
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
			if (af.isRedirect()) {
				response.sendRedirect(contextName + af.getPath());
			} else { //servlet에서 forwarding 하는 방법
				RequestDispatcher rd = request.getRequestDispatcher(af.getPath());
				//중간에 추가할 데이터가 있으면
				rd.forward(request, response);
			}
		}
	}
}
