<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="/sinabro/css/user/member/idPwSearch.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/sinabro/js/jquery-3.2.1.min.js"></script>
<script src="/sinabro/js/user/member/idcheck.js"></script>
<%@include file="/WEB-INF/views/user/main.jsp"%>
</head>
<body>
<c:if test="${fail ne null }">
<script>
alert("입력정보와 가입정보가 일치하지 않습니다.");
</script>
</c:if>
   <div id="wrap">
      <form id="form1" method="post" action="findId.do" onsubmit="return findId()">
         <p id="p1">아이디 찾기</p>
         <hr>
         <p>회원가입 시, 입력하신 이름 + 이메일로 아이디를 확인하실 수 있습니다.</p>
         <div id="idTotalForm">
            <table id="idForm">
               <tr>
                  <th>이&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;름</th>
                  <td><input type="text" name="name" id="name" /></td>
               </tr>
               <tr>
                  <th>이메일</th>
                  <td><input id="mailone" type="text" name="emailone" /></td>
               </tr>

            </table>
            <div id="idBtForm">
               <table id="idBt">
                  <tr>
                     <td><input id="bt1" type="submit" value="아이디 찾기"/></td>
                     <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                     <td><input id="bt" type="button" value="로그인" onclick="javascript:window.location='/sinabro/loginForm.do'"></td>

                  </tr>
               </table>
            </div>
         </div>
         <hr>
      </form>
         <p id="p2">임시 비밀번호 발급</p>
         <hr>
         <p>가입하신 아이디 + 이메일을 입력, 본인인증을 통해 이메일로 임시 비밀번호를 보내드립니다. 확인 후 로그인하셔서
            반드시 비밀번호를 변경하시기 바랍니다.</p>
      <form name="form2" method="post" action="findPw.do" onsubmit="return findPw()">
         <div id="pwTotalForm">
            <table id="pwForm">
               <tr>
                  <th>아이디</th>
                  <td><input type="text" name="id" id="id" /></td>
               </tr>
               <tr>
                  <th>이메일</th>
                  <td><input  id="mailtwo" type="text" name="emailtwo"/></td>
               </tr>
                  <tr>
                     <td><input id="bt2" type="submit" value="임시 비밀번호 발급"></td>
                     <td><input id="bt" type="button" value="로그인" onclick="javascript:window.location='/sinabro/loginForm.do'"/></td>
                  </tr>
            </table>
         </div>
      </form>
         <hr>
   </div>
</body>
</html>
            
            
            