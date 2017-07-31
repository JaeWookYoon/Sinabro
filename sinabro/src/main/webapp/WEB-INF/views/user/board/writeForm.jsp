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
<form method="post" name="writeForm" action="writeForm.do" enctype="multipart.form-data">
글쓰기
<table width=450 border=1>
<tr>
   <td align="center">작성자</td>
   <td align="left"><input type="text" name="writer" value="${writer }"/></td>
</tr>
<tr>
   <td align="center">비밀번호</td>
   <td align="left"><input type="password" name="pass" value="${pass }"/></td>
</tr>
<tr>
   <td align="center">이메일</td>
   <td align="left"><input type="text" name="email" value="${email }"/></td>
</tr>
<tr>
   <td align="center">제목</td>
   <td align="left"><input type="text" name="subject" value="${subject }"/></td>
</tr>
<tr>
   <td align="center">내용</td>
   <td align="left" rows="13" cols="60"><textarea name="content"></textarea></td>
</tr>
</table>
<br/>
<input type="button" value="글쓰기" onclick="writeCheck()" />
<input type="button" value="목록보기" onclick="window.location='list.do'" />

</form>
</div>

</body>
</html>