function getCertify(){
	alert("들어가");
	$.ajax({
		url:"https://openapi.open-platform.or.kr/inquiry/real_name",
		type: "POST",
		dataType:'json',
		data:JSON.stringify({
			"bank_code_std":$("#bank").val(),
			"account_num":$("#bank1").val(),
			"account_holder_info":$("#jumin").val(),
			"tran_dtime":new Date()
		}),
		headers : {
			"Accept":"application/json",
			"Content-Type" : "application/json",
			"X-HTTP-Method-Override" : "POST",
			"Authorization":"Bearer fffe043f4d3b4613aefb0008efdeeeea"
		},
		success:function(data,status){
			alert("?");
		alert(data.bank_name);
		alert(data.account_holder_name);
		alert(data.rsp_code);
		alert(status);
		}
		
	})
}
function nowTime(){
	alert("ㅅ간");
	$.getJSON("/sinabro/nowTime.do", function(data){
		$("#time").attr("value",data.now);
	});
}