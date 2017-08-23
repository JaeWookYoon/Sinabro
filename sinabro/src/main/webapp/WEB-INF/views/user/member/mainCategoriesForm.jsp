<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link rel="stylesheet"
	href="/sinabro/css/user/member/mainCategoriesForm.css" />

		<ul id="categories">
			<li><a href="productList.do?brand=ALL">Brands</a>
				<ul>
					<c:forEach var="brand" items="${brand}">
					<li><a href="productList.do?brand=${brand.brand}">${brand.brand}</a></li>
					</c:forEach>
					<!-- <li><a href="productList.do?brand=champion">Champion</a></li>
					<li><a href="#">Supreme</a></li>
					<li><a href="#">Stussy</a></li>
					<li><a href="#">Obey</a></li>
					<li><a href="#">Palace</a></li>
					<li><a href="#">A.P.C</a></li> -->
					
				</ul></li>
			<!-- <li><a href="productList.do">Categories</a>
				<ul>
					<li><a href="productList.do?category=tee">Tee</a></li>
					<li><a href="productList.do?category=top">Top</a></li>
					<li><a href="productList.do?category=bottom">Bottom</a></li>
					<li><a href="productList.do?category=jacket">Jacket</a></li>
					<li><a href="productList.do?category=shoes">Shoes</a></li>
					<li><a href="productList.do?category=accessory">Accessory</a></li>
					<li><a href="productList.do?category=hat">Hat</a></li>
				</ul></li>-->
			<li><a href="/sinabro/usedlist.do">Shop in Shop</a>
				<ul>
					<li><a href="/sinabro/usedlist.do">Thrift Shop</a></li>
				</ul></li>
			<li><a href="#">Board</a>
				<ul>
					<li><a href="/sinabro/list.do">Free Board</a></li>
					<li><a href="#">Q&A</a></li>
				</ul></li>
			<li><a href="#">News</a>
				<ul>
					<li><a href="#">Notice</a></li>
					<li><a href="#">About</a></li>
				</ul></li>
		</ul>
