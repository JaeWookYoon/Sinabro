function deleteProduct(){
	var code=$("#product_code").val;
	$.ajax({
		url:"deleteProduct.mustang",
		type: "POST",
		dataType:'json',
		data:JSON.stringify({
			"product_code":code
		}),
		headers : {
			"Content-Type" : "application/json",
			"X-HTTP-Method-Override" : "POST"
		},
		success:function(data){
			
			if(data.success){
				alert("삭제");
				window.location="productList.mustang";
				return;
				
			}if(data.fail){
				alert("삭제 실패");
				
				return;
			}
		}
		
	})
}