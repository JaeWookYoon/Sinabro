<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="/WEB-INF/views/user/main.jsp"%>
</head>
<body>
<div>
<%@include file="/WEB-INF/views/user/userpage/myPageTab.jsp"%>
</div>
<table>
<tr><th>Content</th><th>ReadCount</th><th>DATE</th></tr>
<c:forEach var="list" items="${list}">
<tr>
<td><a href="/sinabro/content.do?num=${list.num}">${list.content}</a></td><td>${list.readcount}</td><td>${list.regdate }</td>
</tr>
</c:forEach>
</table>
</body>
<%@include file="/WEB-INF/views/user/footer.jsp"%>
</html>