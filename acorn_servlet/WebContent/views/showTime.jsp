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
	String time = (String)request.getAttribute("time");
%>
<p> 현재 시간 : <strong><%=time %></strong></p>
</body>
</html>