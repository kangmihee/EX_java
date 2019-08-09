<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="test.*"%> <!-- test 밑에있는 package 다 불러옴 -->
<!DOCTYPE html>
<% // 자바프로그래밍하고 비교
	test.AddressBean addr = new AddressBean();
	addr.setName("자기이름 테스트");
	addr.setId("ladslba");
	addr.setAddtrss("천국동 한마음 빌딩");
%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	이름 : <%=addr.getName() %></br>
	아이디 : <%=addr.getId() %></br>
	주소 : 	<%=addr.getAddtrss() %></br>
</body>
</html>