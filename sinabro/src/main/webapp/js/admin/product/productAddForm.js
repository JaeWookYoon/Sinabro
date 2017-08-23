var count=0;
var filecount=0;
function plusSize(){
	++count;
var size="<li id='sizes"+count+"'>";
size+="<select name='sizeaa' id='sizea"+count+"' style='height:23px;'><option> ------ select a Size  -------</option><option value='S'>Small</option><option value='M'>Medium</option><option value='L'>Large</option><option value='XL'>X-Large</option><option value='Free'>Free</option></select><a href='javascript:deleteSize()' id='sizebt"+count+"' class='addbutton'>delete</a></li>";
$("#sizeList").append(size);
var quan="<li id='quan"+count+"'>";
quan+="<input type='number' name='quantitya' id='quantity"+count+"' onkeypress='controlNum(event)' required='required'/></li>";
$("#quanList").append(quan);

}


function plusfile(){
	++filecount;
	var imgFile="<li id='filea"+filecount+"'>";
	imgFile+="<input id='file"+filecount+"' type='file' class='image' name='imgFile' value='search' onfocus='' accept='image/jpg,img/gif,image/png' required='required'/><a href='javascript:deleteFile()' id='filebt"+filecount+"' class='addbutton'>delete</a></li>";
	$("#fileList").append(imgFile);
}

function checkList(){
	for(var i=0;i<filecount;i++){
	if($("#file"+i).val()==""){
		alert("사진을 등록해주세요.");
		return false;
	}
	}
	if($("#name").val()==""){
		alert("제품명을 입력해주세요.");
		return false;
	}
	for(var i=0;i<count;i++){
	if($("#quantity"+i).val()==""){
		alert("수량을 입력해주세요");
		return false;
	}
	}
	
	if($("#price").val()==""){
		alert("가격을 입력해주세요.");
		return false;
	}
		
	
}
function controlNum(event){
	if(event.keyCode<48||event.keyCode>57){
		alert("숫자만 입력하세요.");
		return;
	}
}
function deleteSize(){
	$("#sizes"+count).remove();
	$("#sizea"+count).remove();
	$("#quantity"+count).remove();
	$("#sizebt"+count).remove();
	$("#quan"+count).remove();
	--count;
}
function deleteFile(){
	$("#filea"+filecount).remove();
	$("#file"+filecount).remove();
	$("#filebt"+filecount).remove();
	--filecount;
}
function addBrand(){
	window.open("/sinabro/addBrandForm.mustang",width=100,height=100);
}
