<%@page import="com.itwillbs.board.BoardDAO"%>
<%@page import="com.itwillbs.board.BoardDTO"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>fWritePro.jsp</h1>
	<%
		// 첨부파일이 포함된 글쓰기
		
		// 1) 업로드
		//   - upload 폴더 생성
		// 업로드할 폴더 위치 생성
		String realPath = request.getRealPath("/upload");	// 실제 물리적인 서버 경로에 있는 upload폴더 가져와서 담기
		System.out.println("realPath : " + realPath);
		
		// 업로드 파일의 크기 20MB
		int maxSize = 20 * 1024 * 1024;
		
		// 업로드 객체 MultipartRequest 생성
		MultipartRequest multi = 
				new MultipartRequest(
						request,
						realPath,
						maxSize, //얼마나 담을 건지
						"UTF-8",
						new DefaultFileRenamePolicy()
						);
		System.out.println("첨부파일 업로드 성공!");

		// 2) 전달된 정보 처리(파라메터)
		  // (게시판 제목, 글쓰기, 비밀번호, 내용, 파일명)
		  // 전달정보 한번에 저장객체 BoardDTO 생성
		  BoardDTO dto = new BoardDTO();
		
		  dto.setSubject(multi.getParameter("subject")); 
		  // dto에 multi에서 불러온 subject파라메터값을 저장하겟다	// getParameter는 폼태그에 있는 값을 가져오는 것이다.
		  dto.setName(multi.getParameter("name"));
		  dto.setPass(multi.getParameter("pass"));
		  dto.setContent(multi.getParameter("content"));
		  dto.setFile(multi.getFilesystemName("file"));
		  
		  dto.setIp(request.getRemoteAddr()); 
		  // request 내장객체에 들어있는 값을 가져오려고	// 폼태그에없으니까request내장객체에 있는 ip값을 요청하는 것임
		  
		  // BoardDAO 파일 글쓰기 동작 호출
		  BoardDAO dao = new BoardDAO();
		  
		  dao.insertBoard(dto);  // insertBoard()메서드는 일반 글쓰기모드이지만 그 안에 파일글쓰기 기능도 설정해놓았었다.
		  											// pstmt.setString(11, dto.getFile());
		  // 페이지 이동(list)
		  response.sendRedirect("boardList.jsp");	
		  
		  // 파일글쓰기를 수행하고 나서 워크벤치를 보면 파일명만 저장되어 있다.
		  // 우리가 정보들을 다 가질 수 없으니 디비에는 파일명만 저장해놓고
		  // 실제 데이터는 톰캣서버 안에 저장되어 있는것이다.
	%>
</body>
</html>