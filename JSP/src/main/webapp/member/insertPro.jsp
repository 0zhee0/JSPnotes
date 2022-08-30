<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>insertPro.jsp</h1>
	<%
		// 한글처리 (post방식으로 처리한다고했어서 한글처리 해줘야함)
		request.setCharacterEncoding("UTF-8");		
		
		// MemberBean 객체 생성
		// 전달되는 회원정보를 저장(액션태그)
	%>
		<jsp:useBean id="mb" class="com.itwillbs.member.MemberBean"/>
		<jsp:setProperty property="*" name="mb"/>		
		
<%-- 		<jsp:getProperty property="*" name="mb"/> --%>
<%-- 		<%=mb.getPw() %> --%>

			<%=mb.toString() %><br>
			<%=mb %><br>
	<% 
		// mb 객체에 회원정보(시간정보) 추가
		mb.setRegdate(new Timestamp(System.currentTimeMillis()));
	%>
	<%=mb %><br>
	
	<%
		// 연결정보저장(상수)
		final String DRIVER = "com.mysql.cj.jdbc.Driver";
		final String DBURL = "jdbc:mysql://localhost:3306/jspdb";
		final String DBID = "root";
		final String DBPW = "1234";
	
		// 1. 드라이버 로드
		Class.forName(DRIVER);
		System.out.println("드라이버 로드 성공!");
		
		// 2. 디비 연결
		Connection con = DriverManager.getConnection(DBURL, DBID, DBPW);
		System.out.println("디비연결 성공!");
		
		// 3. SQL 작성 & sptmt 객체
		String sql 
		= "insert into itwill_member (id,pw,name,age,gender,email,regdate) values (?,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		  //???
		  pstmt.setString(1, mb.getId());
		  pstmt.setString(2, mb.getPw());
		  pstmt.setString(3, mb.getName());
		  pstmt.setInt(4, mb.getAge());
		  pstmt.setString(5, mb.getGender());
		  pstmt.setString(6, mb.getEmail());
		  pstmt.setTimestamp(7, mb.getRegdate());
		
		// 4. SQL 구문실행
		pstmt.executeUpdate();	
		System.out.println("회원가입 성공!");
	%>
	
	<script type="text/javascript">
		alert('회원가입 성공!');
		location.href="loginForm.jsp";
	</script>
	
</body>
</html>