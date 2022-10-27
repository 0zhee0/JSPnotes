package com.itwillbs.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 컨트롤러 => 서블릿
// @WebServlet("*.bo") : 주소가 ~~~~.bo 주소의 형태면 해당 컨트롤러 처리

@WebServlet("*.bo")
public class BoardFrontController extends HttpServlet{
   
	
	protected void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" BoardFrontController - doProcess() 호출");
		System.out.println(" GET / POST 방식 상관없이 한번에 처리 ");
		
		/////////////////////////1.가상주소계산////////////////////////////
		// URL => 웹 실행 주소
		// URI => URL - (프로토콜,IP,PORT번호)
		//System.out.println(request.getRequestURI());
		//System.out.println(request.getRequestURL());
		System.out.println(" C : (1단계 시작) 가상주소 계산 시작 ----------------------- ");
		String requestURI = request.getRequestURI();
		System.out.println(" C : requestURI : "+requestURI);
		
		String ctxPath = request.getContextPath();
		System.out.println(" C : ctxPath : "+ctxPath);
		
		String command = requestURI.substring(ctxPath.length());
		System.out.println(" C : command : "+command);
		
		System.out.println(" C : (1단계 끝) 가상주소 계산 완료 ----------------------- ");
		
		/////////////////////////1.가상주소계산////////////////////////////
		
		/////////////////////////2.가상주소매핑////////////////////////////
		System.out.println(" C : (2단계 시작) 가상주소 매핑 시작 ----------------------- ");
		
		Action action = null;
		ActionForward forward = null;
		
		if(command.equals("/BoardWrite.bo")) {
			System.out.println(" C : /BoardWrite.bo 호출");
			System.out.println(" C : [패턴1] DB사용 X, view페이지 이동");
			
			forward = new ActionForward();
			forward.setPath("./board/writeForm.jsp");
			forward.setRedirect(false);
		}
		else if(command.equals("/BoardWriteAction.bo")) {
			System.out.println(" C : /BoardWriteAction.bo  호출 ");
			System.out.println(" C : [패턴2] DB사용 O, 페이지 이동(화면전환)");
			
			// BoardWriteAction() 객체생성
			// 강한결합(결합도 높다)
			// => BoardWriteAction bwa = new  BoardWriteAction();
			// 약한결합(결합도 낮다)
			action = new  BoardWriteAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // BoardWriteAction.bo
		
		else if(command.equals("/BoardList.bo")){
			System.out.println(" C : /BoardList.bo 호출");
			System.out.println(" C : [패턴3] DB사용 O, VIEW 출력");
			
			// BoardListAction 객체 생성
			action = new BoardListAction();
			
			try {
				forward = action.execute(request, response); // 실행의 결과는 항상 forward
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // BoardList.bo
		else if(command.equals("/BoardContent.bo")) {
			System.out.println(" C : /BoardContent.bo 호출");
			System.out.println(" C : [패턴3] DB사용 O, VIEW 출력");
			
			// BoardContentAction 객체 생성
			action = new BoardContentAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		} // BoardContent.bo
		
		else if(command.equals("/BoardUpdate.bo")) { // boardContent에서 수정버튼 눌렀을 때
			System.out.println(" C : /BoardUpdate.bo 호출");
			System.out.println(" C : [패턴3] DB사용 O, VIEW 출력");
						// update페이지이동하면서 화면에 뷰가 보여져야하는데 DB도 써야한다. => 패턴3
			
			// BoardUpdateAction 객체 생성
			action = new BoardUpdateAction();
			
			try {
				forward = action.execute(request, response);
				// action.execute을 호출시켜 티켓만들었으면 forward로 받을 준비
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}// BoardUpdate.bo
		
		else if(command.equals("/BoardUpateProAction.bo")) {
			System.out.println(" C : /BoardUpateProAction.bo 호출");
			System.out.println(" C : [패턴2] DB사용 O, 페이지이동(화면전환)");
			
			// BoardUpdateProAction 객체 생성
			action = new BoardUpateProAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}// BoardUpateProAction.bo
		
		else if(command.equals("/BoardDelete.bo")) {
			System.out.println(" C : /BoardDelete.bo 호출");
			System.out.println(" C : [패턴1] DB사용 X, VIEW 페이지 이동");
			
			forward = new ActionForward();
			forward.setPath("./board/deleteForm.jsp");  
			forward.setRedirect(false); // 포워딩이유? 지금 현재 실행되는 주소는 .bo인데 
										//			   실제 이동해야하는 주소는 .jsp라서!
										// 주소는 안 바뀌면서 화면은 바뀌는 forwarding 사용
		}// BoardDelete.bo
		
		else if(command.equals("/BoardDeleteAction.bo")) {
			System.out.println(" C : /BoardDeleteAction.bo 호출");
			System.out.println(" C : [패턴2] DB사용 O, 페이지이동(화면전환)");
			
			// BoardDeleteAction 객체 생성
			action = new BoardDeleteAction();
			
			try {
				forward = action.execute(request, response); // 다형성의 설계에 맞춰서 구현
							// 다형성 안쓴다고 문제가 생기는 건 아니지만 미리 연습하는 것임
							// BoardDelteAction.java로 이동하여 action안에 있는 execute 실행하기
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//BoardDeleteAction.bo
		
		else if(command.equals("/BoardReWrite.bo")) {
			System.out.println(" C : /BoardReWriter.bo 호출");
			System.out.println(" C : [패턴1] DB사용 X, VIEW 페이지 이동"); // 그냥 글쓰기랑 똑같음
			
			forward = new ActionForward();
			forward.setPath("./board/reWriteForm.jsp");
			forward.setRedirect(false); // forwarding 하기
			
		} // BoardReWriter.bo
		
		else if(command.equals("/BoardReWriteAction.bo")) {
			System.out.println(" C : /BoardReWriteAction.bo 호출");
			System.out.println(" C : [패턴2] DB사용 O, 페이지이동(화면전환)");
			
			// BoardReWriteAction() 객체 생성 - execute()	
			try {
				 action  = new BoardReWriteAction(); // try 안에있거나 밖에있거나 상관없다.
				 		// 어차피 예외가 발생하지 않는 코드라는 걸 알아서 try밖에서 썼던거다.
				 		// 애매하면 그냥 넣으면 되는거고 이거는 어차피 여기 넣어서쓰던 상관없다.
				 forward = action.execute(request, response); 
				
//				forward = new BoardReWriteAction().execute(request, response);
				// 이 형태도 실행은 되는데 안 쓰는게 좋다
				// 왜? 왜 기존의 두 줄짜리 형태를 써야할까? 
				// 1. 업캐스팅 약한결합을 하기위해
				// 2. new BoardReWriteAction()는 가비지 (메모리를 쓰고는 있는데 더 이상 접근하지 못하는 애들)
				// 	  new BoardReWriteAction().execute는 실행하고나면 더 이상 못쓴다. 한 번밖에 못쓴다.
				//    메모리에 쓸 데 없이 차지하고 있는거다. 
				// => 나쁜 코드 호출 형태(가비지 생성)
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} // BoardReWriteAction.bo	
		
		else if(command.equals("/BoardFileWrite.bo")){
			System.out.println(" C : /BoardFileWrite.bo 호출 ");
			System.out.println(" C : [패턴1] DB사용 X, view페이지 이동");
			
			forward = new ActionForward();
			forward.setPath("./board/fWriteForm.jsp"); // 뷰만들기
			forward.setRedirect(false);
		} //BoardFileWrite.bo
		
		else if(command.equals("/BoardFileWriteAction.bo")) {
			System.out.println(" C : /BoardFileWriteAction.bo 호출 ");
			System.out.println(" C : [패턴2] DB사용 O, 페이지 이동(화면전환)");
			
			// BoardFileWriteAction() 객체 생성
			action = new BoardFileWriteAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} //BoardFileWriteAction.bo
		
		System.out.println(" C : (2단계 끝) 가상주소 매핑 완료 ----------------------- ");
		/////////////////////////2.가상주소매핑////////////////////////////
		
		/////////////////////////3.페이지 이동////////////////////////////
		System.out.println(" C : (3단계 시작) 페이지 이동 시작 ----------------------- ");
		
		if(forward != null) { // 이동정보가 있을때(티켓이 있을때)
			
			if(forward.isRedirect()) { //true
				System.out.println(" C : 이동방식 : "+forward.isRedirect()+",주소 : "+forward.getPath());
				response.sendRedirect(forward.getPath());
				
			}else {// false
				System.out.println(" C : 이동방식 : "+forward.isRedirect()+",주소 : "+forward.getPath());
				
				RequestDispatcher dis 
				      = request.getRequestDispatcher(forward.getPath());
				dis.forward(request, response);				
			}
			
		}
		
		
		
		
		
		System.out.println(" C : (3단계 끝) 페이지 이동 완료 ----------------------- ");
		/////////////////////////3.페이지 이동////////////////////////////
		
		
	}// doProcess
	
	// http://localhost:8088/MVC/board  (web.xml 매핑)
	// http://localhost:8088/MVC/board2 (어노테이션)
	// alt shift s + v
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("\n\n BoardFrontController - doGet() 호출");
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("\n\n BoardFrontController - doPost() 호출");
		doProcess(request, response);
	}
	
	

}
