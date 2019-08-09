<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "com.member.MemberDto" %>
<%@ page import = "com.member.MemberDao" %>
<%@ page import = "java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>Insert title here</title>
</head>
<body>
<%
   List<MemberDto> list = MemberDao.getInstance().getList();
%>
<div class="conrainer">
	<center><a href="/acorn_JSP/member/insertForm.html">추가하기</a></center>
	
	<table>
	   <thead>
	      <tr>
	         <th>번호</th><th>이름</th><th>주소</th><th>삭제</th><th>수정</th>
	      </tr>
	   </thead>
	   <tbody>
	      <%for(MemberDto tmp:list){ %>
	         <tr>
	            <td><%=tmp.getNum() %></td>
	            <td><%=tmp.getName() %></td>
	            <td><%=tmp.getAddr() %></td>
	             <td><a href ="delete.jsp?num=<%=tmp.getNum() %>">삭제</a></td> 
	            <td><a href ="updateForm.jsp?num=<%=tmp.getNum() %>">수정</a></td>
	         </tr>
	      <%} %>
	   </tbody>
	</table>
</div>
<center>
	<!-- 상대위치로 파일위피를 확인하고 있음 -->
	<!-- 그래서 절대위치로 표현해야 위치 정상 확인 -->
	<a href="/acorn_JSP/28_member.html">메뉴로</a>
</center>
</body>
</html>