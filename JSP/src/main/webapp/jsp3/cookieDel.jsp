<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 	<h1>cookieDel.jsp</h1>
 	
 	<h1>서버</h1>
 	<h2>쿠키값 삭제</h2>
 	
 <%
 	System.out.println(" 서버 : 쿠키값 삭제...."); 
 
 	// 기존의 쿠키값 가져오기
 	Cookie[] cookies = request.getCookies();
 	
 	// 삭제하려는 쿠키정보 찾기
 	if(cookies != null) {
 		for(int i=0; i < cookies.length;i++) {
 			if(cookies[i].getName().equals("id")){
 				//삭제할 쿠키정보(찾고있는쿠키=id)를 찾았다.
 				cookies[i].setMaxAge(0); // 유효기간 0초
 				
 				// 변경된 쿠키정보를 클라이언트로 전송
 				response.addCookie(cookies[i]);
 			}
 		}
 	} 	 	
 %>
 
 <script type="text/javascript">
 	alert("서버 처리완료, 클라이언트로 이동");
 	alert("쿠키 전달");
 	location.href="cookieTest.jsp";
 </script>
 	 	
</body>
</html>