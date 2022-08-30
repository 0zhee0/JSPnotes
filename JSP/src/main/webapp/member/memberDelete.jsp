<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>memberDelete.jsp</h1>
	
	<h2>회원정보 삭제</h2>
	
	<%
		// 로그인제어
		String id = (String) session.getAttribute("id");
		if(id == null){
			response.sendRedirect("loginForm.jsp");
		}		
	%>
	
	<fieldset>
		<form action="memberDeletePro.jsp" method="post">
			비밀번호 : <input type="password" name="pw">
			<input type="submit" value="탈퇴하기">
		</form>	
	</fieldset>

</body>
</html>