<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="/sinabro/js/jquery-3.2.1.min.js"></script>
<script src="/sinabro/js/user/member/updateForm.js"></script>
<link rel="stylesheet" href="/sinabro/css/user/userpage/changePage.css"/>
<%@include file="/WEB-INF/views/user/main.jsp"%>
</head>
<%@include file="/WEB-INF/views/user/userpage/myPageTab.jsp"%>
<body>


<input type="hidden" name="check" id="check" value="${check}"/>
<c:choose>
<c:when test="${check != true}">
<form name="checkPwForm" action="checkInfo.do" method="post">
<input type="password" name="passwordone" id="checkPw" /><a href="javascript:document.checkPwForm.submit()">제출</a>
</form>
</c:when>
<c:when test="${check == true }">
<c:set var="member" value="${vo}"/>
<div id="updateWrap">
<form name="updateForm" method="post" action="updateUserInfo.do" onsubmit="return checkInput()">
<table>
<tr>
<td>ID</td><td><input type="text" name="id" id="id" readonly="readonly" value="${member.id}"/></td>
</tr>
<tr>
<td>이름</td><td><input type="text" name="name" id="name" readonly="readonly" value="${member.name}"/></td>
</tr>
<tr>
<td>비밀번호</td><td><input type="password" name="password" id="password" onkeypress="passCheck()" required="required"/></td><td><b id="passSecure" style="color:red;">보안정도: 하</b></td>
</tr>
<tr>
<td>비밀번호 확인</td><td><input type="password" name="passwordch" id="passwordch" required="required"/></td>
</tr>
<tr>
<td>전화번호</td><td><input type="text" name="phone" id="phone" value="${member.phone}"/></td>
</tr>
<tr>
<td>성별</td><td><input type="text" name="gender" id="gender" readonly="readonly" value="${member.gender}"/></td>
</tr>
<tr>
<td>e-mail</td><td><input type="email" name="email" id="email" value="${member.email}" required="required"/></td>
</tr>
<tr>
<td>우편번호</td><td><input type="text" name="zipcode" id="zipcode" value="${member.zipcode}" onfocus="getPost()"/></td>
</tr>
<tr>
<td>주소</td><td><input type="text" name="address1" id="address1" value="${member.address1}"/></td>
</tr>
<tr>
<td>상세주소</td><td><input type="text" name="address2" id="address2" value="${member.address2}"/></td>
</tr>

</table>
<a href="javascript:document.updateForm.submit()" class="button">수정</a>
<a href="javascript:history.go(-1)" class="button">취소</a>


</form>
</div>
</c:when>
</c:choose>
</body>
<%@include file="/WEB-INF/views/user/footer.jsp"%>
</html>