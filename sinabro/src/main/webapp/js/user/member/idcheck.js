function idcheck() {

	var id = $("#id").val();
	if (id == "") {

		alert("아이디를 입력하세요.");
		return false;
	}if (id.length < 4 || id.length > 12) {
		alert("아이디는 4글자 이상 12글자 이하로 해주세요.");
		return false;
	}
	
}
function insertId(id) {
	opener.document.regForm.id.value = id;
	self.close();
}
function findId(){
	alert("g");
	var name=$("#name").val();
	var email=$("#mailone").val();
	if(name==""){
		alert("이름을 입력해주세요.");
		return false;
	}if(email==""){
		alert("mail을 입력해주세요.");
		return false;
	}
	
}
function findPw(){
	var id=$("#id").val();
	var email=$("#mailtwo").val();
	if(id==""){
		alert("ID를 입력해주세요.");
		return false;
	}if(email==""){
		alert("mail을 입력해주세요.");
		return false;
	}
	
}
	