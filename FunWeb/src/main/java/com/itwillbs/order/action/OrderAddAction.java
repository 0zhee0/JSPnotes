package com.itwillbs.order.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		// 전달된 주문 정보 (배송지 결제)
				
		// 주문 상품정보 (장바구니 + 상품정보)
		
		// 결제 호출 (JAVA 코드)
		
		// 주문정보 저장
		
		// 메일, 문자 전송 (구현안한다고햇나,,?)
		new Thread(new Runnable() { // 익명의 객체로 만들어진 쓰레드
			public void run() {
				for(long i=0; i<100000000L; i++);
				System.out.println("메일 전송 완료!");
			}
		}).start();
		System.out.println("주문정보 저장완료!");
				
		// 상품 개수 수정(판매량)
		
		// 장바구니 정보 삭제
		
		// 페이지 이동
		
		return null;
	}

}
