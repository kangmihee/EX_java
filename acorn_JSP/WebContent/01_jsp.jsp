<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 지시자 : 컴파일러에게 지시 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- system.out.println() 함수가 JSP에서는 out 객체로 --%>
<%-- request, response, session, application, out (5개로 표현) --%>
<%! int i =0; %> 
<%! int a, b, c; %>
<% out.println("[1]에이콘 아카데미 챗봇과정"); %>
<hr><br>
		서버측 java server page입니다.
		JSP 시작입니다. (out 객체와 함께)
	<br>변수 i에 있는 값은<%= i %>입니다.
</body>
</html>