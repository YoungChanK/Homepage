<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script type="text/javascript" src="../resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="../resources/js/member.js"></script>
</head>
<body>
<form action="/young/member/member" method="post">
<table>
	<tr>
		<td>
			<label> 아이디 :</label><input type="text" name="userid" id="userid">
			<input type ="button" id="idcheck" value="ID중복체크"><label id=idcmsg></label><br>
			<label id=idmsg></label>
		</td>
	</tr>
	<tr>
		<td>
			<label> 비밀번호 :</label><input type="password" name="userpw" id="userpw"><label id=pwmsg></label>
		</td>
	</tr>
 	<tr>
		<td>
			비밀번호 확인 :<input type="password" name="r_userid" id="re_userpw"><label id=re_pwmsg></label>
		</td>
	</tr> 
	<tr>
		<td>
			이름 : <input type="text" name="username" id="username">
		</td>
	</tr>
	<tr>
		<td>
			Email : <input type="text" name="email" id="email">
		</td>
	</tr>
	<tr>
		<td>
			 <input type="submit" value="회원가입">
		</td>
	</tr>
</table>
</form>
</body>
</html>