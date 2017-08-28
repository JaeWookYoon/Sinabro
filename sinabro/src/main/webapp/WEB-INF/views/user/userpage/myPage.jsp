<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="/WEB-INF/views/user/main.jsp"%>
<link rel="stylesheet" href="/sinabro/css/user/userpage/myPage.css"/>
</head>
<body>
<%@include file="/WEB-INF/views/user/userpage/myPageTab.jsp"%>
<center>
<div>
</div>


<div id="myPageMain">
<p>${sessionScope.loginName}님의 페이지 입니다.</p>
<div id="tablediv">
<table style="border:1px dotted black" cellspacing="0" cellpadding="0">
<tr>
<td id="tableInner"><ul id="pointUl"><li>Point<span>&nbsp;&nbsp;&nbsp;</span><input type="text" id="point" value="${point}" /></li></ul></td>
</tr>
</table>
</div>
</div>

</center>
</body>

<%@include file="/WEB-INF/views/user/footer.jsp"%>
</html>