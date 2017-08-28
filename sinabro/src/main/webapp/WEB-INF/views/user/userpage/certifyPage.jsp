<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="/WEB-INF/views/user/main.jsp"%>
<script src="/sinabro/js/jquery-3.2.1.min.js"></script>
<script src="/sinabro/js/user/userpage/certify.js"></script>
<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.4.js"></script>
</head>
<c:if test="${fail}">
<script>
alert("잘못 된 회원정보입니다.");
</script>
</c:if>

<body>
<script>
window.onload=function(){
	setTimeout("nowTime()",1000);
}
</script>
<div>
<%@include file="/WEB-INF/views/user/userpage/myPageTab.jsp"%>
</div>


<select name="bank" id="bank">
<option value="002">산업은행</option>
<option value="003">기업은행</option>
<option value="020">우리은행</option>
<option value="081">하나은행</option>
<option value="004">국민은행</option>
<option value="001">농협</option>
<option value="071">우체국</option>
<option value="088">신한은행</option>
<option value="005">외환은행</option>
<option value="007">수협</option>
<option value="023">SC제일</option>
<option value="054">HSBC</option>
<option value="027">시티은행</option>
<option value="048">신용협동조합</option>
<option value="050">상호저축은행</option>
<option value="032">부산은행</option>
<option value="045">새마을금고</option>
<option value="031">대구은행</option>
<option value="034">광주은행</option>
<option value="055">도이치은행</option>
<option value="039">경남은행</option>
<option value="037">전북은행</option>
<option value="035">제주은행</option>
<option></option>

</select>
<input type="hidden" name="logid" id="logid" value="${sessionScope.loginName}"/>
<input type="hidden" name="time" id="time"/>
<input type="text" name="bank1" id="bank1" placeholder="-없이 입력"/>
<input type="text" name="jumin" id="jumin"placeholder="주민 6자리+성별코드1자리"/>
<input type="button" onclick="getCertify()" value="인증하기"/>

</body>
<%@include file="/WEB-INF/views/user/footer.jsp"%>
</html>