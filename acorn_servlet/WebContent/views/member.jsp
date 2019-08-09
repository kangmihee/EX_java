<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.mvc.Member_Dto" %>
    <%@ page import="com.mvc.Member_Dao" %>
    <%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List<Member_Dto> list = Member_Dao.getInstance().get_List();
	%>
	<table>
	<thead>
		<tr>
			<th>번호</th><th>이름</th><th>주소</th>
		</tr>
	</thead>
	<tbody>
		<%
			for(Member_Dto tmp:list){
		%>
		<tr>
			<td><%=tmp.getNum() %></td>
			<td><%=tmp.getName() %></td>
			<td><%=tmp.getAddr() %></td>
		</tr>
		<%} %>
	</tbody>
</table>
</body>
</html>