<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="/sinabro/js/jquery-3.2.1.min.js"></script>
<script src="/sinabro/js/admin/product/productUpdate.js"></script>
<%@include file="/WEB-INF/views/admin/main.jsp"%>
</head>
<body>

<c:set var="product" value="${product}"/>

<input type="hidden" name="product_code" id="product_code" value="${product.product_code}"/>
<c:forEach var="img" items="${img}">
<img src="/sinabro${img}"/>
</c:forEach>
<select>
<c:forEach var="size" items="${size}">
<option value="${size}">${size}</option>
</c:forEach>
</select>
<c:set var="br" value="${brand}"/>
<div>${br.description}</div>
<a href="productUpdateForm.mustang?product_code=${product.product_code}" class="button">수정</a>
<a href="deleteProduct.mustang?product_code=${product.product_code}" class="button">삭제</a>
</body>
</html>