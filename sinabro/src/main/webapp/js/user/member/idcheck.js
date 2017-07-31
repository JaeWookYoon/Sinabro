function idcheck() {

	var id = $("#id").val();
	if (id == "") {

		alert("아이디를 입력하세요.");
		return false;
	} else if (id.length < 4 || id.length > 12) {
		alert("아이디는 4글자 이상 12글자 이하로 해주세요.");
		return false;
	}
}
function insertId(id) {
	opener.document.regForm.id.value = id;
	self.close();
}
