<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="../resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="../resources/js/member.js"></script>
<link rel="stylesheet" href="../resources/css/reset.css">
<link rel="stylesheet" href="../resources/css/style.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.13.1/css/all.css" 
 	integrity="sha384-xxzQGERXS00kBmZW/6qxqJPyxW3UR0BPsL4c8ILaIWXva5kFi7TxkIIaMiKtqV1Q" 
	crossorigin="anonymous"> 

</head>
<body>
<div id="mainDiv">

     <div id="login">회원가입</div>
          
            
<form action ="/young/member/membermodify" method="post" onsubmit="return checkmem();">
<table style="margin:0 auto">
	<tr>
		<td>
			
			<input type = "text" name="userid" id="userid" value="${login.userid}" readOnly>
			<label id="idmsg"></label>

		</td>
	</tr>
	<tr>
		<td>

			<input type = "password" name="userpw"id="userpw" placeholder="비밀번호">
			<label id="pwmsg" style =color:lightgreen;></label>
		</td>
	</tr>
	<tr>
		<td>
			<label>비밀번호 재확인</label><br>
			<input type = "password" name="re_userpw" id="re_userpw">
			<label id="re_pwmsg"></label>
		</td>
	</tr>
	<tr>
		<td>
			<label>이름</label><br>
			<input type = "text" name="username" id="username" value="${login.username}">
		</td>
	</tr>
	<tr>
		<td>
			<label>Email</label><br>
			<input type = "text" name="email" id="email" value="${login.email}">
			<label id="emailmsg"></label>
		</td>
	</tr>
	<tr>
		<td>
		
			<input type = "submit" value="전송">
		</td>
	</tr>

</table>
</form>
</div> 
</body>
</html>