<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 
<link rel="stylesheet" href="/sinabro/css/admin/board/list.css">

</head>



<body>
<%@include file="/WEB-INF/views/admin/main.jsp"%>
<fieldset>
<legend style="font-weight:bold; font-size:12pt; font-family:Arial, Helvetica, sans-serif;">게시판 목록</legend>

	<center>	`
	

		
	<div id="wrapper">	
		<table width="800" border="0" cellpadding="1" cellspacing="0" >
	
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
		
		 <tbody >
    <tr>
    <td colspan="8" align="center" >
    <div class="tb-center p10" style="font-family: 'NanumGothicWeb'; ">현재비어있땅</div>
    </td>
    </tr>
    <tr><td height="10"></td></tr>
     </tbody>
		
		</tr>
		
		
			
			




		
		
	
	
			
		</table>
		</div>   <!-- wrapper -->
		<div id='write'>
	<a href='writeForm.do' class="button">write</a>
		</div>
		
		<div id='list'>
			<a href='list.do' class="button">list</a>
		</div>
		
		<br/>
		<c:if test="${bp.isPre() }">
		<a href="list.do?pageNum=${bp.getPage_Start()-bp.p_size }">[Previous]</a>
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
		<a href="list.do?pageNum=${bp.getPage_Start()+bp.p_size }">[Next]</a>
		</c:if>
		<p><p>
		<div id="search">
		<form method="get" name="listForm" action="list.do">
			<input type="hidden" name="pageNum" value="${pageNum }"/>

		<input type="radio"  name="search_type" value="all" ${search_type=="all"?"selected":"" }>all
		<input type="radio"  name="search_type" value="subject" ${search_type=="subject"?"selected":"" }>Title
		<input type="radio"  name="search_type" value="writer" ${search_type=="writer"?"selected":"" }>Writer
		<input type="radio"  name="search_type" value="content" ${search_type=="content"?"selected":"" }>Contents
		<input type="text" name="search_text" value="${search_text }" class="button" placeholder="search"/>
		
		
		</form>
		</div>
	</center>
		</fieldset>
</body>
</html>