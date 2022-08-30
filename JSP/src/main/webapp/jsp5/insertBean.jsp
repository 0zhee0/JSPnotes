<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="com.itwillbs.javabean.JavaBean2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>insertBean.jsp</h1>
	<%
		// insertForm.jsp 정보를 전달받아서 DB에 저장
		
		// 1. 전달정보 저장
		 // 1-1. jsp 
// 		 int age = Integer.parseInt(request.getParameter("age"));
// 		 String name = request.getParameter("name");
// 		 String gender = request.getParameter("gender");
// 		 String jumin = request.getParameter("jumin");
		 
		 //1-2. 자바빈 객체
// 		 JavaBean2 jb2 = new JavaBean2();
// 		 jb2.setName(request.getParameter("name"));
// 		 jb2.setGender(request.getParameter("gender"));
// 		 jb2.setJumin(request.getParameter("jumin"));
// 		 jb2.setAge(Integer.parseInt(request.getParameter("age")));
		 
		//1-3. 자바빈 객체 - 액션태그(html영역, JSP코드작성)
		%>
		<!--  HTML 영역 -->
		<jsp:useBean id="jb2" class="com.itwillbs.javabean.JavaBean2" />
		<jsp:setProperty property="*" name="jb2"/>
		<%
	/////////////////////////////////////////////////////////////////////////////
	
		// 2. DB에 정보 저장
		// 디비연결정조(상수)
		final String DRIVER = "com.mysql.cj.jdbc.Driver";
		final String DBURL = "jdbc:mysql://localhost:3306/jspdb";
		final String DBID = "root";
		final String DBPW = "1234";
		
		// 1. 드라이버 로드
		Class.forName(DRIVER);
		
		// 2. 디비 연결
		Connection con = DriverManager.getConnection(DBURL, DBID, DBPW);
		
		// 3. SQL 작성 & pstmt
		String sql = "insert into itwill_member values(?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		  //??? 워크벤치에서 db에 있는 컬럼 순서에 맞게 작성
		  pstmt.setString(1, jb2.getName());
		  pstmt.setInt(2, jb2.getAge());
		  pstmt.setString(3, jb2.getGender());
		  pstmt.setString(4, jb2.getJumin());
		
		// 4. SQL 실행
		pstmt.executeUpdate();
		
		

		
		
	
	%>

</body>
</html>