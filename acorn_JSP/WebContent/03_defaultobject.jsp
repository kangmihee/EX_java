<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<% 
	// Math, String, Date 같은 기본 객체는 import 없이 사용가능
	/* 연습입니다. */
	float f = 2.5f;
	int i = Math.round(f);
	java.util.Date date = new java.util.Date();
%>
	반올림 : <%=i%><br>
	현재날짜 : <%=date.toString() %>
	시간 : <%=date.getHours() %>
</body>
</html>