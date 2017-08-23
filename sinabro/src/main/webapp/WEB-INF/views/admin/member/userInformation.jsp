<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center" class="body">
		<center>
			<h3>회원 정보</h3>
			<table width="600" border="1">
				<tr>
					<td align="center" >아이디</td>
					<td align="left" >${vo.id}</td>
					<td align="center">닉네임</td>
					<td align="left" >${vo.name}</td>
				</tr>
				<tr>
					<td align="center">번호</td>
					<td align="left">${vo.phone}</td>
					<td align="center">우편번호</td>
					<td align="left">${vo.zipcode}</td>
					
				</tr>
				<tr>
					<td align="center">이메일</td>
					<td align="left">${vo.email}</td>
					<td align="center">포인트</td>
					<td align="left">${vo.point}</td>
				</tr>
				<tr>
					<td align="center">주소</td>
					<td align="left">${vo.address1}</td>
				</tr>
				<tr>
					<td align="center">상세주소</td>
					<td align="left">${vo.address2}</td>
				</tr>
			</table>
			<br /> <input type="button" value="회원정보 수정"
				onclick="window.location='updateUserInformation.mustang?id=${vo.id}'" /> <input
				type="button" value="회원 삭제"
				onclick="window.location='deleteUserInformation.mustang?id=${vo.id}'" /> <input
				type="button" value="회원목록" onclick="window.location='userList.mustang'" />
		</center>
	</div>
</body>
</html>