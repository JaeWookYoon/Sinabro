<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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


       <fieldset>
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
		<option value="supreme">Supreme</option>
		<option value="palace">Palace</option>
		<option value="obey">Obey</option>
		<option value="stussy">Stussy</option>
		<option value="a.p.c">A.P.C</option>
		<option value="neighborhood">Neighborhood</option>
		<option value="champion">Champion</option>
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



<fieldset style="margin-top:20px">
<legend>Product</legend>


   <table style="border:solid; text-align:center; border:0; cellpadding:0; cellspacing:0; summary=번호, 사진, 제품명, 수량, 적립금, 가격, 배송비, 취소">
           
             
   <thead>
         <tr style="background-color:#CCC; font-family:Tahoma, Geneva, sans-serif; font-size:10pt; color:#666; ">
         <th width="100">Brand</th>
         <th width="220">Name</th>
         <th width="220">Name</th>
         <th width="60">Category</th>
         <th width="60">Size</th>
         <th width="60">Quantity</th>
         <th width="60">Price</th>
         <th width="60">Option</th>
   		 </tr>
    </thead>
    
     <tbody>
    <tr>
    <td colspan="8" align="center" >
    <div class="tb-center p10" style="font-family: 'NanumGothicWeb'; "></div>
    </td>
    </tr>
    <tr><td height="10"></td></tr>
     </tbody>

     
            
    

    </table>
	
<div id=bottombt>	
   <input type="submit" class='button'value="submit"/>
  <input type="reset" class='button' value="cancel"> 
</div>
 



</fieldset>
</form>
</center>
</body>
</html>