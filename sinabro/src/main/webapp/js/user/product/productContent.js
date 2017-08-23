function getCart(){
	
	$.ajax({
		url:"insertDat.do",
		type: "POST",
		dataType:'json',
		data:JSON.stringify({
			"id":$("#logid").val(),
			"num":$("#thisnum").val(),
			"content":$("#content").val()
		}),
		headers : {
			"Content-Type" : "application/json",
			"X-HTTP-Method-Override" : "POST"
		},
		success:function(data){
			
			if(data.result==1){
				
				window.location='content.do?num='+$("#thisnum").val();
			}if(data.result==2){
				alert("로그인 필요합니다.");
				window.location="/sinabro/loginForm.do";
				return;
			}if(data.result==0){
				alert("댓글달기 실패.");
			}
		}
		
	})
}
