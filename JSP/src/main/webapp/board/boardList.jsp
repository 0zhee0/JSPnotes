<%@page import="com.itwillbs.board.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.itwillbs.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>boardList.jsp</h1>
	<%	
		// DB에 있는 정보 가져와서 화면에 출력
		
		// BoardDAO 객체 생성
		BoardDAO dao = new BoardDAO();
	
		// 게시판 정보를 가져오는 메서드
		ArrayList boardList = dao.getBoardList();
		
		// 게시판 정보 출력			
	%>		
	<h3><a href="writeForm.jsp">글 쓰기</a></h3>
	
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>작성일</th>
			<th>ip</th>
		</tr>
		<%for(int i=0;i<boardList.size();i++){ 
				BoardDTO dto = (BoardDTO) boardList.get(i);
			%>
		<tr>
			<td><%=dto.getBno() %></td>
			<td><%=dto.getSubject() %></td>
			<td><%=dto.getName() %></td>
			<td><%=dto.getReadcount() %></td>
			<td><%=dto.getDate() %></td>
			<td><%=dto.getIp() %></td>
		</tr>
		<%} %>
	</table>

</body>
</html>