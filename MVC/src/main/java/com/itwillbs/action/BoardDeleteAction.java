package com.itwillbs.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.db.BoardDAO;
import com.itwillbs.db.BoardDTO;

public class BoardDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// action안에 있는 execute를 통해 실행하기
		System.out.println(" M : BoardDeleteAction_execute() 호출");
		
		// 전달된 파라미터 (bno, pass, pageNum)
		int bno = Integer.parseInt(request.getParameter("bno"));
		String pass = request.getParameter("pass");
		
		String pageNum = request.getParameter("pageNum");
		
		// BoardDAO 객체 생성 - 글삭제 메서드
		BoardDAO dao = new BoardDAO();
		
		int result = dao.deleteBoard(bno, pass);
	
		// 결과에 따른 페이지 이동 (JS)
		response.setContentType("text/html; charset=UTF-8");
        // => 응답 페이지의 형태를 html 형태로 사용
        
        PrintWriter out = response.getWriter();
        // => 응답페이지로 출력하는 통로를 준비
        
        if(result == 1) {
           out.print("<script>");
           out.print("alert('게시판 글 삭제 완료!');");
           out.print("location.href='./BoardList.bo?pageNum="+pageNum+"';");
           out.print("</script>");
           out.close(); // 리소스 해제
           
           return null; // 더 이상 실행 없이 컨트롤러로 전달
           
        } else if(result == 0) {
           out.print("<script>");
           out.print("alert('비밀번호를 다시 확인해주세요.');");
           out.print("history.back();");
           out.print("</script>");
           out.close(); // 리소스 해제
           
           return null; // 더 이상 실행 없이 컨트롤러로 전달
        } else { // result == -1
           out.print("<script>");
           out.print("alert('게시판 글이 없습니다..');");
           out.print("history.back();");
           out.print("</script>");
           out.close(); // 리소스 해제
           
           return null; // 더 이상 실행 없이 컨트롤러로 전달
        }	
	}
}
