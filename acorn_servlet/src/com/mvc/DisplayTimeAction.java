package com.mvc;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayTimeAction extends Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String time = new Date().toString(); //날짜를 문자열로 변환
		//뷰로 데이터를 전송하는 방법은 속성을 추가하는 방법으로 구현
		request.setAttribute("time", time); //속성 추가
		ActionForward actionf = new ActionForward("/views/showTime.jsp");
		return actionf;
	}
}
