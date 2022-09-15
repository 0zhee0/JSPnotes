<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>deleteForm.jsp</h1>
	<%
		// 전달되는 데이터 저장(bno, pageNum)
		int bno = Integer.parseInt(request.getParameter("bno"));
		String pageNum = request.getParameter("pageNum");		
	%>
		
	<fieldset>
		<form action="deletePro.jsp?pageNum=<%=pageNum %>" method="post">
			<input type="hidden" name="bno" value="<%=bno %>">
			비밀번호 : <input type="password" name="pass"> <br>
			<input type="submit" value="삭제하기">
		</form>
	</fieldset>

</body>
</html>