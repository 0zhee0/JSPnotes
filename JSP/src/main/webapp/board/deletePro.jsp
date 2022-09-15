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
	<h1>deletePro.jsp</h1>
	<%
		// 한글 처리
		request.setCharacterEncoding("utf-8");
	
		// 전달정보 저장(pageNum, bno, pass)
		String pageNum = request.getParameter("pageNum");
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		String pass = request.getParameter("pass");
		
	%>
	 <%-- <jsp:useBean id="dto" class=com.itwillbs.board.BoardDTO" />
		  <jsp:setProperty property="*" name="dto"/> 
	 --%>
	<%
		// BoardDAO 객체
		BoardDAO dao = new BoardDAO();
	
		// 게시판글 삭제
		int result = dao.deleteBoard(bno, pass);
		
	    // result -1, 0, 1
	    if(result == -1){
	    	%>
	    	<script type="text/javascript">
	    	alert('게시판 글 없음!');
	    	history.back();
	    	</script>
	    	<%
	    }else if(result == 0){
	    	%>
	    	<script type="text/javascript">
	    	alert('게시판 비밀번호 오류!');
	    	history.back();
	    	</script>
	    	<%
	    }else{
	    	// result == 1
	    	%>
	    	<script type="text/javascript">
	    	alert('게시판 삭제완료!');
	    	location.href="boardList.jsp?pageNum=<%=pageNum%>";
	    	</script>
	    	<%
	    }
	%>
</body>
</html>
