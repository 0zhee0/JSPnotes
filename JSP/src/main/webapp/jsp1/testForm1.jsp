<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>testForm1.jsp</h1>
	
	<fieldset>
		<legend>폼태그</legend>
		<h3> 정보를 입력받아서 전달(submit)하는 태그</h3>
		<form action="itwill.jsp" method="post">
			<input type="text" name="name">
			<input type="submit" value="입력하기">
			
		</form>
	</fieldset>

	<fieldset>
		<legend>회원정보</legend>
		<h3> 이름과 전화번호를 입력해주세요.</h3>
		<form action="itwill.jsp" method="post">
			이름 : <input type="text" name="name"><br>
			나이 : <input type="text" name="age"><br>
			전화번호 : <input type="text" name="tel"><br>
			<input type="submit" value="입력하기">
			
		</form>
	</fieldset>
</body>
</html>