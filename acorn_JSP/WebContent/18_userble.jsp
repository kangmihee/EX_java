
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 액션태그를 이용한 데이터 관리 : class - 사용자정의 데이터 타입 -->
	<jsp:useBean id="students" class="test.StudentBean">
	<jsp:setProperty name="students" property="firstName" value="강"/>
	<jsp:setProperty name="students" property="lastName" value="일"/>
	<jsp:setProperty name="students" property="age" value="40"/>
	</jsp:useBean>
	
	<p>학생 성 : <jsp:getProperty name="students" property="firstName"/>
	</p>
	<p> 학생이름 :<jsp:getProperty name="students" property="lastName"/>
	</p>
	<p> 학생 나이 :<jsp:getProperty name="students" property="age"/>
	</p>

</body>
</html>