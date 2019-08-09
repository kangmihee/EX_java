<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = "강미희";
	String bloodType = request.getParameter("bloodType");
%>
<!-- 다른 페이지로 처리 위탁...
forward도 전달되고 다른 변수전달 시킬려면 jsp:param으로 전달하고 getParamter으로 받으면 됩니다. -->
<jsp:forward page='<%= bloodType + ".jsp" %>'>
	<jsp:param value="<%=name %>" name="name"/>
</jsp:forward>
