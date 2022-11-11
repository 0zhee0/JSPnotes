package com.itwillbs.order.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.basket.db.BasketDAO;
import com.itwillbs.member.db.MemberDAO;
import com.itwillbs.member.db.MemberDTO;

public class OrderStartAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(" M : OrderStartAction_execute() ");
		
		// 사용자 정보(세션제어)
		HttpSession session = request.getSession();
		String id =  (String) session.getAttribute("id");
		
		ActionForward forward = new ActionForward();
		if(id == null) {
			forward.setPath("./MemberLogin.me");
			forward.setRedirect(true);
			return forward;
		}
		
		// 구매 정보(장바구니 정보)
		BasketDAO bkDAO = new BasketDAO();
		
		Vector totalList =  bkDAO.getBasketList(id);
		ArrayList basketList = (ArrayList) totalList.get(0);
		ArrayList goodsList = (ArrayList) totalList.get(1);		
		
		// 사용자 정보
		MemberDAO mDAO = new MemberDAO();
		MemberDTO memberDTO = mDAO.getMember(id);
		
		// 저장해서 view출력
		request.setAttribute("basketList", basketList);
		request.setAttribute("goodsList", goodsList);
		request.setAttribute("memberDTO", memberDTO);
		
		// ./order/goods_buy.jsp	페이지 이동
		forward.setPath("./order/goods_buy.jsp");
		forward.setRedirect(false);	
		
		return forward;
	}

}
