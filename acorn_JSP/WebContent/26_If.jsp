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
		boolean isCuccess = false;
		String work = "데이터 베이스 작업";
	%>
	<%
		if(isCuccess){ %>
		<script> //  자바스크립트에서도 JSP변수 사용가능
			alert("<%=work%>" + "성공");
		</script>
		<%}else{ %>
		<script>
			alert("<%=work%>" + "실패");
		</script>
	<%} %>
</body>
</html>