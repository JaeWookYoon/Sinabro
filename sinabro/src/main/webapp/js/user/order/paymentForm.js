function getInfo() {

	$.getJSON("/sinabro/callMember.do", function(data) {
		var name = "";
		var phone = "";
		var zipcode = "";
		var address1 = "";
		var address2 = "";
		if (data.x) {
			alert("정보 가져오기 실패");
		}if (data.o) {
			$("#nameone").attr("value", data.member.name);
			$("#phoneone").attr("value", data.phone1);
			$("#phonetwo").attr("value", data.phone2);
			$("#phonethree").attr("value", data.phone3);
			$("#zipcode").attr("value", data.member.zipcode);
			$("#address1").attr("value", data.member.address1);
			$("#address2").attr("value", data.member.address2);
		}
	});

}
function resetInfo(){
	$("#nameone").attr("value", '');
	$("#phoneone").attr("value", '');
	$("#phonetwo").attr("value", '');
	$("#phonethree").attr("value", '');
	$("#zipcode").attr("value", '');
	$("#address1").attr("value", '');
	$("#address2").attr("value", '');
}