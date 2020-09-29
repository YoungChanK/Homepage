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
		<td><input type="text" value="${member.userid}" style="border :none;" readOnly></td>
		<td><input type="text" value="${member.userpw}" style="border :none;"></td>
		<td><input type="text" value="${member.username}" style="border :none;"></td>
		<td><input type="text" value="${member.email}" style="border :none;"></td>
		<td><input type="text" value="${member.regdate}" style="border :none;"></td>
		<td><input type="text" value="${member.updatedate}" style="border :none;"></td>
		<td><select name="authority" size=1>
		 <option value=1> ${member.authority}</option>
		 <option value=2> ${!member.authority}</option>
		</select></td>
		<td><button id="${member.userid}">수정</button></td>
		<td><button class="delete-btn">삭제</button></td>

	</tr>
	
	
	</c:forEach>

	
	

</table>

</body>
</html>