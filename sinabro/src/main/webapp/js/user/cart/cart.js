function cartInsert(){
alert("담기");
	$.ajax({
		url:"cart.do",
		type: "POST",
		dataType:'json',
		data:JSON.stringify({
			"product_code":$("#product_code").val(),
			"sizea":$("#sizea").val()
		}),
		headers : {
			"Content-Type" : "application/json",
			"X-HTTP-Method-Override" : "POST"
		},
		success:function(data){
			
			if(data.success){
				alert("담기 성공");
				
			}
		}
		
	})
}
