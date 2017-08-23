<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/sinabro/js/admin/member/script.js"></script>
</head>

<body>

<form method="post" name="updateUserInformation" action="updateUserInformation.mustang?id=${vo.id}" onsubmit="return userWriteCheck()">
<table width="450" border="1">
<tr>
	<td align="center">이름</td>
	<td><input type="text" name="name" value="${vo.name}" readOnly></td>
</tr>
<tr>
	<td>phone</td>
	<td> <input type="text" size="60" name="phone" value="${vo.phone}"></td>	
</tr>
<tr>
	<td>우편번호</td>
	<td><input type="text" size="60" name="zipcode" value="${vo.zipcode}"></td>
</tr>
<tr>
	<td>이메일</td>
	<td><input type="text" size="60" name="email" value="${vo.email}"></td>
</tr>
<tr>
	<td>address1</td>
	<td><input type="text" size="60" name="address1" value="${vo.address1}"></td>
</tr>
<tr>
	<td>address2</td>
	<td><input type="text" size="60" name="address2" value="${vo.address2}"></td>
</tr>
<tr>
	<td>point</td>
	<td><input type="text" size="60" name="point" value="${vo.point}"></td>
</tr>
<tr>
	<td>admin</td>
	<td><input type="text" size="60" name="admin" value="${vo.admin}"></td>
</tr>
</table>
<input type="submit" value="글수정">
<input type="button" value="목록보기" onclick="window.location='userList.mustang'" />
</form>

</body>
</html>