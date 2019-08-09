<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% // page, request, session, application
	Integer hitsCont = (Integer)application.getAttribute("hitsCont");  // 메모리에 값이 저장되기 때문에 영구 저장되지 않음
	if(hitsCont == null || hitsCont == 0 ){
		out.println("우리 싸이트를 방문해 주셔서 감사! ");
		hitsCont = 1;
	}
	else {
		out.println("우리 싸이트의 재방문을 환영합니다. 또와!");
		hitsCont += 1;
	}
	application.setAttribute("hitsCont", hitsCont);
%>
<center>
<p> 총방문자 수 : <%=hitsCont%></p>
</center>
</body>
</html>