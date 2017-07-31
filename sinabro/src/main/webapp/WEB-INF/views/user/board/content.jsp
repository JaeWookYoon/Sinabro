<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 
코멘트 생기면 추가할 부분
<script type="text/javascript" src="/sinabro/js/user/comment/"></script>
<script type="text/javascript" src="/sinabro/js/user/comment/"></script>
<script type="text/javascript">
	window.onload = function() {
		loadCommentList(document.writeForm.num.value);	}
	function makeCommentView(){}
</script>
 -->

</head>
<body>
	<div align="center" class="body">
		<form  name="writeForm">
			<input type="hidden" name="num" value="${vo.num }" />
		</form>
		<center>
			<h3>글보기</h3>
			<table width="600" border="1">
				<tr>
					<td align="center" width="100">번호</td>
					<td align="left" width="200">${vo.num}</td>
					<td align="center" width="100">작성일</td>
					<td align="left" width="200">${vo.regdate}</td>
				</tr>
				<tr>
					<td align="center">작성자</td>
					<td align="left">${vo.writer}</td>
					<td align="center">조회수</td>
					<td align="left">${vo.readcount}</td>
				</tr>
				<tr>
					<td align="center">이메일</td>
					<td colspan="7" align="left">${vo.email}</td>
				</tr>
				<tr>
					<td align="center">제목</td>
					<td colspan="7" align="left">${vo.subject}</td>
				</tr>
				<tr>
					<td align="center">내용</td>
					<td colspan="7" align="left" height="100"><pre>${vo.content}</pre></td>
				</tr>
			</table>
			<br /> <input type="button" value="글수정"
				onclick="window.location='updateForm.do?num=${vo.num}'" /> <input
				type="button" value="글삭제"
				onclick="window.location='deleteForm.do?num=${vo.num}'" /> <input
				type="button" value="목록보기" onclick="window.location='list.do'" />
		</center>
	</div>
	<!-- 댓글 입력 폼 -->
	<!-- 코멘트 입력하면 주석해제 
	<div id="commentList" align="center" class="body"></div>
	<div id="commentAdd" align="center">
	
	<form action="" name="addForm" method="post">
		<input type="hidden" name="num" value="${vo.num }"/>
		이름 : <input type="text" name="name" size="10"/>
		내용 : <textarea name="content" rows="2" cols="20"></textarea>
		<input type="button" value="등록" onclick="addComment()" />
	</form>
	</div>
	<div id="commentUpdate" style="display: none">
	<form action="" name="updateForm">
		<input type="hidden" name="id" value="" />
		<input type="hidden" name="regdate" value=""/>
		이름 : <input type="text" name="name" size="10"/><br/>
		내용 : <textarea name="content" rows="2" cols="20"></textarea><br/>
		<input type="button" value="등록" onclick="updateComment()" />
		<input type="button" value="취소" onclick="cancleUpdate()" />
	</form>
	</div>
	-->
</body>
</html>