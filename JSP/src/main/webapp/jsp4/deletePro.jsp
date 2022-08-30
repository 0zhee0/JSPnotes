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
<body>
	<h1>deletePro.jsp</h1>
	
	<%
		// 회원정보 삭제
		
		/*
			1. 회원정보가 필요 (deleteForm.jsp전달, 한글처리)
			
			2. 디비에서 삭제
			
			3. 드라이버 로드
			
			4. 디비 연결
			
			5. SQL 작성(select) & pstmt 객체 
			
			6. SQL 실행
			
			7. 데이터가 있을 경우에만 회원 삭제
			
			8. SQL 작성(delete) & pstmt 객체
			
			9. sql 실행
		
		*/
		
		// 한글처리
		request.setCharacterEncoding("UTF-8");
	
		// 전달정보 저장
		String name = request.getParameter("name");
		String jumin = request.getParameter("jumin");
		
		// 디비연결정보(상수)		
		final String DRIVER = "com.mysql.cj.jdbc.Driver";
		final String DRURL = "jdbc:mysql://localhost:3306/jspdb";
		final String DRID = "root";
		final String DRPW = "1234";
		
		// 드라이버 로드
		Class.forName(DRIVER);
		
		// 디비연결
		Connection con = DriverManager.getConnection(DRURL, DRID, DRPW);
		
		// SQL 작성(select) & pstmt 객체
		String sql = "select jumin from itwill_member where name = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		// ???
		pstmt.setString(1, name);
					
		// SQL 실행
		ResultSet rs = pstmt.executeQuery();
		
		// 데이터처리
		if(rs.next()) {
			// 회원
			if(jumin.equals(rs.getString("jumin"))){ //form태그jumin과 db의 jumin이 동일한지확인
				// 회원 - 주민번호 동일 => 삭제
				sql = "delete from itwill_member where jumin=?";			
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, jumin);
				
				// sql 실행
				pstmt.executeUpdate();
			}
			
		}
	
	%>
	

</body>
</html>