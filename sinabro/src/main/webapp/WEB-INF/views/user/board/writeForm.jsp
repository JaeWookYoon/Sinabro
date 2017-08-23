<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="/sinabro/ckeditor/ckeditor.js"></script>
<link rel="stylesheet" href="/sinabro/css/user/board/writeForm.css" />

<style>

.button {
	align:center;
	
	text-decoration:none;
	font-family:Times New Roman;
	text-indent:0px;
	line-height:10px;
	-moz-border-radius:0px;
	-webkit-border-radius:0px;
	border-radius:0px;
	text-align:center;
	vertical-align:middle;
	display:inline-block;
	font-size:16px;
	color:#353535;
	width:65px;
	height:6px;
	padding:8px;
	background-color:#F6F6F6;
	border-color:#bcc1c2;
	border-width:1px;
	border-style:solid;
}



.button:active {
	position:relative;
	top:3px
}

.button:hover {
background-color:#EAEAEA;
}


</style>
<%@include file="/WEB-INF/views/user/main.jsp"%>
</head>



<body>

<center>
<fieldset>
<form method="post" name="writeForm" action="write.do" enctype="multipart/form-data">

<!--  
<div id="board">
<h2>Q & A</h2></div>
-->

<table width="750" cellpadding="1" cellspacing="0.5">


<tr>
 <td>
 
 
   <span style="font-family:Tahoma, Geneva, sans-serif; color:#666;">   TITLE  | </span>
   
   
   <input type="text" name="subject" id="subject" value="${subject }" />
</td>
 	
</tr>

<tr>

   
   <td colspan="6" >
   <div id="write">
   <textarea name="content" id="content" rows="80" cols="100"></textarea>
   <script>
		window.onload=function()
		{
		CKEDITOR.replace('content');
		}
	</script>

   </div>       
  </td>
</tr>


</table>
<br/>

</form>

<div id=Bt>
<a href="javascript:document.writeForm.submit()" class="button">submit</a>

<a href="javascript:window.location='list.do'" class="button">return list</a>
</div>

</fieldset>








</center>

</body>
</html>