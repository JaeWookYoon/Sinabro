<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
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
<%@include file="/WEB-INF/views/user/main.jsp"%>

</head>

<body>
	<fieldset>
		<form method="post" name="writeForm"
			action="usedupdate.do?num=${vo.num}" enctype="multipart/form-data">
			<table width="750" cellpadding="1" cellspacing="0.5">

				<tr>
					<td align="center">작성자</td>
					<td><input type="text" name="id" id="id" value="${vo.id}"
						readonly="readonly"></td>
				</tr>
				<tr>
					<td align="center">가격</td>
					<td align="left"><input type="text" name="price"
						value="${vo.price }" /> 원</td>
				</tr>
				<tr>
					<td align="center">거래방식</td>
					<td align="left"><select name="transaction" >
							<option value="직거래">직거래</option>
							<option value="배송거래">배송거래</option>
					</select></td>
				</tr>
				<tr>
					<td align="center">제목</td>
					<td><input type="text" size="60" id="subject" name="subject"
						value="${vo.subject}"></td>
				</tr>
				<tr>
					<td align="center">내용</td>
					<td><textarea name="content" id="content" rows="80" cols="10">${vo.content}</textarea>
						<script>
							window.onload = function() {
								CKEDITOR.replace('content');
							}
						</script></td>
				</tr>


				<c:forEach var="i" items="${img }">
					<tr>
						<td align="center">이미지</td>
						<td colspan="7" align="left" height="100"><img
							src="/sinabro${i}" /></td>
					</tr>
				</c:forEach>

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
			<input type="button" value="글수정" onclick="updateCheck()"> <input
				type="button" value="목록보기" onclick="window.location='usedlist.do'" />
		</form>
	</fieldset>
</body>
</html>