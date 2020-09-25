/**
 * 
 */

//read.jsp가 준비가 되면 실행하라
$(document).ready(function(){
	
	var filePath=$("#filePath").val();
	filePath=encodeURIComponent(filePath);
	$(".dwload").attr("href", "/young/upload/download?fileName="+filePath);
	
//	$(".dwload").on("click",function(){
//		var filePath=$("#filePath").val();
//		filePath=encodeURIComponent(filePath);
//		colsole.log(filePath);
//	})
	//form의 role이 form인것을 선택
	var formObj = $("form[role='form']");
	
	console.log(formObj);
	//클릭한것의 action과 method를  변겅
	$(".btn-warning").on("click",function(){
	  //formObj.attr("action")일떈 action의 값을 가져오는 getter
	  //formObj.attr("action","/board/modify")처럼 두가지가 채워져있을경우 setter
		formObj.attr("action","/young/board/modify");
		formObj.attr("method","get");
		formObj.submit();
		
	});
	$(".btn-danger").on("click",function(){
		formObj.attr("action","/young/board/remove");
		formObj.attr("method","post");
		formObj.submit();
	});
	$(".btn-primary").on("click",function(){
		formObj.attr("action","/young/board/list");
		formObj.attr("method","get");
		formObj.submit();
	});
	//bno값을 저장하는 변수
	var bno=$("#bno").val();

//	//tbl_attachList에 대한 처리
//	$.getJSON("/young/board/getAttachList",{bno:bno},function(arr){
//		console.log(arr);
//		
//		var str="";
//		$(arr).each(function(i,attach){
//				var fileCallPath=encodeURIComponent(attach.uploadPath+"/"+attach.uuid+"_"+attach.fileName);
//				var sfileCallPath=encodeURIComponent(attach.uploadPath+"/s_"+attach.uuid+"_"+attach.fileName); //썸네일 파일명 보내기
//				if(attach.fileType){ //image type
//					str += "<li data-filename='"+attach.fileName+"' data-uuid='"+attach.uuid+"' data-uploadpath='"+attach.uploadPath+"'data-filetype='"+attach.image+"'>"+
//					"<img src='/young/display?fileName="+fileCallPath+"'>"+"<span data-file='"+sfileCallPath+"' data-type='image'></span>" + "</li>";  
//				
//			}else{					//not image type
//				str+="<li><a href ='/young/download?fileName="+fileCallPath+"'><img src='resources/image/attach.jpg'>"+attach.fileName+"</a></li>";
//			 
//			
//			}
//		})
//		$(".uploadResult ul").append(str);
//	})

})