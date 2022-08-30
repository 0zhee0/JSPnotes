<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>sessionTest.jsp</h1>
	<h2> 클라이언트 </h2>
	
	<%
		String id = (String) session.getAttribute("ID");
		String name = (String) session.getAttribute("name");
	%>
	<h3> 정보 : <%=id %></h3>
	<h3> 정보 : <%=name %></h3>
	
	
<!-- 	버튼 클릭시 sessionSet.jsp 페이지 이동, 세션정보 생성 -->
	<input type="button" value="세션값 생성" onclick="location.href='sessionSet.jsp';">
	
	<input type="button" value="세션값 삭제" onclick="location.href='sessionDel.jsp';">
	
	<input type="button" value="세션값 초기화" onclick="location.href='sessionInv.jsp';">
	

</body>
</html>