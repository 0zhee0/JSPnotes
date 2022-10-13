<%@page import="com.itwillbs.board.BoardDTO"%>
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
	<h1>boardContent.jsp</h1>
	<%
	  // boardContent.jsp?bno=70&pageNum=1
	  // 선택한 글번호 가져오기
	  int bno = Integer.parseInt(request.getParameter("bno"));
	
	  // 페이지 정보 가져오기 
	  String pageNum = request.getParameter("pageNum");
	  
	  // BoradDAO 객체 생성
	  BoardDAO dao = new BoardDAO();
	  
	  // 글 조회수 1증가 동작
	  dao.updateReadcount(bno);
	  
	  // 게시판 글 정보를 가져와서 출력
	  BoardDTO dto = dao.getBoard(bno);
	  
// 	  System.out.println(dto);	
	%>
	
	<table border="1">
	  <tr>
	  	  <td>글번호</td>
	  	  <td><%=dto.getBno() %></td>
	  	  <td>조회수</td>
	  	  <td><%=dto.getReadcount() %></td>
	  </tr>
	  <tr>
	  	  <td>작성자</td>
	  	  <td><%=dto.getName() %></td>
	  	  <td>작성일</td>
	  	  <td><%=dto.getDate() %></td>
	  </tr>
	  <tr>
	  	  <td>제목</td>
	  	  <td colspan="3"><%=dto.getSubject() %></td>
	  </tr>
	  <tr>
	  	  <td>내용</td>
	  	  <td colspan="3"><%=dto.getContent() %></td>
	  </tr>
	  <tr>
	  	  <td>첨부파일</td>		<!-- 첨부파일명클릭 시 다운로드 되도록 하는 동작 (2가지버전) -->
	  	  <td colspan="3">	
	  	  	<a href="../file/fileDown1.jsp?file_name=<%=dto.getFile()%>"><%=dto.getFile() %></a>
	  	  		<!-- ../ : 상위폴더로의 이동인데 그러면 webapp폴더를 의미한다. /
	  	  			 이 경우는 실행하면 콘솔창에 filePath경로가 뜬다(서버에 저장되어있는 파일을 불러오는 것 -->
	  	  	<a href="../upload/<%=dto.getFile()%>"><%=dto.getFile() %></a>
	  	  		<!-- upload 파일로 가서 업로드한 사진을 보여주라는 방법
	  	  			 이 경우 콘솔창에 아무것도 안뜸  -->
	  	  </td>			
	  </tr>	
	  
	   <tr>
	  	  <td colspan="4">
	  	  <input type="button" value="수정" 
	  	  			onclick="location.href='updateForm.jsp?bno=<%=dto.getBno()%>&pageNum=<%=pageNum%>';">
	  	  <input type="button" value="삭제" 
	  	  			onclick="location.href='deleteForm.jsp?bno=<%=dto.getBno()%>&pageNum=<%=pageNum%>';"> 	  			
	  	  <input type="button" value="답글" 
	  	  			onclick="location.href='reWriteForm.jsp?bno=<%=dto.getBno()%>&re_ref=<%=dto.getRe_ref()%>&re_lev=<%=dto.getRe_lev()%>&re_seq=<%=dto.getRe_seq()%>';">
	  	  <input type="button" value="목록" 
	  	  			onclick="location.href='boardList.jsp?pageNum=<%=pageNum%>';">
	  	  </td>
	  </tr>
	</table>
</body>
</html>