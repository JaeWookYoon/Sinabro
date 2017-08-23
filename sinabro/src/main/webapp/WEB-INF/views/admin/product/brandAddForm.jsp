<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/sinabro/css/admin/product/brandAddForm.css"/>
<script src="/sinabro/js/admin/product/productAddForm.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
<c:when test="${update}">
<script>
alert(${brand}+"업데이트 완료");
</script>
</c:when>
<c:when test="${success}">
<script>
alert("변경 완료");
</script>
</c:when>
<c:when test="${fail}">
<script>
alert("변경실패");
</script>
</c:when>
</c:choose>
<div>
<form name="brandAddForm" action="addBrand.mustang" method="post" enctype="multipart/form-data">
<ul id="inputForm">
<li>
New Brand Input 
</li>
<li>
<input class="brandinput" type="text" name="brand" required="required" placeholder="brand 입력"/>
</li>
<li>
<textarea class="brandinput" name="description" cols="25" rows="5" required="required" placeholder="brand설명 입력"></textarea>
</li>
<li>
<input class="brandinput" type="file" name="img" required="required"/>
</li>
<li>
<input type="submit" value="추가"/>
</li>
</ul>
</form>
</div>
<div>

</div>
<div>
<table>
<tr>
<th>Brand</th><th>Description</th><th>Delete</th>
</tr>
<c:forEach var="list" items="${list}">
<tr><td><input type="text" id="albrand" name="albrand" value="${list.brand}" readonly="readonly"/></td><td>${list.description}</td><td><a href="deleteBrand.mustang?brand=${list.brand}" class="button">삭제</a></td></tr>
</c:forEach>
</table>
</div>
</body>
</html>