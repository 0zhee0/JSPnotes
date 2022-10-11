<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Driver"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.net.ConnectException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>select.jsp</h1>
	
	<h2> DB에 저장되어 있는 정보 조회 </h2>
	
	<%
		// 디비연결정보 (상수)
		final String DRIVER = "com.mysql.cj.jdbc.Driver";
		final String DBURL = "jdbc:mysql://localhost:3306/jspdb";
		final String DBID = "root";
		final String DBPW = "1234";
		
		// 1. 드라이버 로드
		Class.forName(DRIVER);
		System.out.println(" 드라이버 로드 성공! ");
		
		// 2. 디비 연결
		Connection con = DriverManager.getConnection(DBURL, DBID, DBPW); 
			//java 안에 있는 connection이라는 객체 안에 변수로 저장
		System.out.println(" 디비 연결 성공! ");
		System.out.println(" con : " + con);
		
		// 3. SQL 작성 & pstmt객체
// 		String sql
// 		= "select * from itwill_member"; // where절 없애면 모두 조회가능
			// 물음표에 따옴표X. 따옴표 붙이면 문자열로 인식
		String sql
		= "select * from itwill_member order by idx desc"; 	// 순서정렬
		System.out.println(" SQL 구문 작성 완료! ");
			
		// PreparedStatement : SQL 구문을 실행하도록 도와주는 객체 (사전작업)
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		// ??? (SQL 구문에 ?가 있는 경우 실행)
//  		pstmt.setString(1, "M"); // 큰 따옴표
			
		// 4. SQL문 실행
		// * 실행 구문은 sql 구문이 실행 시 테이블에 영향을 주는지 판단
		
// 		pstmt.executeUpdate(); : insert구문, update구문, delete구문 
//                               (테이블안에 데이터 조작, 영향을 준다.)
// 		pstmt.executeQuery(); : select구문 (db테이블에 영향주지 않고 조회만)
// 	    ResultSet : select문의 결과 레코드셋이라는 데이터를 저장하는 객체
		ResultSet rs = pstmt.executeQuery();
		System.out.println(" SQL 구문 실행 완료! ");
		
//--------------위에까지는 db연결 성공 후 sql구문 실행만 완료한것임-------------		
		
		// 5. 데이터 처리
		// => 정보를 가져다가 화면에 출력

		// rs.next() : 레코드셋의 커서를 움직여서 데이터가 있는지 없는지 체크
		// rs.next() 리턴타입은 boolean 논리형데이터타입
		while(rs.next()) {
			// 데이터 있을 때 = true
			
			// 데이터 저장 (DB -> 변수)
// 			rs.getXXX( INT 컬럼인덱스 ) : 검색속도가 빠르다, 테이블 설계중요
// 			rs.getXXX( STRING 컬럼명 ) : 데이터 정확도 높음, 컬럼명을 외워야함
			
			// 인덱스 정보 저장
			// int idx = rs.getInt("idx");
			int idx = rs.getInt(1);
			String name = rs.getString("name");
			String gender = rs.getString("gender");
			int age = rs.getInt("age");
			String jumin = rs.getString("jumin"); 
			
			out.println("IDX: "+idx+"<br>"); 
			out.println("name: " +name+"<br>"); 
			out.println("gender: " +gender+"<br>"); 
			out.println("age: " +age+"<br>"); 
			out.println("jumin: " +jumin+"<hr>"); 			
		}
		
	%>


</body>
</html>