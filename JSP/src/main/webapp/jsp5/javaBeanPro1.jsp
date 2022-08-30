<%@page import="com.itwillbs.javabean.JavaBean1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>javaBeanPro1.jsp</h1>
	
	<%	
	
	String id = request.getParameter("id");
	
	// 자바빈 사용해서 정보 저장/처리
	
	// 자바빈 객체 생성
	JavaBean1 jb = new JavaBean1();
	
	// 자바빈에 객체정보를 저장
	jb.setId(request.getParameter("id"));
	
	%>
	
	아이디 : <%=id %><br>
	아이디2 : <%=jb.getId() %><br> 
	
	<hr>
	<h2> 액션태그 - 자바빈 객체 </h2>
	
	<!-- 자바빈 객체 생성(JSP코드) -->
	<%-- 	<jsp:useBean id="객체명" class="객체위치"/> --%>
	<jsp:useBean id="jb2" class="com.itwillbs.javabean.JavaBean1"/>
	
	<!-- 자바빈에 객체정보를 저장 -->
<%-- 	<jsp:setProperty property="객체변수명" name="객체명" param="파라미터명"/> --%>
<%-- 	<jsp:setProperty property="id" name="jb2" param="id"/> --%>
	
	<!-- property, param 값이 동일한 경우 param값을 생략가능 -->
	<jsp:setProperty property="id" name="jb2"/>
	
	<!-- 전달되는 모든 파라메터값을 모든 변수에 저장 가능 -->
	<jsp:setProperty property="*" name="jb2"/>
	
	<!-- 자바빈에 저장된 객체 정보 출력 -->
	<jsp:getProperty property="id" name="jb2"/>

</body>
</html>