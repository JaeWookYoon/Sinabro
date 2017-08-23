<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/sinabro/css/admin/product/productAddForm.css"/>
<script src="/sinabro/js/jquery-3.2.1.min.js"></script>
<script src="/sinabro/js/admin/product/productAddForm.js"></script>
<%@include file="/WEB-INF/views/admin/main.jsp"%>
</head>

<body>

<br><br>
<form name="productAddForm" method="post" action="addProduct.mustang" enctype="multipart/form-data" onsubmit="return checkList()">

	<fieldset class="legend">
       <legend>Admin Page</legend>
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
      <td ><select name="brand" id="brand" >
		<option> ----- select a brand  ------</option>
		<c:forEach var="vo" items="${list}">
		<option value="${vo.brand}">${vo.brand}</option>
		</c:forEach>
		</select>
		
		
		
        <th colspan="2">Category</th>
        <td>
       <select name="category" id="category">
		<option>---select a category--</option>
		<option value="top">Top</option>
		<option value="tee">Tee</option>
		<option value="bottom">Bottom</option>
		<option value="jacket">Jacket</option>
		<option value="shoes">Shoes</option>
		<option value="accessory">Accessory</option>
		<option value="hat">Hat</option>
		</select>
       </td>
       </tr>
   
   	<!-- 사이즈 -->
 <tr>					
      <th ><div>size</div></th>
      <td colspan="2">
      <ul id="sizeList">
      <li><select name="sizeaa" id="sizea" style="height:23px;">
		<option> ------ select a Size  -------</option>
		<option value="S">Small</option>
		<option value="M">Medium</option>
		<option value="L">Large</option>
		<option value="XL">X-Large</option>
		<option value="Free">Free</option>
		</select></li>
<li>
		
  <a href="javascript:plusSize()" class="addbutton">add</a>
  </li>
</ul></td>
   
 
 </tr> 
   
   
       <tr>					<!-- 상품명 -->
       <th><div>Name</div></th>
       <td>
       <div>
       <input id='productName' type='text' name='name'/></div>
       </td>
        </tr>
       
             
       					
       
       
      
       	
       
       
       
       
       <tr>						<!-- 상품이미지파일 첨부 -->
       <th>Image</th>
       <td colspan="4">
      <ul id="fileList">
        <li>
       <input id='file' type='file' class='image' name='imgFile' value='search' onfocus='' accept="image/jpg,img/gif,image/png" required="required"/> 
        <a href="javascript:plusfile()" class="button">add</a>
        </li>
        </ul>                                                                                 
        </td>
        </tr>
       
       <tr>
        <th><div>Quantity</div></th>
       <td>
       <ul id="quanList">
       <li><input id="unit" type="number"  min="0"  step="1" name="quantitya" onkeypress="controlNum(event)" required="required"/>
       </li>
       </ul>
       </td>
       </tr>
       
        <tr>
        <th><div>Price</div></th>
       <td colspan="2">
      
       <input id='price' type='number' min="0" name='price' onkeypress="controlNum(event)"/>
       <label style=" font-size:14pt">won</label>
       </td>
       </tr>
       
       <tr>					<!-- 상품명 -->
       <th><div>Option</div></th>
       <td>
       <div>
       <input id='option' type='text' name='optiona'/></div>
       </td>
        </tr>
       
       
       
       
                                        
      </tbody>                                    
      </table>
      
      </fieldset>



<fieldset>
<legend class="legend">Product</legend>


   <table style="border:solid; text-align:center; border:0; cellpadding:0; cellspacing:0; summary=번호, 사진, 제품명, 수량, 적립금, 가격, 배송비, 취소">          
     <tbody >
    <tr>
    <td colspan="8" align="center" >
    <div class="tb-center p10"></div>
    </td>
    </tr>
    
    <tr><td height="10"></td></tr>
     </tbody>

     
            
    

    </table>
	
<div id=bottombt>	
  <a href="javascript:document.productAddForm.submit()" class="button">submit</a>
 <a href="#" class="button">cancle</a>

</div>
 



</fieldset>
</form>
</body>
</html>