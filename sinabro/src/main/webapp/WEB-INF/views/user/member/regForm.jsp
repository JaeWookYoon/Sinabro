<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
						<td><input id="id" type="text" name="id" readonly="readonly"/>&nbsp;
						<input id="idBt" type="button" value="중복확인" onclick="idCheck()" /></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input id="password" type="password" name="password" onkeydown="passCheck()"/><b id="passSecure">보안정도: 하</b></td>
					</tr>
					<tr>
						<th>비밀번호 확인</th>
						<td><input id="passwordch" type="password" name="passwordch" /></td>
					</tr>
					<tr>
						<th>우편번호</th>
						<td><input id="zipcode" type="text" name="zipcode" />&nbsp;<input id="zipBt"
							type="button" onclick="getPost()" value="우편번호검색" /></td>
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
								<option value="02">02</option>
								<option value="051">051</option>
								<option value="053">053</option>
								<option value="032">032</option>
								<option value="062">062</option>
								<option value="042">042</option>
								<option value="052">052</option>
								<option value="044">044</option>
								<option value="031">031</option>
								<option value="033">033</option>
								<option value="043">043</option>
								<option value="041">041</option>
								<option value="063">063</option>
								<option value="061">061</option>
								<option value="054">054</option>
								<option value="055">055</option>
								<option value="064">064</option>
						</select> <input id="phone1" type="text" name="phone1" /> - <input id="phone2"
							type="text" name="phone2" /></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><input id="email" type="text" name="email" />@<select id="emailaddress" name="emailaddress">
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