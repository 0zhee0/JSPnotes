<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>core_foreach.jsp</h1>
	
<%-- 	<c:forEach begin="초기식" end="끝값" step="증감"> --%>
<!-- 		반복 -->
<%-- 	</c:forEach> --%>

	<h3>"안녕" X 5번 출력하기</h3>
	<c:forEach begin="1" end="5" step="1">
		안녕! <br>
	</c:forEach>
	
	<hr>	
	[jsp] <br>
	<%
		for(int i=1;i<=5;i++){
			out.println("안녕! <br>");
		}
	
	%>
	<hr>
	1 ~ 10까지 숫자를 가로 출력하기 <br>
	<c:forEach var="i" begin="1" end="10" step="1">
		${i }
	</c:forEach>
	
	<hr>
	1 ~ 10까지 숫자(홀수만)를 가로 출력하기 <br>
	<c:forEach var="i" begin="1" end="10" step="2">
		${i }
	</c:forEach>
	
	<hr>
	
	<!-- request.setAttribute("memberList", memberList); -->
	<c:forEach var="member" items="${memberList }">
		${member.id } <br>
		${member.name } <br>
		${member.email } <br>
	</c:forEach>

</body>
</html>














