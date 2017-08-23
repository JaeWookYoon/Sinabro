function checkStatus(){
$.getJSON("/sinabro/checkStatus.do", function(data){
			
			if(data.fail){
				alert("다른 기기에서 로그인되었습니다.");
				window.location="/sinabro/out.do";
			}
			if(data.success){
				
			}
		});
}
function getToken(){
	$.ajax({
		url:"https://testapi.open-platform.or.kr/oauth/2.0/authorize",
		type: "GET",
		contentType:"application/x-www-form-urlencoded; charset=UTF-8",
		
		data:({
			'response_type':"code",
			'client_id':"l7xx2bf61609e91242b8b183290b9f735794",
			'redirect_uri':"http://localhost:8080/sinabro/hi.do",
			'scope':"login",
			'client_info':"hi"
			
			
			
		})
		.done(function(data){
					alert("dd");
			
			// UI에 결과값 바인딩
			alert(data.code);
		})
});
}