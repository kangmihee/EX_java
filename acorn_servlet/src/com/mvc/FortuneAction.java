package com.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FortuneAction extends Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String fortuneToday = "모든 것이 servlet에 의하여 구동";
		request.setAttribute("fortuneToday", fortuneToday);
		ActionForward af = new ActionForward("/views/fortune.jsp");
		return af;
	}
}
