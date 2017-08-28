<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html">
<html>
<head>
<script src="/sinabro/js/jquery-3.2.1.min.js"></script>
<script src="/sinabro/js/admin/product/product.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="/WEB-INF/views/admin/main.jsp"%>
<style>
body{

margin-left:10%;
margin-right:10%;
}
ul {margin: 0; padding: 0; list-style: none;color:#353535; }
ul li{
	font-family:calribri;
	color:#353535;
}
</style>

</head>
<body>

<div id="wrap">
<c:choose>
<c:when test="${brand eq null}">
		<a href="#"><img id="supreme"
			src="/sinabro/images/logo.PNG" /></a>

		<div id="sec1">
			<br />
			<br />
			<div id="leftSec1">
				<a>Home</a>
				<br><br>
			</div>
			
		</div>
		</c:when>
		<c:otherwise>
<a href="#"><img id="supreme"
			src="/sinabro${brand.mainimage}" /></a>

		<div id="sec1">
			<br />
			<br />
			<div id="leftSec1">
				<a>${brand.brand}</a>
				<br><br>
			</div>
			
		</div>
		
		</c:otherwise>
</c:choose>
	<fieldset class="legend" style="margin-bottom:10%;" >
      
       
       
       <table id="lista">
       <colgroup>
       <col width="95" />
       <col width="190" />
       <col width="90" />
       <col />
       </colgroup>
       
      <tbody>
      <tr>					<!-- 브랜드 -->
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







   <table style=" border:solid; width:930; text-align:center; border:0; cellpadding:0; cellspacing:0; summary=번호, 사진, 제품명, 수량, 적립금, 가격, 배송비, 취소">
           
 
    
	
	
	
	
	
	<c:set var="cnt" value="0"/>
	<c:forEach var="vo" items="${list}">
	<c:if test="${cnt%5==0}">
	<tr>
	</c:if>
	<td><ul><li><input style="width:120px;height:120px;" type="image" src="/sinabro${vo.mainImg}" onclick="javascript:window.location='productContent.mustang?product_code=${vo.product_code}'"/></li><li><a href="productContent.mustang?product_code=${vo.product_code}">${vo.name}</a></li><li><a href="productContent.mustang?product_code=${vo.product_code}">&#8361;${vo.price}</a></li></ul></td>
	<c:set var="cnt" value="${cnt=cnt+1}"/>
	<c:if test="${cnt%5==0}">
	</tr>
	</c:if>
	</c:forEach>
	
	
     
            
    

    </table>
	
 



</fieldset>
<div>
<c:if test="${pre}">
		<a href="productList.mustang?pageNum=${startPage-pageBlock}&brand=${sessionScope.branda}&category=${sessionScope.categorya}">[Previous]</a>
		</c:if>
		<c:forEach var="counter" begin="${startPage}" end="${endPage}">
		
		<a href="javascript:window.location='productList.mustang?pageNum=${counter}&brand=${sessionScope.branda}&category=${sessionScope.categorya}'">
		${counter}</a>
		
		
		</c:forEach>
		<c:if test="${post}">
		<a href="productList.mustang?pageNum=${startPage+pageBlock}&brand=${sessionScope.branda}&category=${sessionScope.categorya}">[Next]</a>
		</c:if>

</div>
</div>

</body>

</html>