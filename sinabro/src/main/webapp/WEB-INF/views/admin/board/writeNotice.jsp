<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="/sinabro/smarteditor/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript">
function submitContents(elClickedobj){
	var inputContent=oEditors.getById["content"].exex("UPDATE_CONTENTS_FIELD",[]);
	$('#content').val(inputContent);
	
	try{
		elClickedobj.form.sumbit();
		}catch(e){
		
	}
}

</script>

<%@include file="/WEB-INF/views/admin/main.jsp"%>
<link rel="stylesheet" href="/sinabro/css/admin/board/list.css">


</head>



<body>
<fieldset><legend style="font-weight:bold; font-size:12pt; font-family:Arial, Helvetica, sans-serif;">공지글작성</legend>

<center>


<form method="post" name="writeForm" action="writeNotice.mustang" enctype="multipart.form-data">

<div id="table" style="margin-left:10%; margin-bottom:20px">

<table width="900" >

<tr><td>
<span>  TITLE  | </span>
    <textarea name="subject" id="subject" value="${subject }" rows="1" cols="60" >
 </textarea>
  
</td>
</tr>


<tr>

   
   <td colspan="6" >
   <div id="write" >
   <textarea name="content" id="content" rows="10" cols="100" width="700"></textarea>
	
   </div>       
  </td>
</tr>


</table>
</div>
<br/>

</form>

<div id=Bt>
<a href="#" class="button">submit</a>

<a href="/sinabro/list.mustang" class="button">return list</a>
</div>






<script type="text/javascript">
var oEditors = [];
nhn.husky.EZCreator.createInIFrame({
    oAppRef: oEditors,
    elPlaceHolder: "content",
    sSkinURI: "/sinabro/smarteditor/SmartEditor2Skin.html",
    fCreator: "createSEditor2"
});
</script>




</center>
</fieldset>
</body>
</html>