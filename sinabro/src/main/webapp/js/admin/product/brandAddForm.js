function deleteBrand(){
	var brand=$("#albrand").val;
	$.ajax({
		url:"deleteBrand.mustang",
		type: "POST",
		dataType:'json',
		data:JSON.stringify({
			"brand":brand
		}),
		headers : {
			"Content-Type" : "application/json",
			"X-HTTP-Method-Override" : "POST"
		},
		success:function(data){
			
			if(data.success){
				
				alert("삭제되었습니다.");
				return;
			}else{
				alert("실패하였습니다.")
			}
			
		}
		
	})
}