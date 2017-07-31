<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="/WEB-INF/views/user/main.jsp"%>
<script type="text/javascript">

	function search() {
		var form = document.listForm;
		if (form.search_text.value == null || form.search_text.value == "") {
			alert("검색어를 입력해 주세요");
			return;
		}
		var url = 'list.do?pageNum = 1&search_type=' + form.search_type.value
				+ '&search_text=' + encodeURI(form.search_text.value);
		window.location = url;
	}
	function passCheck(value) {
		if (value == "successDelete" || value.equals("successDelete")) {
			alert("삭제되었습니다.");
		}
	}
	wondow.onload = passCheck("${value}");
</script>
</head>
<body>
<c:if test="${check == false }">
<script>
alert("글쓰기 권한이 없습니다.");
window.location="loginForm.do";
</script>
</c:if>
	<center>
		<h3>게시판</h3>
		<table width="700">
		<tr>
			<td align="right" colspan="5">
				<input type="button" value="전체목록" onclick="window.location='list.do'" />
				<input type="button" value="글쓰기" onclick="window.location='writeForm.do'"/>
			</td>
		</tr>
		<tr>
			<td align="center" width="60">번호</td>
			<td align="center" width="380">제목</td>
			<td align="center" width="100">작성자</td>
			<td align="center" width="100">작성일</td>
			<td align="center" width="60">조회수</td>
		</tr>
		<!-- 글이 없을 경우 -->
		<c:if test="${count==0 }">
			<tr>
				<td colspan="6" align="center">게시판에 저장된 글이 없습니다.</td>
			</tr>
		</c:if>
		<c:if test="${count !=0 }">
			<c:forEach var="vo" items="${boardList }">
				<tr>
					<td align="center">${number }<c:set var="number" value="${number-1 }" scope="page"/></td>
					<td align="left">
					<a href="content.do?num=${vo.num }&pageNum=${bp.currentPage}">&nbsp;${vo.subject }</a>
					<c:if test="${vo.readcount > 10}">
					</c:if></td>
					<td align="center">
						<b>${vo.id }</b></td>
					<td align="center">${vo.regdate }</td>
					<td align="center">${vo.readcount }</td>
				</tr>
			</c:forEach>
		</c:if>
		</table>
		<br/>
		<c:if test="${bp.isPre() }">
		<a href="list.do?pageNum=${bp.getPage_Start()-bp.p_size }">[이전]</a>
		</c:if>
		<c:forEach var="counter" begin="${bp.getPage_Start() }" end="${bp.getPage_End() }">
		<c:if test="${search_text ne ''}">
		<a href="javascript:window.location='list.do?pageNum=${counter }&search_type=${search_type}&search_text=${search_text}'">
		[${counter }]</a>
		</c:if>
		<c:if test="${search_text eq ''}">
		<a href="javascript:window.location='list.do?pageNum=${counter }'">
		[${counter }]</a>
		</c:if>
		</c:forEach>
		<c:if test="${bp.isNext() }">
		<a href="list.do?pageNum=${bp.getPage_Start()+bp.p_size }">[다음]</a>
		</c:if>
		<p><p>
		<form method="get" name="listForm" action="list.do">
			<input type="hidden" name="pageNum" value="${pageNum }"/>
			<select name="search_type">
				<option value="all" ${search_type=="all"?"selected":"" }>전체</option>
				<option value="subject" ${search_type=="subject"?"selected":"" }>제목</option>
				<option value="writer" ${search_type=="writer"?"selected":"" }>작성자</option>
				<option value="content" ${search_type=="content"?"selected":"" }>내용</option>
			</select>
			<input type="text" name="search_text" value="${search_text }"/>
			<input type="button" value="검색" onclick="search()"/>
		</form>
	</center>
</body>
</html>