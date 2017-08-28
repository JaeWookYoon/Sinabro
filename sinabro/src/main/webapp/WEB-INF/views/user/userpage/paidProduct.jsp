<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/sinabro/css/user/userpage/paidProduct.css"/>
<%@include file="/WEB-INF/views/user/main.jsp"%>
</head>
<%@include file="/WEB-INF/views/user/userpage/myPageTab.jsp"%>
<body>
<div>
<table id="paidTable">
<tr>
<th>Photo</th><th>Name</th><th>Address</th><th>Size</th><th>Price</th><th>Option</th><th>Status</th>
</tr>
<c:forEach var="vo" items="${list}">
<tr>
<td><input type="image" id="img" src="/sinabro${vo.mainimg}"/></td><td><input type="text" id="name" value="${vo.nameone}"/></td><td><input id="address" type="text" value="${vo.address}"/></td><td><input id="size" type="text" value="${vo.sizea}"/></td><td><input id="price" type="number" value="${vo.price}"/></td><td><input id="order_message" type="text" value="${vo.order_message}"/></td><td><input id="status" type="text" value="${vo.status}"/></td>

</tr>
</c:forEach>
</table>
</div>



</body>
<%@include file="/WEB-INF/views/user/footer.jsp"%>
</html>