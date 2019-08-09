<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.GuestBoard.GuestDao" %>
    <%@ page import="com.GuestBoard.GuestDto" %>
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
      request.setCharacterEncoding("UTF-8");
      int num = Integer.parseInt(request.getParameter("num"));
      String writer = request.getParameter("writer");
      String title = request.getParameter("title");
      String content = request.getParameter("content");
      String regdate = request.getParameter("regdate");
      GuestDto dto = new GuestDto(num, writer, title, content, regdate);
      boolean isSuccess = GuestDao.getInstance().update(dto);
   %>
   <p>수정 완료.</p>
   <%=isSuccess%>
   <a href="guestborad.jsp">목록보기</a>
</body>
</html>