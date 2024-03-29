package com.itwillbs.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {

	// execute() 실행시 request,response 전달받아서 처리
	//   처리 완료후  ActionForward 리턴
	public ActionForward execute(
			HttpServletRequest request,HttpServletResponse response) throws Exception;
	
}

