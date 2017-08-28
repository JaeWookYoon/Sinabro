<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="/sinabro/js/jquery-3.2.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/sinabro/css/user/main/mainContent.css" />



</head>

<body>
<%@include file="/WEB-INF/views/user/main.jsp"%>
<%@include file="/WEB-INF/views/user/member/mainCategoriesForm.jsp"%>
<%@include file="/WEB-INF/views/user/slide.jsp"%>


   
   






<div id="mainWrapper">
<div id="mainList">


<table>

<c:set var="cnt" value="0"/>
   <c:forEach var="vo" items="${list}">
   <c:if test="${cnt%5==0}">
   <tr>
   </c:if>
   <td style="line-padding:20" ><ul><li><input  style=" width:120px;height:120px;" type="image" src="/sinabro${vo.mainImg}" onclick="javascript:window.location='productContent.do?product_code=${vo.product_code}'"/></li><li><a href="productContent.do?product_code=${vo.product_code}">${vo.name}</a></li><li><a class="price" href="productContent.do?product_code=${vo.product_code}">&#8361;${vo.price}</a></li></ul></td>
   <c:set var="cnt" value="${cnt=cnt+1}"/>
   <c:if test="${cnt%5==0}">
   </tr>
   </c:if>
   </c:forEach>
</table>

<div style="text-align:center;color:black;">
<c:if test="${pre}">
      <a href="hi.do?pageNum=${startPage-pageBlock}">[Previous]</a>
      </c:if>
      <c:forEach var="counter" begin="${startPage}" end="${endPage}">
      
      
      <a id="pageNum" href="javascript:window.location='hi.do?pageNum=${counter }'">
      ${counter}</a>
      
      </c:forEach>
      <c:if test="${post}">
      <a href="hi.do?pageNum=${startPage+pageBlock}">[Next]</a>
      </c:if>

</div>
</div>
</div>
<%@include file="/WEB-INF/views/user/footer.jsp"%>

</body>
</html>