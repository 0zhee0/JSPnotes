<%@page import="com.itwill.test.Phone"%>
<%@page import="com.itwill.test.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Beans.jsp</h1>
	
	[jsp]
	<%
		// request 영역 저장
		// request.setAttribute("person", kim);
		Person p = (Person) request.getAttribute("person"); // 다운캐스팅
	%>
	
	이름 : <%=p.getName() %>
	나이 : <%=p.getAge() %>
	<%
		Phone iPhone = p.getP();
	%>
	휴대폰 모델명 : <%=p.getP().getModel() %>
	휴대폰 모델명 : <%=iPhone.getModel() %>
	
	전화번호 : <%=p.getP().getTel() %>
	전화번호 : <%=iPhone.getTel() %>
	
	<hr>
	[el] set/get 없이 변수명으로 호출
	${requestScope.person.name }  <br> person.getName();
	${requestScope.person.age }
	${requestScope.person. }
	${requestScope.person.p }
	${requestScope.person.p.model }
	${requestScope.person.p.tel }
	${person.p.tel }
	
<%-- 	${requestScope.person.p.tel } --%>

</body>
</html>