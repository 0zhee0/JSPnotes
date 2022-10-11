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
	<!-- 
		1. form 페이지에서 입력한 데이터를 변수로 불러오기
		2. DB연결하기
		3. SQL 구문작성 후 stmt 객체생성하기
			: SQL 구문작성 시에는 작은 따옴표와 큰 따옴표를 잘 입력해야한다.
	 -->
	
	<%
	// 1. 변수로 가져와서 데이터 출력
	
		// 1-1. POST 방식이라서 한글처리
		request.setCharacterEncoding("UTF-8");
	
	// 1-2. 전달된 정보 저장하기 -> 출력하기
	//		form 태그에서 받은 모든 데이터는 String 타입으로 전달되므로 int는 형변환 필수
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	int age = Integer.parseInt(request.getParameter("age"));
	String jumin = request.getParameter("jumin");
	%>
	
	<!-- 1-3. 데이터출력 -->
	이름 : <%=name %>
	성별 : <%=gender %>
	나이 : <%=age %>
	주민번호 : <%=jumin %>
	
	
	<h2> 2. 전달받은 정보를 DB에 저장 </h2>
	<%
	// 0. 드라이버 설치 - 생략
	
	// 디비연결정보 (필요한 변수들 상수로 정리) 
	// final로 변수 지정하면 변경불가능
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
	// 3-1.SQL 구문 작성 시 작은 따옴표와 큰 따옴표 주의하기**
	// itwill_member 테이블에 정보 저장,삽입 - insert
	String sql 
	 = "insert into itwill_member (name, gender, age, jumin) values ('"+name+"', '"+gender+"', "+age+", '"+jumin+"')";
	System.out.println("SQL 구문 작성 완료!");	
	
	// 3-2. Statement 객체 생성(java.sql하위의 statement사용)
	//		: SQL 구문을 실행하도록 도와주는 객체
	Statement stmt = con.createStatement();
	System.out.println("stmt 객체 생성 완료!");	
	
	// 4. SQL문 실행
	stmt.executeUpdate(sql);
	System.out.println("SQL 실행 완료!");
	%>

	<!-- sql구문작성을 보면 변수, 작은따옴표, 큰따옴표 
		 혼재되어있어서 적기에 매우 불편하다.
		 이를 해소하기위한 객체PreparedStatement를 이용하면된다.
		 기존 Statement보다 처리속도도 빠르고 보안도 좋은 
		 PreparedStatement를 사용해야한다. 
		 insertPro2.jsp 로 이동!-->
		 
</body>
</html>