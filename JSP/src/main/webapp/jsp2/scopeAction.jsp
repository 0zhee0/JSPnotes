<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> scopeAction.jsp </h1>
	<h2> 파라미터 </h2>
	
	아이디 : <%=request.getParameter("id")%><br>
	비밀번호 : <%=request.getParameter("pw") %><br>
	
	<hr>
	<h2> 어트리뷰트 </h2>
	page : <%=pageContext.getAttribute("p")%> <br>
	request : <%=request.getAttribute("r")%> <br>
	session : <%=session.getAttribute("s")%> <br>
	application : <%=application.getAttribute("a")%> <br>	
</body>
</html>