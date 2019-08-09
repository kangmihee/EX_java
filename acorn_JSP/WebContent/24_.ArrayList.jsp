<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List<String> names = new ArrayList<>();
		names.add("청춘은");
		names.add("빛나리");
		names.add("열정을");
		names.add("불태워");
		names.add("다함께");
	%>
	<h2>문자열 리스트 출력</h2>
	<ul>
		<li><%=names.get(0) %></li>
		<li><%=names.get(1) %></li>
		<li><%=names.get(2) %></li>
		<li><%=names.get(3) %></li>
		<li><%=names.get(4) %></li>
	</ul>
	<h2>문자열 리스트 출력2</h2>
	<ul> <!-- 자바문법만 사용 -->
		<%for(int i=0;i<names.size();i++){ %>
			<li><%=names.get(i) %></li>
		<% }%>
	</ul>
	<h2>문자열 리스트 출력3</h2>
	<ul>
		<%for(String tmp:names){ %>
		<li><%=tmp %></li>
		<%} %>
	</ul>
</body>
</html>










