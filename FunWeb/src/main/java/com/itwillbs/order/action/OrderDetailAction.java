package com.itwillbs.order.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.order.db.OrderDAO;

public class OrderDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println(" M : OrderDetailAction_execute() 호출");
		
		// 세션제어
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		ActionForward forward = new ActionForward();
		if(id == null) {
			forward.setPath("./MemberLogin.me");
			forward.setRedirect(true);
			return forward;
		}
		
		// 전달정보 (trade_num) 저장
		String trade_num = request.getParameter("trade_num");
		
		// OrderDAO - 주문번호에 상품 조회
		// orderDetail(trade_num)
		OrderDAO orDAO = new OrderDAO();
		
		// request 영역 저장
		request.setAttribute("orderDetail", orDAO.orderDetail(trade_num));
		
		// 페이지 이동(./order/order_detail.jsp)
		forward.setPath("./order/order_detail.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
