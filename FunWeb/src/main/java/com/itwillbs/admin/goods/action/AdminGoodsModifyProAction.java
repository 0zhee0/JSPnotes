package com.itwillbs.admin.goods.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.admin.goods.db.AdminGoodsDAO;
import com.itwillbs.admin.goods.db.GoodsDTO;

public class AdminGoodsModifyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(" M : AdminGoodsModifyProAction_execute() 호출 ");
		System.out.println(" M : 수정완료버튼 눌렀을 때 기존 파일에서 수정된 내용으로 덮어씌우는 동작 중");
		
		// 로그인 세션(생략)
		// 한글처리(생략)
		
		// 전달정보(DTO)
		GoodsDTO dto = new GoodsDTO();
		
		dto.setAmount(Integer.parseInt(request.getParameter("amount")));
		dto.setBest(Integer.parseInt(request.getParameter("best")));
		dto.setCategory(request.getParameter("category"));
		dto.setColor(request.getParameter("color"));
		dto.setContent(request.getParameter("content"));
		
		// dto.setDate(null);
		dto.setGno(Integer.parseInt(request.getParameter("gno")));
		// dto.setImage(null);
		dto.setName(request.getParameter("name"));
		dto.setPrice(Integer.parseInt(request.getParameter("price")));
		dto.setSize(request.getParameter("size"));
		
		// DAO - 상품정보 수정메서드 (adminModifyGoods(DTO))
		AdminGoodsDAO dao = new AdminGoodsDAO();
		dao.adminModifyGoods(dto);
		
		// 페이지 이동
		ActionForward forward = new ActionForward();
		forward.setPath("./AdminGoodsList.ag");
		forward.setRedirect(true);
		
		return forward;
	
	}
}




