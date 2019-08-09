<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<%
		String strNum = request.getParameter("pageNum");
		int pageNum=0;
		if(strNum==null){ // 맨처음 페이지를 로딩했을 경우
			pageNum=1;
		}else{
			pageNum=Integer.parseInt(strNum);
		}
	%>
	<div class = "catainer">
		<h3>pagination 연습</h3>
		<ul class="pagination">
			<%for(int i=1;i<11;i++){ %>
				<li <%if(pageNum==i){%>class="active"<%} %>>
				<a href="pagination.jsp?pageNum=<%=i%>"><%=i%></a></li>
				<%} %>
		</ul>
	</div>
</body>
</html>