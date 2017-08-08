<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/sinabro/js/user/board/script.js"></script>
<!-- CSS file -->
<link rel="stylesheet" href="/sinabro/css/user/main/mainContent.css" />
<%@include file="/WEB-INF/views/user/main.jsp"%>
</head>
<body>
<div align="center" class="body">
<form method="post" name="writeForm" action="write.do" enctype="multipart.form-data" onsubmit="writeCheck()">
글쓰기
<table width=450 border=1>

<tr>
   <td align="center">제목</td>
   <td align="left"><input type="text" name="subject" value="${subject }"/></td>
</tr>
<tr>
   <td align="center">내용</td>
   <td align="left" rows="13" cols="60"><textarea name="content" cols=20 rows=6></textarea></td>
</tr>
</table>
<br/>
<input type="submit" value="글쓰기"/>
<input type="button" value="목록보기" onclick="window.location='list.do'" />

</form>
</div>

</body>
</html>