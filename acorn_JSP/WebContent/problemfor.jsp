<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String problem1 = request.getParameter("problem1");
	int pro1 = Integer.parseInt(problem1);
	String problem2 = request.getParameter("problem2");
	String problem3 = request.getParameter("problem3");
	
	
	if(pro1 == 5) {out.println("<p>좀 더 개방적으로 사람을 대하도록 노력하시오");}
	else if(pro1 == 4){out.println("<p>노력하세요.");}
    else if(pro1 == 3){out.println("<p>보통입니다.");}
    else if(pro1 == 2){out.println("<p>좋은 상태입니다. :)");} 	
    else if(pro1 == 1){out.println("<p>매우 좋아요 :)");}
	
	if(problem2 != null) {out.println("<p> 2문제의 당신의 답변은 : '" + problem2 +  "' 입니다.");}
	if(problem3 != null) { out.println("<p> 3문제의 당신의 답변은 : '" + problem3 +  "' 입니다.");}

%>
<!-- 다른 페이지로 처리 위탁...
forward도 전달되고 다른 변수전달 시킬려면 jsp:param으로 전달하고 getParamter으로 받으면 됩니다. -->
<%--  <jsp:forward page='<%= problem1 + ".jsp" %>'>
	<jsp:param value="<%=problem1 %>" name="problem1"/>
</jsp:forward>--%>


