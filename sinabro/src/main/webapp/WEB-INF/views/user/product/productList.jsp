<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html">
<html>
<head>
<script src="/sinabro/js/jquery-3.2.1.min.js"></script>
<script src="/sinabro/js/user/product/product.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="/WEB-INF/views/user/main.jsp"%>
<style>

ul {margin: 0; padding: 0; list-style: none;color:#353535; }
ul li a{
   margin:0;
   padding:0;
   color:#353535;
}

#leftSec1{
 border-bottom:1px solid black;
}

#wrap{
 border-bottom:1px solid black;
}


.price{
 
 font-family:calibri;
 color:#747474;
 
}

.brand{
 color:#980000;
}

td{
padding:15px;
}
</style>

</head>
<body>

<div id="wrap">
<c:if test="${brand eq null}">
<a href="/sinabro/productList.do"><img id="supreme"
         src="/sinabro/images/mainPic2.png"/></a>

</c:if>
<c:if test="${brand ne null}">
      <a href="/sinabro/productList.do?brand=${brand.brand}"><img id="supreme"
         src="/sinabro${brand.mainimage}" /></a>
</c:if>
      <div id="sec1">
         <br />
         <br />
         <div id="leftSec1">
            <a>Home/${brand.brand}</a>
            <br>
                        
         </div>
         <br>
      </div>
      
   <fieldset class="legend"   >
      

   

       <table id="lista" >
       <colgroup>
       <col width="95" />
       <col width="190" />
       <col width="90" />
       <col />
       </colgroup>
       
      <tbody>
      <tr>               <!-- 브랜드 -->
      <th><div>Brand</div></th>
      <td ><select name="brand" id="brand">
      <option value=""> ----- select a brand  ------</option>
      <c:forEach var="bra" items="${brandAll}">
      <option value="${bra.brand}">${bra.brand}</option>
      </c:forEach>
      </select>
   
      
                        <!-- 카테고리 -->
        <th colspan="2">Category</th>
        <td>
       <select name="category" id="category">
      <option value="">---select a category--</option>
      <option value="top">Top</option>
      <option value="tee" >Tee</option>
      <option value="bottom" >Bottom</option>
      <option value="jacket" >Jacket</option>
      <option value="shoes" >Shoes</option>
      <option value="accessory">Accessory</option>
      <option value="hat">Hat</option>
      </select>
       </td>
       
       
   
  
  
             
       
        <td>
      <input type="button" value="search" onclick="getbrand(brand.options[brand.selectedIndex].value,category.options[category.selectedIndex].value)" class="button"/>
          </td>
       </tr>
       
       
       
     
       
      
       
      

                                        
      </tbody>                                    
      </table>
      </fieldset>

<p style="border-bottom:1px solid black">&nbsp;</p>





   <table style=" border:solid; width:930; text-align:center; border:0; cellpadding:0; cellspacing:0; summary=번호, 사진, 제품명, 수량, 적립금, 가격, 배송비, 취소">
           
 <colgroup>
 <col style="width:20%">
 </colgroup>
    
   
   
   
   
   
   <c:set var="cnt" value="0"/>
   <c:forEach var="vo" items="${list}">
   <c:if test="${cnt%5==0}">
   <tr>
   </c:if>
   <td style="line-padding:20" ><ul><li><input style="width:120px;height:120px;" type="image" src="/sinabro${vo.mainImg}" onclick="javascript:window.location='productContent.do?product_code=${vo.product_code}'"/></li><li><a href="productContent.do?product_code=${vo.product_code}">${vo.name}</a></li><br><li><a class="price" href="productContent.do?product_code=${vo.product_code}">&#8361;${vo.price}</a></li></ul></td>
   <c:set var="cnt" value="${cnt=cnt+1}"/>
   <c:if test="${cnt%5==0}">
   </tr>
   </c:if>
   </c:forEach>
   
   
     
            
    

    </table>
   
 



</fieldset>

<div>
<c:if test="${pre}">
      <a href="productList.do?pageNum=${startPage-pageBlock}&brand=${sessionScope.branda}&category=${sessionScope.categorya}">[Previous]</a>
      </c:if>
      <c:forEach var="counter" begin="${startPage}" end="${endPage}">
      
      
      <a id="pageNum" href="javascript:window.location='productList.do?pageNum=${counter }&brand=${sessionScope.branda}&category=${sessionScope.categorya}'">
      ${counter}</a>
      
      </c:forEach>
      <c:if test="${post}">
      <a href="productList.do?pageNum=${startPage+pageBlock}&brand=${sessionScope.branda}&category=${sessionScope.categorya}">[Next]</a>
      </c:if>

</div>

</div>

</body>
<%@include file="/WEB-INF/views/user/footer.jsp"%>
</html>