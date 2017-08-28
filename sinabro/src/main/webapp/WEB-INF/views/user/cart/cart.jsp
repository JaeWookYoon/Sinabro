<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<%@include file="/WEB-INF/views/user/main.jsp"%>
<link rel="stylesheet" href="/sinabro/css/user/cart/cart.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/sinabro/js/jquery-3.2.1.min.js"></script>
<script src="/sinabro/js/user/member/cart.js"></script>
<title>Insert title here</title>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%@include file="/WEB-INF/views/user/userpage/myPageTab.jsp"%>
<body>
<c:if test="${nop}">
<script>
alert("보유 카트가 없어요.");
</script>
</c:if>






<div id="wrappercart">
<div id="cart">
<form name="cartForm" method="post" action="orderForm.do">
   <table style="text-align: center;"width="80%" border="0" cellpadding="1" cellspacing="0" summary="번호, 사진, 제품명, 수량, 적립금, 가격, 배송비, 취소">
           
             
   <thead>
         <tr style="background-color:#CCC; font-family:Tahoma, Geneva, sans-serif; font-size:7pt; color:#666; ">
         <th height="20" width="30">NO.</th>
         <th width="100">PIC</th>
         <th width="300">NAME</th>
         <th width="100">SIZE</th>
         <th width="100">MILAGE</th>
         <th width="100">PRICE</th>
         
         <th width="100">CANCLE</th>
   		 </tr>
    </thead>
    
     <tbody>
     
     <c:set var="count" value="${count}"/>
    <c:forEach var="product" items="${cart}">
    <tr>
    <td><input type="hidden" name="product_codea" id="product_codea" value="${product.product_code}"/></td>
    </tr>
    <tr>
    <td>${count=count-1}</td><td><a href="/sinabro/productContent.do?product_code=${product.product_code}"><img src="/sinabro${product.mainImg}" style="width:60px;height:60px;" /></a></td><td><a href="/sinabro/productContent.do?product_code=${product.product_code}">${product.name}</a></td><td><input type="text" readonly="readonly" style="border:none;" name="sizeaa" id="sizeaa" value="${product.sizea}" /></td><td>${product.price/1000}</td><td>${product.price}</td><td><a href="deleteCart.do?product_code=${product.product_code}">Cancel</a></td>
    </tr>
    </c:forEach>
    <tr><td height="10"></td></tr>
     </tbody>

    </table>
</form>
   </div> <!--wrapper -->
    
     <div id="cartfoot">
     <a href="javascript:document.cartForm.submit()">ORDER NOW(All Buy)</a> | 

     <a href="/sinabro/hi.do" >KEEP SHOPPING</a> | 
     <a href="#">CLEAR BASKET</a>
   
  <div id="cartfootinner"></div>
                  
                        </div> <!-- cartfoot -->
    </div>

               

</body>
<%@include file="/WEB-INF/views/user/footer.jsp"%>
</html>