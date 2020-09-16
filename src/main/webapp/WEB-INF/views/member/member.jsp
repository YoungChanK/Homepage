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
            <button id="mainBt1"><a href="#"><i class="fab fa-google"></i>&nbsp; Google로 계속</a></button>
            <button id="mainBt2"><a href="#"><i class="fab fa-apple"></i>&nbsp; Apple로 계속</a></button>
            
<form action ="/young/member/member" method="post" onsubmit="return checkmem();">
<table style="margin:0 auto">
	<tr>
		<td>
			
			<input type = "text" name="userid" id="userid" placeholder="아이디">
			<label id="idmsg"></label>
			<input type="button" id="idcheck" value="ID중복체크"><br>
			<label id="idcmsg" style =color:red;></label>
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
			<input type = "text" name="username" id="username">
		</td>
	</tr>
	<tr>
		<td>
			<label>Email</label><br>
			<input type = "text" name="email" id="email">
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
 <a href="#">비밀번호 찾기</a><br>
 <a href="#" style="color: rgba(55, 53, 47, 0.6); font-size: 14px; line-height: 1.6; margin-top: 8px; text-align: center;">SAML SSO를 사용하여 계속할 수도 있습니다.</a>
 </div> 
</body>
</html>