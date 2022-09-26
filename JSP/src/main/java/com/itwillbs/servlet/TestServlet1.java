package com.itwillbs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TestServlet1 extends HttpServlet {
	// http://localhost:8088/JSP/test1 (get)
	// alt shift s + v 오버라이딩
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() 호출");
		
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost() 호출");
		
		//request 영역에 정보 저장
//		request.setAttribute("cnt", new Integer(1000));
		request.setAttribute("cnt", 1000);
		
		// session 영역에 정보 저장
		// cnt - 2000
		HttpSession session = request.getSession();
		session.setAttribute("cnt", 2000);
		
//		1)) response.getWriter().append("<h1>HTML 메시지 작성하기</h1>");
		
		// 2)
//		response.setContentType("text/html; charset=UTF-8");
//		
//		PrintWriter out = response.getWriter();
//		out.print("<h1>HTML 메시지 작성하기222</h1>");
//		out.close();
		
		// 3)) forward 방식 - 포워딩
		//	 1. 페이지 이동 시 주소 변경 x, 화면 변경 o
		//	 2. request 내장객체 정보를 전달가능
//		<jsp:forward> (JSP 코드라 사용할 수 없다. 여기는 JAVA 코드임)
		
		RequestDispatcher dis = request.getRequestDispatcher("./el/Attribute.jsp");
															 //  이동할 주소
		dis.forward(request, response);		
		
	}												
}


