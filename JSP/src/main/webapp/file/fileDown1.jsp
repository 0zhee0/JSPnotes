<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.FileInputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>fileDown1.jsp</h1>
	<%
		// 전달한 파일 이름 정보 저장
		String fileName = request.getParameter("file_name");
		
		// 서버에 업로드된 폴더명
		String savePath = "upload";
		
		// 서버에 업로드된 폴더의 실제 위치
		ServletContext CTX = getServletContext();
		String downloadPath = CTX.getRealPath(savePath);
		
		System.out.println("downloadPath : " + downloadPath);
		
		// 다운로드할 파일의 위치
		String filePath = downloadPath+ "\\" + fileName;
		System.out.println("filePath : " + filePath);
		
		/////////////////////////////////////////////////////////////
		// 파일을 다운로드할 준비
		
		// 파일을 한 번에 읽고/쓰기 배열
		byte[] b = new byte[4096]; //4KB : 데이터를 한 번에 4KB씩 읽겠다.
		
		// 파일 입력 스트림 객체(파일 열기)
		FileInputStream fis = new FileInputStream(filePath);
		
		// 다운로드할 파일의 MIME 타입 확인
		String MIMEType = getServletContext().getMimeType(filePath);
		System.out.println("MIMEType : " + MIMEType);	
		
		// MIME 타입의 값이 없을 경우 기본값으로 설정
		if(MIMEType == null){
			MIMEType = "application/octet-stream";
		}
		
		// 응답할 페이지의 형태를 MIME 타입의 형태로 변경
		response.setContentType(MIMEType);
		
		//////////////////////////////////////////////////////////////
		// ie - 한글처리
		
		// 사용자의 브라우저 정보 확인
		String agent = request.getHeader("User-Agent");
		
		// 문자열.indexOf("문자") : 문자가 포함되어 있을 때 해당 위치 index 리턴, 
		//								   불포함 되어 있을 때 -1 리턴
		boolean ieBrowser 
		= (agent.indexOf("MSIE") > -1) || (agent.indexOf("Trident") > -1);
		
		if(ieBrowser){
			// ie일 때
			fileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
		}else{
			// ie 아닐 때
			fileName = new String(fileName.getBytes("UTF-8"),"iso-8859-1");
		}
		
		// 한글 인코딩처리(파일명)
		
		// 모든 파일을 다운로드 형태로 처리
		response.setHeader("Content_Disposition", "attachment; filename="+fileName);
		
		// 기본생성되는 내장객체 out 처리
		out.clear();
		out = pageContext.pushBody();
	
		// 다운로드
		// 다운로드 하기 위한 준비 (통로 생성)
		ServletOutputStream out2 = response.getOutputStream(); // 출력 response를 통해서 출력하겠다.
		
		int data = 0;
		while((data = fis.read(b,0,b.length)) != -1){ // b : 배열
			out2.write(b,0,data);					  // -1 파일의 끝
		}
		
		// 배열을 사용하여 정보 전달(버퍼)
		// -> 배열의 빈공간에 공백을 채워서 정보 전달
		out2.flush();
		
		out2.close();
		fis.close();
	%>
</body>
</html>



