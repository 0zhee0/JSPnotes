<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Test1.jsp</h1>
	<!-- ctrl + shift + f : 코드 정렬 -->
	<!-- Tab 오른쪽으로 이동, shift + Tab 왼쪽으로 이동 -->

	
	<h2> JSP 구성요소 </h2>
	
	<h3> JSP 지시어 (Directive) </h3>
	<%-- <%@ page, include, taglib %> --%>
	
	<h3> JSP 선언문 (Declaration) </h3>
	<%-- <%! 멤버 변수 선언, 메서드 선언 %> --%>	
	
	<%!
		// 전역 변수 선언 (멤버변수)
		int age = 100;
// 		out.println(age); 선언만 가능하고 호출은 불가능하다.
	%>
		
	<h3> JSP 스크립틀릿 (Scriptlet) </h3>
	<%-- <% 지역 변수 선언 %> --%>
	
	<%
		// 지역 변수 선언
		String name;
		out.println(age);
	%>
	
	<h3> JSP 표현식 (Expression) </h3>
	<!-- JSP 코드로 작성된 데이터를 화면에 출력 -->
	<%-- <%=값  %> --%>
	
	<%=age %>
	
	
	<!-- 스크립틀릿에 지역변수로 내 전화번호를 저장, 표현식을 사용해서 출력 -->
	<%
		String tel = "010-1234-1234";
	%>
	
	<h4> 전화번호 : <%=tel %> </h4>
	
	
	
	
	
</body>
</html>