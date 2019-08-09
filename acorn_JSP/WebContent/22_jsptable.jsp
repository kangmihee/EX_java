<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- Directive 지시자 -->
<!DOCTYPE html> <!-- html5는 반드시 이것으로 시작 -->
<html>
<head>
<meta charset="UTF-8"> <!-- meta는 이 문서의 관한 것 -->
<title>Insert title here</title>
</head>
<body>
	<% // jsp태그 안에서는 java프로그래밍이 가능
		int num = 1;
	 	String name = "대한민국";
	 	String addr = "종로구";
	%>
	<!-- 변수를 지정하면 값을 출력 -->
	<p>번호 : <strong><%=num %></strong></p> <!-- 브라우저의 리턴은 Box model 또는 <br> -->
	<p>이름 : <strong><%=name %></strong></p>
	<p>주소 : <strong><%=addr %></strong></p>
</body>
</html>