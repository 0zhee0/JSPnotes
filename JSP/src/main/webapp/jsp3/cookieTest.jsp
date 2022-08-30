<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function cookieTest(){
		alert("서버로 페이지 요청(request)");
		location.href='cookieSet.jsp';
	}
	
	function cookieDelete(){
		alert("서버로 페이지 요청(request)");
		location.href='cookieDel.jsp';
	}	
</script>
</head>
<body>
	<h1>cookieTest.jsp</h1>
	
	<h2> 쿠키 </h2>
	=> 이름, 값, 유효기간, 도메인, 경로... 구성됨 <br>
	   이름 : 알파벳, 숫자 <br>
	   값 : 알파벳, 숫자(특수문자, 공백... 사용 가능 -> 인코딩) <br>
	   	   
	   <hr>
	   <h1>클라이언트</h1>
	   <%
	   	 // 쿠키값 가져오기
	   	 Cookie[] cookies = request.getCookies();  
	   
	   	 String value = "";
	     // 쿠키값 내가 원하는 정보 조회
	     if(cookies != null) {
	     for(int i=0; i<cookies.length; i++) {
	    	 if(cookies[i].getName().equals("id")) {
	    		 // A.equals(B)  A,B 문자열 값이 같은지 비교
	    		out.println("쿠키값 : " + cookies[i].getValue() );
	    	   	}
	     	}
	     }
	   %>
	   
	   아이디 : <input type="text" name="id" value="<%=value %>">
	   
	   
	   <input type="button" value="쿠키값생성" onclick="cookieTest();">
	   
	   <input type="button" value="쿠키값삭제" onclick="cookieDelete();">
</body>
</html>