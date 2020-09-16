<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="../resources/css/reset.css">
<link rel="stylesheet" href="../resources/css/style.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.13.1/css/all.css"
	integrity="sha384-xxzQGERXS00kBmZW/6qxqJPyxW3UR0BPsL4c8ILaIWXva5kFi7TxkIIaMiKtqV1Q"
	crossorigin="anonymous">

</head>
<body>


	<main>
	<div id="mainDiv">
		<div id="login">로그인</div>
        <button id="mainBt1"><a href="#"><i class="fab fa-google"></i>&nbsp; Google로 계속</a></button>
            <button id="mainBt2"><a href="#"><i class="fab fa-apple"></i>&nbsp; Apple로 계속</a></button>


		<form action="/young/member/loginPost" method="post">
			<input type="text" id="userid" name="userid" placeholder="아이디"> <input
				type="password" id="userpw" name="userpw"placeholder="비밀번호"> <input
				type="submit" id="loginBt" value="로그인">
		</form>
		<a href="#">비밀번호 찾기</a> <a href="#">SAML SSO를 사용하여 계속할 수도 있습니다.</a>

		<div>개인정보</div>
	</div>

	</main>


</body>
</html>