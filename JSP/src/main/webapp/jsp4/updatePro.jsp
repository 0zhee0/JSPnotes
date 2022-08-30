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
	<h1>updatePro.jsp</h1>

	<%
		// 한글처리
		request.setCharacterEncoding("UTF-8");
		
		//전달된 정보 (수정할 데이터) 저장
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));	
		int idx = Integer.parseInt(request.getParameter("idx"));		
	%>
	
	수정할 이름 : <%=name %>, 수정할 나이 : <%=age %> <hr>
	
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
		
	 	// 3. SQL 작성 & pstmt
	 	// SQL - 3번 유저가 존재하는지 아닌지 판단 (회원인지 아닌지)
	 	String sql = "select * from itwill_member where idx = ?";
	 	PreparedStatement pstmt = con.prepareStatement(sql);
	 	
	 	// ???
	 	pstmt.setInt(1, idx);
	 	
		// 4. SQL 실행
		ResultSet rs = pstmt.executeQuery();
		
		// 5. 데이터 처리
		if(rs.next()){
			// 회원일때만
			// SQL - update(3 번 유저의 이름, 나이 수정)
			// 3. SQL 생성 & pstmt 다시 생성
			sql = "update itwill_member set name=?, age=? where idx=?"; // 물음표하나만 ㅎ
			pstmt = con.prepareStatement(sql); // sql이랑 pstmt 둘이 한 세트임 항상 같이다니기
			
			//???
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setInt(3, idx);
			
			// 4. SQL 실행
			pstmt.executeUpdate();
		}else{
			// 비회원
		}
	%>

</body>
</html>