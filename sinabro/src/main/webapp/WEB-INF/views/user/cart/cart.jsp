<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<body>




<div id="wrapper">

<div id="cart">

   <table width="900" border="0" cellpadding="1" cellspacing="0" summary="번호, 사진, 제품명, 수량, 적립금, 가격, 배송비, 취소">
           
             
   <thead>
         <tr style="background-color:#CCC; font-family:Tahoma, Geneva, sans-serif; font-size:7pt; color:#666; ">
         <th height="20" width="30">NO.</th>
         <th width="60">PIC</th>
         <th width="220">NAME</th>
         <th width="60">QUANTITY</th>
         <th width="60">MILAGE</th>
         <th width="60">PRICE</th>
         <th width="60">SHIPPING</th>
         <th width="60">CANCLE</th>
   		 </tr>
    </thead>
    
     <tbody>
    <tr>
    <td colspan="8" align="center" >
    <div class="tb-center p10" style="font-family: 'NanumGothicWeb'; ">현재비어있땅</div>
    </td>
    </tr>
    <tr><td height="10"></td></tr>
     </tbody>

    </table>
   </div> <!--wrapper -->
    
     <div id="cartfoot">
     <a href="#">ORDER NOW</a> | 

     <a href="/sinabro/hi.do" >KEEP SHOPPING</a> | 
     <a href="#">CLEAR BASKET</a>
   
  <div id="cartfootinner"></div>
                  
                        </div> <!-- cartfoot -->

    </div>

               

</body>
</html>