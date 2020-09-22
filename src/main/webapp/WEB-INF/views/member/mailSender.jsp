<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="contact-form" class="form" action=/sendMail method ="POST">
		<div>
			<span>제목</span>
			<input type ="text" name ="submit" placeholder="제목">
		</div>
		<div>
			<span>내용</span>
			<textarea name="message"  placeholder="메세지"></textarea>
		</div>
		<button type="submit" class="button">
			<span>Send</span>	
		</button>
	</form>
</body>
</html>