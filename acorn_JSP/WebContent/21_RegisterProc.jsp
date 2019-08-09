<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- regBean = new RegisterBean(); -->
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="regBean" class="test.RegisterBean"></jsp:useBean>
<jsp:setProperty name="regBean" property="*" />  <!-- jsp:setProperty로 자동으로 데이터 저장 -->
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	아이디 : <jsp:getProperty name="regBean" property="mem_id" /><p>
	이름 : <%=regBean.getMem_name() %><p>
	패스워드 : <%=regBean.getMem_passwd() %><p>
	이메일 : <jsp:getProperty name="regBean" property="mem_email" /><p>
	핸드폰 번호 : <jsp:getProperty name="regBean" property="mem_phone" /><p>
	
</body>
</html>