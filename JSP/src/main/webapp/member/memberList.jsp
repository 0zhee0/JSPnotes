<%@page import="com.itwillbs.member.MemberBean"%>
<%@page import="javax.management.MBeanAttributeInfo"%>
<%@page import="java.util.ArrayList"%>
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
	<h1>memberList.jsp</h1>
	
	<h2>회원정보 목록</h2>
	
	<%
		// 로그인 체크 + 관리자 여부 체크
		String id = (String)session.getAttribute("id");
	
		if(id == null || !id.equals("admin")) {
			response.sendRedirect("loginForm.jsp");			
		} 
		
		// DB에 저장된 회원정보를 모두 가져오기
		
		// MemberDAO 객체 생성
		MemberDAO dao = new MemberDAO();
		
		// dao 객체 안에 회원정보 전부를 조회하는 메서드를 호출
		ArrayList memberList = dao.memberList();
			
		// 정보 출력
		System.out.println(memberList);		
	%>
	
	<table border="1">
		<tr>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이름</td>
			<td>나이</td>
			<td>성별</td>
			<td>이메일</td>
			<td>회원가입일</td>	
		</tr>
		
		<%	
			for(int i=0;i<memberList.size();i++){ 
				MemberBean mb = (MemberBean) memberList.get(i);
				
// 				if(mb.getId().equals("admin")){
// 					continue;
// 				}
			%>
		<tr>
			<td>아이디 : <%=mb.getId() %></td>
			<td>비밀번호 : <%=mb.getPw() %></td>
			<td>이름 : <%=mb.getName() %></td>
			<td>나이 : <%=mb.getAge() %></td>
			<td>성별 : <%=mb.getGender() %></td>
			<td>이메일 : <%=mb.getEmail() %></td>
			<td>회원가입일 : <%=mb.getRegdate() %></td>	
		</tr>
		<% }%>	
	</table>
	
	<a href="main.jsp"> 메인페이지 </a>

</body>
</html>