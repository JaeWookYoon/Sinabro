<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<div>
<p>${sessionScope.loginName}님의 페이지 입니다.</p>
</div>
<div id="tablediv">
<table>
<tr>
<td><ul><li>Point</li><li>${sessionScope.point}</li></ul></td>
</tr>
</table>
</div>
</body>
<%@include file="/WEB-INF/views/user/footer.jsp"%>
</html>