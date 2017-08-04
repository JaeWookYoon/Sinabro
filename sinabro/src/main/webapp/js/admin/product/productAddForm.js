var count=0;
function plusSize(){
var size="<li>";
size+="<select name='sizeaa' id='sizea'><option value='XL'>XL</option><option value='L'>Large</option><option value='M'>Medium</option><option value='S'>Small</option></select></li>";
$("#sizeList").append(size);
var quan="<li>";
quan+="<input type='number' name='quantitya' id='quantity' onkeypress='controlNum(event)'/></li>";
$("#quanList").append(quan);
var imgFile="<li>";
imgFile+="<input type='file' name='imgFile' id='file' /></li>";
$("#fileList").append(imgFile);
}


function checkList(){
	
	if($("#name").val()==""){
		alert("제품명을 입력해주세요.");
		return false;
	}if($("#quantity").val()==""){
		alert("수량을 입력해주세요");
		return false;
	}if($("#price").val()==""){
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