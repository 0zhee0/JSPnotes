package com.itwillbs.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.db.BoardDAO;
import com.itwillbs.db.BoardDTO;

public class BoardReWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(" M : BoardReWriteAction_execute() 호출");
	
		// 한글처리(form-post방식) 생략
		
		// 전달 데이터 저장(pageNum, bno, re_ref, re_lev, re_seq, 
		//					subject, name, pass, content)
		
		String pageNum = request.getParameter("pageNum");
		
		BoardDTO dto = new BoardDTO();
		dto.setBno(Integer.parseInt(request.getParameter("bno")));
		dto.setRe_ref(Integer.parseInt(request.getParameter("re_ref")));
		dto.setRe_lev(Integer.parseInt(request.getParameter("re_lev")));
		dto.setRe_seq(Integer.parseInt(request.getParameter("re_seq")));
		dto.setSubject(request.getParameter("subject"));
		dto.setName(request.getParameter("name"));
		dto.setPass(request.getParameter("pass"));
		dto.setContent(request.getParameter("content"));
		
		dto.setIp(request.getRemoteAddr());
		
		// 전달받은 정보 다 작성했으면 답글 순서 재배치하고 답글 담기
		
		// DAO 객체 생성
		BoardDAO dao = new BoardDAO();
		dao.reInsertBoard(dto);
		
		// 답글 정보를 다 썼으니
		// 페이지 이동(정보 저장)
		ActionForward forward = new ActionForward();
		// BoardList로 이동할 때 pageNum 넘겨주기
		forward.setPath("./BoardList.bo?=pageNum="+pageNum);
		forward.setRedirect(true); // sendRedirect 방식 // [패턴1]이라서 true
			
		return forward;
	}

}






