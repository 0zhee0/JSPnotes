<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1> JSP 파일2 </h1>
	<!-- HTML + JAVA 코드 -->
	
	<script type="text/javascript">
		// javascript 주석문
	</script>

	<%
	 // 스크립틀릿 (퍼센트 태그) - Java 코드 작성
	 
	 // 한 줄짜리 주석
	 
	 /*
	 	여러 줄짜리 주석
	 	1. 여러 줄짜리 주석 언제써? 
	 	2. 이전 코드 남겨놓고 싶을 때(내 코드 상용화 전에 주로 사용), 다른 방식의 코드를 보관해놓고 싶을 때
	 	3. 내 코드 설명
	 */
	 
	 // ctrl + alt + 방향키 아래 : 복사해서 붙여넣기 동시에 가능
	 // ctrl + d => 코드라인 삭제
	 // ctrl + shift + c => 코드라인 주석 설정/해제
	 
	 System.out.println("1");
	 System.out.println("2");
	 System.out.println("3");
	 System.out.println("4");
	 System.out.println("5");
	 
	 // 화면(view)에 출력 => HTML 코드
	 out.println("아이티윌<br>");
	 out.println("아이티윌<br>");
	 out.println("아이티윌<br>");
	 out.println("아이티윌<br>");
	 out.println("아이티윌"+"<br>");
	 

// bit : 0/1을 표현하는 공간
// 1 byte <=> 8 bit
// 1 KB <=> 1024 byte
// 1 MB <=> 1024*1024 byte
	 
	 
// 	  기본형 타입 - 8개

// 	 논리형
// 	 boolean - 1 byte
// 	 문자형
// 	 char - 2 byte
// 	 정수형
// 	 byte - 1 byte
// 	 short - 2 byte
// 	 int - 4 byte
// 	 long - 8 byte
// 	 실수형
// 	 float - 4 byte
// 	 double - 8 byte
	
	// 반복문 - for
// 	for (초기식; 조건식; 증감식){
// 		반복할 코드;
// 	}

	for(int i=0;i<20;i++){
		out.println("울산" + (i + 1) + "<br>");
	}
	
	%>
		부산 부산 부산 부산

	
	<%
	 // JSP 영역
	for(int i =0; i<5;i++){
	%>	
		<!-- HTML 영역-->	
		<h1>@@@</h1>
	<%	
	 // JSP 영역
	}
	%>
	
		
	
	
	
</body>
</html>