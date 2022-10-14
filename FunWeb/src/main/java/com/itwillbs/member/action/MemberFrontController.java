package com.itwillbs.member.action;

import java.io.IOException;
import java.nio.channels.ClosedByInterruptException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberFrontController extends HttpServlet{
	
	protected void doProcess(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
			System.out.println("Member - doProcess() ");
			// mvc 패턴은 핵심적인 구조와 틀이 잘 잡혀있기때문에 여기서 포커스를 맞춰서 작업할 것
			// 그래야 스프링 프레임워크가서 구조 파악하는데 이해 정도가 높아질 것임
			
			// 1. 가상주소 계산
			String requestURI = request.getRequestURI();
			System.out.println(" C : requestURI : " + requestURI);
			String ctxPath = request.getContextPath();
			System.out.println(" C : ctxPath : " + ctxPath);
			String command = requestURI.substring(ctxPath.length());
			System.out.println(" C : command : " + command);
			
			System.out.println(" C : 1. 가상주소 계산 끝 ");
			
			Action action = null;	
			ActionForward forward = null;
			
			// 2. 가상주소 매핑(패턴 1,2,3)
			if(command.equals("/MemberJoin.me")) {
				System.out.println(" C : /MemberJoin.me 호출");
				System.out.println(" C : [패턴1] DB 사용X, view 이동");
				
				forward = new ActionForward();
				forward.setPath("./member/join.jsp");
				forward.setRedirect(false);	
			}
			else if(command.equals("/MemberJoinAction.me")) {
				System.out.println("C : /MemberJoinAction.me 호출");
				System.out.println("C : [패턴2] DB사용 O , 페이지 이동");
				
				// MemberJoinAction() 객체
				action = new MemberJoinAction();
				
				try {
					forward = action.execute(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			else if(command.equals("/MemberLogin.me")) {
				System.out.println(" C : /MemberLogin.me 호출 ");
				System.out.println(" C : [패턴1] DB 사용X, view 이동");
				
				forward = new ActionForward();
				forward.setPath("./member/login.jsp");
				forward.setRedirect(false); // .me(가상) -> .jsp(실제편집) 로 이동하는거라
			}
			else if(command.equals("/MemberIdCheck.me")) {
				System.out.println(" C : /MemberIdCheck.me 호출 ");
				// 중복체크 버튼 눌렀을 때 확인하고 다시 돌아올거다.
				// 단순히 뷰를 보여주는 것이므로 패턴 1
				System.out.println(" C : [패턴1] DB 사용X, view 이동");
				
				forward = new ActionForward();
				forward.setPath("./member/idCheck.jsp");
				forward.setRedirect(false); // .me(가상) -> .jsp(실제편집) 로 이동하는거라
			}
			else if(command.equals("/MemberIdCheckAction.me")) {
				System.out.println(" C : /MemberIdCheckAction.me 호출");
				System.out.println(" C : [패턴3] DB 사용O, view 페이지 출력");
				
				// MemberIdCheckAction() 객체 생성
				action = new MemberIdCheckAction();
				
				try {
					forward = action.execute(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(command.equals("/MemberLoginAction.me")) {
				System.out.println(" C : /MemberLoginAction.me 호출");
				System.out.println(" C : [패턴2] DB 사용O, 페이지 이동");
				
				// MemberLoginAction() 객체 생성
				action = new MemberLoginAction();
				
				try {
					forward = action.execute(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
				
				
			System.out.println(" C : 2. 가상주소 매핑(패턴 1,2,3) 끝 ");
				

			
			
			

			
// ----------------------------------------------------------------------------------------		
			// 3. 페이지 이동
			if(forward != null) {
				if(forward.isRedirect()) { // true
					System.out.println(" C : sendRedirect() : " + forward.getPath());
					response.sendRedirect(forward.getPath());
				}else { // false
					System.out.println(" C : forward() : " + forward.getPath());
					RequestDispatcher dis 
							= request.getRequestDispatcher(forward.getPath());
					dis.forward(request, response);
				}
				System.out.println(" C : 3. 페이지 이동 끝 ");
			}
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			System.out.println("Member - doGet() ");
			doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Member - doPost() ");
		doProcess(request, response);
	}
	
}
