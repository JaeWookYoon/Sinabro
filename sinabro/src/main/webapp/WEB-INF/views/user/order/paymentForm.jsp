<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/sinabro/css/user/order/paymentForm.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/views/user/main.jsp"%>
<%@include file="/WEB-INF/views/user/member/mainCategoriesForm.jsp"%>
<script src="/sinabro/js/jquery-3.2.1.min.js"></script>
<script src="/sinabro/js/user/order/paymentForm.js"></script>
<title>Insert title here</title>
</head>
<body>
<c:set var="member" value="${member}"/>
	<a href="#"><img id="payment" src="/sinabro/images/payment.gif" /></a>


		<form id="orderForm" method="post" action="#" onsubmit="#">
	<div class="order">
		<p>Order Info.</p>
		<hr>
			<table id="order1">
				<tr>
					<th id="li_1">PIC</th>
					<th id="li_2">NAME</th>
					<th id="li_3">SIZE</th>
					<th id="li_4">PRICE</th>
					<th id="li_5">MILAGE</th>
				</tr>
			<c:choose>
			<c:when test="${productList eq null}">
				<tr>
					<td><input type="hidden" id="product_code" name="product_code" value="${product.product_code}"/>
					<input class="productzone" id="img" type="image" name="img" src="/sinabro${product.mainImg}"></td>
					<td><input class="productzone" id="name" readonly="readonly" name="name" value="${product.name}"></td>
					<td><input class="productzone" id="sizea" readonly="readonly" name="sizea" value="${product.sizea}"></td>
					<td><input class="productzone" id="price" readonly="readonly" name="price" value="${product.price}"></td>
					<td><input class="productzone" id="milage" readonly="readonly" name="milage" value="${product.price/1000}"></td>
				</tr>
				</c:when>
				<c:otherwise>
				<c:forEach var="product" items="${productList}">
			
				<tr>
					<td><input type="hidden" name="product_codea" id="product_codea" value="${product.product_code}"/>
					<input class="productzone" id="img" type="image" name="img" src="/sinabro${product.mainImg}"></td>
					<td><input class="productzone" id="names" readonly="readonly" name="names" value="${product.name}"></td>
					<td><input class="productzone" id="sizeaa" readonly="readonly" name="sizeaa" value="${product.sizea}"></td>
					<td><input class="productzone" id="pricea" readonly="readonly" name="pricea" value="${product.price}"></td>
					<td><input class="productzone" id="milagea" readonly="readonly" name="milagea" value="${product.price/1000}"></td>
				</tr>
				</c:forEach>
				</c:otherwise>
				</c:choose>
			</table>
			<hr>
			
		
	</div>


	<div class="customer">
		<p>Customer Info.</p>
		<hr>
		
			<table id="customer1">
				<tr>
					<th>이름</th>
					<td><input id="name" readonly="readonly" name="name" value="${member.name}"></td>
				</tr>
				<tr>
					<th>E-mail</th>
					<td><input id="email" readonly="readonly" name="email" value="${member.email}"/></td>
				</tr>
				<tr>
					<th>연락처</th>
					<td><input id="phone" readonly="readonly" name="phone" value="${phone1}"/> - <input id="phone1" readonly="readonly" name="phone1" value="${phone2}"/> - <input
						id="phone2" readonly="readonly" name="phone2" value="${phone3}"/></td>
				</tr>
			</table>
		
		<hr>
	</div>


	<div class="shipping">
		<span style="font-weight:bold; font-size:24pt">Shipping Info.</span>
		<input type="radio" name="customerInfo" id="customerInfo" value="same as customer's info" onclick="getInfo()"/>same as customer's info
		 / <input type="radio" name="customerInfo" id="newCustomerInfo" value="new customer's info" onclick="resetInfo()">new customer's info
					<br/><br/><hr>
		
			<table id="shipping1">
				<tr>
					<th>이름</th>
					<td><input id="nameone" type="text" name="nameone" required="required"></td>
				</tr>
				<tr>
				<tr>
					<th>연락처</th>
					<td><select id="phoneone" name="phoneone">
							<option value="010">010</option>
							<option value="011">011</option>
							<option value="017">017</option>
							
					</select> - <input id="phonetwo" type="tel" name="phonetwo" required="required"/> - <input id="phonethree" type="tel" name="phonethree" required="required"/></td>
				</tr>
				<tr>
					<th>우편번호</th>
					<td><input id="zipcode" type="text" name="zipcode" required="required"/>&nbsp;<input
						id="zipBt" type="button" onclick="getPost()" value="우편번호검색" /></td>
				</tr>
				<tr>
					<th>기본주소</th>
					<td><input id="address1" type="text" name="address1" required="required"/></td>
				</tr>
				<tr>
					<th>나머지주소</th>
					<td><input id="address2" type="text" name="address2" /></td>
				</tr>
				<tr>
					<th>주문메세지<br>(100자내외)
					</th>
					<td><textarea rows="5" cols="30"></textarea></td>
				</tr>
			</table>
		
		<hr>
	</div>




	<div class="milage">
		<p>Milage Use.</p>
		<hr>
		
			<ul id="milage1">
				<li><input id="usemilage" name="usemilage" type="number">원&nbsp;&nbsp;&nbsp;←&nbsp;&nbsp;&nbsp;
				<input id="alreadymilage" readonly="readonly" name="alreadymilage" value="${member.point}">원 (사용가능 적립금)</li>
			</ul>
		
		<hr>
	</div>
	</form>
	<center>
	<div class="ocBt">
	<table id="btTable">
	<tr>
	<td><a href="#" class="button">Order Now.</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="#" class="button">Cancel.</a></td>
	</tr>
	</table>
	</div>
	</center>
</body>
</html>