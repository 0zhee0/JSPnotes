package com.itwillbs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/ex3")
public class ExServlet3 extends HttpServlet {
	int cnt;
	// http://localhost:8088/JSP/ex3
	// http://localhost:8088/JSP/test.ex3
	// http://localhost:8088/JSP/아이티윌.ex3
	
	@Override
	public void init() throws ServletException {
		System.out.println("서블릿 생성할 때 실행!");
		System.out.println("서블릿 객체를 초기화!");
		cnt = 0;
	}

	// doGET() 오버라이딩 + web.xml 매핑 (/ex3)
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ExServlet3_doGET() 호출!");
		System.out.println("cnt : " + (++cnt));
		
//		response.getWriter().append("cnt : " +(cnt));
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println(" <html> ");
		out.println(" <head></head> ");
		out.println(" <body> ");
		out.println(" <h1> cnt : "+cnt+"</h1> ");	
		out.println(" </body> ");
		out.println(" </html> ");
		
		out.close(); //자원해제
	}

	@Override
	public void destroy() {
		System.out.println(" 서블릿 소멸될 때 실행!");
	}

	
}
