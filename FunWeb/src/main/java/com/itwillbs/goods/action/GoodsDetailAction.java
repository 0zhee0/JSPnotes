package com.itwillbs.goods.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.admin.goods.db.GoodsDTO;
import com.itwillbs.goods.db.GoodsDAO;

public class GoodsDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println(" M : GoodsDetailAction_execute 호출");
		
		// 전달정보 저장(gno)
		int gno = Integer.parseInt(request.getParameter("gno"));
		
		// DAO - getGoods(gno)
		GoodsDAO dao = new GoodsDAO();
		GoodsDTO dto = dao.getGoods(gno); // 데이터 가져오기완. 이제 이 데이터를 저장하여 jsp페이지로 이동시킨다.
		
		// reqeust 영역에 저장
		request.setAttribute("dto", dto);
		
		// 페이지 이동 (./company/goods_detail.jsp)
		ActionForward forward = new ActionForward();
		forward.setPath("./company/goods_detail.jsp");
		forward.setRedirect(false);
		
		return forward;
	}
}
