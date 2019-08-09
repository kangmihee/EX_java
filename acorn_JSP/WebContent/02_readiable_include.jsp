<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%! String name = "나라사랑";%>
	<%  String addr = "서울시 종로구";%>
	<br> 이름 :
	<%=name%>
	<br> 주소 :
	<% out.println(addr); %>
	<br>
	<jsp:include page="age.jsp"></jsp:include> <!-- 공통부분을 공유하기 위해서 -->
	<br>
</body>
</html>