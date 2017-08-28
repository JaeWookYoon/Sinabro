function getInfo() {

	$.getJSON('/sinabro/callMember.do', function(data) {
		var name = '';
		var phone = '';
		var zipcode = '';
		var address1 = '';
		var address2 = '';
		if (data.x) {
			alert('정보 가져오기 실패');
		}if (data.o) {
			$('#nameone').attr('value', data.member.name);
			$('#phoneone').attr('value', data.phone1);
			$('#phonetwo').attr('value', data.phone2);
			$('#phonethree').attr('value', data.phone3);
			$('#zipcode').attr('value', data.member.zipcode);
			$('#address1').attr('value', data.member.address1);
			$('#address2').attr('value', data.member.address2);
		}
	});

}
function checkOrder(){
	var name=$("#nameone").val();
	var phonetwo=$("#phonetwo").val();
	var phonethree=$("#phonethree").val();
	var zipcode=$("#zipcode").val();
	var address1=$("#address1").val();
	var address2=$("#address2").val();
	if(name==""||name==null){
		alert("이름 입력하세요.");
		return;
	}if(phonetwo==""||phonetwo==null){
		alert("휴대폰입력해주세요.");
		return;
	}if(phonethree==""||phonethree==null){
		alert("휴대폰입력해주세요.");
		return;
	}if(zipcode==null||zipcode==""){
		alert("주소 입력하세요.");
		return;
	}if(address1==null||address1==""){
		alert("주소 입력하세요.");
		return;
	}
	var IMP=window.IMP;
	IMP.init('imp44227988');
	IMP.request_pay({
		   pg : 'kakao', // 결제방식
		    pay_method : 'card',	// 결제 수단
		    merchant_uid : 'merchant_' + new Date().getTime(),
		   name : '주문명: 결제 테스트',	// order 테이블에 들어갈 주문명 혹은 주문 번호
		    amount : $('#total').val(),	// 결제 금액
		    buyer_email : $('#emailal').val(),	// 구매자 email
		   buyer_name :  $('#nameal').val(),	// 구매자 이름
		    buyer_tel :  $('#phone').val()+$("#phone1").val()+$("#phone2").val(),	// 구매자 전화번호
		    buyer_addr :  $('#address1').val()+$('#address2').val(),	// 구매자 주소
		    buyer_postcode :  $('#zipcode').val(),	// 구매자 우편번호
		    	// 결제 완료 후 보낼 컨트롤러의 메소드명
		}, function(rsp) {
			if ( rsp.success ) { // 성공시
				var msg = '결제가 완료되었습니다.';
				msg += '고유ID : ' + rsp.imp_uid;
				msg += '상점 거래ID : ' + rsp.merchant_uid;
				msg += '결제 금액 : ' + rsp.paid_amount;
				msg += '카드 승인번호 : ' + rsp.apply_num;
				alert(msg);
				document.orderForm.submit();
				} else { // 실패시
				var msg = '결제에 실패하였습니다.';
				msg += '에러내용 : ' + rsp.error_msg;
				alert(msg);
			}
		});

	
	
	
}
function resetInfo(){
	$('#nameone').attr('value', '');
	$('#phoneone').attr('value', '');
	$('#phonetwo').attr('value', '');
	$('#phonethree').attr('value', '');
	$('#zipcode').attr('value', '');
	$('#address1').attr('value', '');
	$('#address2').attr('value', '');
}



function getPay(){
	IMP.init("imp44227988");   
IMP.request_pay({
   pg : 'kakao', // 결제방식
    pay_method : 'card',	// 결제 수단
    merchant_uid : $("#order_code").val() + new Date().getTime(),
   name : '주문명: 결제 테스트',	// order 테이블에 들어갈 주문명 혹은 주문 번호
    amount : $("#total").val(),	// 결제 금액
    buyer_email : $("#emailal").val(),	// 구매자 email
   buyer_name :  $("#nameal").val(),	// 구매자 이름
    buyer_tel :  $("#phone").val()+'-'+$("#phone1").val()+'-'+$("#phone2").val(),	// 구매자 전화번호
    buyer_addr :  $("#address1").val()+$("#address2").val(),	// 구매자 주소
    buyer_postcode :  $("#zipcode").val(),	// 구매자 우편번호
    m_redirect_url : '/sinabro/hi.do'	// 결제 완료 후 보낼 컨트롤러의 메소드명
}, function(rsp) {
	if ( rsp.success ) { // 성공시
		var msg = '결제가 완료되었습니다.';
		msg += '고유ID : ' + rsp.imp_uid;
		msg += '상점 거래ID : ' + rsp.merchant_uid;
		msg += '결제 금액 : ' + rsp.paid_amount;
		msg += '카드 승인번호 : ' + rsp.apply_num;
	} else { // 실패시
		var msg = '결제에 실패하였습니다.';
		msg += '에러내용 : ' + rsp.error_msg;
	}
});

}
	
	