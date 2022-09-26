<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// 한글처리
		request.setCharacterEncoding("utf-8");
	
		String name = request.getParameter("name");
	%>
	
	이름 : <%=name %><br>
	이름(el표현식 - jsp코드값 사용 x) : ${name }<br>
	이름(el) : ${param.name } <br>
	* el 표현식은 null값을 공백문자로 표시
	
	<hr>
	<%
		String[] menu = request.getParameterValues("menu");
	%>
		
	<h3>오늘의 추천메뉴</h3>
	[jsp]<br>
	메뉴1 : <%=menu[0] %><br>
	메뉴2 : <%=menu[1] %><br>
	
	<hr>
	
	[el]<br>
	메뉴1 : ${paramValues.menu[0] }<br>
	메뉴2 : ${paramValues.menu[1] }<br>
	
		<hr>
	<%
		String[] hobbys = request.getParameterValues("hobby");
	%>
	<h3>취미 정보</h3>
	 [jsp]<br>
<%-- 	 취미1 : <%=hobbys[0] %><br> --%>
<%-- 	 취미2 : <%=hobbys[1] %><br>	 --%>
<%-- 	 취미3 : <%=hobbys[2] %><br> --%>
	 
	 <%
	 if( hobbys != null){
 	 for(int i=0;i<hobbys.length;i++){
 		 %> 
		 	취미<%=i+1 %> : <%=hobbys[i] %><br>		
		 <% 	 	
 	 }
	 %>
	 
	 <%
	  for(String h:hobbys){
		  %>
		  	취미 : <%=h %><br>
		  <%
		  }
	 }
	 %>
	 
	 <hr>
	 [el]<br> 
	 취미1 : ${paramValues.hobby[0] }<br>
	 취미2 : ${paramValues.hobby[1] }<br>
	 취미3 : ${paramValues.hobby[2] }<br>

	 
</body>
</html>






