<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
	String name = request.getParameter("name");
	String bloodType = request.getParameter("bloodType");
%>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	당신의 이름은 <%=name %>이고요<br>
	<b><%=bloodType %></b>형이고<br>
	좋아요.
</body>
</html>