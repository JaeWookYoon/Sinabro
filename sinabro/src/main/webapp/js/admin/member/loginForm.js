
function loginCheck(){
	var id=$("#id").val();
	var password=$("#password").val();
	if(id==""){
		alert("아이디를 입력하세요.");
		return false;
	}else if(password==""){
		alert("비밀번호를 입력하세요.");
		return false;
	}
	
	
}