<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String userid=(String)session.getAttribute("userid");
%>

<h1>${login.userid} , ${login.userpw}</h1>
<%=userid%> 로그인 
<a href="/young/board/list">list</a>
</body>
</html>