<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div id="top">
<div id="top_1">
<ul id="topmenu1">
<li><a href="#"/>Notice</li>
<li><a href="#"/>Q&A</li>
<li><a href="#"/>Event</li>
<li><a href="#"/>Review</li>
<li><a href="#"/>MyShop</li>
</ul>

</div>
<div id="top_2">
<c:if test="${session.loginID eq null}">
<ul id="topmenu2">
<li><a href="#"/>Login</li>
<li><a href="#"/>Join</li>
<li><a href="#"/>Contact</li>

</ul>
</c:if>
<c:if test="${session.loginID ne null}">
<ul id="topmenu2">
<li><a href="#">${session.loginID}</a></li>
<li>${session.point}</li>
<li><a href="#"/>Contact</li>

</ul>
</c:if>
</div>


</div><br/>
<div id="ourname">
<a href="/sinabro/hi.mdo">SinaBro</a><br/>
<label>Will steal ur wallet, hommy</label>
</div>

<div id="header">
<ul id="headmenu">
<li><a href="#"/>Home</li>
<li><a href="#"/>New Arrive</li>
<li><a href="#"/>On Sale</li>
<li><a href="#">Clothes</a>
	
</li>
<li><a href="#"/>Accessory</li>
<li><a href="#"/>Shoes</li>
</ul>
</div>
