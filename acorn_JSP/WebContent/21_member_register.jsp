<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script>
	function autoTab() {
		if(event.keyCode == 13) {  // enter
			event.ketCode = 9;    // tab
		}
	}
</script>
<link href="style.css" rel="stylesheet" type="text/css">
<script language="Javascript" src="script.js"></script>
</head>
<body bgcolor="#996600">
	<table width="80%" align="center" border="0" cellspacing="0" cellpadding="5">
		<tr>
			<td align="center" valign="middle" bgcolor="#FFFFCC">
			 <table width="90%" align="center" border="1" cellspacing="0" cellpadding="2">
			 	<form name="regForm" method="post" action="21_RegisterProc.jsp">
			 		<tr align="center" bgcolor="#996600">
			 			<td colspan="3"><font color="#FFFFFF"><b>회원가입</b></font></td>
		 			</tr>
		 			<tr>
		 				<td width="24%">아이디</td>
		 				<td width="35%"><input type="text" name="mem_id" size="15" onkeydown="autoTab()"></td>
	 					<td width="41%">아이디를 적어주세요</td> 
 					</tr>
 					<tr>
 						<td>패스워드</td>
 						<td><input type="password" name="mem_passwd" size="15" onkeydown="autoTab()"></td>
 						<td>패스워드를 적어 주세요.</td>
					</tr>
					<tr>
 						<td>패스워드 확인</td>
 						<td><input type="password" name="mem_repasswd" size="15" onkeydown="autoTab()"></td>
 						<td>패스워드를 확인합니다.</td>
					</tr>
					<tr>
 						<td>이름</td>
 						<td><input type="text" name="mem_name" size="15" onkeydown="autoTab()"></td>
 						<td>고객 실명을 적어 주세요.</td>
					</tr>	
					<tr>
 						<td>이메일</td>
 						<td><input type="text" name="mem_email" size="27" onkeydown="autoTab()"></td>
 						<td>이메일을 적어 주세요.</td>
					</tr>	
					<tr>
 						<td>전화번호</td>
 						<td><input type="text" name="mem_phone" size="20" onkeydown="autoTab()"></td>
 						<td>연락처를 적어 주세요.</td>
					</tr>
					<tr>
						<td colspan="3" align="center"><input type="submit" value="회원가입">
													   <input type="button" value="회원가입" onclick="inputCheck()"> 
				   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="다시쓰기">
						</td>
					</tr>										
			 	</form>
			 </table>
			</td>
		 </tr>
	</table>
</body>
</html>


















