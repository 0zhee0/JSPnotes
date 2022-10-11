<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>updateForm.jsp(MVC)</h1>
	
	<fieldset>
		<form action="./BoardUpdateProAction.bo?pageNum=${pageNum }"  method="post">
			<input type="hidden" name="bon" value="${dto.bno }">
			제목 : <input type="text" name="subject" value=${dto.subject }><br>
			작성자 : <input type="text" name="name" value=${dto.name }><br>
			비밀번호 : <input type="password" name="pass" placeholder="비밀번호를 입력하세요."><br>
			내용 : 
			<textarea rows="10" cols="20" name="content">${dto.content }></textarea>	
			<hr>
			<input type="submit" value="글 수정">	
		</form>	
	</fieldset>

</body>
</html>