package com.itwillbs.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.db.BoardDAO;
import com.itwillbs.db.BoardDTO;

public class BoardContentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(" M : BoardContentAction_execute() 호출");
		System.out.println(" M : 글목록(list.jsp)에서 글제목 눌렀을 때 내용을 보여주기위한 동작 중");
		
		// 전달정보(파라미터) 저장
		// boardList.jsp 에서 제목컬럼부분에 <a href="./BoardContent.bo?bno=${dto.bno}&pageNum=${pageNum}"> 
		// a링크 주소줄에서 물음표(?) 뒤에 bno와 pageNum를 입력하여 다음 페이지에 전달할 수 있도록 설정함.
		// 그래서 이 페이지에서 bno와 pageNum을 받는 중.
		int bno = Integer.parseInt(request.getParameter("bno")); // From boardList.jst
		String pageNum = request.getParameter("pageNum");
		
		System.out.println("M : bno : " + bno + ", pageNum : " + pageNum);
		
		// DAO 객체 생성
		BoardDAO dao = new BoardDAO();
		// 글 조회수 1증가 -> DAO 1증가 메서드 호출
		dao.updateReadcount(bno);
		System.out.println(" M : 조회수 1증가 완료!");
		
		// 글번호에 해당 글 정보를 가져오기
		BoardDTO dto = dao.getBoard(bno);
		
		// request 영역에 글정보를 저장
		request.setAttribute("dto", dto);
		request.setAttribute("pageNum", pageNum); // 지금은 넘겨주기만하기
		
		// 페이지 이동(준비)
		ActionForward forward = new ActionForward();
		forward.setPath("./board/boardContent.jsp"); // 해당 페이지가 글 제목눌렀을 때 글 내용 보여주는 동작페이지라서!
		forward.setRedirect(false); // .bo -> .jsp

		return forward; // 리턴값 forward를 통해 해당 페이지의 정보들을 담아서 컨트롤러로 이동한다. 
	}

}











































