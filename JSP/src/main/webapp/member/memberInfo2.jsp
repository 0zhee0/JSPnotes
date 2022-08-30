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
	<h1>memberInfo2.jsp</h1>
	<h2>로그인한 사용자의 개인정보 조회 페이지</h2>

	<%
		// 한글 처리
		request.setCharacterEncoding("UTF-8");
	
		// 세션정보를 가지고 로그인 제어 = 회원정보 유무
		String id = (String)session.getAttribute("id");	
		if(id == null) {
			response.sendRedirect("loginForm.jsp");			
		}			
		
		// DB 에서 필요한 정보 가져오기
		// 디비연결정보 (상수)
		final String DRIVER = "com.mysql.cj.jdbc.Driver";
		final String DBURL = "jdbc:mysql://localhost:3306/jspdb";
		final String DBID = "root";
		final String DBPW = "1234";
		
		// 1. 드라이버 로드
		Class.forName(DRIVER);
		// 2. 디비 연결
		Connection con = DriverManager.getConnection(DBURL, DBID, DBPW);
		
		// 3. SQL 작성(select) & pstmt 객체
		String sql = "select * from itwill_member where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
			// ?
			pstmt.setString(1, id);
					
		// 4. SQL 실행
		ResultSet rs = pstmt.executeQuery();
		
		// MemberBean mb = new MemberBean();
		MemberBean mb = null;
		// 5. 데이터 처리
		if(rs.next()){
			// 회원정보 저장(MemberBean)
			// rs(DB정보) --> MemberBean
			mb = new MemberBean();
			
			mb.setAge(rs.getInt("age"));
			mb.setEmail(rs.getString("email"));
			mb.setGender(rs.getString("gender"));
			mb.setId(rs.getString("id"));
			mb.setName(rs.getString("name"));
			mb.setPw(rs.getString("pw"));
			mb.setRegdate(rs.getTimestamp("regdate"));						
		}			
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

