package com.itwillbs.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.db.BoardDAO;
import com.itwillbs.db.BoardDTO;

public class BoardWriteAction implements Action {

	// 글쓰기 동작 수행하는 객체
	@Override
	public ActionForward execute(HttpServletRequest request,
							HttpServletResponse response) throws Exception {
		
		System.out.println(" M : BoardWriteAction_execute() 호출 ");
		
		// 한글처리
		// request.setCharacterEncoding("UTf-8");
		
		// 전달정보 (파라메터 저장)
		BoardDTO dto = new BoardDTO();
		
		dto.setSubject(request.getParameter("subject"));
		dto.setName(request.getParameter("name"));
		dto.setPass(request.getParameter("pass"));
		dto.setContent(request.getParameter("content"));
		
		// ip 저장
		dto.setIp(request.getRemoteAddr());
		
		System.out.println(" M : " + dto);
		
		// BoardDAO 객체 
		BoardDAO dao = new BoardDAO();
		
		// insertBoard()
		dao.insertBoard(dto);
			
		// 페이지 이동정보 생성(티켓 생성)
		ActionForward forward = new ActionForward();
		forward.setPath("./BoardList.bo");
		forward.setRedirect(true);
		
		return forward;
	}

}
