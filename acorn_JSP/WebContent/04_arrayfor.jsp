<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table, th,td {
		border: 1px solid black; 
	}
</style>
</head>
<body>
	<table>
		<tr>
			<% int godhralth = 1004; // 변수 선언
			// 2차원 배열 스크립트 안에서의 주석
			// 2x3 배열 -> 1x6 배열
			// 문제 : 2*3배열로 출력해 보시오
			String arr[][] = {{"acorn", "BigData", "Develoment"}, 
							  {"one", "two", "three"}};
			
			for (String data[] : arr){  // 2차원배열에서 요소를 꺼내면 1차원 배열 
			out.println(data.length + "<br>" );
			for(String str : data ) {
				 %>	<%-- 여기까지가 JSP 태그 --%>
				 
				 <td><%=str%></td>
				 
				 <%
				 }
			%></tr><tr>
			<%
			 }
		 %> <%-- 또 한번 더 JSP --%>
		 </tr>		  
	</table>
	<%-- 데이터  출력되나? <%=godhralth%>...jsp 주석 --%>
	<!-- 출력은 어디서 되나 <%=godhralth%>...html 주석--> 
	결과출력 <%=godhralth%>
</body>
</html>