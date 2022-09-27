<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>core_out.jsp</h1>
	
	out.print() / JSP표현식 [% %] => 대신하는 출력형태<br>
	JSTL 코드는 HTML 영역에 작성한다. <br>
	
	<c:out value="안녕하세요. ITWILL입니다."></c:out> <br>
	<c:out value="안녕하세요. ITWILL입니다."/>
	<hr>
	c:out + EL 표현식 사용 => 연산 수행가능
	10 * 10 = 출력 <br>
	JSTL : <c:out value="10 * 10"/> <br>
	JSTL : <c:out value="${10*10 }"/> <br>
	JSTL : <c:out value="<%=10*20 %>"/> <br>
	JSP : <%=10*10 %> <br>
	
	<hr>
	* null 값을 출력할 때 공백으로 출력(el표현식)<br>
	c:out - default 값을 사용하면 null때의 기본값을 사용 가능
	<c:out value="${member.name }" default="기본값 입니다."/> <br>
	<%-- <%=member.name %> --%>
	<hr>
	escapeXml : <,> 특수기호를 처리할 때 사용 (default - false)
	<c:out value="${10 > 20}" escapeXml="true"/><br>
	<%-- <c:out value="${10 &lt; 20}" escapeXml="true"/><br> --%>
<%-- 	<c:out value="${10 &lt; 20}" escapeXml="true"/><br> --%>
	<c:out value="${10 lt 20}" escapeXml="false"/><br>
	
	<hr>
	<abc>는 abc태그입니다. <br>
	&lt;abc>는 abc태그입니다. <br>
	
	<c:out value="<abc>는 abc 태그입니다."/><br>
	
	
</body>
</html>