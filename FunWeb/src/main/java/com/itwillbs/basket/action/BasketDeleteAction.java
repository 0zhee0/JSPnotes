package com.itwillbs.basket.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.basket.db.BasketDAO;

public class BasketDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(" M : BasketDeleteAction_execute() ");
		
		// 세션값 제어
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		ActionForward forward = new ActionForward();
		if(id == null) {
			forward.setPath("./MemberLogin.me");
			forward.setRedirect(true);
			return forward;			
		}
		
		// 전달정보 저장(b_num)
		int b_num = Integer.parseInt(request.getParameter("b_num"));
		
		// DAO - 장바구니 삭제(b_num)
		BasketDAO dao = new BasketDAO();
		int result = dao.deleteBasket(b_num);
		
		if(result == 1) {
			System.out.println(" M : 장바구니 삭제 완료! ");
		}
		
		// 페이지 이동(BasketList.ba)
		forward.setPath("./BasketList.ba");
		forward.setRedirect(true);
		
		return forward;
	}

}
