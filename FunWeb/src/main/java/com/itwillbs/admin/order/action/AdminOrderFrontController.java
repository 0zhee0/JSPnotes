package com.itwillbs.admin.order.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.ao")
public class AdminOrderFrontController extends HttpServlet{

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(" C : doProcess() 호출 ");

		// 1. 가상주소 계산
		String requestURI = request.getRequestURI();
		System.out.println(" C : requestURI : " + requestURI);
		String ctxPath = request.getContextPath();
		System.out.println(" C : ctxPath : " + ctxPath);
		String command = requestURI.substring(ctxPath.length());
		System.out.println(" C : command : " + command);

		System.out.println(" C : 1. 가상주소 계산 끝 \n");
		Action action = null;
		ActionForward forward = null;
		
		
		// 2. 가상주소 매핑
		if(command.equals("/AdminOrderList.ao")) {
			System.out.println(" C : AdminOrderList.ao 호출 ");
			System.out.println(" C : [패턴3] ");
			
			// AdminOrderListAction()
			action = new AdminOrderListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/AdminOrderDetail.ao")) {
			System.out.println(" C : AdminOrderDetail.ao 호출 ");
			System.out.println(" C : [패턴3] ");
			
			//AdminOrderDetailAction()
			action = new AdminOrderDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/AdminOrderModify.ao")) {
			System.out.println(" C : AdminOrderModify.ao 호출 ");
			System.out.println(" C : [패턴2] ");
			
			//AdminOrderModifyAction()
			action = new AdminOrderModifyAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		System.out.println(" C : 2. 가상주소 매핑 끝");
		
		
		
		// 3. 페이지 이동
		if (forward != null) {
			if (forward.isRedirect()) { // true
				System.out.println(" C : sendRedirect() : " + forward.getPath());
				response.sendRedirect(forward.getPath());
			} else { // false
				System.out.println(" C : forward() : " + forward.getPath());
				RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
				dis.forward(request, response);
			}
			System.out.println(" C : 3. 페이지 이동 끝 \n");
		}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(" C : doGet() ");
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(" C : doPost() ");
		doProcess(request, response);
	}
	 

}
