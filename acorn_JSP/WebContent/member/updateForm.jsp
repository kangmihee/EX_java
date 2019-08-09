<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.member.MemberDto" %>
<%@ page import = "com.member.MemberDao" %>
    <!-- jsp에서 임포트 해야하는 것 : out, request, response, session, application -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<%
		int num = Integer.parseInt(request.getParameter("num"));
		MemberDto dto = MemberDao.getInstance().getData(num);	
	%>
	<center>
		<h3>수정할 회원 정보</h3>
			<form action="update.jsp" method="post">
				<input type="hidden" name="num" id="num" value="<%=dto.getNum()%>">
				
				<label for="name">이름</label>
				<input type="text" name="name" id="name" value="<%=dto.getName()%>"/>
				
				<label for="addr">주소</label>
				<input type="text" name="addr" id="addr" value="<%=dto.getAddr()%>"/>
				
				<button type="submit">수정</button>
			</form>
		</center>
</body>
</html>