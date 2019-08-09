<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.GuestBoard.GuestDto" %>
    <%@ page import="com.GuestBoard.GuestDao"%>
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
		request.setCharacterEncoding("utf-8");
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String regdate = request.getParameter("regdate");
		
		
		GuestDto dto = new GuestDto();
		dto.setWriter(writer);
		dto.setTitle(title);
		dto.setContent(content);
		dto.setRegdate(regdate);		
		
		boolean isSuccess = false;
		isSuccess = GuestDao.getInstance().insert(dto);
		if(isSuccess)System.out.println("데이터 입력 성공");
		else System.out.println("데이터 입력 실패");

	%>
	<p> 데이터입력이 완료 되었습니다.</p>
	<a href="guest.html">메뉴보기</a>
</body>
</html>