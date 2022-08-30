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
	<h1>updateForm.jsp</h1>
	
	<h2> 정보 수정 페이지 </h2>
	<!-- 	idx=3인 사람의 정보를 가져와서 화면에 출력 -->
	
	<%
		// 디비연결정보 (상수)
		final String DRIVER = "com.mysql.cj.jdbc.Driver";
		final String DBURL = "jdbc:mysql://localhost:3306/jspdb";
		final String DBID = "root";
		final String DBPW = "1234";
		
		// 1. 드라이버로드
		Class.forName(DRIVER);
		System.out.println(" 드라이버 로드 성공! ");
		
		// 2. 디비연결
		Connection con = DriverManager.getConnection(DBURL, DBID, DBPW);
		System.out.println(" 디비 연결 성공! ");
		System.out.println(" con : " + con);
		
		// 3. SQL 작성(select) & pstmt
		String sql = "select * from itwill_member where idx=3"; // 정보 다 가져와도 되고 필요한 것만 가져와도 된다.
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		// 4. SQL 실행
		ResultSet rs = pstmt.executeQuery(); // ResultSet에 저장해야하는 거 잊지말기!
		
		// 전역변수로..
		String name = "";
		int age = 0;
		
		// 5. 데이터 처리
		if(rs.next()){ // 특정값 하나만 들고올거니까 while말고 if쓰자
			// 데이터가 있을 때
			name = rs.getString("name"); //rs에서 name값 가져오기
			age = rs.getInt("age");
		}
	%>
	
	
	<form action="updatePro.jsp" method="post">
		<input type="hidden" name="idx" value="3"><br>
		이름 : <input type="text" name="name" value="<%=name %>"><br>
		나이 : <input type="text" name="age" value="<%=age %>"><br>
<!-- 		성별 : <input type="text" name="gender"><br> -->
<!-- 		주민번호 : <input type="text" name="jumin"><br> -->
		
		<input type="submit" value="디비에 수정하기">
	</form>		

</body>
</html>