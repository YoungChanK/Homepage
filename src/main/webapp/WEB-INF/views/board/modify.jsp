<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../resources/js/jquery-3.5.1.js"></script>
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.js"></script>
<script src="../resources/js/summernote-ko-KR.js"></script>
<script>
$(document).ready(function() {
	  $('#summernote').summernote({
 	    	placeholder: 'content',
	        minHeight: 370,
	        maxHeight: null,
	        focus: true, 
	        lang : 'ko-KR'
	  });
	});
</script>
</head>
<body>
<h1>수정화면 입니다. </h1>
<c:if test="${msg}.eq 'SUCCESS'}">
<script>
	alert("수정되었습니다.");
</script>
</c:if>
${msg}
<form action="/young/board/modify" method ="post">
	<input type="hidden" name="bno" value="${modify.bno}">
	제목 :   <input type="text" name="title" value="${modify.title}">
	내용 :   <textarea id="summernote" name="content">${modify.content}</textarea>
	작성자 : <input type="text" name="writer" value="${modify.writer}" readonly>

	<input type="submit" value="글수정">

</form>
</body>
</html>