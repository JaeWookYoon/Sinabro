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
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="/sinabro/js/user/member/regForm.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.2.js"></script>
<title>Insert title here</title>
</head>
<body>

<c:set var="member" value="${member}"/>
	<a href="#"><img id="payment" src="/sinabro/images/payment.gif" /></a>


	<form name="orderForm" method="post" action="orderExec.do">
	<input type="hidden" name="order_code" id="order_code" value="${order_code}"/>
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
				<tr><td><input type="hidden" id="product_code" name="product_codea" value="${product.product_code}"/></td></tr>
				<tr>
					
					<td><input class="productzone" id="img" type="image" disabled="disabled" src="/sinabro${product.mainImg}"/></td>
					<td><input class="productzone" id="name" type="text" readonly="readonly" value="${product.name}"/></td>
					<td><input class="productzone" id="sizea" type="text" readonly="readonly" name="sizeaa" value="${product.sizea}"/></td>
					<td><input class="productzone" id="price" type="number" readonly="readonly" name="pricea" value="${product.price}"/></td>
					<td><input class="productzone" id="milage" type="number" readonly="readonly" name="milagea" value="${product.price/1000}"/></td>
				</tr>
				</c:when>
				<c:when test="${productList ne null}">
			
				<c:forEach var="product" items="${productList}">
				<tr><td><input type="hidden" name="product_codea" id="product_codea" value="${product.product_code}"/></td></tr>
				<tr>
					
					<td><input class="productzone" id="img" type="image"  disabled="disabled" src="/sinabro${product.mainImg}"/></td>
					<td><input class="productzone" type="text" id="name" readonly="readonly"  value="${product.name}"/></td>
					<td><input class="productzone" type="text" id="sizea" readonly="readonly" name="sizeaa" value="${product.sizea}"/></td>
					<td><input class="productzone" type="text" id="price" readonly="readonly" name="pricea" value="${product.price}"/></td>
					<td><input class="productzone" type="text" id="milage" readonly="readonly" name="milagea" value="${product.price/1000}"/></td>
				</tr>
				</c:forEach>
				</c:when>
				</c:choose>
			</table>
			<hr>
		<b>TOTAL</b>	<input type="number" id="total" name="total" value="${total}" />
			
		
	</div>

	
	<div class="customer">
		<p>Customer Info.</p>
		<hr>
		
			<table id="customer1">
				<tr>
					<th>이름</th>
					<td><input type="text" id="nameal" name="nameal"  readonly="readonly" value="${member.name}"/></td>
				</tr>
				<tr>
					<th>E-mail</th>
					<td><input type="text" id="emailal" name="emailal" readonly="readonly" value="${member.email}"/></td>
				</tr>
				<tr>
					<th>연락처</th>
					<td><input type="text" id="phone" name="phone" readonly="readonly" value="${phone1}"/> - 
					<input type="text" id="phone1" name="phone1" readonly="readonly"  value="${phone2}"/> - 
					<input type="text" id="phone2" name="phone2" readonly="readonly" value="${phone3}"/></td>
				</tr>
			</table>
		
		<hr>
	</div>


	<div class="shipping">
		<span style="font-weight:bold; font-size:24pt">Shipping Info.</span>
		<input type="radio" id="customerInfo" value="same as customer's info" onclick="getInfo()"/>same as customer's info
		 / <input type="radio" id="newCustomerInfo" value="new customer's info" onclick="resetInfo()"/>new customer's info
					<br/><br/><hr>
		
			<table id="shipping1">
				<tr>
					<th>이름</th>
					<td><input id="nameone" type="text" name="nameone" /></td>
				</tr>
				<tr>
				<tr>
					<th>연락처</th>
					<td><select id="phoneone">
							<option value="010">010</option>
							<option value="011">011</option>
							<option value="017">017</option>
							
					</select> - <input id="phonetwo" name="phonetwo" type="text"/> - <input id="phonethree" name="phonethree" type="text"/></td>
				</tr>
				<tr>
					<th>우편번호</th>
					<td><input id="zipcode" type="text" name="zipcode"/>&nbsp;<input
						id="zipBt" type="button" onclick="getPost()" value="우편번호검색" /></td>
				</tr>
				<tr>
					<th>기본주소</th>
					<td><input id="address1" type="text" name="address1"/></td>
				</tr>
				<tr>
					<th>나머지주소</th>
					<td><input id="address2" type="text" name="address2" /></td>
				</tr>
				<tr>
					<th>주문메세지<br>(100자내외)
					</th>
					<td><textarea id="order_message" name="order_message" rows="5" cols="30"></textarea></td>
				</tr>
			</table>
	
		
		<hr>
	</div>



	<div class="milage">
		<p>Milage Use.</p>
		<hr>
		
			<ul id="milage1">
				<li><input id="usemilage" name="usemilage" type="number" value="0"/>원&nbsp;&nbsp;&nbsp;←&nbsp;&nbsp;&nbsp;
				<input id="alreadymilage" type="number" name="alreadymilage" readonly="readonly" value="${member.point}"/>원 (사용가능 적립금)</li>
				
			</ul>
		
		<hr>
	</div>
	<input type="submit" value="전송"/>
</form>
	<div id="payChoose">
	<ul></ul>
	</div>
	<a href="javascript:checkOrder()" class="button">Buy</a>
	<div class="ocBt">
	<center>
	<table id="btTable">
	<tr>
	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="javascript:history.go(-1)" class="button">Cancel.</a></td>
	</tr>
	</table>
	</center>
	</div>
	
</body>
</html>