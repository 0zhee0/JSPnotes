package com.itwillbs.admin.goods.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.admin.goods.db.AdminGoodsDAO;
import com.itwillbs.admin.goods.db.GoodsDTO;
import com.itwillbs.member.db.MemberDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class AdminGoodsAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(" M : AdminGoodsAddAction_execute() ");
		
		// 한글처리(생략)
		
		// 첨부파일 (우선순위 1번)
		//	1) upload 폴더 생성 - 가상업로드경로 설정을 위해
		//			: 파일이 저장되는 실제 경우(tomcat-서버)
		request.getRealPath(""); 
		ServletContext CTX = request.getServletContext(); // 인터페이스라 객체 못 만드니까 request영역에 내장되어있는 객체를 불러온다.
		String realPath = CTX.getRealPath("/upload");
		System.out.println(" M : realPath : " + realPath);
		
		//	2) 업로드 크기 제어
		int maxSize = 10 * 1024 * 1024; // 어떤 기준으로 설정하는지? 서버에서 제공되는 하드디스크 크기를 고려해서 지정한다.
		
		//	3) 라이브러리 설치(cos.jar)
		
		//	4) MultipartRequest객체 생성(업로드)
		MultipartRequest multi 
				= new MultipartRequest(
						request, 
						realPath, 
						maxSize, 
						"UTF-8", 
						new DefaultFileRenamePolicy()
						);
				
		System.out.println(" M : 첨부파일 업로드 완!");
		
		// 전달정보 저장(DTO)
		// 폼태그 -> DTO
		GoodsDTO dto = new GoodsDTO();
		dto.setAmount(Integer.parseInt(multi.getParameter("amount")));	// amount 정수형이라 형변환
		dto.setBest(maxSize);	// 0 일반상품, 1 인기상
		dto.setCategory(multi.getParameter("category")); 
		dto.setColor(multi.getParameter("color"));
		dto.setContent(multi.getParameter("content"));
//		dto.setGno(maxSize); // gno는 여기서(관리자상품등록페이지에서) 안 받아오기 때문에 뺀다.
		dto.setName(multi.getParameter("name"));
		dto.setPrice(Integer.parseInt(multi.getParameter("price")));
		dto.setSize(multi.getParameter("size"));
		
		// 업로드한 이미지들을 하나로 저장할 것이다
		String img = multi.getFilesystemName("file1")+"," 
				+ multi.getFilesystemName("file2")+","
				+ multi.getFilesystemName("file3")+","
				+ multi.getFilesystemName("file4");
		
		System.out.println(" M : img : " + img);
		dto.setImage(img);
		
		// DAO - 상품등록메서드 
		AdminGoodsDAO dao = new AdminGoodsDAO();
		
		// 상품등록메서드 - insertGoods(DTO)
		dao.insertGoods(dto);
		
		// 페이지 이동
		ActionForward forward = new ActionForward();
		forward.setPath("./AdminGoodsList.ag"); // 가상 -> 가상이므로 (패턴2)
		forward.setRedirect(true);

		return forward;
	}
}
