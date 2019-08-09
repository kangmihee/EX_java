<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--"1. 다른 사람들에게 자신을 소개하는 것을 어려워합니다."
응답 : 매우그렇다.  그렇다.  보통이다.  아니다.  매우아니다. (5가지)
	점수 따라서 5점 채점하고 점수를 3등분해서 5,4에 대한 판단메시지, 
	3,2에 대한 메시지, 1점에 대한 메시지를 응답하도록 페이지를 작성하시오 (좀 더 개방적으로 사람을 대하도록 노력하시오) --%>
	<form method="post" action="problemfor.jsp">
   1. 다른 사람들에게 자신을 소개하는 것을 어려워합니다. <br><br>
			<input type="radio" name="problem1" id="1pro5" value="5">
			<label for="1pro5">매우그렇다</label>
			<input type="radio" name="problem1" id="1pro4" value="4">
			<label for="1pro4">그렇다</label>
			<input type="radio" name="problem1" id="1pro3" value="3">
			<label for="1pro3">보통이다</label>
			<input type="radio" name="problem1" id="1pro2" value="2">
			<label for="1pro2">아니다</label>
			<input type="radio" name="problem" id="1pro1" value="1">
			<label for="1pro1">매우아니다</label><br><br><br><br>
			
	2. 종종 주변을 무시하거나 잊어 버리는 생각에 빠지곤 합니다. <br><br>
			<input type="radio" name="problem2" id="2pro5" value="5">
			<label for="2pro5">매우그렇다</label>
			<input type="radio" name="problem2" id="2pro4" value="4">
			<label for="2pro4">그렇다</label>
			<input type="radio" name="problem2" id="2pro3" value="3">
			<label for="2pro3">보통이다</label>
			<input type="radio" name="problem2" id="2pro2" value="2">
			<label for="2pro2">아니다</label>
			<input type="radio" name="problem2" id="2pro1" value="1">
			<label for="2pro1">매우아니다</label><br><br><br><br>
			
	3. 이메일에 가능한 빨리 회신하려고 하고 지저분한 편지함을 참을 수 없습니다. <br><br>
			<input type="radio" name="problem3" id="3pro5" value="5">
			<label for="3pro5">매우그렇다</label>
			<input type="radio" name="problem3" id="3pro4" value="4">
			<label for="3pro4">그렇다</label>
			<input type="radio" name="problem3" id="3pro3" value="3">
			<label for="3pro3">보통이다</label>
			<input type="radio" name="problem3" id="3pro2" value="2">
			<label for="3pro2">아니다</label>
			<input type="radio" name="problem3" id="3pro1" value="1">
			<label for="3pro1">매우아니다</label><br><br>			
   		<input type="submit" value="결과 확인하기">
 		
</form>
		
</body>
</html>