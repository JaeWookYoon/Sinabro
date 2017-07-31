<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="/sinabro/css/user/member/loginForm.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/sinabro/js/jquery-3.2.1.min.js"></script>
<script src="/sinabro/js/user/member/loginForm.js"></script>
<title>Insert title here</title>
<%@include file="/WEB-INF/views/user/main.jsp"%>
</head>
<body>
	<div id="wrap">
		<p>로그인</p>
		<hr>
		<div id="logTotalForm">
			<form id="form" method="post" action="login.do" onsubmit="return loginCheck()">
				<table id="logForm">
					<tr>
						<th>I.D</th>
						<td><input type="text" name="id" id="id" /></td>
						<td rowspan="2"><input type="submit" value="L O G I N"
							id="bt" /></td>
					</tr>
					<tr>
						<th>P.W</th>
						<td><input type="password" name="password" id="password" /></td>
					</tr>
				</table>
			</form>
		</div>
		<div id="findForm">
			<form>
				<table id="table2">
					<tr>
						<td id="join1"><a href="/sinabro/policy.do">JOIN
								MEMBERSHIP</a></td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td id="join2"><a href="#">FINDING ID/PW</a></td>
					</tr>
				</table>
			</form>
		</div>
		<hr>
	</div>

</body>
</html>