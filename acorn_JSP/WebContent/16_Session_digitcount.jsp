<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import= "java.io.*,java.util.*"%>
    <%request.setCharacterEncoding("UTF-8"); %>
    <%
    	String id = request.getParameter("id");
    	String name = request.getParameter("name");
    	String title = "재방문을 환영합니다.";
    	Integer visitCount = new Integer(0);
    	
    	String userID = "";
    	Integer maxinterval = session.getMaxInactiveInterval();
    	Date createTime = new Date(session.getCreationTime());
    	Date lastAccseeTime = new Date(session.getLastAccessedTime());
    	
    	if(session.isNew()){ // id의 유무를 확인
    		title = "홈페이지 첫 방문을 환영합니다.";
    		session.setAttribute("id", id); // 생성
    		session.setAttribute("visitCountKey", visitCount);
    	}
    	visitCount = (Integer)session.getAttribute("visitCountKey");
    	visitCount = visitCount + 1 ;
    	userID = (String)session.getAttribute("id");
    	session.setAttribute("visitCountKey", visitCount);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 유저별로 방문 횟수 카운트 하시오 -->
	<table border="1" align="center">
		<tr bgcolor="#949494">
			<td>Session 정보</td>
			<td>Value</td>
		</tr>
		<tr>
			<td>id</td>
			<td><%out.println(session.getId()); %></td>
		</tr>
		<tr>
			<td>생성시간</td>
			<th><%out.println(createTime); %></th>
		</tr>
		<tr>
			<td>마지막 접근시간</td>
			<td><%out.println(session.getId()); %></td>
		</tr>
		<tr>
			<td>사용자 아이디</td>
			<td><%out.println(userID); %></td>
		</tr>
		<tr>
			<td>방문 횟수</td>
			<td><%out.println(visitCount); %></td>
		</tr>
		<tr>
			<td>max interval</td>
			<td><%out.println(maxinterval); %></td>
		</tr>
	</table>
</center>
</body>
</html>

































