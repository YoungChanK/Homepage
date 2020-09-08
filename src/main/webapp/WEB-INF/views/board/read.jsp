<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="../resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="../resources/js/read.js"></script>
<script type="text/javascript" src="../resources/js/ajaxtest.js"></script>
<link  rel="stylesheet" type="text/css" href="../resources/css/read.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form role="form">
		<input type="hidden" name="bno" id="bno" value="${read.bno}">
		<input type="text"   name="pageNum" value="${cri.pageNum}">
		<table border="1">
			<tr>
				<td colspan="2">${read.title}</td>
			</tr>
			<tr>
				<td>${read.writer}</td>
				<td>${read.viewcnt}</td>
			</tr>
			<tr>
				<td colspan="2">${read.content}</td>
			</tr>

			<tr>
				<td colspan="2">
					<button type="submit" class="btn-warning">수정</button>
					<button type="submit" class="btn-danger">삭제</button>
					<button type="submit" class="btn-primary">목록</button>
				</td>
			</tr>
		</table>
	</form>
	<div class="uploadResult">
		<ul>
		
		</ul>
	</div>
	<div>
		<div>
			작성자 : <input type="text" name="replyer" id="newReplyWriter">
		</div>
		<div>
			댓글내용 : <input type="text" name="replytext" id="newReplyText">
		</div>
		<button id="replyAddBtn">댓글 등록</button>
	</div>

	<ul id="replies">

	</ul>
	<ul id="replyPage">

	</ul>
		<div id="modDiv">
		<div class="modal-title"></div>
		<div>
			<input type="text" id="replytext">
		</div>
		<div>
			<button type="button" id="replyModBtn">수정</button>
			<button type="button" id="replyDelBtn">삭제</button>
			<button type="button" id="closeBtn">닫기</button>

		</div>
	</div>
	
</body>
</html>