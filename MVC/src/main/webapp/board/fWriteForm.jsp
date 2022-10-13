<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <h1>fWriteForm.jsp(MVC)</h1>
     
     <fieldset>
        <form action="./BoardFileWriteAction.bo" method="post" enctype="multipart/form-data">
           제목 : <input type="text" name="subject"><br>
           작성자 : <input type="text" name="name"><br>
           비밀번호 : <input type="password" name="pass"><br>
           내용 : 
           <textarea rows="10" cols="20" name="content"></textarea><br>
           첨부파일 : <input type="file" name="file">
           <hr>
           <input type="submit" value="글쓰기">        
        </form>     
     </fieldset>
     
     
     <!-- 
     		 파일 업로드를 하려면?
			 form 태그를 사용!
			 전달 방식은 post방식
			 enctype="multipart/form-data"
			<form emthod="post"  enctype="multipart/form-data">
      -->
     
     
     
</body>
</html>































<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" --%>
<%--     pageEncoding="UTF-8"%> --%>
<!-- <!DOCTYPE html> -->
<!-- <html> -->
<!-- <head> -->
<!-- <meta charset="UTF-8"> -->
<!-- <title>Insert title here</title> -->
<!-- </head> -->
<!-- <body> -->
<!-- 	<h1> fWriteForm.jsp(MVC) </h1> -->
	
<!-- 	<fieldset> -->
<!-- 		<form action="./BoardFileWriteAction.bo" method="post" enctype="multipart/form-data"> -->
<!-- 			제목 : <input type="text" name="subject"><br> -->
<!-- 			작성자 : <input type="text" name="name"><br> -->
<!-- 			비밀번호 : <input type="password" name="pass"><br> -->
<!-- 			내용 :  -->
<!-- 			<textarea rows="10" cols="20" name="content"></textarea><br> -->
<!-- 			첨부파일 : <input type="file" name="file"> -->
<!-- 			<hr> -->
<!-- 			<input type="submit" value="글쓰기">	 -->
<!-- 		</form>	 -->
<!-- 	</fieldset> -->
<!-- </body> -->
<!-- </html> -->

