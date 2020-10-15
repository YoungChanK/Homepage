<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<script type="text/javascript" src="../resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="../resources/js/register.js"></script>

</head>
<body>
<form role="${member.userid}">
<table border="1">
	<tr>
		<td>ID</td>
		<td>PW</td>
		<td>이름</td>
		<td>email</td>
		<td>회원가입날짜</td>
		<td>최근사용날짜</td>
		<td>관리자 권한</td>
		
	</tr>


	<c:forEach items="${memberinfo}" var="member">
	<tr>
		<td><a href = "/young/member/inforead?userid=${member.userid}">${member.userid}</a></td>
		<td>${member.userpw}</td>
		<td>${member.username}</td>
		<td>${member.email}</td>
		<td>${member.regdate}</td>
		<td>${member.updatedate}</td>
		<td>${member.authority}</td>

	</tr>
	
	
	</c:forEach>

	
	

</table>

</body> 
</html>