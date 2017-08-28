function writeCheck() {
	

	if (document.writeForm.subject.value == "") {
		alert("제목을 입력해 주세요");
		document.write.subject.focus();
		return false;
	}
	if (document.writeForm.content.value == "") {
		alert("내용을 입력해 주세요");
		document.write.content.focus();
		return false;
	}
	
}


function addFile(num) {
	var v = document.getElementById('list_dis');
	if (num == "b") {
		v.style.display = "";
	}
	if (num == "a") {
		v.style.display = "none"
	}
}
function datInsert(){
	var content=$("#content").val();
	if($("#logid").val()==""){
		alert("회원만이 작성가능합니다.");
		window.location="/sinabro/loginForm.do";
		return;
	}else{
		insertDat();
		
	}
}
function insertDat(){
	
	$.ajax({
		url:"insertUsedDat.do",
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
				
				window.location='usedContent.do?num='+$("#thisnum").val();
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
function getDat(){
		
		$.getJSON("/sinabro/getUsedBoardDat.do?num="+$("#thisnum").val(), function(data){
			console.log(data.list.length);
			var str="";
			var	tr="";
			var td1="";
			var td2="";
			$(data.list).each(function(){//받아온 댓글 리스트를 foreach문으로 돌린다.
			
				str += "<tr class='list' data-rno='"+this.dnum+"'><td>" + this.id + " : " + "</td><td class='content'>"+ this.content +"</td><td><button>수정/삭제</button></td></tr>";
				//str이 모든 값을 저장하고 마지막에 table에 html로 삽입됨.
			
			});
			$("#tr").html(str);//테이블에 적용
		});
	
}
function updateCheck(){

	if (document.writeForm.subject.value == "") {
		alert("제목을 입력해 주세요");
		document.write.subject.focus();
		return;
	}
	if (document.writeForm.content.value == "") {
		alert("내용을 입력해 주세요");
		document.write.content.focus();
		return;
	}
	document.writeForm.submit();
}
