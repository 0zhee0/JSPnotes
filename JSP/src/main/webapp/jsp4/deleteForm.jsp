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
	
	<!-- 	사용자 이름, 주민번호 입력 -->
	
	<form action="deletePro.jsp" method="post">
		이름 : <input type="text" name="name"><br>
		주민번호 : <input type="text" name="jumin"><br>
		
		<input type="submit" value="탈퇴하기">	
	</form>

</body>
</html>