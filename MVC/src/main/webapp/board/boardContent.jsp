<%@page import="com.itwillbs.db.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>boardContent.jsp</h1>

	<table border="1">
		<tr>
			<td>번호</td>
			<td>${requestScope.dto.bno }</td>
			<td>조회수</td>
			<td>${dto.bno }</td>	<!-- 영역객체 생략 가능 -->
		</tr>
		<tr>
			<td>작성자</td>
			<td>${dto.name }</td>
			<td>작성일</td>
			<td>${dto.date }</td>
		</tr>
		<tr>
			<td>제목</td>
			<td colspan="3">${dto.subject }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td colspan="3">${dto.content }</td>
		</tr>
		<tr>
			<td>첨부파일</td>
			<td colspan="3">${dto.file }</td>
		</tr>
		<tr>
 	   <tr>
  	      <td colspan="4">
  	         <input type="button" value="수정" 
  	                onclick=" location.href='./BoardUpdate.bo?bno=${dto.bno}&pageNum=${pageNum }'; ">
  	         <input type="button" value="삭제"
  	         		onclick=" location.href='./BoardDelete.bo?bno=${dto.bno }&pageNum=${pageNum }'; ">
  	         <input type="button" value="답글"
  	         		onclick=" location.href='./BoardReWrite.bo?bno=${dto.bno }&pageNum=${pageNum }&re_ref=${dto.re_ref }&re_seq=${dto.re_seq }&re_lev=${dto.re_lev }'; ">
  	         <input type="button" value="목록" 
  	                onclick="location.href='./BoardList.bo?pageNum=${pageNum}';">
  	      </td>
  	   </tr>
					<!-- 여기에 있는 pageNum은 BoardContentAction에서 담아놓은 pageNum이다. -->
	</table>
</body>
</html>