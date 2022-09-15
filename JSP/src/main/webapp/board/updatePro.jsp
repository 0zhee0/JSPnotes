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
	<h1>updatePro.jsp</h1>
	
	<%
	  // 한글처리
	  request.setCharacterEncoding("UTF-8");
	  
	  // 전달정보 (pageNum) 저장
	  String pageNum = request.getParameter("pageNum");
	  
	  // 수정할 데이터 받아오기 (bno, name, pass, subject, content)
	  // => 액션태그 사용 자바빈 객체 저장 확인
	  // BoardDTO dto = new BoardDTO();
	  	%>
		<jsp:useBean id="dto" class="com.itwillbs.board.BoardDTO" />
		<jsp:setProperty property="*" name="dto"/>
		<% 
		// System.out.println(dto);
		
		// BoardDAO 객체 생성하기
		BoardDAO dao = new BoardDAO();
		
	    // 정보 수정하기
	    int result = dao.updateBoard(dto);
	    
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
	    	alert('게시판 수정완료!');
	    	location.href="boardList.jsp?pageNum=<%=pageNum%>";
	    	</script>
	    	<%
	    }    
	%>
</body>
</html>

