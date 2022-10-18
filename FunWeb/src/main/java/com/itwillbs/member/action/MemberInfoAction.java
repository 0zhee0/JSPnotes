package com.itwillbs.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.member.db.MemberDAO;
import com.itwillbs.member.db.MemberDTO;

public class MemberInfoAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(" M : MemberInfoAction_execute() 호출");
		
		// 세션 제어 ( 로그인이 안되어있다면 로그인이 되도록 제어해야한다.)
		HttpSession session = request.getSession(); // 여기서 session 영역 객체 선언 후에 사용가능
		String id = (String) session.getAttribute("id");
		
		ActionForward forward = new ActionForward(); // 여기서 바로 움직일 수 있게 해야된다.
		if(id == null) {
			forward.setPath("./Main.me");
			forward.setRedirect(true);		
			return forward; // return 동작이 execute 문을 종료시킨다.
		}
		
		// DAO - 회원정보 가져오는 메서드(getMember(ID) : 실행할 때 정보하나 받아가야겠다.)
			// getMember() 메서드에서는 비밀번호가 필요할까? 아니!
			// 위에 세션제어를 하게되면 이미 아이디 비번을 알고 있다는 말이다.
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.getMember(id);
		
		// 정보를 뷰에 전달하기위해 request 영역에 저장
		request.setAttribute("dto", dto);
		
		// ./member/info.jsp 페이지 이동
		forward.setPath("./member/info.jsp");
		forward.setRedirect(false);
		return forward;
		
	}
}
