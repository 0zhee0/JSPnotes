<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>fmt_formatNumber.jsp</h1>
	
	HTML : 1000000000 <hr>
	
	<fmt:formatNumber value="1000000000"/> <br>
	<fmt:formatNumber value="1000000000" groupingUsed="true" /> <br>
	<fmt:formatNumber value="1000000000" groupingUsed="false" /> <br>
	
	<hr>
	3.1456789 => 소수점 2번째 자리까지만 표현 <br>
	pattern 속성에 #특수기호를 사용해서 자릿수를 표현<br>
	<fmt:formatNumber value="3.1456789" pattern="#.##" /> <br>
	<fmt:formatNumber value="3.1456789" pattern="#.####" /> <br>
	<fmt:formatNumber value="3.1456789" pattern="#.#############" /> <br>
	<hr>
	10.5 => 소수점 2번째 자리까지 표현 (10.50) <br>
	<fmt:formatNumber value="10.5"/> <br>
	<fmt:formatNumber value="10.5" pattern="##.##"/> <br>
	<fmt:formatNumber value="10.5" pattern="##.00"/> <br>
	<fmt:formatNumber value="10.5" pattern="##.0000"/> <br>
	
	<hr>
	0.5 => 50% <br>
	<fmt:formatNumber value="0.5" type="percent"/> <br>
	<fmt:formatNumber value="<%=78/13 %>" type="percent"/> <br>
	
	<hr>
	<fmt:formatNumber value="1000000000" type="currency" /> <br>
	<fmt:formatNumber value="1000000000" type="currency" groupingUsed="false"/> <br>
	<fmt:formatNumber value="1000000000" type="currency" groupingUsed="false" currencySymbol="@"/> <br>
</body>
</html>













