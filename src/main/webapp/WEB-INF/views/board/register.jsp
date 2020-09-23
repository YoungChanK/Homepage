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
<link  rel="stylesheet" type="text/css" href="../resources/css/register.css">
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.js"></script>
<script src="../resources/js/summernote-ko-KR.js"></script>
<script>
var i=1;
$(document).ready(function() {
	
	  $('#summernote').summernote({
 	    	placeholder: 'content',
	        minHeight: 370,
	        maxHeight: null,
	        focus: true, 
	        lang : 'ko-KR'
	  })
	  
	  
/* 	   $("#uploadadd").click(function(){
		  $(".tr1").append("<tr id='tr"+i+"'><input type='file' name='file' id='upload' multiple></td></tr>")
		  i++;
	  }) */
	  $('#uploadadd').click (function () {  
		  	
                $('.tr1').append (                        
                    '<td><input type="file" name="file" multiple> <input type="button" class="btnRemove" value="Remove"><br></td>'                    
                ); // end append 
        	  
                $('.btnRemove').on('click', function () { 
                    $(this).prev().remove (); // remove the textbox
                    $(this).next ().remove (); // remove the <br>
                    $(this).remove (); // remove the button
                });
            }); // end click    
	
	})

</script>
</head>
<body>
<h1>게시판 글쓰기화면. ${result}</h1>
<form role="form" action="/young/board/register" method ="post" enctype="multipart/form-data">

	제목 :   <input type="text" name="title">
<!-- 	내용 :   <textarea name="content"></textarea> -->
	작성자 : <input type="text" name="writer" value="${login.userid}" readOnly>
		<textarea name="fileName" id="fileName" readOnly></textarea>
		<textarea name="filePath" id="filePath" readOnly></textarea>
	<textarea id="summernote" name="content"></textarea>
		<table>
		<tr class="tr1">
			<td><input type="file" name="file" multiple></td>
		</tr>
	</table>
	<input type="submit" value="글쓰기">
   <button type="button" onclick="location.href='list'">목록</button>
</form>
<button id="uploadadd">추가</button>
<div class="fileDrop">파일 업로드 Drag  Drop</div>

<!-- 파일업로드 drag&drop 결과 이미지 list -->
<div class="uploadResult">




<ul>

</ul>
</div>

</body>
</html>