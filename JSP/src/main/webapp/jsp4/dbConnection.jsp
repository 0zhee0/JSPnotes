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

	<h1>dbConnection.jsp</h1>
	<!-- p.428 -->
	
	<h2>JDBC(Java DataBase Connectivity) : 자바와 DB(MySQL)를 연결하는 API(라이브러리)</h2>
	
	<%
		// 0. JDBC 라이브러리(드라이버) 설치
		// mysql-connector-java-8.0.30.jar 파일을
		// /src/main/webapp/WEB-INF/lib 폴더에 저장 (설치)
		// => 프로젝트당 1번만 수행
		
		// 1. 드라이버 로드
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		System.out.println("드라이버 로드 성공!");
		
		// jdbc:mysql://localhost:3306/jspdb
		// jdbc:mysql://132.123.56.66:3306/jspdb
		// http://localhost:8088/JSP/jsp4/dbConnection.jsp
		
		// jdbc:mysql://localhost:3306/jspdb
		//	프로토콜 : // IP주소(DB서버의 주소) : DB프로그램 포트번호 / DB명
	
		// 2. 디비 연결
		// DriverManager.getConnection(url, user, password)
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspdb", "root", "1234");
		
		System.out.println("디비 연결 성공!");
		
		// 3. SQL 작성﻿(insert, select, update, delete)
		
		
		
		
	%>
	
	
	
	
	
	
	
	
	
	

</body>
</html>