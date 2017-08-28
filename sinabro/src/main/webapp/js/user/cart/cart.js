function cartInsert(){

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
				
			}else{
				alert("담기 실패");
			}
		}
		
	})
}
function checkSubmit(){
	size=$("#sizea").val();
	alert('g');
	if(size.indexOf("SELECT")>-1){
		alert("Size를 선택하시오.");
		return false;
	}if(size.indexOf("품절")>-1){
		alert("품절 된 상품입니다.");
		return false;
	}
}
