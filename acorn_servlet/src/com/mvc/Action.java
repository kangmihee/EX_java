package com.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//이벤트 콜백함수(이벤트가 호출함)
public abstract class Action { //추상클래스 / 반드시 오버라이딩을 한다.
	public abstract ActionForward execute(HttpServletRequest request, HttpServletResponse response);
}
