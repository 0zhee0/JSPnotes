<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>sessionDel.jsp</h1>
	
	<h2> 서버 (세션값 삭제) </h2>
	
	<%
		// 세션 영역에 있는 값을 제거
		session.removeAttribute("ID");	
	%>
	<script type="text/javascript">
		alert('세션값 삭제');
		location.href="sessionTest.jsp";	
	</script>

</body>
</html>