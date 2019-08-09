<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%request.setCharacterEncoding("UTF-8"); %>
      
    <% // 쿠키객체를 생성 (키 이름과 데이터 입력)
    	Cookie first_name = new Cookie("first_name", request.getParameter("first_name"));
   		 Cookie phonenum = new Cookie("phonenum",request.getParameter("phonenum"));
   		 
   		 first_name.setMaxAge(60*60*24); // 초 단위로 하루 동안 지속되도록 함
   		 phonenum.setMaxAge(60*60*24);
   		 
   		 response.addCookie(first_name); // response에 등록해주면 자동으로 클라이언트
   		 response.addCookie(phonenum);   // 에 저장됨    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>쿠키 설정 후 전송</h1>
	</center>
	다음과 같이 입력하였습니다.
</body>
</html>