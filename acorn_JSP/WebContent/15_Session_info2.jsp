<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<%  // session 이 저장되는 곳 : webserver memory (session공간)
	// 유저를 관리하기 위하여 사용, 시간을 절감하기 위해서 사용 
	// id 가 자동부여
	// String을 캐스칭 하는 이유 : 
	// 		- 상속 : 부모 자식 (자바에서 최상위는 Object : 부모는 자식을 가리킬 수 없음) 
	//		- 자식의 멤버변수, 함수, 부모의 이름의 자식의 함수나 멤버면수는 호출불가
	// 		- 자식의 이름으로 downcasting
	// setAttribute(Strind, object) // 상속의 최상위 구조로 저장
	// getAttribute() : 속성의 이름값만 Enymberation으로 가지고 옴
	// getCreatTime() : 만들어진 시간
	// isNew() : 새롭게 만들어진 것인지 홧인 유무확인
	// invalidate() : 강제로 세션에서 제거
	// getLastAccessTime() 마지막 접근 시간 확인
	String xid = (String)session.getAttribute("id");
	String xname = (String)session.getAttribute("name");
	String xtoday = (String)session.getAttribute("today");
	String xtomorrow = (String)session.getAttribute("tomorrow");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	아이디 : <%=xid%><p>
	이름 : <%=xname%><p>
	오늘은 : <%=session.getAttribute("today") %><p> 
	내잃은 : <%=session.getAttribute("tomorrow")%><p>
	세션 아이디 : <%=session.getId() %><p>
</body>
</html>