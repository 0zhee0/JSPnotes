<%@page import="java.sql.PreparedStatement"%>
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
	<h1>insertPro2.jsp</h1>
	
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
// 	 = "insert into itwill_member (name, gender, age, jumin) values ('"+name+"', '"+gender+"', "+age+", '"+jumin+"')";
	 = "insert into itwill_member (name, gender, age, jumin) values (?, ?, ?, ?)";
	System.out.println("SQL 구문 작성 완료!");	
	
	// Statement : SQL 구문을 실행하도록 도와주는 객체
// 	Statement stmt = con.createStatement();
//	PreparedStatement : SQL 구문을 실행하도록 도와주는 객체 (사전작업)
	PreparedStatement pstmt = con.prepareStatement(sql); // 전처리
	System.out.println("stmt 객체 생성 완료!");

	// ???? (SQL 구문에 ?가 있는 경우 실행)
// 	pstmt.setXXXXX(?의 위치, ?에 들어갈 값);
//  => DB에 저장되는 타입에 따라서 메서드가 변경
//  => set() 개수는 ?? 개수와 동일
	pstmt.setString(1, name);
	pstmt.setString(2, gender);
	pstmt.setInt(3, age);
	pstmt.setString(4, jumin);
				
	// 4. SQL문 실행
// 	stmt.executeUpdate(sql);
	pstmt.executeUpdate();
	System.out.println("SQL 실행 완료!");
	
	// select.jsp 페이지로 이동
	response.sendRedirect("select.jsp");
	
	%>
	
	<!-- 실행 시 기능에 따라 쿼리구문을 두가지로 구별할 수 있다.
		1. DB 조작하는 구문
			-> pstmt.executeUpdate() : insert, update, delete에 사용
		2. DB 조작없이 값만 사용하는 구문
			-> pstmt.executeQuery() : select에 사용
	 -->
</body>
</html>