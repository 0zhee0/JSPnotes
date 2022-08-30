<%@page import="java.sql.Statement"%>
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
	<h1>insertPro.jsp</h1>
	
	<%
		// 한글처리
		request.setCharacterEncoding("UTF-8");
	
	// 전달된 정보 저장하기 -> 출력하기
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	int age = Integer.parseInt(request.getParameter("age"));
	String jumin = request.getParameter("jumin");
	
	%>
	
	이름 : <%=name %>
	성별 : <%=gender %>
	나이 : <%=age %>
	주민번호 : <%=jumin %>
	<h2> 전달받은 정보를 DB에 저장 </h2>
	
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
	 = "insert into itwill_member (name, gender, age, jumin) values ('"+name+"', '"+gender+"', "+age+", '"+jumin+"')";
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