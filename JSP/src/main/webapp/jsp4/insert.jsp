<%@page import="java.sql.Statement"%>
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

	<h1>insert.jsp</h1>
	
	<h2> 정보를 DB에 저장(Create) </h2>
	
	<%
		// 0. 드라이버 설치 - 생략
		
		// 디비연결정보 (상수)
		final String DRIVER = "com.mysql.cj.jdbc.Driver";
		final String DBURL = "jdbc:mysql://localhost:3306/jspdb";
		final String DBID = "root";
		final String DBPW = "1234";
		
		// 1. 드라이버 로드
		Class.forName(DRIVER);
		System.out.println("드라이버 로드 성공!");
		
		// 2. 디비 연결
		Connection con = DriverManager.getConnection(DBURL, DBID, DBPW);
		System.out.println("디비 연결 성공!");		
		System.out.println("con : " + con);			
		
		// 3. SQL문 작성 & stmt 객체 생성
		// itwill_member 테이블에 정보 저장 - insert
		String sql 
		 = "insert into itwill_member (name, gender, age, jumin) values ('부산', '여자', 55, '900101-9999999')";
		System.out.println("SQL 구문 작성 완료!");	
		
		// Statement : SQL 구문을 실행하도록 도와주는 객체
		Statement stmt = con.createStatement();
		System.out.println("stmt 객체 생성 완료!");	
		
		// 4. SQL문 실행
		stmt.executeUpdate(sql);
		System.out.println("SQL 실행 완료!");

	
	
	%>

</body>
</html>