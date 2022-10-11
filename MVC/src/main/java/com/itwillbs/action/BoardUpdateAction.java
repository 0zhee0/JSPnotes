package com.itwillbs.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.db.BoardDAO;
import com.itwillbs.db.BoardDTO;

public class BoardUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(" M : ################################");
		System.out.println(" M : BoardUpdateAction_execute() 호출");
		
		// update직전페이지는 content페이지 (페이지 이동한거네 / 이동할 페이지에 정보 전달)
		// BoardUpdate.bo?bno=91&pageNum=1
		// 페이지 전달정보 저장
		int bno = Integer.parseInt(request.getParameter("bno"));
		String pageNum = request.getParameter("pageNum");
		
		// BoardDAO 객체 생성
		BoardDAO dao = new BoardDAO();
		
		// DB에 저장된 수정할 글번호를 가져와서 
		BoardDTO dto = dao.getBoard(bno);
		
		// request 영역에 저장
		request.setAttribute("dto", dto); // dto라는 이름으로 dto를 보낼거다.
		request.setAttribute("pageNum", pageNum);
		
		// view 출력(./board/updateForm.jsp)
		// 페이지 이동(티켓)
		ActionForward forward = new ActionForward();
		forward.setPath("./board/updateForm.jsp");
		forward.setRedirect(false); // 정보를 가져가면서(화면전환은하면서)
									// 주소는 이동하지 않아야하기때문에
		
		return forward;
	}

}
