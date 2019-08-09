<%@page import="com.member.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.GuestBoard.GuestDao" %>
    <%@ page import="com.GuestBoard.GuestDto" %>
    <%@ page import="java.util.List" %>
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
		List<GuestDto> list = GuestDao.getInstance().getList();
	%>
	<div class="container">
	<table class="table">
	   <thead>
	      <tr>
	         <th>글번호</th><th>작성자</th><th>제목</th><th>내용</th><th>등록일</th><th>삭제</th><th>수정</th>
	      </tr>
	   </thead>
	   <tbody>
	      <%for(GuestDto tmp:list){ %>
	         <tr>
	            <td><%=tmp.getNum() %></td>
	            <td><%=tmp.getWriter() %></td>
	            <td><%=tmp.getTitle() %></td>
	            <td><%=tmp.getContent() %></td>
	            <td><%=tmp.getRegdate()%></td>
	            <td><a href ="g_delete.jsp?num=<%=tmp.getNum() %>">삭제</a></td>
	            <td><a href ="g_updateForm.jsp?num=<%=tmp.getNum() %>">수정</a></td>
	         </tr>
	      <%} %>
	   </tbody>
	</table>
	<center>
		<a href ="g_insertForm.html">추가</a>
		<br>
		<a href="guest.html">메뉴로</a>
		
	</center>
</div>
</body>
</html>



 <!-- 방명록 -->
    <!-- DB구성한 다음 CRUD를 DTO, DAO를 이용해서 구현하시오
    	데이터타입, 데이터사이즈, 데이터이름
    	1. 글번호 num
    	2. 작성자 writer
    	3. 제목 title
    	4. 내용 content
    	5. 등록일 regdate	
     -->
     <!-- 작업순서
     	1.DB구성
     	2. DTO
     	3. DAO
     	4. insert
     	5.list
      -->









