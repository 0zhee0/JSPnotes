package com.itwillbs.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberLogoutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(" M : MemberLogoutAction_execute() 호출");
		
		// 로그아웃(세션정보 초기화)
		HttpSession session = request.getSession();
		session.invalidate();
		
		// 페이지이동
		ActionForward forward = new ActionForward();
		forward.setPath("./Main.me");
		forward.setRedirect(true);
		
		return forward;
	}

}
