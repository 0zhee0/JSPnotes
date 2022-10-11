<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>deleteForm.jsp(MVC)</h1>
	<!-- bno.pageNum -->
   <fieldset>
      <form action="./BoardDeleteAction.bo?pageNum=${param.pageNum }" method="post">
          <input type="hidden" name="bno" value="${param.bno }">	<!-- 주소들을 파라미터로 넘길거니까 -->
          비밀번호 : <input type="password" name="pass"> <br>
          <input type="submit" value="삭제하기">
      </form>   
   </fieldset>
</body>
</html>