<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%request.setCharacterEncoding("UTF-8"); %>
    <%
    	String id = request.getParameter("id");
    	String name = request.getParameter("name");
    	session.setAttribute("id", id);
    	session.setAttribute("name", name);
    	session.setAttribute("today", "건강한 마음으로 변화 되는 날!");
    	session.setAttribute("tomorrow", "변화된 내가 기대 되는 날");
    	session.setMaxInactiveInterval(3000); // seconds 기간동안 
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="15_Session_info2.jsp">Session info.jsp 호츌</a>
	<br>
	<a href="16_Session_digitcount.jsp">재방문 기록 호츌</a>
</body>
</html>