<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../member/header.jsp" %>
</head>
<body>

<table border ="1">
	<tr>	
		<td colspan="5"><button type="button" onclick="location.href='register'">글쓰기</button></td>
		
	</tr>
	<tr>
		<td colspan="2">제목</td>
		<td>작성자</td>
		<td>자료</td>
		<td>작성일</td>
		
	</tr>
	<c:forEach items="${list}" var="board">
	<tr>
		<td>${board.bno}</td>
		<td><a href = "/young/board/read?bno=${board.bno}">${board.title}</a></td>
		<td>${board.writer}</td>
		<td>${board.fileName}</td>
		<td>${board.regdate}</td>
	</tr>
	</c:forEach>
	
	
	

</table>
<%--   <c:forEach var ="num" begin="${PageMaker.startPage}"
						 end="${PageMaker.endPage}">
	<a href="/young/board/list?pageNum=${num}">${num}</a>
</c:forEach>   --%>
     <c:if test="${PageMaker.prev}">
      <a href="/young/board/list?PageNum=${PageMaker.startPage-1}&type=${PageMaker.cri.type}&keyword=${PageMaker.cri.keyword}">이전</a>
   </c:if> 
   <c:forEach var="num" begin="${PageMaker.startPage}" end="${PageMaker.endPage}">
      <a href="/young/board/list?PageNum=${num}&type=${PageMaker.cri.type}&keyword=${PageMaker.cri.keyword}">${num}</a>
   </c:forEach>
   <c:if test="${PageMaker.next}">
      <a href="/young/board/list?PageNum=${PageMaker.endPage+1}&type=${PageMaker.cri.type}&keyword=${PageMaker.cri.keyword}">다음</a>
   </c:if>



	<form action="/young/board/list?keyword=${PageMaker.cri.keyword} "
		method="get">
		<select name="type">
			<option value="T" <c:out value="${PageMaker.cri.type eq 'T'?'selected':''}"/>>제목
			<option value="C" <c:out value="${PageMaker.cri.type eq 'C'?'selected':''}"/>>내용
<%-- 			<option value="W"<c:out value="${PageMaker.cri.type eq 'W'?'selected':''}"/>>작성자 --%>
			<option value="TC"<c:out value="${PageMaker.cri.type eq 'TC'?'selected':''}"/>>제목+내용
<%-- 			<option value="TCW" <c:out value="${PageMaker.cri.type eq 'TCW'?'selected':''}"/>>제목+내용+작성자 --%>
		</select> <input type="text" name="keyword"> <input type="submit"
			value="검색">
	</form> 
</body>
</html>