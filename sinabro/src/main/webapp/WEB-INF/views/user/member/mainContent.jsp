<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<!-- CSS file -->
<link rel="stylesheet" href="/sinabro/css/user/main/mainContent.css" />
<body>
<%@include file="/WEB-INF/views/user/main.jsp"%>
<%@include file="/WEB-INF/views/user/member/mainCategoriesForm.jsp"%>
<div class="sp-slideshow">
	<input id="button-1" type="radio" name="radio-set" class="sp-selector-1" checked="checked" />			
	<label for="button-1" class="button-label-1"></label>
	
	<input id="button-2" type="radio" name="radio-set" class="sp-selector-2" />
	<label for="button-2" class="button-label-2"></label>
	
	<input id="button-3" type="radio" name="radio-set" class="sp-selector-3" />
	<label for="button-3" class="button-label-3"></label>
	
	<input id="button-4" type="radio" name="radio-set" class="sp-selector-4" />
	<label for="button-4" class="button-label-4"></label>
	
	<label for="button-1" class="sp-arrow sp-a1"></label>
	<label for="button-2" class="sp-arrow sp-a2"></label>
	<label for="button-3" class="sp-arrow sp-a3"></label>
	<label for="button-4" class="sp-arrow sp-a4"></label>
	
	<div class="sp-content">
		<div class="sp-parallax-bg"></div>
		<ul class="sp-slider clearfix">
			<li><img src="/sinabro/images/mainPic1.png" alt="image01" /></li>
			<li><img src="/sinabro/images/mainPic2.png" alt="image02" /></li>
			<li><img src="/sinabro/images/mainPic3.png" alt="image03" /></li>
			<li><img src="/sinabro/images/mainPic4.png" alt="image04" /></li>
		</ul>
	</div><!-- sp-content -->
</div><!-- sp-slideshow -->



<!-- 메인 상품리스트 -->
<div id="tableName">
<br/>
<div id="leftTableName"><a href="#"></a>LATEST</div>
<div id="rightTableName"><a href="#"></a>BEST</div>
<br/><br/>
</div>
<div id="productsList">
<hr>
<div id="table">
<table id="mainProductsList" >
<tr>
<td><a href="#"><img id="mainProducts" src="/sinabro/images/1.jpg"></a></td>
<td><a href="#"><img id="mainProducts" src="/sinabro/images/2.jpg"></a></td>
<td><a href="#"><img id="mainProducts" src="/sinabro/images/3.jpg"></a></td>
<td><a href="#"><img id="mainProducts" src="/sinabro/images/4.jpg"></a></td>
<td><a href="#"><img id="mainProducts" src="/sinabro/images/5.jpg"></a></td>
</tr>
<tr>
<td><a href="#"><img id="mainProducts" src="/sinabro/images/6.jpg"></a></td>
<td><a href="#"><img id="mainProducts" src="/sinabro/images/7.jpg"></a></td>
<td><a href="#"><img id="mainProducts" src="/sinabro/images/8.jpg"></a></td>
<td><a href="#"><img id="mainProducts" src="/sinabro/images/9.jpg"></a></td>
<td><a href="#"><img id="mainProducts" src="/sinabro/images/10.jpg"></a></td>
</tr>
<tr>
<td><a href="#"><img id="mainProducts" src="/sinabro/images/11.jpg"></a></td>
<td><a href="#"><img id="mainProducts" src="/sinabro/images/12.jpg"></a></td>
<td><a href="#"><img id="mainProducts" src="/sinabro/images/13.jpg"></a></td>
<td><a href="#"><img id="mainProducts" src="/sinabro/images/14.jpg"></a></td>
<td><a href="#"><img id="mainProducts" src="/sinabro/images/15.jpg"></a></td>
</tr>
<tr>
<td><a href="#"><img id="mainProducts" src="/sinabro/images/16.jpg"></a></td>
<td><a href="#"><img id="mainProducts" src="/sinabro/images/17.jpg"></a></td>
<td><a href="#"><img id="mainProducts" src="/sinabro/images/18.jpg"></a></td>
<td><a href="#"><img id="mainProducts" src="/sinabro/images/19.jpg"></a></td>
<td><a href="#"><img id="mainProducts" src="/sinabro/images/20.jpg"></a></td>
</tr>
</table>
</div>
<hr/>
</div>


<%@include file="/WEB-INF/views/user/footer.jsp"%>

</body>
</html>