function loginCheck(){
	var id=$("#id").val();
	var password=$("#password").val();
	
	if(id==""){
		alert("ID 입력하세요.");
		$("#id").focus();
		return;
	}else if(password==""){
		alert("Password 입력하세요.");
		$("#password").focus();
		return;
	}
}