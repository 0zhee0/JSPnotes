package com.itwillbs.basket.action;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.basket.db.BasketDAO;

public class BasketListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(" M : BasketListAction_execute() ");
		
		// 로그인 체크
		// 세션제어(id)
				HttpSession session = request.getSession();
				String id = (String) session.getAttribute("id");
				
				ActionForward forward = new ActionForward();
				if(id == null) {
					forward.setPath("./MemberLogin.me");
					forward.setRedirect(true);
					return forward;			
				}	
		
		// BasketDAO - 장바구니 정보 (구매 옵션-상품번호, 구매수량, 사이즈, 컬러, 구매자)
		// => 로그인한 사용자의 장바구니 정보를 가져오기
		// GoodsDAO - 상품명,가격,이미지
							// => 장바구니에 들어있는 상품의 정보를 가져오기
		// (MemberDAO - 유저정보)
//		MemberDAO mdao = new MemberDAO();
//		mdao.getMember(id);		
				
		BasketDAO dao = new BasketDAO();
		Vector totalList = dao.getBasketList(id); // 로그인한 사용자가 전제조건이니까 실행할 때 id를 가져가게 하자 
		
//		System.out.println(" M : " + totalList);
		
		// request 영역에 저장
		// request.setAttribute("totalList", totalList);
		// totalList.basketlist.basketDTO.b_g_num
		
		request.setAttribute("basketList", totalList.get(0));
		request.setAttribute("goodsList", totalList.get(1));
		
		
		// 페이지 이동(./basket/basket_list.jsp)	
		forward.setPath("./basket/basket_list.jsp");
		forward.setRedirect(false);
		
		return forward;
	}
}
