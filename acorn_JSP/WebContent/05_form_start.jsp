<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<pre>
			<form action="05_response_color_sel.jsp" method="post">
				이름 : <input type="text" name="name"><br>
				좋아하는 색깔? <select name ="color">
									<option value="blue"></option>
									<option value="red">빨강</option>
									<option value="orange">오렌지</option>
									<option value="etc">기타</option>
								</select>
				 <input type="submit" value="전송하기">
			</form>
		</pre>
	</center>
</body>
</html>