/**
 * 
 */
$(document).ready(function(){
	//파일형식제한하는 변수와 파일크기제한하는 변수 생성
	var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
	var maxSize=5242880;
	
	function checkExtension(fileName, fileSize){
		if(fileSize>=maxSize){
			alert("파일사이즈 초과");
			return false;
		}
		if(regex.test(fileName)){
			alert("지원하지 않는 파일형식 입니다");
			return false;
		}
		return true;
	}
	
	
	function shwoUploadFile(uploadResultArr){
		var str = "";
		var name="";
			//data는 배열 , for문과 같은 반복문을 이용해서 0~끝까지를 화면에 출력(each)
			$(uploadResultArr).each(function(i,obj){
				var fileCallPath=encodeURIComponent(obj.uploadPath+"/"+obj.uuid+"_"+obj.fileName);
				if(!obj.image){
					//이미지 파일이 아니면(image:false) - download 할수있도록..
//					var fileCallPath=encodeURIComponent(obj.uploadPath+"/"+obj.uuid+"_"+obj.fileName);
					str+="<li><a href ='/young/download?fileName="+fileCallPath+"'><img src='resources/image/attach.jpg'>"+obj.fileName+"</a></li>";
				    name="<p>"+obj.fileName+"<p>"
				}else{
					//이미지 파일이 아니면(image:ture) - display 웹에 이미지 출력..
					var sfileCallPath=encodeURIComponent(obj.uploadPath+"/s_"+obj.uuid+"_"+obj.fileName); //썸네일 파일명 보내기
//					str+="<li><img src='/young/display?fileName="+fileCallPath+"'></li>";
					str += "<li><img src='/young/display?fileName="+fileCallPath+"'>"+"<span data-file='"+sfileCallPath+"' data-type='image'>X</span>" + "</li>";  
				}

			})
			$(".uploadResult ul").append(str);
			$("#fileName").append(name);
		
	}
	
	//drop 상황이 아니면 정지 
	$(".fileDrop").on("dragenter dragover",function(e){
		e.preventDefault();
//		alert("drag");
	});
	
	$(".fileDrop").on("drop",function(e){
		e.preventDefault();
//		alert("drag");
		//drop한 모든 파일들의 정보를 가진 FileList 
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
				shwoUploadFile(data);
			}
		})
	
		
	})// drop 이벤트 end
	
	   $("#uploadtd").on("click", "button", function(e){
		      //alert("x를 클릭")
		   
		   var fileName = $("#filePath").val();//파일명을 저장
		  
//		   alert(fileName+"asd");
//		   alert(type);
		   
		      $.ajax({
		         url : 'deleteFile',
		         data: {fileName:fileName}, //어떤파일 삭제해야 하는지(파일명),
		         dataType: 'text',
		         type: 'POST',
		         success: function(data){
		   
		            $("#uploadtd").remove();
		         }
		      })
		      
		   })//x에 대한 click 이벤트end
		   
	
	

	
	
})


