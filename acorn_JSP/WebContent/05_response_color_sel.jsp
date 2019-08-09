<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>폼에 반응</title>
</head>
<%! String msg; %>
<%  // action에서 넘어온 페이지는 request, response객체가 자동으로 생성
	String name  = request.getParameter("name");
	String color = request.getParameter("color");
	if(color.equals("blue")) {msg = "파랑색";} // 영어를 한국어 매핑
	else if(color.equals("red")) {msg = "빨강색";}
	else if(color.equals("orange")) {msg = "오랜지색";}
	else {color = "white"; msg = "기타 색";} 
%>
<body bgcolor="<%=color%>">
	<%=name%>님이 좋아하는 색깔은?<%=msg%>
</body>
</html>