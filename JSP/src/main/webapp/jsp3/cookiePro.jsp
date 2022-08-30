<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>cookiePro.jsp</h1>
	
	<%
	String lang = request.getParameter("language");
		
	%>
	전달 정보 : <%=lang %><br>
	
	<%
		// 쿠키값 생성
		Cookie cookie = new Cookie("lang",lang);
		// Cookie cookie = new Cookie("lang",request.getParameter("language")); 
		// 위에 처럼 이렇게 변수지정없이 바로 넣을 수 있어야함
		
		// 쿠키의 유효기간 설정
		cookie.setMaxAge(60*60); // 3600s 니까 1시간걸어둔거임
		
		// 쿠키값을 클라이언트에 전달
		response.addCookie(cookie);
			
	%>
<!-- 	이제 다시 폼태그로 돌아가도록 자스src를 이용할 것이다.  -->
	<script type="text/javascript">
		alert('언어 쿠키정보 생성!');
		location.href="cookieForm.jsp"; 
	</script>


</body>
</html>

