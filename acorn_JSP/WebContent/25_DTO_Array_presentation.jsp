<%@page import="acorn.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="java.util.List" %>
    <%@ page import="acorn.MemberDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 문제
		1. 대한 종로
		2. 민국 수원
		3. 만세 청파	
		DTO 배열에 입력한 다음, table로 출력해 보시오
	 -->
	 
	 <%
		List<MemberDTO> list = new ArrayList<MemberDTO>();
	 	list.add(new MemberDTO(1,"대한","종로")); // 리스트에서 인덱스로 접근
	 	list.add(new MemberDTO(2,"민국","수원"));
	 	list.add(new MemberDTO(3,"만세","청파"));

	%>
	<h2>출력</h2>
	<table>
		<thead>
			<tr>
				<td>번호</td><th>이름</th><th>주소</th>
			</tr>
		</thead>
		<tbody>
			<%for(MemberDTO tmp :list){  // 홀수만 출력하시요
				if(tmp.getNum() % 2 == 1) {
			%>
			<tr>
				<td><%=tmp.getNum()%></td>
				<td><%=tmp.getName()%></td>
				<td><%=tmp.getAddr()%></td>
			</tr>
				<% }
			}%>
		</tbody>
	</table>
</body>
</html>
















