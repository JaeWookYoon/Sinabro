
function submitContents(elClickedobj){
	oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD",[]);
	//$('#content').val(inputContent);
	//var inputContent=
	try{
		elClickedobj.form.submit();
		alert("true");
		}catch(e){
	
		alert(e.message);
	}
}
