//다음 주소 API   

function checkInput(){
	
	var id=$("#id").val();
	var password=$("#password").val();
	var passwordch=$("#passwordch").val();
	var name=$("#name").val();
	var email=$("email").val();
	var phone=$("#phone").val();
	var phone1=$("#phone1").val();
	var phone2=$("#phone2").val();
	
		
	if(id==""){
		alert("아이디 입력하세요.");
		return false;
	}if(password==""){
		alert("패스워드를 입력해주세요.");
		return false;
	}if(password!=passwordch){
		alert("패스워드 확인과 일치하지 않습니다.");
		return false;
	}if(password.length>14||password.length<6){
		alert("패스워드는 7자 이상 15자 미만으로 해주세요.");
		return false;
	}
	if(phone1.length<3){
		alert("번호 형식에 맞게 입력하세요.");
		return false; 
	}if(phone2.length!=4){
		alert("번호 형식에 맞게 입력하세요.");
		return false;
	}
	var count=0;
	var Tksu=['!','@','#','$','%','^','&','*','(',')','-','_','=','+'];
	for(var i=0;i<password.length;i++){
		for(var j=0; j<Tksu.length; j++){
			if(password.charAt(i) == Tksu[j]){
			count++;
			}
			}
	}	
if(count==0){
	alert("비밀번호는 특수문자를 하나 이상 포함해야 합니다.");
	
	return false;
}
if(name==""){
	alert("이름을 입력하세요.");
	return false;
}if(email==""){
	alert("메일을 입력하세요.");
	return false;
}
var numco=0;
for(var i=0;i<email.length;i++){
	if((email.charAt(i)>='a'&&email.charAt(i)<='z')||(email.charAt(i)>='A'&&email.charAt(i)<='Z')||(email.charAt(i)>='0'&&email.charAt(i)<='9')){
		
	}else{
		numco++;
	}
	if(email.charAt(i)=='@'){
		
	}else{
		numco++;
	}
}
if(numco>0){
	alert("email형식에 맞지 않습니다.");
	return false;
}
/*$.ajax({
	url:"join.do",
	type: "POST",
	dataType:'json',
	data:JSON.stringify({
		"id":$("#id").val(),
		"password":$("#password").val(),
		"name":$("#name").val(),
		"email":$("#email").val()+"@"+$("#emailaddress").val(),
		"phone":$("#phone").val()+$("#phone1").val()+$("#phone2").val(),
		"zipcode":$("#zipcode").val(),
		"address1":$("#address1").val(),
		"address2":$("#address2").val()
	}),
	headers : {
		"Content-Type" : "application/json",
		"X-HTTP-Method-Override" : "POST"
	},
	success:function(data){
		if(data.result==1){
			alert("회원가입 성공하셨습니다.");
			window.location='hi.do';
		}else{
			alert("회원가입 실패");
		}
	}
	
})*/
		
		
	

}
function passCheck(){
	
			var password=$("#password").val();
			var Tksu=['!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '_', '-', '+', '='];
			var num=['1', '2', '3', '4', '5', '6', '7', '8', '9', '0'];
			var count=0;
			var numcount=0;
			for(var i=0;i<password.length;i++){
				for(var j=0;j<Tksu.length;j++){
			if(password.charAt(i)==Tksu[j]){
				count++;
			}
			}//end j
			}//end i
			for(var i=0;i<password.length;i++){
				for(var j=0;j<num.length;j++){
					if(password.charAt(i)==num[j]){
						numcount++;
					}
				}//end j
			}//end i
			if(numcount>0){
				$("#passSecure").html("보안정도: 중");
				if(count>0){
					$("#passSecure").html("보안정도: 상");
				}
			}else{
				$("#passSecure").html("보안정도: 하");
			}
			
}
function idCheck(){
	window.open("/sinabro/check.mustang?this.regForm.id.value","post","width=300,height=300");
}

function checkedAll(){ 
	if($("input[name=every_agree]").is(":checked")){
		$(".input-cbox_every_agree").attr("checked","checked");
		$("#iyong").attr("value","y");
		$("#inform").attr("value","y");
		$("#privacy").attr("value","y");
	}else{
		$(".input-cbox_every_agree").attr("checked",null);	
	}
	}
function checkiyong(){
	$("#iyong").val="y";
}
function checkinform(){
	$("#inform").val="y";
}
function checkprivacy(){
	$("#privacy").val="y";
}
function checkDong(){
	if($("#iyong").val()=="n"){
		alert("약관 동의를 눌러주세요.");
		return;
	}if($("#inform").val()=="n"){
		alert("약관 동의를 눌러주세요.");
		return;
	}if($("#privacy").val()=="n"){
		alert("약관 동의를 눌러주세요.");
		return;
	}
	window.location="regForm.mustang";
}
	

