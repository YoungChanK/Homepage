/**
 * 
 */
$(document).ready(function(){
	// .뒤에 exe,sh,zip,alz 를 제한하겠다 ->파일형식 제한
	//정규식
	var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$")
	var maxSize=5242880;			//파일 사이즈(5MB)
	
	function shwoUploadFile(uploadResultArr){
		var str = "";
		var name="";
		var path="";
			//data는 배열 , for문과 같은 반복문을 이용해서 0~끝까지를 화면에 출력(each)
			$(uploadResultArr).each(function(i,obj){
				var fileCallPath=encodeURIComponent(obj.uploadPath+"/"+obj.uuid+"_"+obj.fileName);
				if(!obj.image){
					//이미지 파일이 아니면(image:false) - download 할수있도록..
//					var fileCallPath=encodeURIComponent(obj.uploadPath+"/"+obj.uuid+"_"+obj.fileName);
					str+="<li><a href ='/young/upload/download?fileName="+fileCallPath+"'><img src='resources/image/attach.jpg'>"+obj.fileName+"</a></li>";
					name=obj.fileName;
					path=fileCallPath;
	
				}else{
					//이미지 파일이 아니면(image:ture) - display 웹에 이미지 출력..
					var sfileCallPath=encodeURIComponent(obj.uploadPath+"/s_"+obj.uuid+"_"+obj.fileName); //썸네일 파일명 보내기
					str += "<li data-filename='"+obj.fileName+"' data-uuid='"+obj.uuid+"' data-uploadpath='"+obj.uploadPath+"'data-filetype='"+obj.image+"'>"+
							"<img src='/young/upload/display?fileName="+fileCallPath+"'>"+"<span data-file='"+sfileCallPath+"' data-type='image'>X</span>" + "</li>";  
					name=obj.fileName;
					path=fileCallPath;
				}

			})
			$(".uploadResult ul").append(str);
			$("#fileName").append(name);
			$("#filePath").append(path);
//			$("#filePath").html(fileCallPath);
	}
	
	
	function checkExtension(fileName, fileSize){
		if(fileSize>=maxSize){
			alert("파일 사이즈 초과");
			return false;
		}
		if(regex.test(fileName)){
			alert("파일 업로드할수 없습니다");
			return false;
		}
		return true;
	}

	
	$(".fileDrop").on("dragenter dragover",function(e){
		e.preventDefault();
//		alert("drag");
	});
	
	$(".fileDrop").on("drop",function(e){
		e.preventDefault();
//		alert("drag");
		var files = e.originalEvent.dataTransfer.files;
//		console.log(files[0].name);
//		console.log(files[0].size);
		var formData = new FormData(); //uploadAjax.jsp에 form태그가 없다. 대체할 무언가가 필요한데 , FormData()
		for(var i=0; i<files.length;i++){
			if(!checkExtension(files[i].name,files[i].size)){
				return false;
			}
		formData.append("file",files[i]);
		}
//		var file = files[0];
//		console.log(file);
//		var file2 = files[1];
//		console.log(file2);
//		var file3 = files[2];
//		console.log(file3);
		
		$.ajax({
			url:"/young/upload/uploadajax",
			data:formData,
			dataType:"json",
			//processData 와 contentType은 파일업로드시 false가 되어야함.
			processData:false,
			contentType:false,
			type:'POST',
			success:function(data){
				console.log(data);
			       alert("업로드맨");
			       shwoUploadFile(data);
			}
		})
	
		
	})// drop 이벤트 end
//선택자를 이용하여 폼태그를 선택하여 formObj변수에 저장
	//form태그의 role속성이 form인 것을 선택하라.
	var formObj=$("form[role='form']")
	
	
//글쓰기 버튼을 클릭하면 이벤트 start
	$("input[type ='submit']").on("click",function(e){  //input태그의 type속성이 submit인 것을 선택하라.
		e.preventDefault();
		alert("전송");
		var str="";
		$(".uploadResult ul li").each(function(i,obj){
			var jobj =$(obj);
			console.log("jobj: "+jobj);
			str+="<input type='text' name='attachList["+i+"].fileName' value='"+jobj.data("filename")+"'>";
			str+="<input type='text' name='attachList["+i+"].uuid' value='"+jobj.data("uuid")+"'>";
			str+="<input type='text' name='attachList["+i+"].uploadPath' value='"+jobj.data("uploadpath")+"'>";
			str+="<input type='text' name='attachList["+i+"].fileType' value='"+jobj.data("filetype")+"'>";
		})
//		$(".uploadResult1").html(str);
		//formObj에 str을 추가(append)하여 submit을 하라.
		//submit을 하면 action으로 간다 ->boardController에서 value값이 register인것을 찾아감
		formObj.append(str).submit();
		
})
//글쓰기 버튼을 클릭하면 이벤트end





	$(".fileDrop").on("drop",function(e){
		e.preventDefault();

		var files = e.originalEvent.dataTransfer.files;

		var formData = new FormData(); //uploadAjax.jsp에 form태그가 없다. 대체할 무언가가 필요한데 , FormData()
		for(var i=0; i<files.length;i++){
			if(!checkExtension(files[i].name,files[i].size)){
				return false;
			}
		formData.append("file",files[i]);
		}
		$.ajax({
			url:"/young/upload/uploadajax",
			data:formData,
			dataType:"json",
			//processData 와 contentType은 파일업로드시 false가 되어야함.
			processData:false,
			contentType:false,
			type:'POST',
			success:function(data){
				console.log(data);
			       alert("업로드맨");
			       shwoUploadFile(data);
			}
		})
	
		
	})// drop 이벤트 end











})

