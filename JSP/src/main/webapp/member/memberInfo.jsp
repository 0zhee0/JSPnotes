<%@page import="com.itwillbs.member.MemberDAO"%>
<%@page import="com.itwillbs.member.MemberBean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>memberInfo.jsp</h1>
	<h2>로그인한 사용자의 개인정보 조회 페이지</h2>

	<%
		// 한글 처리
		request.setCharacterEncoding("UTF-8");
	
		// 세션정보를 가지고 로그인 제어 = 회원정보 유무
		String id = (String)session.getAttribute("id");	
		if(id == null) {
			response.sendRedirect("loginForm.jsp");			
		}	
		
		// id에 해당하는 회원정보를 DB에서 조회
		// => DB에 대한 처리 필요하다
		
		// MemberDAO 객체 생성
		MemberDAO dao = new MemberDAO();
		
		// id 정보를 사용하여 회원정보 모두를 가져오기
		MemberBean mb = dao.getMember(id);
								
	%>
	
	<h3> 아이디 : <%=mb.getId() %></h3>
	<h3> 비밀번호 : <%=mb.getPw() %> </h3>
	<h3> 이름 : <%=mb.getName() %></h3>
	<h3> 나이 : <%=mb.getAge() %></h3>
	<h3> 성별 : <%=mb.getGender() %></h3>
	<h3> 이메일 : <%=mb.getEmail() %></h3>
	<h3> 회원가입일 : <%=mb.getRegdate() %></h3>
	
	<a href="main.jsp"> 메인페이지 </a>
	
</body>
</html>

