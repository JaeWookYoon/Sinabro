/*function checkPw(){
	var pass=$("#checkPw").val;
	if(pass==""){
		alert("입력하세요.");
		return;
	}
	
	$.ajax({
		url:"checkPw.do",
		type: "POST",
		dataType:'json',
		data:JSON.stringify({
			"password":pass
		}),
		headers : {
			"Content-Type" : "application/json",
			"X-HTTP-Method-Override" : "POST"
		},
		success:function(data){
			
			if(data.check){
				
			}
			
		}
		
	})
}*/