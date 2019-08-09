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
	String grade = "1등급";
%>
<%-- 인클루된 패이지로는 request가 전달 되지 않음 --%>
<jsp:include page="Top.jsp">
	<jsp:param value="<%=grade%>>" name="grade"/>
</jsp:include>
<%
	out.println(request.getParameter("msg"));
	String msg = "삽입하는 페이지에도 가나";
	int number = 5;
	int count  =0;
	do {
%>
		<b><%=msg %></b><br>
<%
		count++;	
	}while(number > count); // do while
%>
<%@ include file="Bottom.jsp" %>
</body>
</html>