<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/sinabro/css/user/userpage/myPageTab.css"/>
<c:if test="${loginError}">
<script>
alert("로그인이 필요한 서비스입니다.");
window.location="/sinabro/hi.do";
</script>
</c:if>
<div id="wrapper">
<table>
<tr>
<th><a href="/sinabro/updateCheck.do">내 정보</a></th>
</tr>
<tr>
<th><a href="/sinabro/Mycart.do">장바구니</a></th>
</tr>
<tr>
<th><a href="/sinabro/getMyboard.do">작성글</a></th>
</tr>
<tr>
<th><a href="/sinabro/certifyPage.do">판매권한 요청</a></th>
</tr>
</table>
</div>
