<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html">
<link rel="stylesheet" href="/sinabro/css/user/main.css" />
<script src="/sinabro/js/user/main.js"></script>
<script src="/sinabro/js/user/footer.js"></script>
<script src="/sinabro/js/jquery-3.2.1.min.js"></script>

<script>
window.onload=function(){
	checkStatus();
}
	
</script>


<div id="wrappermain">
	<div id="headerLogo">
		<a href="/sinabro/hi.do">SinaBro</a><br /> <label>Will steal
			ur wallet, hommy</label>
	</div>

	<div id="topMenuwrap">
		<c:if test="${sessionScope.loginId eq null}">

			<ul id="topMenu">
				<li><a href="/sinabro/loginForm.do"> LOGIN</a></li>
				<li><a href="/sinabro/policy.do"> JOIN</a></li>
			</ul>
			

		</c:if>
		<c:if test="${sessionScope.loginId ne null}">




			<ul id="topMenu">
				<li><a href="#">${sessionScope.loginName}</a></li>
				<li>Point : ${sessionScope.point}</li>

				<li><a href="/sinabro/Mycart.do">CART</a></li>
				<li><a href="/sinabro/Mypage.do">MY PAGE</a></li>
				<li><a href="/sinabro/logout.do">LOG OUT</a></li>
			</ul>

		</c:if>
	</div>
</div>
				
				
				

				

