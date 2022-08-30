<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ITWILL 회원가입 페이지</h1>
	
	<fieldset>
		<form action="insertPro.jsp" method="post">
		아이디 : <input type="text" name="id" value="" placeholder="아이디를 입력하세요."><br>
		비밀번호 : <input type="password" name="pw"><br> 
		이름 : <input type="text" name="name"><br> 
		나이 : <input type="text" name="age"><br> 
		성별 : <input type="radio" name="gender" value="남">남
			   <input type="radio" name="gender" value="여">여<br>
		이메일 : <input type="text" name="email"><br>
		
		<hr><hr>
		
		<input type="submit" value="회원가입하기">
		</form>	
	</fieldset>

</body>
</html>