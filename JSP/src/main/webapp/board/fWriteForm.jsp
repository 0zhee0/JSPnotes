<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> fWriteForm.jsp </h1>
	
	<!-- boardList.jsp 파일에서 파일글쓰기 링크 클릭했을 때 이동화면 -->
	<!-- JSP에서 파일 업로드를 위해서는 COS라이브러리가 필요하다. -->
	<!-- COS라이브러리의 Multipart Request클래스를 사용할 것이기 때문이다. -->
	
	<fieldset>
		<form action="fWritePro.jsp" method="post" enctype="multipart/form-data">
			제목 : <input type="text" name="subject"><br>
			작성자 : <input type="text" name="name"><br>
			비밀번호 : <input type="password" name="pass"><br>
			내용 : 
			<textarea rows="10" cols="20" name="content"></textarea><br>
			첨부파일 : <input type="file" name="file">	 <!-- 이렇게만 적어놓으면 FILE은 전달되지않고 이름만 전달이 된다. -->
			<hr>										 <!-- 파일까지 잘 전달하기위해서 FORM태그에 enctype을 추가해준다. -->
			<input type="submit" value="글쓰기">	
		</form>	
	</fieldset>
</body>
</html>

