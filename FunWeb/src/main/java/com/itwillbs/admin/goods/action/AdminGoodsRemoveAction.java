package com.itwillbs.admin.goods.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.admin.goods.db.AdminGoodsDAO;

public class AdminGoodsRemoveAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println(" M : AdminGoodsRemoveAction_execute 호출 ");
		// 로그인세션(생략)
		// 전달정보 저장
		int gno = Integer.parseInt(request.getParameter("gno"));
		
		// DAO - 삭제 메서드
		AdminGoodsDAO dao = new AdminGoodsDAO();
		
		dao.adminRemoveGoods(gno);
		
		// 페이지 이동
		ActionForward forward = new ActionForward();
		forward.setPath("./AdminGoodsList.ag");
		forward.setRedirect(true);
		return forward;
	}

}
