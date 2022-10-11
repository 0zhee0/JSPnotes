package com.itwillbs.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.db.BoardDAO;
import com.itwillbs.db.BoardDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardFileWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1) 파일 업로드
		// 업로드 가상폴더 생성 /upload
		// 첨부파일 크기 지정 / 10 MB
		
		String realPath = request.getRealPath("/upload");
		System.out.println(" M : realPath : "+realPath);
		int maxSize = 10 * 1024 * 1024;
		
		// 파일어로드 ->  파일업로드 객체 생성(MultipartRequest)
		MultipartRequest multi
					= new MultipartRequest(
							request, 
							realPath,
							maxSize,
							"UTF-8",
							new DefaultFileRenamePolicy()
							);
		
		System.out.println(" M : 첨부파일 업로드 성공! ");
		
		// 2) 정보를 DB에 저장
		BoardDTO dto = new BoardDTO();
		
		dto.setName(multi.getParameter("name")); // multi 는 첨부파일 도와주는 객체
		dto.setPass(multi.getParameter("pass"));
		dto.setSubject(multi.getParameter("subject"));
		dto.setContent(multi.getParameter("content"));		
		dto.setFile(multi.getFilesystemName("file")); // getFilesystemName()
		dto.setIp(request.getRemoteAddr());
		
		// DAO
		BoardDAO dao = new BoardDAO();
		dao.insertBoard(dto);
		
		// 페이지 이동(정보저장)
		ActionForward forward = new ActionForward();
		forward.setPath("./BoardList.bo");
		forward.setRedirect(true); // sendRedirect 방식

		return forward;
	}

}
