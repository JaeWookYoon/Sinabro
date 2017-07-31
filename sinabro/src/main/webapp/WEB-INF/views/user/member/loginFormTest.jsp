<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="/sinabro/css/user/member/loginForm.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/sinabro/js/user/member/loginForm.js"></script>
<title>Insert title here</title>
</head>
<body>
	<%@include file="/WEB-INF/views/user/main.jsp"%>
	<div id="wrap">

		<form id="loginForm" method="post">

			<div id="logForm">
				<ul id="idInput">
					<li>I.D <input type="text" name=id id="id" /></li>
					<li>P.W <input type="password" name="password" id="password" /></li>
				</ul>
			</div>

			<div id="buttonForm">
				<input type="button" value="login" onClick="loginCheck()" />
			</div>

			<div id="joinFindForm">
				<ul id="joinFind">
					<li><a href="#" /> JOIN MEMBERSHIP</li>
					<li><a href="#" /> FINDING ID/PW</li>
				</ul>
			</div>
		</form>
	</div>
</body>
</html>