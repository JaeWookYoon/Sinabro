<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="/sinabro/css/admin/member/regForm.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>regForm</title>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="/sinabro/js/jquery-3.2.1.min.js"></script>
<script src="/sinabro/js/admin/member/regForm.js"></script>
</head>
<body>
	<%@include file="/WEB-INF/views/admin/main.jsp"%>
<fieldset>

	<div id="wrap">
		<p>관리자 추가</p>
		<hr>
			<div id="regTotalForm">
		<form id="regForm" name="regForm" method="post" action="join.mustang" onsubmit="return checkInput()">
				<table id="Form">
					<tr>
						<th>이름</th>
						<td><input id="name" type="text" name="name" /></td>
					</tr>
					<tr>
						<th>아이디</th>
						<td><input id="id" type="text" name="id" readonly="readonly" onfocus="idCheck()"/>&nbsp;
						<input id="idBt" type="button" value="중복확인" onclick="idCheck()" />
						
						
						</td>
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
						
						
				<!-- 	<input id="join"  type="submit" value="JOIN"/>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -->
						<a href="javascript:this.regForm.submit()" class="button">join</a>
						<a href="#" class="button">cancle</a>
					<!-- 	<input id="cancel" type="reset" value="CANCEL" />--></td>
					</tr>
				</table>
				</div>
		</form>
			</div>
				<input type="hidden" name="check" value="n" />
	<hr>
	</div>
	
	</fieldset>
</body>
</html>