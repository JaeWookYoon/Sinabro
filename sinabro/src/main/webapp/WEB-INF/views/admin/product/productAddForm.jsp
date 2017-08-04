<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="/sinabro/js/jquery-3.2.1.min.js"></script>
<script src="/sinabro/js/admin/product/productAddForm.js"></script>
</head>
<body>
<c:choose>
<c:when test="${success}">
alert("물품 추가 성공");
</c:when>
<c:when test="${fail}">
alert("물품올리기 실패");
</c:when>
</c:choose>

<form name="productAddForm" method="post" action="addProduct.mustang" enctype="multipart/form-data" onsubmit="return checkList()">
<table id="lista" style="border:solid; text-align:center">
<tr>
<th>Brand</th><th>Category</th><th>Size</th><th>Img</th><th>Name</th><th>Quantity</th><th>Price</th><th>Option</th>
</tr>
<tr>
<td>
<select name="brand" id="brand">
<option value="supreme">SUPREME</option>
<option value="obey">OBEY</option>
<option value="A.P.C">A.P.C</option>
<option value="palace">PALACE</option>
<option value="bape">BAPE</option>
<option value="champion">CHAMPION</option>
<option value="stussy">STUSSY</option>
</select>
</td>
<td>
<select name="category" id="category">
<option value="top">Top</option>
<option value="bottom">Pants</option>
<option value="shoes">Shoes</option>
<option value="jacket">Jacket</option>
<option value="hat">Cap</option>
<option value="bag">Bag</option>
</select>
</td>
<td>
<ul id="sizeList">
<li>
<select name="sizeaa" id="sizea">
<option value="XL">XL</option>
<option value="L">Large</option>
<option value="M">Medium</option>
<option value="S">Small</option>
</select>
</li>
</ul>
<input type="button" value="추가" onclick="plusSize()"/>
</td>
<td>
<ul id="fileList">
<li>
<input type="file" name="imgFile" id="file" />
</li>
</ul>
</td>
<td>
<input type="text" name="name" id="name"/>
</td>
<td>
<ul id="quanList">
<li>
<input type="number" name="quantitya" id="quantity" onkeypress="controlNum(event)"/>
</li>
</ul>
</td>
<td>
<input type="number" name="price" id="price" onkeypress="controlNum(event)"/>
</td>
<td>
<input type="text" name="optiona" id="optiona"/>
</td>
</tr>
</table>
<input type="submit" value="전송"/>
</form>
<input type="button" value="추가" onclick="getPlus()"/>

</body>
</html>