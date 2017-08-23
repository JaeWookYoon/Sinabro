<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/sinabro/js/user/usedboard/script.js"></script>
<script type="text/javascript" src="/sinabro/ckeditor/ckeditor.js"></script>
<%@include file="/WEB-INF/views/user/main.jsp"%>

</head>

<body>
<fieldset>
<form method="post" name="writeForm" action="usedupdateForm.do?num=${vo.num}">
<table width="750" cellpadding="1" cellspacing="0.5">
<tr>
	<td align="center">작성자</td>
	<td><input type="text" name="writer" value="${vo.id}" readonly="readonly"></td>
</tr>
<tr>
<td align="center">가격</td>
<td align="left"><input type="text" name="price" value="${vo.price }" /> 원</td>	
</tr>
<tr>
<td align="center">거래방식</td>
<td align="left">

<select name="transaction">
	<option value="직거래">직거래</option>
	<option value="배송거래">배송거래</option>
</select>	
</td>
</tr>
<tr>
	<td align="center">제목</td>
	<td><input type="text" size="60" name="subject" value="${vo.subject}"></td>
</tr>
<tr>
	<td align="center">내용</td>
	<td><textarea name="content" rows="80" cols="10" >${vo.content}</textarea>
	<script>
	window.onload=function()
	{
	CKEDITOR.replace('content');
	}
</script>
	</td>
</tr>
</table>
</form>
<input type="button" value="글수정" onclick="updateCheck()">
<input type="button" value="목록보기" onclick="window.location='usedlist.do'" />
</fieldset>
</body>
</html>