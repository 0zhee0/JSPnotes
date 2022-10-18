package com.itwillbs.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.member.db.MemberDAO;

public class MemberLoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(" M : MemberLoginAction_execute() 호출");
		
		//  한글처리(필터)
		
		// 전달정보 저장(id.pw)
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println(" id, pw 값 전달 성공");
		
		// DAO 객체 생성 - 로그인 여부 체크메서드
		MemberDAO dao = new MemberDAO();	
		
		int result =  dao.memberLogin(id, pw);
		
		// 체크결과에 따른 페이지 이동(JS)		
		if(result == 0) {
			response.setContentType("text/html; charest=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print(" alert('비밀번호 오류!'); ");
			out.print(" history.back(); ");
			out.print("<script>");
			out.close();
			return null;
		}
		
		if(result == -1) {
			response.setContentType("text/html; charest=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print(" alert('회원 정보 없음!'); ");
			out.print(" history.back(); ");
			out.print("<script>");
			out.close();
			return null;
		}
		
		// result == 1
		// 로그인 성공 -> 아이디 세션영역에 저장
		// Session.setAttribute("id",id); => 에러발생!
		// 자바페이지라서 내장객체 정보 불러올 수 없음(그러므로 세션도 불러올 수 없음)
		HttpSession session = request.getSession(); // 세션 영역 객체 생성한 뒤에 session 내장 객체 불러 올 수 있음
		session.setAttribute("id", id);
		
		ActionForward forward = new ActionForward();
		forward.setPath("./Main.me");
		forward.setRedirect(true); // 가상주소에서 가상주소로의 이동이므로 sendRedirect 방식으로 이동
		
		return forward;
	}
}
