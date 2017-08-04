<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" href="/sinabro/css/main.css" />

<div id="wrappermain">
	<div id="headerLogo">
		<a href="#">SinaBro</a><br /> <label>Will steal
			ur wallet, hommy</label>
	</div>

	<div id="topMenuwrap">
		<c:if test="${sessionScope.loginId eq null}">

			<ul id="topMenu">
				<li><a href="#"> LOGIN</a></li>
				<li><a href="#"> JOIN</a></li>
			</ul>
			

		</c:if>
		<c:if test="${sessionScope.loginId ne null}">




			<ul id="topMenu">
				<li><a href="#">${sessionScope.loginName}</a></li>
				

				<li><a href="#">CART</a></li>
				<li><a href="#">MY PAGE</a></li>
				<li><a href="#">LOG OUT</a></li>
			</ul>

		</c:if>
	</div>
</div>
				
				
				

				

