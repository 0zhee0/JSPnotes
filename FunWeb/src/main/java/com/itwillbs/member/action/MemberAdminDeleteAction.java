package com.itwillbs.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.member.db.MemberDAO;

public class MemberAdminDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(" M : MemberAdminDeleteAction_execute() 호출");
		
		// 세션제어(admin)
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		ActionForward forward = new ActionForward();
		if(id == null || !id.equals("admin")) {
			forward.setPath("./MemberLogin.me");
			forward.setRedirect(true);
			return forward;
		}
		
		// 전달정보 저장
		String delID = request.getParameter("id");
		
		// DAO - adminMemberDelete(ID)
		MemberDAO dao = new MemberDAO();
		dao.adminMemberDelete(delID);
		
		// 페이지 이동
		forward.setPath("./MemberAdmin.me");
		forward.setRedirect(true);
		
		return forward;
	}

}
