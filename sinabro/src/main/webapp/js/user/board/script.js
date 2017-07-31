function writeCheck() {
	alert("야");
	if (document.writeForm.writer.value == "") {
		alert("작성자를 입력해 주세요");
		document.write.writer.focus();
		return false;
	}
	if (document.writeForm.subject.value == "") {
		alert("제목을 입력해 주세요");
		document.write.subject.focus();
		return false;
	}
	if (document.writeForm.content.value == "") {
		alert("내용을 입력해 주세요");
		document.write.content.focus();
		return false;
	}
	
}
function addFile(num) {
	var v = document.getElementById('list_dis');
	if (num == "b") {
		v.style.display = "";
	}
	if (num == "a") {
		v.style.display = "none"
	}
}