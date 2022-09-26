<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Arrays.jsp</h1>
	<%
// 	request.setAttribute("foods", foods);
	String[] foods = (String[])request.getAttribute("foods");
	%>
	
	[jsp] <br>
	<%
		for(int i=0;i<foods.length;i++){
			%>
				음식 : <%=foods[i] %> <br>
			<%
		}
	%>
	
	[el] : JSP 반복문 코드를 사용불가 => JSTL 코드 사용<br>
	음식 : ${requestScope.foods[0] }<br>
	음식 : ${requestScope.foods[1] }<br>
	음식 : ${foods[2] }<br> 
	음식 : ${requestScope.foods[3] }<br>
	음식 : ${requestScope.foods[4] }<br>
	
	<%
 		for(int i=0; i<foods.length; i++){
			%>
				${requestScope.foods[i] }<br>
			<%
 		}
	
	%>
	
	[jsp] <br>
	<%
		List sports = (List)request.getAttribute("sports");
	
		for(int i=0;i<sports.size();i++){
			%>
				<%=sports.get(i) %> <br>
			<%
		}
		
	
		for(Object s:sports){
			%>
			<%=s %>
			<%
		}
	%>
	
	[el] <br>
	${requestScope.sports[0] }
	${requestScope.sports[1] }
	${requestScope.sports[2] }
	${sports[3] }
	${sports[4] }
	
	
	
	

</body>
</html>