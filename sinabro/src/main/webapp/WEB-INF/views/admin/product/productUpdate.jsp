<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/sinabro/css/admin/product/productUpdate.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="/sinabro/js/jquery-3.2.1.min.js"></script>

<script src="/sinabro/js/admin/product/productAddForm.js"></script>
<%@include file="/WEB-INF/views/admin/main.jsp"%>
</head>
<body>
<div id="wrapupdate">

<div id="onewrap">
현재 정보는 수정 정보로 갱신되어집니다.
<form name="updateProductForm" action="productUpdate.mustang" method="post" enctype="multipart/form-data" onsubmit="return checkList()">
<c:set var="product" value="${product}"/>

<input type="hidden" name="product_code" id="product_code" value="${product.product_code}"/>
<table>
<tr><th>NAME</th></tr>
<tr>
<td><input type="text" name="name" id="name" value="${product.name}" required="required"/></td>
</tr>
<tr>
<td>
<ul>
<li>Now Image</li>
<c:forEach var="img" items="${img}">
<li><img id="imgs" src="/sinabro${img}"/></li>
</c:forEach>

</ul>
</td>
<td>
<ul id="fileList">
<li>MODIFY IMG</li>
<li><a href="javascript:plusfile()">add</a></li>
</ul>
</td>
</tr>

<tr><th>SIZE</th></tr>
<tr>
<td>
<ul>
<c:forEach var="size" items="${size}">
<li><input type="text" value="${size}" readonly="readonly"/></li>
</c:forEach>
</ul>
</td>
<td>
<ul id="sizeList">
<li>MODIFY SIZE</li>
<li><a href="javascript:plusSize()">add</a></li>
</ul>
</td>
</tr>

<tr><th>QUANTITY</th></tr>
<tr>
<td>
<ul>
<c:forEach var="quan" items="${quantity}">
<li><input type="number" value="${quan}" readonly="readonly"/></li>
</c:forEach>
</ul>
</td>

<td>
<ul id="quanList">
<li>MODIFY QUANTITY</li>
</ul>
</td>
</tr>

<tr><th>PRICE</th></tr>

<tr>
<td>
<ul>
<li>PRICE</li>
<li>
<input type="number" name="price" id="price" value="${product.price}" required="required"/>
</li>
<li>OPTION</li>
<li>
<input type="text" name="optiona" id="optiona" value="${product.optiona}" placeholder="Option"/>
</li>
</ul>
</td>
</tr>
</table>
</form>
</div>


<a href="javascript:document.updateProductForm.submit()" class="button">수정</a>
<a href="#" class="button">취소</a>
</div>
</body>
</html>