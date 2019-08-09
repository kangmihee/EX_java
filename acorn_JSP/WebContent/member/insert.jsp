<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.member.MemberDao" %>
    <%@ page import="com.member.MemberDto" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 입력 로직</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		
		MemberDto dto = new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		
		boolean isSuccess = false;
		isSuccess = MemberDao.getInstance().insert(dto);
		if(isSuccess)System.out.println("데이터 입력 성공");
		else System.out.println("데이터 입력 실패");

	%>
	<p> 데이터입력이 완료 되었습니다.</p>
	<a href="list.jsp">목록보기</a>
</body>
</html>





















