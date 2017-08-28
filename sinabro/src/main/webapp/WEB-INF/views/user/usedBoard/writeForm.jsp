<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="/sinabro/js/user/usedboard/script.js"></script>
<script type="text/javascript" src="/sinabro/ckeditor/ckeditor.js"></script>
<script type="text/javascript">
	var count = 0;
	var filecount = 0;
	function plusfile() {

		++filecount;
		var imgFile = "<li id='filea"+filecount+"'>";
		imgFile += "<input id='file"+filecount+"' type='file' class='image' name='imgFile' value='search' onfocus='' accept='image/jpg,img/gif,image/png' required='required'/><a href='javascript:deleteFile()' id='filebt"
				+ filecount + "' class='addbutton'>delete</a></li>";
		$("#fileList").append(imgFile);
	}
	function deleteFile() {
		$("#filea" + filecount).remove();
		$("#file" + filecount).remove();
		$("#filebt" + filecount).remove();
		--filecount;
	}
</script>
<link rel="stylesheet" href="/sinabro/css/user/board/writeForm.css" />

<style>
.button {
	align: center;
	text-decoration: none;
	font-family: Times New Roman;
	text-indent: 0px;
	line-height: 10px;
	-moz-border-radius: 0px;
	-webkit-border-radius: 0px;
	border-radius: 0px;
	text-align: center;
	vertical-align: middle;
	display: inline-block;
	font-size: 16px;
	color: #353535;
	width: 65px;
	height: 6px;
	padding: 8px;
	background-color: #F6F6F6;
	border-color: #bcc1c2;
	border-width: 1px;
	border-style: solid;
}

.button:active {
	position: relative;
	top: 3px
}

.button:hover {
	background-color: #EAEAEA;
}
</style>
<%@include file="/WEB-INF/views/user/main.jsp"%>
</head>



<body>

	<center>
		<fieldset>
			<form method="post" name="writeForm" action="usedwrite.do"
				enctype="multipart/form-data">

				<!--  
<div id="board">
<h2>Q & A</h2></div>
-->

				<table width="750" cellpadding="1" cellspacing="0.5">


					<tr>
						<td><span
							style="font-family: Tahoma, Geneva, sans-serif; color: #666;">
								TITLE | </span> <input type="text" name="subject" id="subject"
							value="${subject }" /></td>
						<td>거래방식 <select name="transaction">
								<option value="직거래">직거래</option>
								<option value="배송거래">배송거래</option>
						</select>
						</td>
						<td align="center">가격</td>
						<td align="left"><input type="text" name="price"
							value="${price }" /> 원</td>
					</tr>

					<tr>


						<td colspan="6">
							<div id="write">
								<textarea name="content" id="content" rows="80" cols="100"></textarea>
								<script>
									window.onload = function() {
										CKEDITOR.replace('content');
									}
								</script>

							</div>
						</td>
					</tr>
					<tr>
						<!-- 상품이미지파일 첨부 -->
						<th>Image</th>
						<td colspan="4">
							<ul id="fileList">
								<li><input id='file' type='file' class='image'
									name='imgFile' value='search' onfocus=''
									accept="image/jpg,img/gif,image/png" /> <a
									href="javascript:plusfile()" class="button">add</a></li>
							</ul>
						</td>
					</tr>
				</table>
				<br />
			</form>

			<div id=Bt>
				<a href="javascript:document.writeForm.submit()" class="button">submit</a>

				<a href="javascript:window.location='usedlist.do'" class="button">return
					list</a>
			</div>
		</fieldset>
	</center>

</body>
</html>