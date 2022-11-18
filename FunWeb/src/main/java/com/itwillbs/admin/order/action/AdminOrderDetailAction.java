package com.itwillbs.admin.order.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.admin.order.db.AdminOrderDAO;

public class AdminOrderDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(" M : AdminOrderDetailAction_execute() ");
		
		// 세션제어(관리자, 로그인)
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		ActionForward forward = new ActionForward();
		if(id == null || !id.equals("admin")) {
			forward.setPath("./MemberLogin.me");
			forward.setRedirect(true);
			return forward;
		}
				
		// 전달인자(trade_num) 저장
		String trade_num = request.getParameter("trade_num");
		
		// DAO 객체 - getAdminOrderDetail(trade_num)
		AdminOrderDAO dao = new AdminOrderDAO();
		
		// request 영역 저장
		request.setAttribute("adminOrderDetail", dao.getAdminOrderDetail(trade_num));
		
		// 페이지 이동 후 출력(./adminorder/admin_order_detail.jsp)
		forward.setPath("./adminorder/admin_order_detail.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
