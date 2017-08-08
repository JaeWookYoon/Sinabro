<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<th colspan="5">LIST</th>
</tr>
<c:if test="${count==0}">
<tr>
<td>Not Found</td>
</tr>
</c:if>
<c:if test="${count>0}">


<c:set var="td" value="${tdcount}"/>
<c:forEach var="product" items="${list}">
<c:choose>
<c:when test="${td%5==0}">
<c:set var="td" value="0"/>
<tr>
<c:when test="${td%5!=0}">
<c:set var="td" value="${td=td+1}"/>
<td><img style="width:200px; height:200px" src="/sinabro${product.mainImg}"/></td>
</c:when>
</tr>
</c:when>
</c:choose>
</c:forEach>


</c:if>




</table>
<div>
<c:if test="${pre}">
		<a href="list.do?pageNum=${startPage-pageSize}">[Previous]</a>
		</c:if>
		<c:forEach var="counter" begin="${startPage}" end="${endPage}">
		<c:if test="${search_text ne ''}">
		<a href="javascript:window.location='productList.do?pageNum=${counter }&search_type=${search_type}&search_text=${search_text}'">
		[${counter }]</a>
		</c:if>
		<c:if test="${search_text eq ''}">
		<a id="pageNum" href="javascript:window.location='list.do?pageNum=${counter }'">
		${counter }</a>
		</c:if>
		</c:forEach>
		<c:if test="${post}">
		<a href="productList.do?pageNum=${startPage+pageSize}">[Next]</a>
		</c:if>

</div>
</body>
</html>