package com.itwillbs.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.db.BoardDAO;
import com.itwillbs.db.BoardDTO;

public class BoardUpateProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println(" M : BoardUpateProAction_execute() 호출");
		
		// post방식으로 전달받았으니까 한글처리(생략 => web.xml에 한글필터 걸어둠)
		// 전달된 데이터 저장(파라미터)
		// DTO 객체 생성
		BoardDTO dto = new BoardDTO();
		dto.setBno(Integer.parseInt(request.getParameter("bno"))); // 파라미터로 전달 받았으니 숫자를 문자열로 받았을거다 정수로 변환 필수
		dto.setName(request.getParameter("name"));
		dto.setSubject(request.getParameter("subject"));
		dto.setPass(request.getParameter("pass"));
		dto.setContent(request.getParameter("content"));		
		// 페이지넘버도 받아줘야한다.
		String pageNum = request.getParameter("pageNum");
		
		
		// DB에 가서 수정
		BoardDAO dao = new BoardDAO();
		int result = dao.updateBoard(dto);
		
		System.out.println(" M : 수정완료" + result);
		
		// 페이지 이동 (컨트롤러X -> 티켓생성X)
			// 컨트롤러 페이지에 forward 값이 null이 될 텐데 그러면 3단계에서 실행이 안될거다.
			// 왜 forward에 값 안 넣는지?
			// 액션페이지에서 자바스크립트로 움직일거다. history.back()할거다.
			// 뒤로가기(history.back())랑 주소쳐서 움직이는거랑 다른동작
			// 뒤로가기는 내 기록의 정보를 가지고 이동하는 것(컨트롤러x)
			// 근데 내가 주소를 쳐서 움직이는 것은 컨트롤러로 이동하는 동작임
			// 그럼 이 페이지에서 자바스크립트 쓸 수 있나? 아니.. 
			// JAVA 페이지에서 JSP/HTML 코드를 쓸 수 있나? 됩니다.. JSP폴더에 TestServlet1.java에서 참고
		// JS 사용 페이지 이동		
		
		response.setContentType("text/html; charset=UTF-8"); 
		// => 응답페이지의 형태를 html 형태로 사용하겠다는 말
		
		PrintWriter out = response.getWriter(); 
		// getWriter()는 글을 쓸 수있게 출력(out)해주는 메서드
		// => 응답페이지로 출력하는 통로를 준비
		// out.print("<h1>안녕 테스트</h1>");
		
		if(result ==1) { // 수정이 되었을 때
			out.print("<script>");
			out.print(" alert('수정 완료');");
			out.print(" location.href='./BoardList.bo?pageNum="+pageNum+"';"); // pageNum 위에 변수에 저장해둔 걸 가져갈거다.
			out.print("</script>");				// 여기서는 el표현식사용불가 => java코드형태로 접근 : (+)를 이용해 문자열을 서로 연결
			out.close();
			
			return null; // 더이상 아래로 실행없이 여기서 중단하고 컨트롤러 전달 
			
		} else if(result == 0) { // 비번오류
			out.print("<script>");
			out.print(" alert('비밀번호 오류! 수정 불가');");
			out.print(" history.back(); "); 
			out.print("</script>");				
			out.close();
			
			return null;
			
		} else { // result = -1
			out.print("<script>");
			out.print(" alert('게시판 글없음! 수정 붕가');");
			out.print(" history.back(); "); 
			out.print("</script>");				
			out.close();
			
			return null; 
		}		
	}
}
