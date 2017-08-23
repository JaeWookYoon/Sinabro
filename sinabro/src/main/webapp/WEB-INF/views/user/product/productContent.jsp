<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="/sinabro/js/jquery-3.2.1.min.js"></script>
<script src="/sinabro/js/user/cart/cart.js"></script>
<script type="text/javascript"
   src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script src="/sinabro/js/user/product/productSlide.js"></script>
<script src="/sinabro/js/user/product/productSlide.min.js"></script>
<link rel="stylesheet" href="/sinabro/css/user/product/productContent.css" />


<script>
   $(document).ready(function() {
      var slider = $('.bxslider').bxSlider({
         auto : false,
         mode : 'fade',
      });
      // 클릭시 멈춤 현상 해결 //
      $(document).on('click', '.bx-next, .bx-prev', function() {
         slider.stopAuto();
         slider.startAuto();
         slider_01.stopAuto();
         slider_01.startAuto();
      });
      $(document).on('mouseover', '.bx-pager, #bx-pager1', function() {
         slider.stopAuto();
         slider.startAuto();
         slider_01.stopAuto();
         slider_01.startAuto();
         slider_02.stopAuto();
         slider_02.startAuto();
      });
   });
   function openCity(cityName, elmnt, color) {
       // Hide all elements with class="tabcontent" by default */
       var i,  tabcontent, tablinks;
       tabcontent =  document.getElementsByClassName("tabcontent");
       for (i =  0; i < tabcontent.length; i++) {
            tabcontent[i].style.display = "none";
       }
    
       // Remove the background color of all tablinks/buttons
        tablinks = document.getElementsByClassName("tablink");
        for (i = 0; i < tablinks.length; i++) {
            tablinks[i].style.backgroundColor = "";
       }
    
       // Show the specific tab content
        document.getElementById(cityName).style.display = "block";

        // Add the specific color to the button used to open the tab content
        elmnt.style.backgroundColor = color;
   }
   // Get the element with id="defaultOpen" and click on it
   $(document).ready(function() {
      document.getElementById("defaultOpen").click();   
   });
</script>
<%@include file="/WEB-INF/views/user/main.jsp"%>
</head>


<body>
      <center>
<c:choose>
<c:when test="${error }">
<script>
alert("실패했습니다.");
</script>
</c:when>
<c:when test="${sucess }">



<script>
alert("성공!했당!.");
</script>

<a href="#"><img id="supreme"
         src="/sinabro${brand.mainimage}" /></a>

      <div id="sec1">
         <br />
         <br />
         <div id="leftSec1">
            <a>Home/${brand.brand}</a>
         </div>


</c:when>
</c:choose>

      <div id="s_banner_wrap">
         <ul class="bxslider">
<c:forEach var="img" items="${img}">
            <li class="banner_01"><img src="/sinabro${img}" alt="광고슬라이드" width="900px" height="500px" align="center"></li>

</c:forEach>
</ul>
</div>
         
<table >
<tr>
<td>
<c:set var="br" value="${brand}"/>
<p> ${br.description}</p>
</td>


<td>
<div id="right">
<form name="orderForm" method="post" action="orderForm.do"> 
<table style="margin-left:30%;">
<tr>
<td width="30"></td>
<td height="277" align="right" valign="top">


 <div id="name">${vo.name}</div>
 
 <div style="width:277px; font-size:8pt; color:#666; text-align:right;  height:38px; border-bottom:1px solid black; padding-bottom:10px; margin-bottom:20px; position:relative;">
 <div style="position:absolute; top:0; left:15px; text-align:right; font-size:9pt; font-family:Arial, Helvetica, sans-serif;">${vo.brand}</div>
 <div id="price">￦   ${price}<br>
 <font style="font-size:8pt; color:#000;"> MILAGE / ${milage/1000} won
 </font></div></div>

                                      
 <div style="width:277px; border-bottom:1px solid black; padding-bottom:17px; position:relative; text-align:left;">
  
<label style="margin-left:10px;"> size  </label>
<select id="sizea" name="sizea" class="basic_option" style="margin-left:35%">
<option>----SELECT A OPTION----</option>
<c:forEach var="size" items="${size}" >

<option value="${size}">${size}</option>
</c:forEach>
</select>
  
</div>
                                           
                         
                                                                                     
                                                                                                                               
                                                     
<div style="width:277px; text-align:left; font-family:calribri; font-size:14pt ;padding-top:10px; border-bottom:1px solid black; padding-bottom:10px;">   TOTAL PRICE : 
<strong>${price}</strong>
</div>
                                                                                                                    
       <div id="cart"> 
                                                            
<a href="javascript:document.orderForm.submit()" class="button">바로구매 |</a>
<a href="javascript:cartInsert()" class="button">장바구니담기</a>

</div>
</table>
<input type="hidden" id="product_code" name="product_code" value="${vo.product_code}"/>
</form>


</div>
   
</td>
</tr>
</table>
      


</center>





</body>
<%@include file="/WEB-INF/views/user/footer.jsp"%>
</html>

