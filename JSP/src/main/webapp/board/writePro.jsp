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
	<h1>writePro.jsp</h1>

	<%
		// 한글 처리
		request.setCharacterEncoding("utf-8");
	
		// 자바빈 객체 => BoardDTO(Data Transfer Object) (=BoardBean)
				
		// 전달된 파라메터를 저장(액션태그)	
	%>
	<!-- dto : 데이터 전송 객체 -->
	<jsp:useBean id="dto" class="com.itwillbs.board.BoardDTO"/>
	<jsp:setProperty property="*" name="dto"/>
	
	<%-- <%=dto.toString() %> --%>
	<%
		// dto 객체에 IP 주소 추가 저장
		dto.setIp(request.getRemoteAddr());
	%>
	<%=dto.toString() %>
	
	<%
		// 저장된 글정보(DTO)를 DB에 저장
		// BoardDAO 객체 생성
		BoardDAO dao = new BoardDAO();
	
		// 글쓰기 메서드 호출
		dao.insertBoard(dto);
	
		// 리스트 페이지 이동
		response.sendRedirect("boardList.jsp");
	
	%>
</body>
</html>
