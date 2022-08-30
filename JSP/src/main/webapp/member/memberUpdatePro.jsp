<%@page import="com.itwillbs.member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>memberUpdatePro.jsp</h1>
	<%
		// 로그인제어
		String id = (String) session.getAttribute("id");
		if(id == null){
			response.sendRedirect("loginForm.jsp");
		}
		
		// 한글 처리
		request.setCharacterEncoding("UTF-8");
	
		// 전달된 정보 저장 (수정할 데이터) - 액션태그
		%>
		<!-- MemberBean umb = new MemberBean(); -->
		<jsp:useBean id="umb" class="com.itwillbs.member.MemberBean" />
		<jsp:setProperty property="*" name="umb"/>
		
		수정할 정보 : <%=umb %>
		
		<%
			// DB에 가서 해당 회원의 정보를 수정
			
			// DAO 객체 생성
			MemberDAO dao = new MemberDAO();
		
			// 회원정보를 수정해주는 메서드 실행
			int result = dao.updateMember(umb);
			
			// result == 1, 0, -1
			if(result == 1) {
				// 수정성공
				// 메인페이지 이동
				%>
				 <script type="text/javascript">
					 alert('수정 성공!');
					 location.href="main.jsp";
				 </script>				
				<%
			}else if(result == 0){
				// 수정실패 - 비밀번호 오류
				// 페이지 뒤로가기
				%>
				 <script type="text/javascript">
				 	 alert("수정 실패 - 비밀번호 오류");
				 	 history.back();
				 </script>
				<%
			}else{ // result == -1
				// 수정실패 - 회원정보 오류
				// 페이지 뒤로가기
				%>
				 <script type="text/javascript">
				 	 alert("수정 실패 - 회원정보 오류");
				 	 history.back();
				 	 
				 </script>
				<%
			}
		%>


</body>
</html>