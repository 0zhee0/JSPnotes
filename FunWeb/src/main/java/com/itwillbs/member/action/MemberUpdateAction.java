package com.itwillbs.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.member.db.MemberDAO;
import com.itwillbs.member.db.MemberDTO;

public class MemberUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(" M : MemberUpdateAction_execute() 호출");
		
		// 세션제어
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		ActionForward forward = new ActionForward(); // 여기서 바로 움직일 수 있게 해야된다.
		if(id == null) {
			forward.setPath("./Main.me");
			forward.setRedirect(true);		
			return forward; // return 동작이 execute 문을 종료시킨다.
		}
		
		// DAO - 기존의 회원정보 가져오기(getMember(ID))
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.getMember(id);
		
		// 정보 request 영역 저장
		request.setAttribute("dto", dto);
		
//		request.setAttribute("dto", dao.getMember(id)); =>아래 두 줄을 한 줄로 간단하게 만드는 코드임
		// => MemberDTO dto = dao.getMember(id);
		// => request.setAttribute("dto", dto); 
		
		// 페이지 이동
		forward.setPath("./member/update.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
