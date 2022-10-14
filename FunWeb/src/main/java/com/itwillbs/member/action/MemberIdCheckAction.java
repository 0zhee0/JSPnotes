package com.itwillbs.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.member.db.MemberDAO;

public class MemberIdCheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println(" M : MemberIdCheckAction_execute() 호출 ");
		
		//  한글처리(필터)
		
		// 전달정보 저장(userid)
		String userid = request.getParameter("userid");
		System.out.println(" M : userid : " + userid);
		
		// DB에 확인 -> DAO 생성 - 체크 메서드 호출
		MemberDAO dao = new MemberDAO();
		int result = dao.memberIdCheck(userid);
		
		if(result == 1) {
			System.out.println(" M : 아이디 중복, 사용불가");
		}else { // result == 0
			System.out.println(" M : 아이디 중복X, 사용가능");
		}
		
		// Action정보 -> JSP페이지 전달
		request.setAttribute("result", result);	
		
		// 페이지 이동(준비)
		ActionForward forward = new ActionForward();
		forward.setPath("./member/idCheck.jsp?inputID="+userid); // 아이디 받아서 jsp파일에 출력된 상태가 되기
		forward.setRedirect(false);
		
		return forward;
	}

}
