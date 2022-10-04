<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>boardList.jsp</h1>
	
	<!-- 전달된 정보 확인 -->
	
<%--	1번 방식 : jsp코드 이용해서 출력
	
	<%= request.getAttribute("boardListAll") %>
	
	2. el표현식 이용해서 출력
	
	${requestScope.boardListAll } --%>
	
	
	<h3><a href="./BoardWrite.bo">글쓰기</a></h3>
	
	<!-- <h3>전체 글 개수 : 00 개</h3> -->
	<h3>전체 글 개수 : ${reqeustScope.totalCnt } 개</h3>
	
	<table border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>글쓴이</td>
			<td>조회수</td>
			<td>작성일</td>
			<td>ip</td>
		</tr>
		
	<c:forEach var="dto" items="${boardListAll }">	
		<tr>
			<td>${dto.bno }</td>
			<td>${dto.subject }</td>
			<td>${dto.name }</td>
			<td>${dto.readcount }</td>
			<td>${dto.date }</td>
			<td>${dto.ip }</td>
		</tr>
	</c:forEach>	
	</table>
</body>
</html>