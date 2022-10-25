package com.itwillbs.admin.goods.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.admin.goods.db.AdminGoodsDAO;
import com.itwillbs.admin.goods.db.GoodsDTO;


public class AdminGoodsListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(" M : AdminGoodsListAction_execute() 호출 ");
		
		// 관리자만 볼 수 있는 페이지니까 세션제어 해줘야함
		// 세션제어(관리자여부)
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		ActionForward forward = new ActionForward();
		if(id == null || !id.equals("admin")) {
			forward.setPath("./Main.me");
			forward.setRedirect(true);
			return forward;	
		}
		
		// DAO - 상품정보를 모두 가져오는 메서드
		AdminGoodsDAO dao = new AdminGoodsDAO();
		List adminGoodsList = dao.getAdminGoodsList();
		
		// 상품정보를 request 영역에 저장
		request.setAttribute("adminGoodsList", adminGoodsList);
		
		// 페이지 이동 (./center/admin_goods_list.jsp)
		forward.setPath("./center/admin_goods_list.jsp");
		forward.setRedirect(false);
		
		return forward;
	}
}


