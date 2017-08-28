<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="/sinabro/css/user/userpage/myPageTab.css" />


<style>
body{
margin-left:auto;
margin-right:auto;
}
</style>


<body>
<c:if test="${loginError}">
<script>
alert("로그인이 필요한 서비스입니다.");
window.location="/sinabro/hi.do";
</script>
</c:if>


<!-- Sidebar -->
<div class="w3-sidebar w3-bar-block w3-border-right" style="display:none" id="mySidebar">
  <button onclick="w3_close()" class="w3-bar-item w3-large">Close &times;</button>
  <a href="/sinabro/updateCheck.do" class="w3-bar-item w3-button">┗ 내 정보</a>
  <a href="/sinabro/Mycart.do" class="w3-bar-item w3-button">┗ 장바구니</a>
  <a href="/sinabro/getMyboard.do" class="w3-bar-item w3-button">┗ 작성글</a>
  <a href="/sinabro/MyShopping.do" class="w3-bar-item w3-button">┗ 구매상품</a>
  <a href="/sinabro/certifyPage.do" class="w3-bar-item w3-button">┗ 판매권한요청</a>
</div>

<!-- Page Content -->
<div class="w3-teal">
  <button class="w3-button w3-teal w3-xlarge" onclick="w3_open()">☰</button>
  <div class="w3-container">
    <h1>My Page</h1>
  </div>
</div>



<script>
function w3_open() {
    document.getElementById("mySidebar").style.display = "block";
}
function w3_close() {
    document.getElementById("mySidebar").style.display = "none";
}
</script>
     
</body>
</html> 












</body>
</html>