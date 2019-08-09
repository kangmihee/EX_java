<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<pre>
	이 파일은 Top.jsp 입니다.<br>
	<%=request.getParameter("msg") %>
</pre>
<%
	int number = 10;
	for(int i=0;i<number;i++){
	out.println("<font size=5>사는 힘은 주변에 감동을 심는 것</font>");
	}
	out.println("<br>");
%>
<%-- 부모 페이지로 부터 넘어 온 값<%= grade %> --%>
