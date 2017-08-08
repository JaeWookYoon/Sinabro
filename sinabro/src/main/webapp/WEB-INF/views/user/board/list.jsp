<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/sinabro/css/user/board/list.css">
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
	<center>	`
	
	<br><br>
		<h3>FreeBoard</h3>
		
	<div id="wrapper">	
		<table width="900" border="0" cellpadding="1" cellspacing="0">
	
		<tr>
		
		<thead>
         <tr style="background-color:#CCC; font-family:Tahoma, Geneva, sans-serif; font-size:7pt; color:#666; ">
        <th align="center" width="60">No.</th>
			<th align="center" width="380">Content</th>
			<th align="center" width="100">Name</th>
			<th align="center" width="100">Date</th>
			<th align="center" width="60">Hits</th>
   		 </tr>
    </thead>
		
		 <tbody>
    <tr>
    <td colspan="8" align="center" >
    
    </td>
    </tr>
    <tr><td height="10"></td></tr>
     </tbody>
		
	
		
	
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
					<td align="center">
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
		<div id="bt-zone">
			
				<input type="button" value="전체목록" onclick="window.location='list.do'" />
				<input type="button" value="writer" onclick="window.location='writeForm.do'"/>
			
		</div>
		</div>   <!-- wrapper -->
		
		<br/>
		<c:if test="${bp.isPre() }">
		<a href="list.do?pageNum=${bp.getPage_Start()-bp.pageBlock }">[Previous]</a>
		</c:if>
		<c:forEach var="counter" begin="${startPage}" end="${endPage}">
		
		<c:if test="${search_text ne ''}">
		<a href="javascript:window.location='list.do?pageNum=${counter }&search_type=${search_type}&search_text=${search_text}'">
		[${counter }]</a>
		</c:if>
		<c:if test="${search_text eq ''}">
		<a id="pageNum" href="javascript:window.location='list.do?pageNum=${counter }'">
		${counter }</a>
		</c:if>
		
		</c:forEach>
		<c:if test="${bp.isNext() }">
		<a href="list.do?pageNum=${startPage=startPage+bp.pageBlock }">[Next]</a>
		</c:if>
		<p><p>
		<form method="get" name="listForm" action="list.do">
			<input type="hidden" name="pageNum" value="${pageNum }"/>
			<select name="search_type">
				<option value="all" ${search_type=="all"?"selected":"" }>전체</option>
				<option value="subject" ${search_type=="subject"?"selected":"" }>Title</option>
				<option value="writer" ${search_type=="writer"?"selected":"" }>Writer</option>
				<option value="content" ${search_type=="content"?"selected":"" }>Contents</option>
			</select>
			<input type="text" name="search_text" value="${search_text }"/>
			<input type="button" value="검색" onclick="search()"/>
		</form>
	</center>
</body>
</html>