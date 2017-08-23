<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 
<link rel="stylesheet" href="/sinabro/css/user/board/list.css">-->
<link rel="stylesheet" href="/sinabro/css/user/usedboard/list.css"/>
<%@include file="/WEB-INF/views/user/main.jsp"%>



<script type="text/javascript">

	function search() {
		var form = document.listForm;
		if (form.search_text.value == null || form.search_text.value == "") {
			alert("검색어를 입력해 주세요");
			return;
		}
		var url = 'usedlist.do?pageNum = 1&search_type=' + form.search_type.value
				+ '&search_text=' + encodeURI(form.search_text.value);
		window.location = url;
	}
	
</script>
</head>



<body>
<c:if test="${check == false }">
<script>
alert("글쓰기 권한이 없습니다.");
window.location="loginForm.do";
</script>
</c:if>
	<div id="centerwrap">	`
	
	<br><br>
		<h3>FreeBoard</h3>
		
	<div id="wrapper">	
		<table width="700" border="0" cellpadding="1" cellspacing="0">
	
		<tr>
		
		<thead>
         <tr style="background-color:#CCC; font-family:Tahoma, Geneva, sans-serif; font-size:10pt; color:#666; ">
        <th align="center" width="60">No.</th>
			<th align="center" width="380">Content</th>
			<th align="center" width="100">Name</th>
			<th align="center" width="100">Date</th>
			<th align="center" width="60">Hits</th>
   		 </tr>
    </thead>
		
		
		
			
			




		
		
	
		<!-- 글이 없을 경우 -->
		<c:if test="${count==0 }">
			<tr>
				<td colspan="6" align="center">게시판에 저장된 글이 없습니다.</td>
			</tr>
		</c:if>
		<c:if test="${count !=0 }">
			<c:forEach var="vo" items="${usedBoardList }">
				<tr>
					<td align="center">${number }<c:set var="number" value="${number-1 }" scope="page"/></td>
					<td align="left">
					<a href="usedContent.do?num=${vo.num }&pageNum=${bp.currentPage}">&nbsp;${vo.subject }</a>
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
		</div>   <!-- wrapper -->
		<div id='write'>
	<a href='usedwriteForm.do' class="button">write</a>
		</div>
		
		<div id='list'>
			<a href='usedlist.do' class="button">list</a>
		</div>
		
		<br/>
		<c:if test="${bp.isPre() }">
		<a href="usedList.do?pageNum=${startPage-bp.pagesize }">[Previous]</a>
		</c:if>
		<c:forEach var="counter" begin="${startPage}" end="${endPage}">
		<c:if test="${search_text ne ''}">
		<a href="javascript:window.location='usedList.do?pageNum=${counter }&search_type=${search_type}&search_text=${search_text}'">
		${counter }</a>
		</c:if>
		<c:if test="${search_text eq ''}">
		<a href="javascript:window.location='usedList.do?pageNum=${counter }'">
		[${counter }]</a>
		</c:if>
		</c:forEach>
		<c:if test="${bp.isNext() }">
		<a href="usedList.do?pageNum=${startPage+bp.pageSize}">[Next]</a>
		</c:if>
		<p><p>
		<div id="search">
		<form method="get" name="listForm" action="list.do">
			<input type="hidden" name="pageNum" value="${pageNum }"/>

		<input type="radio"  name="search_type" value="all" ${search_type=="all"?"selected":"" }>all
		<input type="radio"  name="search_type" value="subject" ${search_type=="subject"?"selected":"" }>Title
		<input type="radio"  name="search_type" value="ID" ${search_type=="id"?"selected":"" }>ID
		<input type="radio"  name="search_type" value="content" ${search_type=="content"?"selected":"" }>Contents
		<input type="text" name="search_text" value="${search_text }" class="button" placeholder="search"/>
		
		
		</form>
		</div>
	</div>
</body>
</html>