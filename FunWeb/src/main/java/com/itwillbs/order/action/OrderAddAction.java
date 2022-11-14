package com.itwillbs.order.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.basket.db.BasketDAO;
import com.itwillbs.goods.db.GoodsDAO;
import com.itwillbs.order.db.OrderDAO;
import com.itwillbs.order.db.OrderDTO;

public class OrderAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println(" M : OrderAddAction_execute() ");
		
		// 세션제어(로그인체크)
		HttpSession session = request.getSession();
		String id =  (String) session.getAttribute("id");
		
		ActionForward forward = new ActionForward();
		if(id == null) {
			forward.setPath("./MemberLogin.me");
			forward.setRedirect(true);
			return forward;
		}
		
		// 한글처리(생략)
		// 전달된 주문 정보( 배송지+결제 )
		// (배송받는 사람,주소(1,2), 전화번호,메모,
		//   구매방법,구매자) + id
		OrderDTO orDTO = new OrderDTO();
		
		orDTO.setO_r_name(request.getParameter("o_r_name"));
		orDTO.setO_r_addr1(request.getParameter("o_r_addr1"));
		orDTO.setO_r_addr2(request.getParameter("o_r_addr1"));
		orDTO.setO_r_phone(request.getParameter("o_r_phone"));
		orDTO.setO_r_msg(request.getParameter("o_r_msg"));
		orDTO.setO_trade_payer(request.getParameter("o_t_payer"));
		orDTO.setO_trade_type(request.getParameter("o_t_type"));
		orDTO.setO_m_id(id);
		
		System.out.println(" M : " + orDTO);

		// 주문 상품정보 (장바구니 + 상품정보)
		BasketDAO bkDAO = new BasketDAO();
		List totalList = bkDAO.getBasketList(id);
		
		// 장바구니 정보
		ArrayList basketList = (ArrayList)totalList.get(0);
		
		// 상품정보
		ArrayList goodsList = (ArrayList)totalList.get(1);
			// 디비에서 꺼내오면 되니까 굳이 파라미터로 넘겨줄 필요없음
			// 디비에서 가지고 오는 게 시간이 더 빠르다.

		
		// 결제 호출 (JAVA코드)
		System.out.println(" M : 결제 처리 완료! ");
		
		// 주문정보 저장(구매한 상품 + 배송 + 주문)
		
		OrderDAO orDAO = new OrderDAO();
		orDAO.addOrder(orDTO, basketList, goodsList);
		
		// 메일,문자 전송
		new Thread(new Runnable() {
			public void run() {
				for(long i=0;i<1000000000000000L;i++);
				System.out.println(" M : 메일 전송 완료");
			}
		}).start();

		System.out.println(" 주문정보 저장완료! ");
		
		// 상품 개수 수정(판매량)
		GoodsDAO gdao = new GoodsDAO();
		gdao.updateAmount(basketList);
		
		// 장바구니 정보 삭제
		bkDAO.deleteBasket(id);
		
		// 페이지 이동
		forward.setPath("./OrderList.or");
		forward.setRedirect(true);
		
		return forward;
	}

}
