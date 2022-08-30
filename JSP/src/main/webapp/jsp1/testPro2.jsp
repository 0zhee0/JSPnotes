<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1> </h1>
	<%
		// 한글처리
		request.setCharacterEncoding("UTF-8");
		
		// 전달저장
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String gender = request.getParameter("gender");	
		String hobby1 = request.getParameter("hobby");
		String hobby2 = request.getParameter("hobby");
		String hobby3 = request.getParameter("hobby");
				
		String[] hobbys = request.getParameterValues("hobby");
		
		// 배열이 null인지 아닌지 체크
		// null 반복문 실행 x, null 아니면 실행 o
		
		if(hobbys != null){
			for(int i=0; i<hobbys.length;i++) {
			//System.out.println(hobbys[i]);
			// out.println("<h3> 취미" + (i+1) + " : " + hobbys[i] + "</h3>");
				%>
				<h3> 취미 <%=i+1 %> : <%=hobbys[i] %> </h3>
			 	<%
		}
			
			for(int i=0; i<hobbys.length;i++) {
				//System.out.println(hobbys[i]);
				out.println("<h3> 취미" + (i+1) + " : " + hobbys[i] + "</h3>");
			}
		}
	
		
		
		
	    %>
	
	
	<h3> 이름 : <%=name %> </h3>
	<h3> 비밀번호 : <%=pass %></h3>
	<h3> 성별 : <%=gender %></h3>
<%-- 	<h3> 취미 : <%=hobbys[0] %></h3> --%>
<%-- 	<h3> 취미 : <%=hobbys[1] %></h3> --%>
<%-- 	<h3> 취미 : <%=hobbys[2] %></h3> --%>

<%
	String num = request.getParameter("num");
%>
	<h3> 강의장 : <%=num %> 강의장 </h3>

	

</body>
</html>