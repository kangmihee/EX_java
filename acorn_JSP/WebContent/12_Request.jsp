<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.io.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% request.setCharacterEncoding("utf-8"); %>
<%
	String aa[] = request.getParameterValues("later");
	out.println("좋아하는 음식 : " +  aa.length + "<br>");
	
	for(int i=0;i<aa.length;i++){
		out.println(aa[i]);
	}
	Enumeration<String> en = request.getParameterNames();
	while(en.hasMoreElements()){
		String bb = en.nextElement();
		out.println(bb);
	}
%>
<%=request.getRemoteAddr() %> <!-- 원격 요청한 ip정보 -->
<%=request.getQueryString() %> <!-- get방식으로 요청한 파라미터 정보 -->
<%=request.getRequestURI() %> <!-- 요청 페이지 정보 -->
<%=request.getHeader("Accept") %> <!-- 전송된 헤더 정보 확인 -->

<%=out.getBufferSize()%> <!-- 버퍼가 자동flush, 강제flush가능 -->
실제경로??? = <%=application.getRealPath("/") %>
<% application.log("어플리케이션 로그");%>
ip:<%=request.getRemoteAddr() %>
<% ServletRequest xx = pageContext.getRequest(); %>
ip주소 :<%=xx.getRemoteAddr() %>
내부에서 확인한 IP주소 : <%=pageContext.getRequest().getRemoteAddr() %>
</body>
</html>