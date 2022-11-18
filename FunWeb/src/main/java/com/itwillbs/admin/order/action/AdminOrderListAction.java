package com.itwillbs.admin.order.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.admin.order.db.AdminOrderDAO;


public class AdminOrderListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(" M : AdminOrderListAction_execute() ");
		
		// 세션제어(관리자/로그인)
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		ActionForward forward = new ActionForward();
		if(id == null || !id.equals("admin")) {
			forward.setPath("./MemberLogin.me");
			forward.setRedirect(true);
			return forward;
		}
		
		// AdminOrderDAO - adminOrderList()
		AdminOrderDAO dao = new AdminOrderDAO();
		
		// request 영역에 저장
		request.setAttribute("adminOrderList", dao.adminOrderList());
		
		// 페이지 이동 후 출력(./adminorder/admin_order_list.jsp)
		 forward.setPath("./adminorder/admin_order_list.jsp");
		 forward.setRedirect(false);
		 
		return forward;
	}

}
