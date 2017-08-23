<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="/sinabro/js/jquery-3.2.1.min.js"></script>
<script src="/sinabro/js/user/board/script.js"></script>
<%@include file="/WEB-INF/views/user/main.jsp"%>
</head>
<body>
<script>
window.onload=function(){
	getDat();
}
</script>
	<div align="center" class="body">
		<form  name="writeForm">
			<input type="hidden" name="num" value="${vo.num }" />
		</form>
		<center>
			<h3>글보기</h3>
			<table width="600" border="1">
				<tr>
					<td align="center" width="100">번호</td>
					<td align="left" width="200">${vo.num}</td>
					<td align="center" width="100">작성일</td>
					<td align="left" width="200">${vo.regdate}</td>
				</tr>
				<tr>
					<td align="center">작성자</td>
					<td align="left">${vo.id}</td>
					<td align="center">조회수</td>
					<td align="left">${vo.readcount}</td>
				</tr>
				
				<tr>
					<td align="center">제목</td>
					<td colspan="7" align="left">${vo.subject}</td>
				</tr>
				<tr>
					<td align="center">내용</td>
					<td colspan="7" align="left" height="100"><pre>${vo.content}</pre></td>
				</tr>
			</table>
			<br /> 
			<c:if test="${sessionScope.loginId eq vo.id}">
			<input type="button" value="글수정"
				onclick="window.location='updateForm.do?num=${vo.num}'" /> <input
				type="button" value="글삭제"
				onclick="window.location='deleteProc.do?num=${vo.num}'" /> 
				</c:if>
				<input
				type="button" value="목록보기" onclick="window.location='list.do'" />
		</center>
	</div>
	<table id="tr">
	</table>
	<input type="hidden" name="num" id="thisnum" value="${vo.num}"/>
	<input type="hidden" name="id" id="logid" value="${sessionScope.loginId}"/>
	<input type="text" name="content" id="content" onkeypress="if(event.keyCode==13){ insertDat()}"/>
</body>
</html>