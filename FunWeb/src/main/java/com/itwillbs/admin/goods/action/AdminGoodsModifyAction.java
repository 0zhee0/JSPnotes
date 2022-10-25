package com.itwillbs.admin.goods.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.admin.goods.db.AdminGoodsDAO;

public class AdminGoodsModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(" M : AdminGoodsModifyAction_execute() 호출 ");
		System.out.println(" M : 수정하기 버튼 눌렀을 때 수정하는 페이지(.jsp)로 이동 중");
		
		// 로그인 세션제어(생략) 왜? 기존에 있던 것들 가져다 놓기만 하면 되니까
		
		// 전달정보(주소줄에 gno 데이터 가져오고 있으니까 gno받아오기) 
		int gno = Integer.parseInt(request.getParameter("gno"));
		
		// DAO - 상품정보 가져오기
		AdminGoodsDAO dao = new AdminGoodsDAO();
		
		// 연결된 뷰에 출력하기 위해서 request 영역에 저장
		request.setAttribute("dto", dao.getAdminGoods(gno));
		
		// 페이지 이동(./center/admin_goods_modify.jsp)
		ActionForward forward = new ActionForward();
		forward.setPath("./center/admin_goods_modify.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}




