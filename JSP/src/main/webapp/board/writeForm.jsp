<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> writeForm.jsp </h1>
	
	<fieldset>
		<form action="writePro.jsp" method="post">
			제목 : <input type="text" name="subject"><br>
			작성자 : <input type="text" name="name"><br>
			비밀번호 : <input type="password" name="pass"><br>
			내용 : 
			<textarea rows="10" cols="20" name="content"></textarea>	
			<hr>
			<input type="submit" value="글쓰기">	
		</form>	
	</fieldset>
</body>
</html>

