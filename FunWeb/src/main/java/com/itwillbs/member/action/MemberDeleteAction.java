package com.itwillbs.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.member.db.MemberDAO;

public class MemberDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(" M : MemberDeleteAction_execute() 호출");
		
		// 전달정보 저장
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// DAO - 회원정보 삭제 (deleteMember())
		MemberDAO dao = new MemberDAO();
		int result = dao.deleteMember(id, pw);
		
		// 페이지 이동 (JS)
		response.setContentType("text/html; charset=UTF-8"); 
		// => 응답페이지의 형태를 html 형태로 사용하겠다는 말
		
		PrintWriter out = response.getWriter(); 
		// getWriter()는 글을 쓸 수있게 출력(out)해주는 메서드
		// => 응답페이지로 출력하는 통로를 준비
		
		if(result== -1) { // 회원정보가 없음
			out.print("<script>");
			out.print("alert('회원정보가 없음!');");
			out.print("history.back();");
			out.print("</script>");
			out.close();
			
			return null;
			
		}else if (result == 0){ // 비번오류
			out.print("<script>");
			out.print(" alert('비밀번호 오류! 수정 불가');");
			out.print(" history.back(); "); 
			out.print("</script>");				
			out.close();
			
			return null;
				
		}else { // result == 1
			// 세션 초기화
			HttpSession session = request.getSession();
			session.invalidate();
			
			out.print("<script>");
			out.print(" alert('회원정보 삭제완료!');");
			out.print(" location.href='./MemberInfo.me'; "); // pageNum 위에 변수에 저장해둔 걸 가져갈거다.
			out.print("</script>");				
			out.close();
			
			return null; 			
		}			
	}
}
