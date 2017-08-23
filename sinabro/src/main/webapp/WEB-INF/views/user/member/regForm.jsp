<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/sinabro/css/user/member/regForm.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>regForm</title>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="/sinabro/js/jquery-3.2.1.min.js"></script>
<script src="/sinabro/js/user/member/regForm.js"></script>
</head>
<body>
	<%@include file="/WEB-INF/views/user/main.jsp"%>

	<div id="wrap">
		<p>회원정보입력</p>
		<hr>
			<div id="regTotalForm">
		<form id="regForm" name="regForm" method="post" action="join.do" onsubmit="return checkInput()">
				<table id="Form">
					<tr>
						<th>이름</th>
						<td><input id="name" type="text" name="name" /></td>
					</tr>
					<tr>
						<th>아이디</th>
						<td><input id="id" type="text" name="id" readonly="readonly" onfocus="idCheck()"/>&nbsp;
						<input id="idBt" type="button" value="중복확인" onclick="idCheck()" /></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input id="password" type="password" name="password" onkeydown="passCheck()" required="required"/><b id="passSecure">보안정도: 하</b></td>
					</tr>
					<tr>
						<th>비밀번호 확인</th>
						<td><input id="passwordch" type="password" name="passwordch" required="required"/></td>
					</tr>
					<tr>
						<th>우편번호</th>
						<td><input id="zipcode" type="text" name="zipcode" onfocus="getPost()"/>&nbsp;</td>
					</tr>
					<tr>
						<th>주소</th>
						<td><input id="address1" type="text" name="address1" /></td>
					</tr>
					<tr>
						<th>상세주소</th>
						<td><input id="address2" type="text" name="address2" /></td>
					</tr>
					<tr>
						<th>연락처</th>
						<td><select id="phone" name="phone">
									<option value="010">010</option>
								<option value="011">011</option>
								<option value="017">017</option>
						</select> <input id="phone1" type="text" name="phone1" /> - <input id="phone2"
							type="text" name="phone2" /></td>
					</tr>
					<tr>
					<th>성별</th>
					
					
					<td>
					<input type="radio" name="gender" value="man"/>man<input type="radio" name="gender" value="woman"/>woman
					</td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><input id="email" type="text" name="email" />@<select id="emailaddress" name="emailaddress" >
						<option value="naver.com">naver.com</option>
						<option value="daum.net">daum.net</option>
						<option value="gmail.com">gmail.com</option>
						<option value="nate.com">nate.com</option>
						</select></td>

					</tr>
				</table>
				<div id="joinCancelBt">
				<table>
					<tr>
						<td colspan="2">
						<input id="join" type="submit" value="JOIN"/>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input id="cancel" type="reset" value="CANCEL" /></td>
					</tr>
				</table>
				</div>
		</form>
			</div>
				<input type="hidden" name="check" value="n" />
	<hr>
	</div>
</body>
</html>