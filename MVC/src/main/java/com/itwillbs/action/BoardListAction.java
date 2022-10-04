package com.itwillbs.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.db.BoardDAO;

public class BoardListAction implements Action {
	
	// alt shift s + v
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(" M : BoardListAction_execute() 호출");
		
		// BoardDAO 객체 생성
		BoardDAO dao = new BoardDAO(); // 이것도 강한결합임 인터페이스 안쓰고 이렇게 쓰는 이유는 근데 지금 안알랴줌 프레임워크가서 알려줄것임
		
		// 게시판 전체 글 개수 확인
		int cnt = dao.getBoardCount(); // 변수 맞추기
		
		System.out.println(" M : 전체 글 개수 : " + cnt + "개"); // 변수 맞추기
		
		////////////////////////////////////////////////////////////////////////////////////////////////
		// 페이징 처리 (1)
		
		// 한 페이지에 보여줄 글의 개수를 설정
		int pageSize = 10;
		
		// http://localhost:8088/JSP/board/boardList.jsp?pageNum=2
		
		// 한 페이지가 몇페이지인지 확인
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null){
			pageNum = "1";
		}
		
		// 시작행 번호 계산하기  1  11	21	31	41 ....
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage-1)*pageSize+1;
		
		// 끝행 번호 계산하기  10  20  30  40  50
		int endRow = currentPage*pageSize;
		////////////////////////////////////////////////////////////////////////////////////////////////
		
		// 디비에 전체 글 리스트 가져오기
		ArrayList boardListAll= dao.getBoardList(); 
					// 글정보를 저장한 어레이리트스를 리턴할거라서 ArrayList 객체에 저장하기
//		System.out.println(" M : " + boardListAll); // 웬만하면 주석처리하기
													// 콘솔에 글 내용 다보여서 자리 x
		
		//////////////////////////////////////////////////////////////////////////////////////
		// 페이징 처리 (2)
		
//		if(cnt != 0){ // 글이 있을 때 => 아래에 request.setAttribute("pageCount", pageCount) 하려고 중복되는 변수이름 제거하기위해 if문 주석처리하기
						// 변수를 if문안에있을때만 쓸 수 있으니까 if문밖에서도 쓰려고
			// 총 페이지 = 글개수(총량) / 페이지당 출력
			//		=> 만약에 나머지가 있을 때 페이지 1개 추가
			
			// 전체 페이지수 // 변수 맞추기
			int pageCount = (cnt/pageSize)+(cnt%pageSize==0? 0:1); // 삼항연산 A? 참이면 true:false ==> 0:1
			
			// 한 화면에 보여줄 페이지수 (화면에 나타나는 페이지 인덱스 개수)
			int pageBlock = 2;
			
			// 페이지블럭의 시작번호	1~10 => 1, 11~20 => 11, 21~30 => 21
			int startPage = ((currentPage-1)/pageBlock)*pageBlock+1;
			
			// 페이지블럭의 끝번호
			int endPage = startPage+pageBlock-1;
			
			if(endPage > pageCount){
				endPage = pageCount;
			}
//		}
		//////////////////////////////////////////////////////////////////////////////////////
		
		
		// 직접출력 -> 위임(대신출력) : view (.jsp 페이지)에서 출력
		// Action -> jsp 페이지 정보 전달 (둘의 연결고리인 request 영역객체에 저장)
		request.setAttribute("boardListAll", boardListAll); // 디비에 가져온 걸 어레이리스트에 담아서 출력하겠다.
//		request.setAttribute("boardListAll", dao.getBoardList()); // 디비에서 가져온 걸 그대로 토스하겟다.
		
		// 페이징처리 정보 저장 // 객체에 따로 저장도 가능 우리가 dto처럼 다른 객체에 담아서 사용도 할 수 있다.
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("totalCnt", cnt);
		request.setAttribute("pageCount", pageCount); // 페이징처리2번에 if문 주석처리(삭제가능)하기 // 전역 변수로 지정하기위해
		request.setAttribute("pageBlock", pageBlock); 
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		// 페이지 이동준비(티겟 생성)
		// ./board/boardList.jsp 로 이동
		ActionForward forward = new ActionForward();
		forward.setPath("./board/boardList.jsp");
		forward.setRedirect(false); 
							// forward방식으로 이동하는 이유?
							// 1번) request를 담아서 갈거라서 얘를 담아서 이동할 수 잇는 방법은 foward밖에 없다.
							// 2번 )주소는 .bo -> .jsp 로 이동해야하는데
							// 주소는 바뀌지 않으면서 화면만 이동할 수 있는 방식인 forward 사용
		
				
		return forward;
		}
		}


