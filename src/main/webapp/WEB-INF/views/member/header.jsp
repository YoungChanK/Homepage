<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id=headerdiv style="width: 100%; height: 100px;">
		<p id="loginsession">${login.userid}님환영합니다</p>
		<c:if test="${login.authority==true}">
			<input type="button" value="관리자모드" onclick="location.href='/young/member/admin'">
		</c:if>
		<input type="button" value="로그아웃"
			onclick="location.href='/young/member/logout'"> <input
			type="button" value="회원정보수정"
			onclick="location.href='/young/member/membermodify'">
	</div>
</body>
</html>