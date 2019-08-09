<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.GuestBoard.GuestDto" %>
    <%@ page import="com.GuestBoard.GuestDao" %>
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
		GuestDto dto = GuestDao.getInstance().getData(num);
	%>
		<center>
		<h3>수정할 회원 정보</h3>
			<form action="g_update.jsp" method="post">
				<input type="hidden" name="num" id="num" value="<%=dto.getNum()%>">
				<label for="writer">작성자</label>
				<input type="text" name="writer" id="writer" value="<%=dto.getWriter()%>"/>
				<label for="title">제목</label>
				<input type="text" name="title" id="title" value="<%=dto.getTitle()%>"/>
				<label for="content">내용</label>
				<input type="text" name="content" id="content" value="<%=dto.getContent()%>"/>
				<label for="regdate">등록일</label>
				<input type="text" name="regdate" id="regdate" value="<%=dto.getRegdate()%>"/>
				<button type="submit">수정</button>
			</form>
		</center>
</body>
</html>