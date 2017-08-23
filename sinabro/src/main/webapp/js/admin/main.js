function checkStatus(){
$.getJSON("/sinabro/checkStatus.mustang", function(data){
			
			if(data.fail){
				alert("다른 기기에서 로그인되었습니다.");
				window.location="/sinabro/out.mustang";
			}
			if(data.success){
				
			}
		});
}

