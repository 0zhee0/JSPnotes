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
	<h1>core_set1.jsp</h1>
	<%
		// JSP 코드는 set1.jsp 페이지에서만 사용가능
		int num1 = 100;
		int num2 = 200;
		int sum = num1 + num2;
	%>
	JSP : <%=sum %> <br>
	JSTL : <c:out value="<%=sum %>"></c:out> <br>
	EL : ${sum } <br>
	
	<h2> 변수 선언 </h2>
	<%-- 
			<c:set var="변수명" value="변수값" scope="영역"/>
			영역 객체.setAttribute("변수명, "변수값"); 
			* 영역 객체 정보가 생략된 경우 page가 디폴트
	--%>
	<c:set var="sum0" value="<%=sum %>"/> <%-- page 영역에 저장 --%>
	<%-- <%=sum0 %> --%>
	${sum0 }<br>
	page : ${pageScope.sum0 } <br>
	request : ${requestScope.sum0 } <br>
	session : ${sessionScope.sum0 } <br>
	application : ${applicationScope.sum0 } <br>
	
	<hr>
	JSTL 사용해서 100 + 200 + = 300 연산결과를 출력 <br>
	<c:set var="num3" value="100" />
	<c:set var="num4" value="200" />
	<c:set var="sum5" value="${num3+num4 }" />
	
	<c:out value="${num3}"/> + <c:out value="${num4}"/> = <c:out value="${sum5}"/> <br>
	${num3} + ${num4} = ${sum5}<br>
	
	<hr>
	<c:set var="model" value="아이폰14" scope="request" />
	<c:set var="color" value="black" scope="request" />
	<c:set var="price" value="200" scope="request" />
	<c:set var="price" value="300" scope="session" />
	
	<h2>core_set2.jsp 이동</h2>
	액션태그 - forward
	<jsp:forward page="core_set2.jsp" />
	
</body>
</html>















