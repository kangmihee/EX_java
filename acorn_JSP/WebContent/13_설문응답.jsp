<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%! int jumsu = 0;
	int total = 0;
	String level ="";
%>
<%
	for(int i=1;i<7;i++){ // 문항 수
		String mind = request.getParameter("mind"+i);
		if(mind.equals("sel1")){jumsu = 5;}
		else if(mind.equals("sel2")){jumsu = 4;}
		else if(mind.equals("sel3")){jumsu = 3;}
		else if(mind.equals("sel4")){jumsu = 2;}
		else {jumsu = 1;}
	
		total += jumsu;
	}
	if(total < 13 ) {level = "마음가짐이 좋습니다. 가정평화 세계평화를 이루시길 바랍니다.";}
	else if(total < 18 ) {level = "평소 마음 편하게 생활을 하는 것 같습니다. 경계선에 있으니 항상 마음을 갈고 닦길 바랍니다.";}
	else{level = "너무 어려움이 많이 있습니다. 여유를 가지고 생활하시기 바랍니다. 동네 한바퀴 뛰고 쉬세요.";}

%>
<script>alert(<%=total%>)
</script>

<body>
	당신의 성격은 다음과 같습니다.<br><%=level%>
</body>
</html>