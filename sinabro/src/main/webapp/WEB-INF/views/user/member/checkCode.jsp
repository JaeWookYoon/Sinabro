<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<input type="hidden" name="codech" value="n"/>
<c:choose>
<c:when test="${codeId==1}">
<form name="checkCode" method="post" action="checkIdCode.do">
<input type="text" name="code" id="code"/>
<input type="submit" value="인증"/>
</form>
</c:when>

<c:when test="${codePw==1}">
<form name="checkCode" method="post" action="checkPwCode.do">
<input type="text" name="code" id="code"/>
<input type="submit" value="인증"/>
</form>
</c:when>

<c:when test="${codech eq 'y'}">
<div>
회원님의 아이디는 
<c:forEach var="id" items="${findId}">
${id}
</c:forEach>
입니다.
</div>
</c:when>

<c:when test="${codech eq 'p'}">
<p>회원님의 임시비밀번호는 ${findPw}입니다.
	변경하여 사용하시기 바랍니다.</p>
</c:when>
</c:choose>
<a href="/sinabro/hi.do">메인으로</a>
</body>
</html>