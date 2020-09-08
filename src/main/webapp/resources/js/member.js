/**
 * 
 */
var idcheck=false;
var pwcheck= false;
var iddupcheck=false;
var repwcheck=false;
var emailcheck=false;

$(document).ready(function(){
	
	//idcheck
	$("#userid").on("blur",function(){
		var idreg=/^[a-zA-Z0-9]{4,12}$/; //ID 유효성검사를 위한 정규식
		var idVal=$("#userid").val();
		
		if(idreg.test(idVal)){
			$("#idmsg").html("적합한 아이디 입니다")
			idcheck=true;
		}else{
			$("#idmsg").html("부적합한 아이디 입니다")
			idcheck=false;
		}
	})
	
	//pwcheck
	$("#userpw").on("blur",function(){
		var pwreg=/^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$^&*-]).{8,}$/;
		var pwVal=$("#userpw").val();
		
		if(pwreg.test(pwVal)){
			$("#pwmsg").html("적합한 비밀번호입니다")
			pwcheck=true;
		}else{
			$("#pwmsg").html("부적합한 비밀번호입니다")
			pwcheck=false;
		}
	})
	$("#re_userpw").on("blur",function(){
		var pwVal=$("#userpw").val();
		var re_pwVal=$("#re_userpw").val();
		
		if(pwVal==re_pwVal){
			$("#re_pwmsg").html("비밀번호가 같습니다");
			re_pwcheck=true;
		}else{
			$("#re_pwmsg").html("비밀번호가 다릅니다");
			re_pwcheck=false;
		}
	})
	
	$("#idcheck").on("click",function(){
		var idval =$("#userid").val();
		
		$.ajax({
			type:"POST",
			url:"/young/member/idCheck",
			data:{
				userid:$("#userid").val()
			},
			
			success:function(data){
				if(data=="yes"){
					$("#idcmsg").html("사용가능한 아이디입니다")
				}else if(data=="no"){
					$("#idcmsg").html("사용중인 아이디입니다")
				}
			}
			
		})
		
	})
	
	
})
