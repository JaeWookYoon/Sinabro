<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="/WEB-INF/views/admin/main.jsp"%>

<style>
body {
	font-size: 10pt;
	color: #898989;
	padding: 0 0 0 0;
	margin: 0 0 0 0;
	margin-left: auto;
	margin-right: auto;
	width:1000px;
	position: relative;
}

#write {
	text-align: left;
}

#list {
	text-align: right;
}

#search {
	text-align: right;
}

.button {
	align: center;
	text-decoration: none;
	font-family: Times New Roman;
	text-indent: 0px;
	line-height: 10px;
	-moz-border-radius: 0px;
	-webkit-border-radius: 0px;
	border-radius: 0px;
	text-align: center;
	vertical-align: middle;
	display: inline-block;
	font-size: 16px;
	color: #353535;
	width: 65px;
	height: 6px;
	padding: 8px;
	background-color: #F6F6F6;
	border-color: #bcc1c2;
	border-width: 1px;
	border-style: solid;
}

.button:active {
	position: relative;
	top: 3px
}

.button:hover {
	background-color: #EAEAEA;
}

#wrapper {
	
}

#bottom {
	width: 900px;
	text-align: center;
	font-size: 12pt;
	color: #999;
	padding-top: 60px;
	padding-bottom: 60px;
	font-family: NanumGothicWeb;
}

#bottominner {
	margin-top: 5px;
	font-family: NanumGothicWeb;
	color: #999;
}
</style>
<script type="text/javascript">
	function search() {
		var form = document.listForm;
		if (form.search_text.value == null || form.search_text.value == "") {
			alert("검색어를 입력해 주세요");
			return;
		}
		var url = 'userList.mustang?pageNum = 1&search_type='
				+ form.search_type.value + '&search_text='
				+ encodeURI(form.search_text.value);
		window.location = url;
	}
</script>
</head>
<body>
	<center>
		<br> <br>
		<h3>회원목록</h3>

		<div id="wrapper">
			<table width="700" border="0" cellpadding="1" cellspacing="0">

				<tr>
				<thead>
					<tr
						style="background-color: #CCC; font-family: Tahoma, Geneva, sans-serif; font-size: 10pt; color: #666;">
						<th align="center" width="60">No.</th>
						<th align="center" width="100">id</th>
						<th align="center" width="100">Name</th>
						<th align="center" width="350">address1</th>
						<th align="center" width="60">point</th>
					</tr>
				</thead>

				<tbody>
					<tr>
						<td colspan="8" align="center">
							<div class="tb-center p10" style="font-family: 'NanumGothicWeb';"></div>
						</td>
					</tr>
					<tr>
						<td height="10"></td>
					</tr>
				</tbody>

				<tr />



				<!-- 글이 없을 경우 -->
				<c:if test="${count==0 }">
					<tr>
						<td colspan="6" align="center">저장된 회원이 없습니다.</td>
					</tr>
				</c:if>
				<c:if test="${count !=0 }">
					<c:forEach var="vo" items="${userList }">
						<tr>
							<td align="center">${number }<c:set var="number"
									value="${number-1 }" scope="page" /></td>
							<td align="center"><b>
							<a href="userInformation.mustang?id=${vo.id}&pageNum=${bp.currentPage} ">${vo.id }</a></b>
							</td>
							<td align="center">${vo.name }</td>
							<td align="center">${vo.address1 }</td>
							<td align="center">${vo.point }</td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
		</div>
		<br />
		<c:if test="${bp.isPre() }">
			<a
				href="userList.mustang?pageNum=${bp.getPage_Start()-bp.pageBlock }">[Previous]</a>
		</c:if>
		<c:forEach var="counter" begin="${bp.getPage_Start() }"
			end="${endPage}">
			<c:if test="${search_text ne ''}">
				<a
					href="javascript:window.location='userList.mustang?pageNum=${counter }&search_type=${search_type}&search_text=${search_text}'">
					[${counter }]</a>
			</c:if>
			<c:if test="${search_text eq ''}">
				<a
					href="javascript:window.location='userList.mustang?pageNum=${counter }'">
					${counter }</a>
			</c:if>
		</c:forEach>
		<c:if test="${bp.isNext() }">
			<a
				href="userList.mustang?pageNum=${bp.getPage_Start()+bp.pageBlock }">[Next]</a>
		</c:if>
		<p>
		<p>
		<div id="search">
			<form method="get" name="listForm" action="userList.mustang">
				<input type="hidden" name="pageNum" value="${pageNum }" /> <select
					name="search_type">
					<option value="all" ${search_type=="all"?"selected":"" }>전체</option>
					<option value="id" ${search_type=="id"?"selected":"" }>id</option>
					<option value="name" ${search_type == "name" ? "selected" : "" }>name</option>
				</select> <input type="text" name="search_text" value="${search_text }" /> <input
					type="button" value="검색" onclick="search()" />
			</form>
		</div>
	</center>
</body>
</html>