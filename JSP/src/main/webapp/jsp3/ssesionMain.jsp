<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ssesionMain.jsp</h1>
	
	<h2> 메인 페이지 </h2>
	
	<%
	  // 로그인 정보가 없을 경우 사용불가
	  // => 로그인 페이지 이동
	  // 로그인 정보가 있을 경우 사용가능
	  // => ㅇㅇㅇㅇ 님 환영합니다! 출력(화면)
	  
	  // 세션에 저장된 정보 가져오기
	  // session.setAttribute("id", id);
	  String id = (String)session.getAttribute("id");
	  
	  if(id == null) {
		  response.sendRedirect("sessionLoginForm.jsp");
	  } // else 굳이 할 필요 없음 그냥 로그인 성공하면 이 페이지에 남을 거니까  
	
	%>
	
	아이디 : <%=id %>님 환영합니다! <br>
	
<!-- 	로그아웃해보자 -->
	<input type="button" value="로그아웃" onclick="location.href='sessionLogOut.jsp';">
		
</body>
</html>