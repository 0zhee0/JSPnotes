package com.itwillbs.member.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.member.db.MemberDAO;
import com.itwillbs.member.db.MemberDTO;

public class MemberAdminAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(" M : MemberAdminAction_execute() 호출");
		
		// 관리자 로그인 체크
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		ActionForward forward = new ActionForward();
		if(id == null || !id.equals("admin")) { // id가 없거나 관리자가 아니면 이 페이지 사용못함
			forward.setPath("./MemberLogin.me");
			forward.setRedirect(true); // 가상주소에서 가상주소로의 이동
			return forward; 
			// 여기서는 왜 자바스크립트로는 이동하지 않나요?
			// => 관리자 계정이라 페이지 정보 노출없이 이동하려고..
		}
		
		// DAO - 회원정보 모두 가져오기(관리자제외)
		MemberDAO dao = new MemberDAO();
		List memberList = dao.getMemberList();
		
		// request 영역에 저장(view 전달)
		request.setAttribute("memberList", memberList);
		
		
		forward.setPath("./member/admin.jsp");
		forward.setRedirect(false);
		return forward;
	}
}
