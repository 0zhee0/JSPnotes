<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<h1>main.jsp</h1>
	
	<h2> 메인페이지 </h2>
	
	<%	
		// 로그인을 해야만 정보를 확인가능 페이지
		// 로그인X -> 사용자 페이지 사용X
		// => 로그인 페이지로 이동
		// 로그인O -> "ooo"님 환영합니다.
		
		String id = (String)session.getAttribute("id");
	
		if(id == null) {
			response.sendRedirect("loginForm.jsp");			
		}							
	%>
	
	<h3><%=id %>님 환영합니다!</h3>
	
	<input type="button" value="로그아웃" onclick="location.href='logout.jsp';">
	
	<a href="logout.jsp"> 로그아웃2 </a>
		
	<a href="javascript:location.href='logout.jsp';"> 로그아웃3 </a>
	
	<hr><hr>
	
	<h4><a href="memberInfo.jsp">회원정보 조회</a></h4>
	
	<h4><a href="memberUpdate.jsp">회원정보 수정</a></h4>
	
	<h4><a href="memberDelete.jsp">회원정보 삭제</a></h4>
	
		
</body>
</html>

























