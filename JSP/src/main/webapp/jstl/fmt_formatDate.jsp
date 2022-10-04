<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>fmt_formatDate.jsp</h1>
	
	<c:set var="today" value="<%=new Date() %>"/>
	
	<hr>
	<h2>기본값</h2>
	${today }
	
	<hr>
	<fmt:formatDate value="${today }"/> <br>
	<fmt:formatDate value="${today }" type="time"/> <br>
	<fmt:formatDate value="${today }" type="both"/> <br>
	
	<hr>
	<fmt:formatDate value="${today }" dateStyle="full"/> <br>
	<fmt:formatDate value="${today }" dateStyle="long"/> <br>
	<fmt:formatDate value="${today }" dateStyle="medium"/> <br>
	<fmt:formatDate value="${today }" dateStyle="short"/> <br>
	
	<hr>
	<fmt:formatDate value="${today }" type="time" timeStyle="full"/> <br>
	<fmt:formatDate value="${today }" type="time" timeStyle="long"/> <br>
	<fmt:formatDate value="${today }" type="time" timeStyle="medium"/> <br>
	<fmt:formatDate value="${today }" type="time" timeStyle="short"/> <br>
	
	<hr>
	2022년 9월 29일 목요일 오후 3:11:00 <br>
	<fmt:formatDate value="${today }" type="both" dateStyle="full" timeStyle="medium"/> <br>
	
	<br>
	2022/9/29(목) <br>
	<fmt:formatDate value="${today }" pattern="yyyy/MM/dd(E)"/> <br>
	<fmt:formatDate value="${today }" pattern="yy-MM-dd(E)"/> <br>
	(오후) 3:17:00 <br>
	<fmt:formatDate value="${today }" type="time" pattern="hh:mm:ss"/> <br>
	<fmt:formatDate value="${today }" type="time" pattern="[a h:mm:ss]"/> <br>
	
	
</body>
</html>












