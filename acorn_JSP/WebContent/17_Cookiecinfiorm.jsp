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
	Cookie cookie = null;
	Cookie[] cookies = null; // 쿠키는 여러개의 값을 가지고 있는 배열임
	
	cookies = request.getCookies(); // 클라이언트 요청으로 부터 전체 쿠키획득
	if( cookies != null ){
		out.println("<h2>쿠키 키와 벨류 확인</h2>");
		for(int i=0;i<cookies.length;i++){ //쿠키의 개수만큼 돌아가면서 
			out.println("Name : " + cookie.getName() + ",  "); // 이름 확인
			out.println("Value : " + cookie.getValue() + "<br/>"); // 값 확인
		}
	}else{
		out.println("<h2>쿠키가 발견되자 않았습니다. </h2>");
	}
%>
</body>
</html>