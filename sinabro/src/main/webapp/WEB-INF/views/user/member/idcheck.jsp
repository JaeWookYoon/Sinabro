<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="/sinabro/js/jquery-3.2.1.min.js"></script>
<script src="/sinabro/js/user/member/idcheck.js"></script>
</head>
<body>

<form name="checkForm" action="idcheck.do" method="post" onsubmit="return idcheck()">
<input type="text" name="id" id="id" value="${id}"/><input type="submit" value="중복확인"/>
<p id="result"></p>
<div id="pos">
<c:if test="${check==0 }">
<p>아이디는 영어,숫자로만 가능합니다.</p>
</c:if>
<c:if test="${check==1 }">

<p>사용가능한 아이디입니다.</p>
<a href="javascript:insertId(this.checkForm.id.value)">사용하기</a>
</c:if>
<c:if test="${check==2 }">
<p>중복되는 아이디입니다.</p>
</c:if>

</div>
</form>
</body>
</html>