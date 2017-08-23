<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="/sinabro/js/jquery-3.2.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/sinabro/css/user/main/mainContent.css" />

</head>

<body>
<%@include file="/WEB-INF/views/user/main.jsp"%>
<%@include file="/WEB-INF/views/user/member/mainCategoriesForm.jsp"%>
<%@include file="/WEB-INF/views/user/slide.jsp"%>


	
	







<!-- 메인 상품리스트 -->
<div id="tableName">
<br/>
<div id="leftTableName"><a href="#"></a>LATEST</div>
<div id="rightTableName"><a href="#"></a>BEST</div>
<br/><br/>
</div>
<div id="productsList">
<hr>
<div id="table">
<table id="mainProductsList" >
<tr>
<td><a href="#"><img id="mainProducts" src="/sinabro/images/1.jpg"></a></td>
<td><a href="#"><img id="mainProducts" src="/sinabro/images/2.jpg"></a></td>
<td><a href="#"><img id="mainProducts" src="/sinabro/images/3.jpg"></a></td>
<td><a href="#"><img id="mainProducts" src="/sinabro/images/4.jpg"></a></td>
<td><a href="#"><img id="mainProducts" src="/sinabro/images/5.jpg"></a></td>
</tr>
<tr>
<td><a href="#"><img id="mainProducts" src="/sinabro/images/6.jpg"></a></td>
<td><a href="#"><img id="mainProducts" src="/sinabro/images/7.jpg"></a></td>
<td><a href="#"><img id="mainProducts" src="/sinabro/images/8.jpg"></a></td>
<td><a href="#"><img id="mainProducts" src="/sinabro/images/9.jpg"></a></td>
<td><a href="#"><img id="mainProducts" src="/sinabro/images/10.jpg"></a></td>
</tr>
<tr>
<td><a href="#"><img id="mainProducts" src="/sinabro/images/11.jpg"></a></td>
<td><a href="#"><img id="mainProducts" src="/sinabro/images/12.jpg"></a></td>
<td><a href="#"><img id="mainProducts" src="/sinabro/images/13.jpg"></a></td>
<td><a href="#"><img id="mainProducts" src="/sinabro/images/14.jpg"></a></td>
<td><a href="#"><img id="mainProducts" src="/sinabro/images/15.jpg"></a></td>
</tr>
<tr>
<td><a href="#"><img id="mainProducts" src="/sinabro/images/16.jpg"></a></td>
<td><a href="#"><img id="mainProducts" src="/sinabro/images/17.jpg"></a></td>
<td><a href="#"><img id="mainProducts" src="/sinabro/images/18.jpg"></a></td>
<td><a href="#"><img id="mainProducts" src="/sinabro/images/19.jpg"></a></td>
<td><a href="#"><img id="mainProducts" src="/sinabro/images/20.jpg"></a></td>
</tr>
</table>
</div>
<hr/>
</div>


<%@include file="/WEB-INF/views/user/footer.jsp"%>

</body>
</html>