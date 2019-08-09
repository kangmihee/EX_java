package com.mvc;

public class ActionForward {
	private String path; //이동할 위치
	private boolean isRedirect; //리다이렉트할 것인가 아닌가
	public ActionForward(String path) {
		this.path = path;
	}
	public ActionForward(String path, boolean isRedirect) {
		this.path = path;
		this.isRedirect = isRedirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
}
