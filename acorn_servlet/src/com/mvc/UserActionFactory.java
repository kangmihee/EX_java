package com.mvc;

public class UserActionFactory { //singleton은 오로지 하나의 객체 생성
	private static UserActionFactory factory;
	private UserActionFactory() {} //생성자를 은닉
	public static UserActionFactory getInstance() { //퍼블릭함수로만 접근가능
		if (factory == null) {
			factory = new UserActionFactory();
		}
		return factory;
	}
	public Action action(String command) {
		Action action = null;
		if (command.equals("/fortune")) {
			action = new FortuneAction();
		} else if (command.contentEquals("/displaytime")) {
			action = new DisplayTimeAction();
		}else if (command.contentEquals("/member")) {
			action = new MemberAction();
		}
		return action;
	}
}
