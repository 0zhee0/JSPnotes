<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
		<!-- multipart패키지안에서 DefaultFileRenamePolicy클래스 import하기
			  : 사용자가 업로드한 파일 중에서 중복된 파일명이 존재할 시 자동으로 파일이름을 변경해주고, 
			    오류가 발생하지 않도록 적용해주는 등 전반적으로 파일이름과 관련한 처리를 도와주는 클래스-->
<%@page import="com.oreilly.servlet.MultipartRequest"%>
		<!-- MultipartRequest클래스 : 파일 업로드를 도와주는 클래스.
			 / MultipartRequest클래스가 파일 업로드 할 수 있도록 우리가 만들어줄거다.  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>fileUploadPro.jsp</h1>	
	<!-- fileUploadForm.jsp에서 받아온 값으로 파일을 업로드처리하는 페이지 -->
	
	<%
		// 파일 업로드 장소 -> upload폴더 (가상경로 이클립스 upload폴더)
		// 실제 파일이 저장되는 곳은(서버 안에 upload 폴더)
		
		String path = request.getRealPath("/upload");
					// 서버의 실제 프로젝트 경로에서 자원을 찾는 메서드인데 
					// 원래 request보다 application 내장 객체를 가장 많이 사용한다.
					// application 내장객체 : 전체 프로젝트에 대한 자원을 관리하는 객체
					//		-> 우리가 만들었던 upload폴더안에 실제로 파일을 저장할 수 있도록 만들어줌
		System.out.println("path : " + path);
		
		// 업로드 파일의 크기 제한 : 10MB
		int maxSize = 10 * 1024 * 1024;
		
		// 파일 업로드
		MultipartRequest multi
			= new MultipartRequest(
					request,
					path,
					maxSize,
					"UTF-8",
					new DefaultFileRenamePolicy() // 파일명 중복처리 오류안나게 파일명 변경해주는 메서드
			);		
		// MultipartRequest 객체는 사용자가 전송한(request) 파일정보를 토대로
		// 우리가 만든 upload폴더(path)안에 maxSize만큼만 인코딩("UTF-8")을 적용해서 
		// 파일업로드를 수행할 수 있도록 만들어줌
		System.out.println("파일 업로드 성공!");
		
		// 전달받은 정보를 저장(이름, 메시지 출력)
		
// 		String name = request.getParameter("name");
 		String name = multi.getParameter("name");
// 		String msg = request.getParameter("msg");
		String msg = multi.getParameter("msg");
		
		System.out.println("이름 : " + name + ", 메시지 : " + msg);
		
// 		String file = multi.getParameter("file");
		String file = multi.getFilesystemName("file"); // 사용자가 업로드하고자 한 파일, fileUploadForm.jsp에서 넘어온 파일
		// => 서버에 저장되는 파일명 (중복파일 -> 이름 변경됨)
		String o_file = multi.getOriginalFileName("file"); // 실제로 서버에 업로드가 된 파일 시스템 네임을 가져온다.
		// => 원래 파일명
		
		System.out.println("파일명 : " + file); // 파일명
		System.out.println("파일명_o : " + o_file); // 실제파일명
	%>	
	
	<a href="fileDown1.jsp?file_name=<%=o_file%>"> 다운로드 페이지 이동1 </a> <!-- 파일다운로드하러 고고! -->
	<a href="../upload/<%=o_file%>"> 다운로드 페이지 이동2 </a>
	
</body>
</html>