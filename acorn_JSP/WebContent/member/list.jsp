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
	<center><a href="/acorn_JSP/member/insertForm.html">�߰��ϱ�</a></center>
	
	<table>
	   <thead>
	      <tr>
	         <th>��ȣ</th><th>�̸�</th><th>�ּ�</th><th>����</th><th>����</th>
	      </tr>
	   </thead>
	   <tbody>
	      <%for(MemberDto tmp:list){ %>
	         <tr>
	            <td><%=tmp.getNum() %></td>
	            <td><%=tmp.getName() %></td>
	            <td><%=tmp.getAddr() %></td>
	             <td><a href ="delete.jsp?num=<%=tmp.getNum() %>">����</a></td> 
	            <td><a href ="updateForm.jsp?num=<%=tmp.getNum() %>">����</a></td>
	         </tr>
	      <%} %>
	   </tbody>
	</table>
</div>
<center>
	<!-- �����ġ�� �������Ǹ� Ȯ���ϰ� ���� -->
	<!-- �׷��� ������ġ�� ǥ���ؾ� ��ġ ���� Ȯ�� -->
	<a href="/acorn_JSP/28_member.html">�޴���</a>
</center>
</body>
</html>